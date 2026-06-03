class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        if (words.length==1) return Arrays.asList(words);
        HashMap<String,Integer>freq=new HashMap<>();
        for (String word:words){
            freq.put(word,freq.getOrDefault(word,0)+1);
        }
        PriorityQueue<String>q=new PriorityQueue<>((a,b)->{

        int freqCompare = freq.get(a) - freq.get(b);
        
        if (freqCompare == 0) {
            return b.compareTo(a);
        }
        
        return freqCompare;
    });

        for (String word:freq.keySet()){
            if (q.size()<k){
                    q.offer(word);
            }else{
                String minString=q.peek();
                int minFreq=freq.get(minString);
                if (minFreq<freq.get(word)){
                    q.poll();
                    q.offer(word);
                }else if (minFreq==freq.get(word)){
                    int result=word.compareTo(minString);
                    if (result<0){
                        q.poll();
                        q.offer(word);
                    }else{
                        continue;
                    }
                }
            }
        }
        List<String>res=new ArrayList<>();
        while (!q.isEmpty()){
            res.add(0, q.poll());
        }
        return res;

    }
}