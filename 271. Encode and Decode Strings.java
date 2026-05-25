public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb=new StringBuilder();
        for (String word:strs){
            sb.append(word.length()).append('#').append(word);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int i=0;
        List<String>res=new ArrayList<>();
        while (i<s.length()){
            int j=i;
            while (s.charAt(j)!='#'){
                j++;
            }
            int len=Integer.parseInt(s.substring(i, j));
            res.add(s.substring(j+1,j+1+len));
            i=j+1+len;
        }
        return res;
    }
}

