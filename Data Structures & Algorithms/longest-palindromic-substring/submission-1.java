class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int resIdx = 0, resLen = 0;

        for (int i=0; i<n; i++) {
            int l = i, r = i;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if (resLen < r-l+1) {
                    resIdx = l;
                    resLen = r-l+1;
                }
                l--;
                r++;
            }

            l = i;
            r = i + 1;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if (resLen < r-l+1) {
                    resIdx = l;
                    resLen = r-l+1;
                }
                l--;
                r++;
            }
        }

        return s.substring(resIdx, resIdx + resLen);
    }

    public String longestPalindrome2(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int resIdx = 0, resLen = 0;

        for (int i=0; i<n; i++) {
            dp[i][i] = true;
        }
        // dp[i+1][j-1] && s.charAt(i) == s.charAt(j)
        for (int i=n-1; i>=0; i--) {
            for (int j=i; j<n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j-i <= 2 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    if (resLen < (j-i+1)) {
                        resIdx = i;
                        resLen = j-i+1;
                    }
                }
            }
        }

        return s.substring(resIdx, resIdx+resLen);
    }
}
