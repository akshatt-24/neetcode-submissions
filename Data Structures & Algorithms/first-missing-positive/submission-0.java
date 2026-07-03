class Solution {
    public int firstMissingPositive(int[] nums) {
        boolean[] seen = new boolean[nums.length];

        for(int num : nums) {
            if(num > 0 && num <= nums.length) {
                seen[num - 1] = true;
            }
        }

        for(int i = 0 ; i < seen.length; i++) {
            if(!seen[i]) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}