/*
Compare Version Numbers 
Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37

Example: 1.0, 1 return 0 (1.0 = 1)
         1.1, 1 return 1 (1.1 < 1)
         1, 1.1 return -1 (1 > 1.1)
*/

/*
在java中 \代表转义字符 \n \t 等，而 \\ 代表一个反斜杠 而.代表一个元字符
要表示一个.就需要用 要用\. 
所以"\\." 在实际编译中 就代表 . 
*/

 public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\."); 
        String[] v2 = version2.split("\\.");
        
        for (int i = 0; i < v1.length || i < v2.length; i++) {
            if (i < v1.length && i < v2.length) {
                if (Integer.parseInt(v1[i]) < Integer.parseInt(v2[i])) {
                    return -1;
                }
                else if (Integer.parseInt(v1[i]) > Integer.parseInt(v2[i])) {
                    return 1;
                }
            }
            else if (i < v1.length) {
                if (Integer.parseInt(v1[i]) != 0) {
                    return 1;
                }
            }
            else {
                if (Integer.parseInt(v2[i]) != 0) {
                    return -1;
                }
            }
        }
        return 0;
    }