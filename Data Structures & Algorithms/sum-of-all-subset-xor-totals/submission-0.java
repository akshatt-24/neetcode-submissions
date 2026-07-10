class Solution {
    public int subsetXORSum(int[] nums) {
        return subset(nums, 0, 0);
    }
    private int subset(int[] nums, int i, int currentXOR) {
        if(i == nums.length) {
            return currentXOR;
        }

        int choose = subset(nums, i+1, currentXOR ^ nums[i]);
        int skip = subset(nums, i+1, currentXOR);

        return choose + skip;
    }
}