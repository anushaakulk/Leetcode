class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<nums2.length;i++){
            while(stack.size()>0 && nums2[i]>stack.peek()){
                int k = stack.pop();
                map.put(k,nums2[i]);
            }
            stack.push(nums2[i]);
        }
        int[] res = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            res[i] = map.getOrDefault(nums1[i],-1);
        }
        return res;
    }
}

Lesson: When searching similar elements from 2 arrays, use Hashmap !!!!
