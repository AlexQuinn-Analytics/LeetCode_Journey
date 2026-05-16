static int[] sortFrequency(int[] nums) {
        Map<Integer, Integer>freq=new HashMap<>();
        Map<Integer, Integer>firstOccur=new HashMap<>();
        for (int i=0;i<nums.length;i++){
            freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);
            firstOccur.putIfAbsent(nums[i],i);
        }
        Integer[]arr=new Integer[nums.length];
        for (int i=0;i<nums.length;i++){
            arr[i]=nums[i];
        }
        Arrays.sort(arr,(a,b)->{
            int fa=freq.get(a);int fb=freq.get(b);
            if (fa!=fb) return fb-fa;
            return firstOccur.get(a)-firstOccur.get(b);
        });
        int[]res=new int[nums.length];
        for (int i=0;i<nums.length;i++){
            res[i]=arr[i];
        }
        return res;
    }