class Solution {
    class Pair {
        int row ;
        int col;

        Pair(int r, int c) {
            this.row = r;
            this.col = c;
        }
    }
    int[][] directions ={  {-1,0},
                            {1,0},
                            {0,-1},
                            {0,1}
                        };
    public int orangesRotting(int[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        int min = 0;
        int fresh = 0;

        int m = grid.length , n = grid[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new Pair(i, j));
                }
                if(grid[i][j] == 1) {
                    // fresh orange
                    fresh++;
                }
            }
        }

        while(!queue.isEmpty() && fresh > 0) {
            
            int size = queue.size();

            for(int i = 0 ; i < size; i++) {
                Pair rotten = queue.poll();
                int r = rotten.row;
                int c = rotten.col;

                for(int[] dir : directions) {
                    int nR = r + dir[0];
                    int nC = c + dir[1];

                    if(nR >= 0 && nR < m && nC >= 0 && nC < n) {
                        if(grid[nR][nC] == 1) {
                            fresh--;    // fresh decreases --> rots
                            grid[nR][nC] = 2;   // mark visited
                            queue.offer(new Pair(nR, nC));
                        }
                    }
                }
            }
            min++;
        }
        if(fresh > 0) {
            return -1;
        }
        return min;
    }
}