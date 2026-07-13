class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indegree = new int[n + 1];
        int[] outdegree = new int[n + 1];

        for(int[] t : trust) {
            int from = t[0];
            int to = t[1];

            outdegree[from]++;
            indegree[to]++;
        }

        for(int i = 1; i <= n ; i++) {
            if(indegree[i] == (n - 1) && outdegree[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}