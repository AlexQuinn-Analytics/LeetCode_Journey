static int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[]res=new int[n];
        Arrays.fill(res,-1);
        Deque<Integer>stack=new ArrayDeque<>();
        for (int i=0;i<2*n;i++){
            int idx=i%n;
            while (!stack.isEmpty()&&nums[idx]>nums[stack.peek()]){
                res[stack.pop()]=nums[idx];
            }
            if (i<n){
                stack.push(idx);
            }
        }
        return res;
    }