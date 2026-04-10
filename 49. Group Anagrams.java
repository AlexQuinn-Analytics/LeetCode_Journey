class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String str:strs){
            char[] strArray=str.toCharArray();
            Arrays.sort(strArray);
            String newstr=new String(strArray);
            if (map.containsKey(newstr)){
                map.get(newstr).add(str);
            }else{
                ArrayList<String> arrList=new ArrayList<>();
                arrList.add(str);
                map.put(newstr,arrList);
            }
        }
            List<List<String>>results=new ArrayList<>();
            for (String str:map.keySet()){
                results.add(map.get(str));
            }
        return results;
    }
}