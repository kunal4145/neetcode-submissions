class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        int islands = 0;

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    islands++;
                    exploreIsland(grid, visited, i, j);
                }
            }
        }

        return islands;
    }

    private void exploreIsland(char[][] grid, boolean[][] visited, int i, int j) {
        int n = grid.length;
        int m = grid[0].length;

        visited[i][j] = true;

        if (i+1 < n && !visited[i+1][j] && grid[i+1][j] == '1') {
            exploreIsland(grid, visited, i+1, j);
        }
        if (i-1 >= 0 && !visited[i-1][j] && grid[i-1][j] == '1') {
            exploreIsland(grid, visited, i-1, j);
        }
        if (j+1 < m && !visited[i][j+1] && grid[i][j+1] == '1') {
            exploreIsland(grid, visited, i, j+1);
        }
        if (j-1 >= 0 && !visited[i][j-1] && grid[i][j-1] == '1') {
            exploreIsland(grid, visited, i, j-1);
        }
    }
}
