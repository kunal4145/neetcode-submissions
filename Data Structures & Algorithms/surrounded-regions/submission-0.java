class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        ArrayDeque<int[]> q = new ArrayDeque<>();

        for (int i=0; i<m; i++) {
            if (board[i][0] == 'O') {
                q.add(new int[] {i, 0});
            }
            if (board[i][n-1] == 'O') {
                q.add(new int[] {i, n-1});
            }
        }

        for (int j=0; j<n; j++) {
            if (board[0][j] == 'O') {
                q.add(new int[] {0, j});
            }
            if (board[m-1][j] == 'O') {
                q.add(new int[] {m-1, j});
            }
        }

        while (!q.isEmpty()) {
            int[] tmp = q.removeFirst();
            int i = tmp[0];
            int j = tmp[1];
            visited[i][j] = true;

            if (i+1 < m && !visited[i+1][j] && board[i+1][j] == 'O') {
                q.add(new int[] {i+1, j});
            }
            if (i-1 >= 0 && !visited[i-1][j] && board[i-1][j] == 'O') {
                q.add(new int[] {i-1, j});
            }
            if (j+1 < n && !visited[i][j+1] && board[i][j+1] == 'O') {
                q.add(new int[] {i, j+1});
            }
            if (j-1 >= 0 && !visited[i][j-1] && board[i][j-1] == 'O') {
                q.add(new int[] {i, j-1});
            }
        }

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
