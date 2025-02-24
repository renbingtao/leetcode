package dynamicProgramming.media.string;

/*
给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。

注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。



示例 1：

输入: s = "leetcode", wordDict = ["leet", "code"]
输出: true
解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
示例 2：

输入: s = "applepenapple", wordDict = ["apple", "pen"]
输出: true
解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
     注意，你可以重复使用字典中的单词。
示例 3：

输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
输出: false


提示：

1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s 和 wordDict[i] 仅由小写英文字母组成
wordDict 中的所有字符串 互不相同
 */

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordSplit {

    @Test
    public void test() {
        String s = "applepenapple";
        ArrayList<String> list = new ArrayList<>();
        list.add("apple");
        list.add("pen");
        System.out.println(wordBreak(s, list));
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
