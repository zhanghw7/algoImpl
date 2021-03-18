package com.bala.letterCombinationOfPhoneNumber;

import java.util.*;

public class Solution {
    /*
    给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

示例:

输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
说明:
尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    /*
    递归方法
     */
    public List<String> letterCombinations(String digits) {
        Map<Character,char[]> map = new HashMap<>();
        map.put('2',new char[]{'a','b','c'});
        map.put('3',new char[]{'d','e','f'});
        map.put('4',new char[]{'g','h','i'});
        map.put('5',new char[]{'j','k','l'});
        map.put('6',new char[]{'m','n','o'});
        map.put('7',new char[]{'p','q','r','s'});
        map.put('8',new char[]{'t','u','v'});
        map.put('9',new char[]{'w','x','y','z'});

        List<String> list = new LinkedList<>();
        helper("",0,digits,map,list);

        return list;
    }
    public void helper(String cur, int index, String digits, Map<Character,char[]> map, List<String> list){
        if (index==digits.length()) {
            list.add(cur);
        }else{
            char c = digits.charAt(index);
            if (map.containsKey(c)){
                for (char ch: map.get(c)
                     ) {
                    helper(cur+ch, index+1, digits, map,list);
                }
            }
        }

    }
/*
队列方法
 */
    public List<String> letterCombinations2(String digits){
        Map<Character,char[]> map = new HashMap<>();// 完成数字和字母的映射
        map.put('2',new char[]{'a','b','c'});
        map.put('3',new char[]{'d','e','f'});
        map.put('4',new char[]{'g','h','i'});
        map.put('5',new char[]{'j','k','l'});
        map.put('6',new char[]{'m','n','o'});
        map.put('7',new char[]{'p','q','r','s'});
        map.put('8',new char[]{'t','u','v'});
        map.put('9',new char[]{'w','x','y','z'});

        Queue<String> queue = new LinkedList<>();
        queue.offer("");
        int index = 0;
        while (index<digits.length()){ //从参数的第一个数字开始，让其对应的所有字符与原队列中每一个相加，并加入到queue中
            char c = digits.charAt(index);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String s= queue.poll();
                for (char ch: map.get(c)
                     ) {
                    queue.offer(s+ch);
                }
            }
            index++;
        }
        return (List<String>) queue;
    }

}
