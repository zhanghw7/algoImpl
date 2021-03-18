package com.bala.zigzag;

public class ZigzagTest {
    public static void main(String[] args) {
        String s = "abcdefghijkl";
        System.out.println(Solution.zigZagconvert(s,3));
    }

    public String convert(String s, int numRows) {
        if (s.length()<=numRows) return s;
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < sb.length; i++) {//初始化
            sb[i] = new StringBuilder();
        }
        int p = 0;
        boolean down = true;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb[p].append(s.charAt(i));
            if (down) {
                if (p==numRows-1){
                    down=false;
                    p--;
                }
                else p++;
            }else {
                if (p==0){
                    down=true;
                    p++;
                }
                else p--;
            }
        }
        for (StringBuilder stringBuilder : sb) {
            res.append(stringBuilder);
        }
        return res.toString();
    }
}
