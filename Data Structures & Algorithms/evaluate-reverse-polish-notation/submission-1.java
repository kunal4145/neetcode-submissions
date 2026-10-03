class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            if (token.equals("+")) {
                int num1 = stack.removeLast();
                int num2 = stack.removeLast();
                stack.addLast(num2 + num1);
            } else if (token.equals("-")) {
                int num1 = stack.removeLast();
                int num2 = stack.removeLast();
                stack.addLast(num2 - num1);
            } else if (token.equals("*")) {
                int num1 = stack.removeLast();
                int num2 = stack.removeLast();
                stack.addLast(num2 * num1);
            } else if (token.equals("/")) {
                int num1 = stack.removeLast();
                int num2 = stack.removeLast();
                stack.addLast(num2 / num1);
            } else {
                stack.addLast(Integer.parseInt(token));
            }
        }

        return stack.removeLast();
    }
}
