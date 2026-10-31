class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        ArrayDeque<int[]> queue = new ArrayDeque<>();

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 0) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int dist = 1;
        while (!queue.isEmpty()) {
            int count = queue.size();
            while (count-- > 0) {
                int[] temp = queue.removeFirst();
                int i = temp[0];
                int j = temp[1];
                visited[i][j] = true;

                if (i+1 < m && !visited[i+1][j] && grid[i+1][j] == Integer.MAX_VALUE) {
                    grid[i+1][j] = dist;
                    queue.addLast(new int[]{i+1, j});
                }
                if (i-1 >= 0 && !visited[i-1][j] && grid[i-1][j] == Integer.MAX_VALUE) {
                    grid[i-1][j] = dist;
                    queue.addLast(new int[]{i-1, j});
                }
                if (j+1 < n && !visited[i][j+1] && grid[i][j+1] == Integer.MAX_VALUE) {
                    grid[i][j+1] = dist;
                    queue.addLast(new int[]{i, j+1});
                }
                if (j-1 >= 0 && !visited[i][j-1] && grid[i][j-1] == Integer.MAX_VALUE) {
                    grid[i][j-1] = dist;
                    queue.addLast(new int[]{i, j-1});
                }
            }
            dist++;
        }
    }
}
