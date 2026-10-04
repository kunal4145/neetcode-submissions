class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minheap = new PriorityQueue<>((a,b) -> Integer.compare(a[0]*a[0] + a[1]*a[1], b[0]*b[0] + b[1]*b[1]));

        for (int[] point : points) {
            minheap.add(point);
        }

        int[][] result = new int[k][2];

        for (int i=0; i<k; i++) {
            int[] temp = minheap.poll();
            result[i][0] = temp[0];
            result[i][1] = temp[1];
        }

        return result;
    }
}
