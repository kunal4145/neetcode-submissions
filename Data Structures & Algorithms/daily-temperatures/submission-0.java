class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        int[] result = new int[temperatures.length];

        for (int i=0; i<temperatures.length; i++) {
            while (!stack.isEmpty() && stack.getLast()[0] < temperatures[i]) {
                int[] temp = stack.removeLast();
                result[temp[1]] = i - temp[1];
            }

            stack.addLast(new int[]{temperatures[i], i});
        }

        return result;
    }
}
