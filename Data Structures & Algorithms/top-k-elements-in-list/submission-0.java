class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqmap = new HashMap<>();

        for(int num : nums) {
            freqmap.put(num, freqmap.getOrDefault(num,0) + 1);
        }
        // Bucket Sort to be applied
        // index = frequency 
        
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }

        // iteration over the freqmap to fill the bucket lists
        for(Map.Entry<Integer, Integer> entry : freqmap.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            bucket[count].add(num);
        }
        int[] result = new int[k];
        int idx = 0;

        for(int i = bucket.length - 1; i >= 0 && idx < k; i--) {
            for(int num: bucket[i]) {
                result[idx++] = num;
                if(idx == k) break;
            }
        }
        return result;
    }
}
