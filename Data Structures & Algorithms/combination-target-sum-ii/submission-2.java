class Solution {
    private List<List<Integer>> result;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>();

        Arrays.sort(candidates);
        combSumUtil(candidates, target, new ArrayList<>(), 0);

        return result;    
    }

    private void combSumUtil(int[] candidates, int target, List<Integer> curr, int i) {
        if (target == 0) {
            List<Integer> res = new ArrayList<>(curr);
            result.add(res);
            return;
        } else if (target < 0 || i == candidates.length) {
            return;
        } 

        curr.add(candidates[i]);
        combSumUtil(candidates, target-candidates[i], curr, i+1);

        while (i+1 < candidates.length && candidates[i] == candidates[i+1]) {
            i++;
        }
        curr.remove(curr.size()-1);
        combSumUtil(candidates, target, curr, i+1);
    }
}
