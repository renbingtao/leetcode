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
        System.out.println(longestPalindrome("cbbd"));
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
            //abac型
            if (i - pre - 1 < 0) {
                max[i] = 1;
                String tmp = s.substring(0, i + 1);
                if (isPalindrome(tmp)) {
                    compare = tmp;
                    max[i] = i;
                }
            } else {
                if (s.charAt(i) == s.charAt(i - pre - 1)) {
                    max[i] = max[i - 1] + 2;
                    compare = s.substring(i - pre - 1, i + 1);
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

    public String longestPalindromeOld(String s) {
        if (s.length() == 1) {
            return s;
        }

        int[] max = new int[s.length()];
        boolean[] sames = new boolean[s.length()];
        max[0] = 1;
        sames[0] = true;
        String maxStr = s.charAt(0) + "";

        for (int i = 1; i < max.length; i++) {
            int pre = max[i - 1];
            boolean preSame = sames[i - 1];

            //abb型
            if (preSame && s.charAt(i) == s.charAt(i - 1)) {
                max[i] = max[i - 1] + 1;
                sames[i] = true;
                maxStr = maxStr + s.charAt(i);
                continue;
            }

            //abac型
            if (i - pre - 1 < 0) {
                max[i] = 1;
                sames[i] = true;
                //ab型
                if (maxStr.length() == 1 && pre == 1) {
                    maxStr = s.charAt(i) + "";
                }
                continue;
            }
            //aba型
            if (s.charAt(i) == s.charAt(i - pre - 1)) {
                max[i] = max[i - 1] + 2;
                String compare = s.substring(i - pre - 1, i + 1);
                if (compare.length() >= maxStr.length()) {
                    maxStr = compare;
                }
            } else {
                //abc型
                max[i] = 1;
                sames[i] = true;
                if (maxStr.length() == 1 && pre == 1) {
                    maxStr = s.charAt(i) + "";
                }
            }
        }
        return maxStr;
    }

}
