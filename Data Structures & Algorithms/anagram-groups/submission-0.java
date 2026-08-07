class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        int[] freq;

        for (int i=0; i<strs.length; i++) {
            freq = new int[26];
            for (int j=0; j<strs[i].length(); j++) {
                freq[strs[i].charAt(j) - 'a']++;
            }
            
            String temp = Arrays.toString(freq);
            //System.out.println(temp);
            if (!map.containsKey(temp)) {
                map.put(temp, new ArrayList<>());
            }
            map.get(temp).add(strs[i]);
        }

        for (List<String> value : map.values()) {
            result.add(value);
        }

        return result;
    }
}
