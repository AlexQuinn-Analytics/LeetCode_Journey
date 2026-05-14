class Solution {
    public String alienOrder(String[] words) {
        Map<Character, List<Character>>graph=new HashMap<>();
        Map<Character, Integer>inDegree=new HashMap<>();
        for (String word:words){
            for (char c:word.toCharArray()){
                graph.putIfAbsent(c, new ArrayList<Character>());
                inDegree.putIfAbsent(c, 0);
            }
        }
        for (int i=0;i<words.length-1;i++){
            String word1=words[i];
            String word2=words[i+1];
            int minLen=Math.min(word1.length(), word2.length());
            if (word1.length()>word2.length()&&word1.startsWith(word2)) return "";
            for (int j=0;j<minLen;j++){
                char x=word1.charAt(j), y=word2.charAt(j);
                if (x!=y){
                    if (!graph.get(x).contains(y)){
                        graph.get(x).add(y);
                        inDegree.put(y, inDegree.get(y)+1);
                    }
                    break;
                }
            }
        }
        Queue<Character>queue=new LinkedList<>();
        for (char c:inDegree.keySet()){
            if (inDegree.get(c)==0){
                queue.add(c);
            }
        }
        StringBuilder sb=new StringBuilder();
        while (!queue.isEmpty()){
            char cur=queue.poll();
            sb.append(cur);
            for (char c:graph.get(cur)){
                inDegree.put(c, inDegree.get(c)-1);
                if (inDegree.get(c)==0){
                    queue.add(c);
                }
            }
        }
        return sb.length()==graph.size()?sb.toString():"";

    }
}
