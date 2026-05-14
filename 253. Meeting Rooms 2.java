class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        PriorityQueue<Integer>minHeap=new PriorityQueue<>();
        for (int i=0;i<intervals.length;i++){
            int start=intervals[i][0];
            int end=intervals[i][1];
            if (!minHeap.isEmpty()&&start>=minHeap.peek()){
                minHeap.poll();
            }
            minHeap.offer(end);
    }
    return minHeap.size();
}
}