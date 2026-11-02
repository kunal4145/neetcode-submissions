class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] car = new int[position.length][2];

        for (int i=0; i<position.length; i++) {
            car[i][0] = position[i];
            car[i][1] = speed[i];
        }

        Arrays.sort(car, ((a,b) -> Integer.compare(b[0], a[0])));
        int fleets = 1;
        double prevTime = (double) (target - car[0][0]) / car[0][1];

        for (int i=1; i<position.length; i++) {
            double currTime = (double) (target - car[i][0]) / car[i][1];
            if (currTime > prevTime) {
                fleets++;
                prevTime = currTime;
            }
        }
        return fleets;
    }
}
