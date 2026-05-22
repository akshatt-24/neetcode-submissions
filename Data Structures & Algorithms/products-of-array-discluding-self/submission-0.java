class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int[] pre = new int[nums.length];
        int[] suf = new int[nums.length];

        int prod = 1;
        int i = 0;
        while(i < nums.length) {
            if(i == 0) {
                pre[i++] = 1;
            }
            else {
                prod = prod * nums[i-1];
                pre[i++] = prod;
            }
        }

        i = nums.length - 1;
        prod = 1;
        while(i >= 0) {
            if(i == nums.length - 1) {
                suf[i--] = 1;
            }
            else 
            {   
                prod = prod * nums[i + 1];
                suf[i--] = prod;
            }
        }
        for(int j = 0; j < nums.length; j++) {
            res[j] = pre[j] * suf[j];
        }
        return res;
    }
}  
