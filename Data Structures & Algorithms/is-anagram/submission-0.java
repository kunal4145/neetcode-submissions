class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();

        if (sc.length != tc.length) {
            return false;
        }

        for (int i=0; i<sc.length; i++) {
            if (map.containsKey(sc[i])) {
                map.put(sc[i], map.get(sc[i]) + 1);
            } else {
                map.put(sc[i], 1);
            }
        }

        for (int i=0; i<tc.length; i++) {
            if (map.containsKey(tc[i])) {
                if (map.get(tc[i]) == 1) {
                    map.remove(tc[i]);
                } else {
                    map.put(tc[i], map.get(tc[i]) - 1);
                }
            } else {
                return false;
            }
        }

        return true;
    }
}
