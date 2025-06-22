class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> set = new HashMap<>();
        if(s.length()==1) return 1;
        int start = 0;
        int max = 0;
        for(int i=0;i<s.length();i++){
            if(set.containsKey(s.charAt(i))){
                max = Math.max(max,i-start);
                start = Math.max(start,set.get(s.charAt(i))+1);
                set.remove(s.charAt(i));
            }
            set.put(s.charAt(i),i);
            if(i==s.length()-1){
                max = Math.max(max,i-start+1);
            }
        }
        return max;
    }
}


Took some time but did it without solution. This is a leetcode medium problem. Took little time to sort out the conditions. Will try to do faster next time
