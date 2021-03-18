package com.bala.longestSubString;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Solution {
      /*利用LinkedHashetS，它可以按存储顺序取出*/
    public static String GetLongestSubString(String s) {
        int maxLength = 0;
        String longestSub = null;
        Set<Character> set = new LinkedHashSet<>();

        for (int i = 0; i < s.length(); i++) {
            Character aChar = s.charAt(i);
            if (set.contains(aChar)) {  //如果包含就按顺序删除c和它之前的值
                Iterator<Character> iterator = set.iterator();
                StringBuilder sb = new StringBuilder();//用于存储删除的值
                boolean flag = false;
                while (iterator.hasNext()) {
                    Character ch = iterator.next();
                    sb.append(ch);
                    if (!flag) {
                        if (ch == aChar)
                            flag = true;
                        iterator.remove();
                    }
                }
                if (sb.length() > maxLength) {
                    maxLength = sb.length();
                    longestSub = sb.toString();
                }
            }

            set.add(aChar);
        }
        //判断最后set中字符的长度
        StringBuilder sb1 = new StringBuilder();
        Iterator<Character> iterator = set.iterator();
        while (iterator.hasNext())
            sb1.append(iterator.next());

        if (sb1.length() > maxLength) {
            maxLength = sb1.length();
            longestSub = sb1.toString();
        }
        return longestSub;
        }

        /*利用一个Boolean数组来进行判断*/

        public static String getLongestSubString2(String s){
                 if(s==null||s.length()==0) return null;
                boolean[] boo = new boolean[128];
                int left = 0, right=0;
                int maxLength=0,startPoint = 0;
                while (right<s.length()){
                    char aChar = s.charAt(right);
                    if(!boo[aChar]){//char的十进制数当成数组的index
                        boo[aChar]=true;
                        right++;
                    }else {
                        if((right-left)>maxLength){
                            maxLength=right-left;
                            startPoint=left;
                        }
                        while (s.charAt(left)!=aChar){
                            boo[s.charAt(left)]=false;
                            left++;
                        }
                        left++;
                        right++;
                    }
                }
            if((right-left)>maxLength){
                maxLength=right-left;
                startPoint=left;
            }
            return  s.substring(startPoint,startPoint+maxLength);

        }

        /*测试*/
    public static void main(String[] args) {
        String s = "http://how2j.cn/k/number-string/number-string-manipulate/325.html#nowhere";
       System.out.println(GetLongestSubString(s));
        System.out.println(getLongestSubString2(s));


    }
}
