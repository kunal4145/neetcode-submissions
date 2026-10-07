class Solution {
    private List<String> result;
    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();

        generateUtils(new StringBuilder(), 0, 0, n);

        return result;
    }

    private void generateUtils(StringBuilder sb, int open, int close, int n) {
        if (open == n && close == n) {
            result.add(new String(sb));
            return;
        }

        if (open < n) {
            sb.append('(');
            generateUtils(sb, open+1, close, n);
            sb.deleteCharAt(sb.length()-1);
        }

        if (close < n && close < open) {
            sb.append(')');
            generateUtils(sb, open, close+1, n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
