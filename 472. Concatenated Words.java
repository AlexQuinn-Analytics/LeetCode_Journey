import java.util.*;

class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>(Arrays.asList(words));

        for (String word : words) {
            if (word.isEmpty()) continue;
            if (isConcatenated(word, set, new HashMap<>())) {
                res.add(word);
            }
        }
        return res;
    }

    private boolean isConcatenated(String s, Set<String> set, Map<String, Boolean> memo) {
        if (memo.containsKey(s))
            return memo.get(s);

        for (int i = 1; i < s.length(); i++) {
            String prefix = s.substring(0, i);
            String suffix = s.substring(i);
            if (set.contains(prefix)) {
                if (set.contains(suffix) || isConcatenated(suffix, set, memo)) {
                    memo.put(s, true);
                    return true;
                }
            }
        }
        memo.put(s, false);
        return false;
    }
}