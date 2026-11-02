class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;
        int n = gas.length;

        for (int i=0; i<n; i++) {
            totalGas += gas[i];
            totalCost +=  cost[i];
        }

        if (totalCost > totalGas) {
            return -1;
        }

        int l = 0, tank = 0;
        for (int i=0; i<n; i++) {
            tank += gas[i] - cost[i];

            if (tank < 0) {
                tank = 0;
                l = i + 1;
            }
        }

        return l;
    }
}
