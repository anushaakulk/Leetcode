class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int result = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) sum -= 1;
            else sum += 1;
            if(sum==0){
                result = Math.max(result, i+1);
            }
            else if(map.containsKey(sum)){
                result = Math.max(result, i - map.get(sum));
            }
            else{
                map.put(sum,i);
            }
        }
        return result;
    }
}
