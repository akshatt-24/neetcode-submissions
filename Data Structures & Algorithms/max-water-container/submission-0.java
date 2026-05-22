class Solution {
    public int maxArea(int[] heights) {
        int res = 0;
        for(int i = 0; i < heights.length - 1; i++) {
            for(int k = heights.length - 1; k > i; k--) {
                int curr = (k - i) * Math.min(heights[i], heights[k]);
                res = Math.max(curr, res);
            }
        }
        return res;
    }
}
