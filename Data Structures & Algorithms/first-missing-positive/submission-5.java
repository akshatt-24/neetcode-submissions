class Solution {
    public int firstMissingPositive(int[] nums) {
        // cycle sort

        // to place value v at index v - 1
        // that is value = 2 place at idx = 1
            int i = 0;
            int n = nums.length;
        
            while(i < n) {
                if(nums[i] <= 0 || nums[i] > n) {
                    i++;
                    continue;
                }
                int index = nums[i] - 1;
                if(nums[i] != nums[index]) {
                    int temp = nums[i];
                    nums[i] = nums[index];
                    nums[index] = temp;
                }
                else {
                    i++;
                }
            }

        for(i = 0; i < nums.length ; i++) {
            if(nums[i] != i + 1) {
                return i+1;
            }
        }
        return (n + 1);
    }
}