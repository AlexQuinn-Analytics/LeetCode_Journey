class Solution {
    public String decodeString(String s) {
        int index=0;
        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<String> strStack = new ArrayDeque<>();
        StringBuilder res = new StringBuilder();
        while (index<s.length()){
            char c = s.charAt(index);
            if(Character.isDigit(c)){
                int count=0;
                while (index<s.length()&&Character.isDigit(s.charAt(index))){
                    count = count*10 + (s.charAt(index++) - '0');
                }
                countStack.push(count);
            }else if (c == '['){
                strStack.push(res.toString());
                res = new StringBuilder();
                index++;
            }else if (c == ']'){
                StringBuilder temp = new StringBuilder(strStack.pop());
                int count=countStack.pop();
                for (int n=0;n<count;n++){
                    temp.append(res);
                }
                res = temp;
                index++;
            }else{
                res.append(s.charAt(index));
                index++;
            }
        }
    return res.toString();    
    }
}