class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length==1) return;
        int zero=0;
        int count=0;
        while (zero<nums.length){
            if (nums[zero]==0){
                count++;
            }
            zero++;
        }
        int nonZeroCnt=nums.length-count;
        int j=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=0){
                nums[j]=nums[i];
                j++;
            }
            if (j==nonZeroCnt) break;
        }
        while (nonZeroCnt<nums.length){
            nums[nonZeroCnt]=0;
            nonZeroCnt++;
        }
        return;
    }
}