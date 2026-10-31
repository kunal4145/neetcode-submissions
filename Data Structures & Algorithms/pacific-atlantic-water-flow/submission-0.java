class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        ArrayDeque<int[]> pq = new ArrayDeque<>();
        ArrayDeque<int[]> aq = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();

        for (int i=0; i<n; i++) {
            pacific[i][0] = true;
            pq.addLast(new int[]{i, 0});
            atlantic[i][m-1] = true;
            aq.addLast(new int[]{i, m-1});
        }
        for (int j=0; j<m; j++) {
            pacific[0][j] = true;
            pq.addLast(new int[]{0, j});
            atlantic[n-1][j] = true;
            aq.addLast(new int[]{n-1, j});
        }

        while (!pq.isEmpty()) {
            int[] tmp = pq.removeFirst();
            int i = tmp[0];
            int j = tmp[1];

            if (i+1 < n && !pacific[i+1][j] && heights[i][j] <= heights[i+1][j]) {
                pq.add(new int[]{i+1, j});
                pacific[i+1][j] = true;
            }
            if (i-1 >= 0 && !pacific[i-1][j] && heights[i][j] <= heights[i-1][j]) {
                pq.add(new int[]{i-1, j});
                pacific[i-1][j] = true;
            }
            if (j+1 < m && !pacific[i][j+1] && heights[i][j] <= heights[i][j+1]) {
                pq.add(new int[]{i, j+1});
                pacific[i][j+1] = true;
            }
            if (j-1 >= 0 && !pacific[i][j-1] && heights[i][j] <= heights[i][j-1]) {
                pq.add(new int[]{i, j-1});
                pacific[i][j-1] = true;
            }
        }

        while (!aq.isEmpty()) {
            int[] tmp = aq.removeFirst();
            int i = tmp[0];
            int j = tmp[1];

            if (i+1 < n && !atlantic[i+1][j] && heights[i][j] <= heights[i+1][j]) {
                aq.add(new int[]{i+1, j});
                atlantic[i+1][j] = true;
            }
            if (i-1 >= 0 && !atlantic[i-1][j] && heights[i][j] <= heights[i-1][j]) {
                aq.add(new int[]{i-1, j});
                atlantic[i-1][j] = true;
            }
            if (j+1 < m && !atlantic[i][j+1] && heights[i][j] <= heights[i][j+1]) {
                aq.add(new int[]{i, j+1});
                atlantic[i][j+1] = true;
            }
            if (j-1 >= 0 && !atlantic[i][j-1] && heights[i][j] <= heights[i][j-1]) {
                aq.add(new int[]{i, j-1});
                atlantic[i][j-1] = true;
            }
        }

        for (int i=0 ;i<n; i++) {
            for (int j=0; j<m; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);temp.add(j);
                    result.add(temp);
                }
            }
        }

        return result;

    }
}
