package com.bala.addBinary;

public class Solution {
    /**
    Given two binary strings, return their sum (also a binary string).
The input strings are both non-empty and contains only characters 1 or 0.
Example 1:
Input: a = "11", b = "1"
Output: "100"
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-binary
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
 /*   public String addBinary(String a, String b) {
        int i = a.length()-1;
        int j = b.length()-1;
        int k =(Math.max(a.length(), b.length()))-1;
        char[] res = new char[k+1];
        char carry = '0';
        while (j>=0||i>=0){
            char c1 = i<0?'0':a.charAt(i);
            char c2 = j<0?'0':b.charAt(j);
            if (c1=='0'&&c2=='0'){
                res[k]=carry;
                carry='0';
            }
            else if (c1=='1'&&c2=='1'){
                res[k] = carry;
                carry='1';
            }else {
                if (carry=='0'){
                    res[k]='1';
                    carry='0';
                }
                else {
                    res[k]='0';
                    carry='1';
                }
            }
            k--;
            i--;
            j--;
        }
        if (carry=='1')
            return carry+ new String(res);
        else
            return new String(res);
    }*/
    public String addBinary(String a, String b){
        char[] ans  = new char[Math.max(a.length(),b.length())];
        int carry = 0;
        for (int i = a.length()-1,j=b.length()-1,k = ans.length-1; i >=0||j>=0; i--,j--,k--) {
            int sum = carry;
            sum+=i>=0?a.charAt(i)-'0':0;
            sum+=j>=0?a.charAt(j)-'0':0;
            ans[k] = (char) (sum % 2+48);
            carry = sum / 2;
        }
        String res = carry==1?"1"+new String(ans):new String(ans);
        return res;
    }
}
