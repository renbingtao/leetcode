package dynamicProgramming.media.string;

/*
给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。

子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。



示例 1：

输入：s = "bbbab"
输出：4
解释：一个可能的最长回文子序列为 "bbbb" 。
示例 2：

输入：s = "cbbd"
输出：2
解释：一个可能的最长回文子序列为 "bb" 。


提示：

1 <= s.length <= 1000
s 仅由小写英文字母组成
 */

import org.junit.jupiter.api.Test;

public class LongestPalindromicSubSequence {

    @Test
    public void test() {
        System.out.println(longestPalindromeSubseq("bbbab"));
    }

    public int longestPalindromeSubseq(String s) {
        if (s.length() == 1) {
            return 1;
        }
        int[] longest = new int[s.length()];
        longest[0] = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            int tmp = longestPalindrome(s.substring(0, i + 1)).length();
            longest[i] = Math.max(longest[i - 1], tmp);
        }
        return longest[longest.length - 1];
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
