class Solution {
    List<String> result;
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        String[] map = new String[10];
        map[2] = "abc";
        map[3] = "def";
        map[4] = "ghi";
        map[5] = "jkl";
        map[6] = "mno";
        map[7] = "pqrs";
        map[8] = "tuv";
        map[9] = "wxyz";

        letterCombUtils(digits, map, 0, new StringBuilder());

        return result;
    }

    private void letterCombUtils(String digits, String[] map, int x, StringBuilder sb) {
        if (x == digits.length()) {
            result.add(new String(sb));
            System.out.println(sb);
            return;
        }

        int digit = (int)digits.charAt(x) - '0';
        System.out.println(digit);

        for (int i=0; i<map[digit].length(); i++) {
            sb.append(map[digit].charAt(i));
            letterCombUtils(digits, map, x+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
