class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        char[] map1 = new char[26];
        char[] map2 = new char[26];

        for (int i=0; i<s1.length(); i++) {
            map1[s1.charAt(i) - 'a']++;
            map2[s2.charAt(i) - 'a']++;
        }

        if (isPermutation(map1, map2)) {
            return true;
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            map2[s2.charAt(i) - 'a']++;
            map2[s2.charAt(i-s1.length()) - 'a']--;

            if (isPermutation(map1, map2)) {
                return true;
            }
        }

        return false;
    }

    private boolean isPermutation(char[] map1, char[] map2) {
        for (int i=0; i<26; i++) {
            if (map1[i] != map2[i]) {
                return false;
            }
        }

        return true;
    }
}
