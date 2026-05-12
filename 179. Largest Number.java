class Solution {
    public String largestNumber(int[] nums) {
        String[]string=new String[nums.length];
        for (int i=0;i<nums.length;i++){
            string[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(string,(a,b)->(b+a).compareTo(a+b));
        if (string[0].charAt(0)=='0') return "0";
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<nums.length;i++){
            sb.append(string[i]);
        }
        return sb.toString();
    }
}