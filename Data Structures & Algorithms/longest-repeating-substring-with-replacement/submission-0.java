class Solution {
    public int characterReplacement(String s, int k) {
        Set<Character> charSet = new HashSet<>();
        int result = 0;

        for (int i=0; i<s.length(); i++) {
            charSet.add(s.charAt(i)); 
        }

        for (char c : charSet) {
            int l = 0, count = 0;
            
            for (int r = 0; r < s.length(); r++) {
                if (s.charAt(r) == c) {
                    count++;
                } 
                
                while ((r - l + 1) - count > k) {
                    if (s.charAt(l) == c) {
                        count--;
                    }
                    l++;
                }

                result = Math.max(result, r-l+1);
            }
        }

        return result;
    }
}
