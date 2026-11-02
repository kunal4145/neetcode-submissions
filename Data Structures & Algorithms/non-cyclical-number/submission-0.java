class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while(true) {
            List<Integer> digits = getDigits(n);
            int sum = 0;
            for (int digit : digits) {
                sum += digit * digit;
            }

            if (sum == 1) {
                return true;
            }

            if (set.contains(sum)) {
                return false;
            }

            set.add(sum);
            n = sum;
        }
    }

    private List<Integer> getDigits(int n) {
        List<Integer> result = new ArrayList<>();

        while (n != 0) {
            result.add(n % 10);
            n /= 10;
        }

        return result;
    }
}
