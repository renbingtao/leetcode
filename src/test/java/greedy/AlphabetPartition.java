package greedy;

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

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class AlphabetPartition {

    @Test
    public void test() {
        List<Integer> abc = partitionLabels("ababcbacadefegdehijhklij");
        System.out.println(abc);
    }

    public List<Integer> partitionLabels(String s) {
        ArrayList<Integer> response = new ArrayList<>();
        String tmp = s;
        Integer partition = getPartition(tmp);
        while (partition > 0) {
            response.add(partition);
            tmp = tmp.substring(partition);
            partition = getPartition(tmp);
        }
        return response;
    }

    private Integer getPartition(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int start = 0;
        int end = 0;
        int curIndex = 0;

        int curZimu = s.charAt(0);

        for (int i = s.length() - 1; i >= 0; i--) {
//            System.out.println(s.charAt(i));
            if (s.charAt(i) == curZimu) {
                end = i;
                break;
            }
        }

        while (end > curIndex) {
            curIndex++;
            curZimu = s.charAt(curIndex);
//            System.out.println(s.charAt(curIndex));
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) == curZimu) {
                    if (i > end) {
                        end = i;
                    }
                    break;
                }
            }
        }

        return end - start + 1;
    }

}
