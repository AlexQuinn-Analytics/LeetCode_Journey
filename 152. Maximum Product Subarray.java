class Solution {
    public int maxProduct(int[] nums) {
        if (nums==null||nums.length==0) return 0;
        int curMax=nums[0];
        int curMin=nums[0];
        int max=nums[0];
        for (int i=1;i<nums.length;i++){
            if (nums[i]<0){
                int temp=curMax;
                curMax=curMin;
                curMin=temp;
            }
            curMax=Math.max(nums[i],curMax*nums[i]);
            curMin=Math.min(nums[i],curMin*nums[i]);
            max=Math.max(curMax,max);
        }
        return max;
    }
}