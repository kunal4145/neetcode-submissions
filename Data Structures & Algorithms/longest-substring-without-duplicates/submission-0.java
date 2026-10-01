class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        Set<Character> hash = new HashSet<>();
        int maxlen = 0, currlen = 0, i = 0;

        while (i < arr.length) {
            if (!hash.contains(arr[i])) {
                hash.add(arr[i]);
                currlen++;
                maxlen = Math.max(maxlen, currlen);
            } else {
                char temp = arr[i];
                while (i-1 >= 0 && arr[i-1] != temp) {
                    i--;
                }
                currlen = 1;
                hash = new HashSet<>();
                hash.add(arr[i]);
            }
            i++;
        }

        return maxlen;
    }
}
