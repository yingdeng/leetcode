/*
Excel Sheet Column Title
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
*/

public String convertToTitle(int n) {
	if (n <= 0) {
		return "";
	}

	HashMap<Integer, String> map = new HashMap()<>;
	map.put(0,"A");
    map.put(1,"B");
    map.put(2,"C");
    map.put(3,"D");
    map.put(4,"E");
    map.put(5, "F");
    map.put(6, "G");
    map.put(7, "H");
    map.put(8, "I");
    map.put(9, "J");
    map.put(10, "K");
    map.put(11, "L");
    map.put(12, "M");
    map.put(13, "N");
    map.put(14, "O");
    map.put(15, "P");
    map.put(16, "Q");
    map.put(17, "R");
    map.put(18, "S");
    map.put(19, "T");
    map.put(20, "U");
    map.put(21, "V");
    map.put(22, "W");
    map.put(23, "X");
    map.put(24, "Y");
    map.put(25, "Z");

    StringBuilder res = new StringBuilder();
    while (n > 26) {
    	n--;
    	int i = n / 26;
    	int j = n % 26;
    	res.insert(0, map.get(j));
    	n = i;
    }
    res.insert(0, map.get(n-1));
    return res.toString();
}