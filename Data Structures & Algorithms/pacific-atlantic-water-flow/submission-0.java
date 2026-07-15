class Solution {
    // outside to inside approach :
    // ocean to cells 

    // Water can flow in any of the 4 directions at any point
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] visitedPacific = new boolean[m][n];
        boolean[][] visitedAtlantic = new boolean[m][n];

        // for top boundary (pacific ocean) :
        for(int c = 0; c < n; c++) {
            dfs(heights, 0, c, visitedPacific);
        }
        // for left boundary (pacific ocean) :
        for(int r = 0; r < m; r++) {
            dfs(heights, r, 0, visitedPacific);
        }

        // for bottom boundary (atlantic ocean) :
        for(int c = 0; c < n; c++) {
            dfs(heights, m - 1, c, visitedAtlantic);
        }

        // for right boundary (atlantic ocean) :
        for(int r = 0; r < m; r++) {
            dfs(heights, r, n - 1, visitedAtlantic);
        }

        // we have the visited cells of both pacific and atlantic oceans
        // their intersection would be the cells visited by both

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(visitedPacific[i][j] && visitedAtlantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] heights,int r, int c, boolean[][] visited) {
        visited[r][c] = true;

        for(int[] dir : directions) {
            int nR = r + dir[0];
            int nC = c + dir[1];
            // from ocean to cells (outside to inside approach)\
            
            if(nR >= 0 && nR < heights.length && nC >= 0 && nC < heights[0].length) {
                if(heights[nR][nC] >= heights[r][c]  && !visited[nR][nC]) {
                    dfs(heights, nR, nC, visited);
                }
            }
        }
    }
}