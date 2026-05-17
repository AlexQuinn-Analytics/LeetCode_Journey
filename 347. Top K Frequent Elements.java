class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 1. 统计频率
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // 2. 把【不重复的数字】拿出来！！！（关键）
        List<Integer> keys = new ArrayList<>(freq.keySet());

        // 3. 按频率降序排序
        Collections.sort(keys, (a, b) -> freq.get(b) - freq.get(a));

        // 4. 取前 k 个
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = keys.get(i);
        }

        return res;
    }
}