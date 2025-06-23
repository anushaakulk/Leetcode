Optimal code: 

class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        boolean[] freq = new boolean[n + 1];
        for(int num : nums) {
            if(freq[num])
                return num;
            freq[num] = true;
        }
        return -1;
    }
}


My code:

class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])) return nums[i];
            set.add(nums[i]);
        }
        return 0;
    }
}

Code	           Usually Faster?	          Why
Code 1 (array)	  ✅ Yes	                  Simple memory layout, primitive operations, no hashing
Code 2 (HashSet)	❌ Slower	                Uses autoboxing, hashing, more overhead
