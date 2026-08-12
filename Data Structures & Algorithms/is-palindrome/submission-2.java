class Solution {
    public boolean isPalindrome(String s) {
        int i=0, j=s.length()-1;

        while (i < j) {
            while (i < s.length() && !isAlphanumeric(s.charAt(i))) {
                i++;
            } 
            
            while (j >= 0 && !isAlphanumeric(s.charAt(j))) {
                j--;
            }
            //System.out.println(i + " " + j);

            if (i >= j) {
                return true;
            }

            if (Character.toLowerCase(s.charAt(i++)) != Character.toLowerCase(s.charAt(j--))) {
                return false;
            }
        }

        return true;
    }

    private boolean isAlphanumeric(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }
}
