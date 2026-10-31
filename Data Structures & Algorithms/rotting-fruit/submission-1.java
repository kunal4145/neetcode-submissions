class Solution {
    private int m,n;
    public int orangesRotting(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int fresh = 0;
        ArrayDeque<int[]> q = new ArrayDeque<>();

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 2) {
                    q.addLast(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) {
            return 0;
        }

        int time = 0;

        while (!q.isEmpty()) {
            int rotting = q.size();

            while (rotting-- > 0) {
                int[] temp = q.removeFirst();
                int i = temp[0];
                int j = temp[1];

                if (i+1 < m && grid[i+1][j] == 1) {
                    grid[i+1][j] = 2;
                    q.add(new int[]{i+1, j});
                }
                if (i-1 >= 0 && grid[i-1][j] == 1) {
                    grid[i-1][j] = 2;
                    q.add(new int[]{i-1, j});
                }
                if (j+1 < n && grid[i][j+1] == 1) {
                    grid[i][j+1] = 2;
                    q.add(new int[]{i, j+1});
                }
                if (j-1 >= 0 && grid[i][j-1] == 1) {
                    grid[i][j-1] = 2;
                    q.add(new int[]{i, j-1});
                }
            }
            time++;       
        }

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return time-1;

    }
}
