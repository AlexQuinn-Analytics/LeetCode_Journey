class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals==null||intervals.length==0){
            return new int[0][];
        }
        Arrays.sort(intervals,(a,b)->(a[0]-b[0]));
        List<int[]>res=new ArrayList<>();
        res.add(intervals[0]);
        for (int i=1;i<intervals.length;i++){
            int[]last=res.get(res.size()-1);
            int[]curr=intervals[i];
            if (last[1]>=curr[0]){
                last[1]=Math.max(last[1],curr[1]);
            }else{
                res.add(curr);
            }
        }
    return res.toArray(new int[res.size()][]);
    }
}