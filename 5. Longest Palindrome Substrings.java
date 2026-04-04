class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) return s;

        int maxLen = 0;
        int start = 0;

        for (int i = 0; i < len; i++) {
            // 每个中心都试两种：奇数长度、偶数长度
            int len1 = expand(s, i, i);   // 奇
            int len2 = expand(s, i, i+1); // 偶

            int currentMax = Math.max(len1, len2);

            if (currentMax > maxLen) {
                maxLen = currentMax;
                // 计算回文起始位置
                start = i - (maxLen - 1) / 2;
            }
        }

        return s.substring(start, start + maxLen);
    }

    // 返回以 left/right 为中心的最长回文长度
    private int expand(String m, int left, int right) {
        while (left >= 0 && right < m.length() && m.charAt(left) == m.charAt(right)) {
            left--;
            right++;
        }
        // 退出时不相等，真实长度是 (right-1)-(left+1)+1 = right-left-1
        return right - left - 1;
    }
}