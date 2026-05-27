class Solution {
    public int lengthOfLongestSubstring(String s) {
        // brute force

        int res = 0;

        for(int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();

            for(int j = i; j < s.length() ; j++) {
                if(set.contains(s.charAt(j))) break;
                set.add(s.charAt(j));
            }
            res = Math.max(res, set.size());
        }
        return res;
    }
}
