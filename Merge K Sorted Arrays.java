 static class Node{
        int val; int arrIdx; int elemIdx;
        Node (int v, int a, int e){
            val=v;arrIdx=a;elemIdx=e;
        }
    }
    static int[] mergeKArrays(int[][] arrays) {
        int total=0;
        PriorityQueue<Node>minHeap=new PriorityQueue<>((a,b)->a.val-b.val);
        for (int i=0;i<arrays.length;i++){
            if (arrays[i].length>0){
                minHeap.offer(new Node(arrays[i][0],i,0));
                total+=arrays[i].length;
            }
        }
        int[]res=new int[total];
        int idx=0;
        while (!minHeap.isEmpty()){
            Node cur=minHeap.poll();
            res[idx++]=cur.val;
            int[]arr=arrays[cur.arrIdx];
            if (cur.elemIdx+1<arr.length){
                minHeap.offer(new Node(arr[cur.elemIdx+1],cur.arrIdx,cur.elemIdx+1));
            }
        }
        return res;
    }