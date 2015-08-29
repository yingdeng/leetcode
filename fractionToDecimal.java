/*
Fraction to Recurring Decimal 
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".
*/

public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        if (denominator == 0) {
            return "";
        }
        
        String result = "";


        // Because num and den coule be negative at the same time, so using XOR(^) to distinguish
        // the final result as negative or negative
        if ((numerator < 0) ^ (denominator < 0)) {
            result += "-";
        }
        
        long num = numerator;
        long den = denominator;
        num = Math.abs(num);
        den = Math.abs(den);
        
        // Quotient
        long res = num / den;
        result += String.valueOf(res);
        
        // if remainder = 0, then return result
        long remainder = (num % den) * 10;
        if (remainder == 0) {
            return result;
        }

        // Create a hashmap store the remainder and the correspondense position, that is the length of current result
        // and then calculate the right side of the decimal point 
        HashMap<Long, Integer> map = new HashMap<>();
        result += ".";
        
        while(remainder != 0) {
        	// if digit is repeating
            if (map.containsKey(remainder)) {
                int a = map.get(remainder);
                String p1 = result.substring(0, a);
                String p2 = result.substring(a, result.length());
                result = p1 + "(" + p2 + ")";
                return result;
            }
            // keep calculating 
            map.put(remainder, result.length());
            res = remainder / den;
            result += String.valueOf(res);
            remainder = (remainder % den) * 10;
        }
        return result;
    }