package dynamicProgramming.media;

import org.junit.jupiter.api.Test;

/*
给你一个字符串 s，找到 s 中最长的 回文 子串。



示例 1：

输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。
示例 2：

输入：s = "cbbd"
输出："bb"


提示：

1 <= s.length <= 1000
s 仅由数字和英文字母组成
 */

public class LongestPalindromicSubstring {

    @Test
    public void test() {
        System.out.println(longestPalindrome("cbbbd"));
    }

    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        int[] max = new int[s.length()];
        max[0] = 1;
        String maxStr = s.charAt(0) + "";
        for (int i = 1; i < max.length; i++) {
            int pre = max[i - 1];
            String compare = "";
            int start = i - pre - 1;
            if (start < 0) {
                start = 0;
            }
            for (int j = start; j < i + 1; j++) {
                String tmp = s.substring(j, i + 1);
                if (isPalindrome(tmp)) {
                    compare = tmp;
                    max[i] = compare.length();
                    break;
                }
            }
            if (compare.length() >= maxStr.length()) {
                maxStr = compare;
            }
        }
        return maxStr;
    }

    private boolean isPalindrome(String s) {
        int start = 0;
        while (start < s.length() / 2) {
            if (!(s.charAt(start) == s.charAt(s.length() - 1 - start))) {
                return false;
            }
            start++;
        }
        return true;
    }

}
