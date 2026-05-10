class MedianFinder {
    PriorityQueue<Integer>maxHeap=new PriorityQueue<>();
    PriorityQueue<Integer>minHeap=new PriorityQueue<>();
    
    public void addNum(int num) {
        if (!minHeap.isEmpty()&&num>minHeap.peek()){
            minHeap.offer(num);
        }else{
            maxHeap.offer(-num);
        }
        if (maxHeap.size()-minHeap.size()==2){
            minHeap.offer(-maxHeap.poll());
        }else if (minHeap.size()-maxHeap.size()==2){
            maxHeap.offer(-minHeap.poll());
        }
        
    }
    
    public double findMedian() {
        if (maxHeap.size()>minHeap.size()){
            return -maxHeap.peek();
        } else if (maxHeap.size()<minHeap.size()){
            return minHeap.peek();
        }
        return (double)(minHeap.peek()-maxHeap.peek())/2.0;
        
    }
}