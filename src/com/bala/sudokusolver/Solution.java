package com.bala.sudokusolver;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * 编写一个程序，通过已填充的空格来解决数独问题。
     * 一个数独的解法需遵循如下规则：
     * 数字 1-9 在每一行只能出现一次。
     * 数字 1-9 在每一列只能出现一次。
     * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
     * 空白格用 '.' 表示。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sudoku-solver
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param board
     */
    public void solveSudoku(char[][] board) {
        if (board==null||board.length!=9||board[0].length!=9) return;
        helper(board, 0, 0);
    }
    private static boolean helper(char[][] board, int row, int col){
        while (row < 9&& col < 9){
            if (board[row][col]=='.') break;
            else {
                row = col == 8 ? row+1:row;
                col = col == 8 ? 0 : col+1;
            }
        }
        if (row==9) return true;
        for (char i = '1'; i <='9' ; i++) {
            if (isValid(board, row, col, i)) {
                board[row][col] = i;
                if (helper(board, col == 8 ? row+1:row, col == 8 ? 0 : col+1))
                    return true;
                board[row][col] = '.';
            }
        }
        return false;
    }
    private static boolean isValid(char[][] board, int row, int col, char c){
        for (int i = 0; i < board.length; i++) {
            if (board[row][i]==c||board[i][col]==c)
                return false;
        }
        int boxRow = row/3*3;
        int boxCol = col/3*3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[boxRow+i][boxCol+j]==c)
                    return false;
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        Set[] rows = new Set[9];
        for (int i = 0; i < 9; i++)
            rows[i] = new HashSet();
        Set[] cols = new Set[9];
        for (int i = 0; i < 9; i++)
            cols[i] = new HashSet();
        Set[] boxes = new Set[9];
        for (int i = 0; i < 9; i++)
            boxes[i] = new HashSet();
        int row = 0;
        int col = 0;
        while (row < 9 && col < 9) {
            char c = board[row][col];
            int boxNum = row / 3 * 3 + col / 3;
            if (c != '.') {
                if ((rows[row].contains(c) ||
                        cols[col].contains(c) ||
                        boxes[boxNum].contains(c)))
                    return false;
                else {
                    rows[row].add(c);
                    cols[col].add(c);
                    boxes[boxNum].add(c);
                }
            }
            if (col==8){
                row++;
                col=0;
            }
            else col++;
        }
        return true;
    }
    public boolean isValidSudoku2(char[][] board){
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];
        int row = 0;
        int col =0;
        while (row<9&&col<9){
           int ch = board[row][col] - '1';
           int boxNum = row/3*3+col/3;
            if (ch!='.'){
                if (rows[row][ch] || cols[ch][col] || boxes[boxNum][ch])
                    return false;
                else {
                    rows[row][ch]=true;
                    cols[ch][col]=true;
                    boxes[boxNum][ch]=true;
                }
            }
            if (col==8){
                row++;
                col=0;
            }
            else col++;
        }
        return true;
    }
}
