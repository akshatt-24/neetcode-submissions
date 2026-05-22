class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1; 
        while(true) {
            int left = numbers[l], right = numbers[r];
            if(left + right == target ){
                return new int[]{l+1, r+1};
            }
            if(left + right > target)
                r--;
            if(left + right < target)
                l++;
        }
    }
}
