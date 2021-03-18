package com.bala.isPalindrome;

import com.bala.list.removeNthListNode.ListNode;

import java.util.Arrays;

public class Solution {
    /**
     * 判断是否是回文数，转换为字符串
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x<0) return false;
        String s = String.valueOf(x);
        for (int i = 0; i < s.length()&&i<(s.length()-1-i); i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                return false;
        }
        return true;
    }
    public boolean isPalindrome2(int x){
        if (x<0) return false;
        int reverse = 0;
        int cur = x;
        while (reverse < cur){
            reverse = reverse*10 + cur%10;
            if (reverse==cur||reverse==cur/10)
                return true;
            cur/=10;
        }
        return false;
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode snake = dummy;
        while (l1!=null&&l2!=null){
            if (l1.val<l2.val){
                snake.next = l1;
                l1 = l1.next;
            }else {
                snake.next = l2;
                l2 = l2.next;
            }
            snake = snake.next;
        }
        snake.next = l1==null?l2:l1;
        return dummy.next;
    }

    public int reverse(int x) {//2147483647 //-2147483648
        if (x/10==0) return x;
        int rev = 0;
        while (x/10!=0){
            rev = rev*10 + x%10;
            x/=10;
        }
        if (rev>Integer.MAX_VALUE/10||(rev==Integer.MAX_VALUE/10&&x>7)) return 0;
        if (rev<Integer.MIN_VALUE/10||rev==Integer.MIN_VALUE/10&&x<-8) return 0;
        return rev*10+x;
    }

    public int maxSubArray(int[] nums) {//有问题
        if (nums.length==1) return nums[0];
        int[] opt = new int[nums.length];
        opt[0] = nums[0];
        int[] curMax = new int[nums.length];
        curMax[0] = nums[0];
        int max = opt[0];
        for (int i = 1; i < nums.length; i++) {
            curMax[i] = Math.max(curMax[i-1] +nums[i],nums[i]);
            opt[i] = Math.max(curMax[i],opt[i-1]);
            max = Math.max(max,opt[i]);
        }
        return max;
    }
    /*public int maxSubArray(int[] nums) {
        int max =nums[0];
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            max = Math.max(sum,max);
            for (int j = i+1; j < nums.length; j++) {
                sum += nums[j];
                max = Math.max(sum,max);
            }
        }
        return max;
    }*/

   /** 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
    示例 1：
    输入: "babad"
    输出: "bab"
    注意: "aba" 也是一个有效答案。
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/longest-palindromic-substring
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    */
   public String longestPalindrome(String s) {
       if (s.length()==0||s.length()==1) return s;
       boolean[][] dp = new boolean[s.length()][s.length()];//记录substring（index，index）是否为回文串
       int[] max = {0,0};
       for (int i = 0; i < s.length(); i++) {//把长度为1的加进去
           dp[i][i] = true;
       }
       for (int i = 0; i <s.length()-1 ; i++) {//把长度为2的加进去
           if (s.charAt(i)==s.charAt(i+1)) {
               dp[i][i + 1] = true;
               max = new int[]{i, i + 1};
           }
       }
       for (int i = s.length()-3; i >=0; i--) {//
           int mark = i;
           for (int j = i+2; j < s.length(); j++) {
               if (s.charAt(i)==s.charAt(j) && dp[i + 1][j - 1]) {
                   dp[i][j] = true;
                   mark = j;
               }
           }
           max = max[1]-max[0]>mark-i?max:new int[]{i,mark};
       }
       return s.substring(max[0],max[1]+1);
   }
    private static boolean isPalindrome(String s,int startIndex,int endIndex) {
        if (s.length()==0||startIndex>endIndex) return false;
        for (int i = startIndex,j=endIndex;i<=j; i++,j--) {
            if (s.charAt(i) != s.charAt(j))
                return false;
        }
        return true;
    }

}
