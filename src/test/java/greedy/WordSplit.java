package greedy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。

注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。

返回一个表示每个字符串片段的长度的列表。



示例 1：
输入：s = "ababcbacadefegdehijhklij"
输出：[9,7,8]
解释：
划分结果为 "ababcbaca"、"defegde"、"hijhklij" 。
每个字母最多出现在一个片段中。
像 "ababcbacadefegde", "hijhklij" 这样的划分是错误的，因为划分的片段数较少。
示例 2：

输入：s = "eccbbbbdec"
输出：[10]


提示：

1 <= s.length <= 500
s 仅由小写英文字母组成
 */

public class WordSplit {

    @Test
    public void test() {
        String s = "leetcode";
        ArrayList<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        boolean b = wordBreak(s, wordDict);
        System.out.println(b);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordSet = new HashSet<>();
        for (String dict : wordDict) {
            wordSet.add(dict);
        }

        boolean[] wordExist = new boolean[s.length() + 1];

        for (int i = 0; i <= s.length(); i++) {
            if (wordSet.contains(s.substring(0, i))) {
                wordExist[i] = true;
                System.out.println("i=" + i + ":" + s.substring(0, i));
            } else {
                for (int j = 0; j <= i; j++) {
                    if (wordExist[j] && wordSet.contains(s.substring(j, i))) {
                        wordExist[i] = true;
                        break;
                    }
                }
            }
        }

        return wordExist[s.length()];
    }

}
