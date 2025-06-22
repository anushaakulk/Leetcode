class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for(int m=0;m<k && m<nums.length;m++){
            sum += (double)nums[m];
        }
        double temp = sum;
        int j = k-1;
        for(int i=1;j<nums.length-1;i++,j++){
            temp -= nums[i-1];
            temp += nums[j+1];
            sum = Math.max(sum,temp);
        }
        return sum/k;
    }
}


Took too much time for an easy problem. Realised System.out.println() increases time complexity of the code. 
Need to learn simple variables assignment like k or k-1 and nums.length or nums.length-1 to solve problems quickly
