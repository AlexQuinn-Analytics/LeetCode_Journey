class Solution {
    public void rotate(int[] nums, int k) {
        int nk=k%nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, nk-1);
        reverse(nums, nk, nums.length-1);
    }

    private void reverse(int[] nums, int start, int end){
        while (start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
        return;
    }
}