package com.bala.reverseInteger;

public class Solution {
    /*
    Given a 32-bit signed integer, reverse digits of an integer.

Example 1:
Input: 123
Output: 321
Example 2:
Input: -123
Output: -321
Example 3:
Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only store integers within
 the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem,
 assume that your function returns 0 when the reversed integer overflows.
     */

    public static int reverse(int i){
        int rev=0,newRev=0,m=0,d=i;
        while(d!=0){
            m = d % 10;
            newRev = rev *10 +m;
            if ((newRev-newRev%10)/10 != rev) //如果逆运算结果和之前不相等，则判断出现了溢出，返回0
                return 0;
            else
                rev = newRev;
            d = d / 10;
        }
        return rev;
    }


    /*
    Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

    Example 1:

    Input: 121
    Output: true
    Example 2:

    Input: -121
    Output: false
    Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
    Example 3:

    Input: 10
    Output: false
    Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
    Follow up:

    Could you solve it without converting the integer to a string?

     */
    /*
        利用上面reverse的方法，判断reverse一半时是否相等
     */
    public static boolean isPalindrome(int x){
        if (x<0) return false;
        int rev=0 ,newRev=0;
        int mod , div=x;//mod指余数，div指商
        boolean ans = false;
        while(newRev<div){
            mod = div % 10;
            div = div / 10;
            newRev = rev * 10 +mod;
            if (newRev==div||rev==div) ans = true;
            rev = newRev;

        }
        return ans;
    }

    /*
        直接判断循环判断左右两位是否相等，难点在于获取首位的值
     */
    public static boolean isPalindrome2(int x){
        if (x<0) return false;
        int div = 1, num = x;
        while (num/div>=10){
            div*=10;
        }
        while (num>0){
            int left = num /div;
            int right = num % 10;
            if (left!=right) return false;
            num = (num%div) / 10; //去掉首位和末位
            div/=100;
        }
        return true;
    }
}
