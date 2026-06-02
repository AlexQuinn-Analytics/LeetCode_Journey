class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> res = new ArrayList<>();
        List<Interval> all = new ArrayList<>();
        
        // 1. 把所有工作时间放进一个 list
        for (List<Interval> emp : schedule) {
            all.addAll(emp);
        }
        
        // 2. 按 start 升序排序
        Collections.sort(all, (a, b) -> a.start - b.start);
        
        // 3. 合并区间
        List<Interval> merged = new ArrayList<>();
        Interval prev = all.get(0);
        
        for (int i = 1; i < all.size(); i++) {
            Interval curr = all.get(i);
            if (curr.start <= prev.end) {
                // 重叠，合并
                prev.end = Math.max(prev.end, curr.end);
            } else {
                // 不重叠，先把前一段加进去
                merged.add(prev);
                prev = curr;
            }
        }
        merged.add(prev); // 最后一段
        
        // 4. 合并后的空隙就是空闲时间
        for (int i = 1; i < merged.size(); i++) {
            int freeStart = merged.get(i-1).end;
            int freeEnd = merged.get(i).start;
            res.add(new Interval(freeStart, freeEnd));
        }
        
        return res;
    }
}