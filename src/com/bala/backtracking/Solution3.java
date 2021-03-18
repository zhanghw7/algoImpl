package com.bala.backtracking;

import java.util.*;

/**
 * @Description
 * @Author Zhang Hongwei
 * @Date 2020/11/14 15:21
 */
public class Solution3 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ret = new ArrayList<>();
        backtrace(ret, new ArrayList<>(), 0, n);
        return ret;
    }

    public void backtrace(List<List<String>> finalResult, List<String> curSol, int curRow, int totalRow){
        if(curRow == totalRow){
            finalResult.add(new ArrayList(curSol));
            return;
        }
        for(int col = 0; col < totalRow; col++){
            if(isAvailable(curSol, col)){
                curSol.add(getRowString(col, totalRow));
                backtrace(finalResult, curSol, curRow + 1, totalRow);
                curSol.remove(curSol.size() - 1);
            }
        }
    }

    public String getRowString(int posOfQ, int totalCol){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < totalCol; i++){
            sb.append(i == posOfQ ? "Q" : ".");
        }
        return sb.toString();
    }

    //判断当前位置是否可以放置
    public boolean isAvailable(List<String> curSol, int curCol){
        if( curSol == null){
            return true;
        }
        for(int i = 0; i < curSol.size(); i++){
            String curStr = curSol.get(i);
            double k = (double)(curStr.indexOf("Q") - curCol) / (i - curSol.size());// 斜率
            if(k == 0 || k == -1 || k == 1){
                return false;
            }
        }
        return true;
    }

    public static int findRepeatNumber(int[] nums) {
        int temp;
        for(int i=0;i<nums.length;i++){
            while (nums[i]!=i){
                if(nums[i]==nums[nums[i]]){
                    return nums[i];
                }
                temp=nums[i];
                nums[i]=nums[temp];
                nums[temp]=temp;
            }
        }
        return -1;
    }

    private static int[][] arr = {{1,0},{0,1},{-1,0},{0,-1}};

    private static boolean flag = false;

    public static boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length;i++){
            for(int j = 0; j < board[0].length; j++){
                backtracing(board, word, 0, 0, 0, new int[200][200]);
            }
        }
        return flag;
    }

    private static void backtracing(char[][] board, String word, int i, int j, int length, int[][] map){
        if (length == word.length()){
            flag = true;
            return;
        }
        if (i >= board.length || i < 0 || j >=board[0].length || j < 0 || map[i][j] == 1 || board[i][j] != word.charAt(length)){
            return;
        }
        map[i][j] = 1;
        for (int k = 0; k < arr.length; k++) {
            backtracing(board, word, i + arr[k][0], j + arr[k][1], length + 1, map);
        }
        map[i][j] = 0;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "SEE";
        System.out.println(exist(board, word));
    }


}
