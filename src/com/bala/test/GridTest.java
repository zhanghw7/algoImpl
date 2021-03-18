package com.bala.test;

public class GridTest {
    public static int surfaceArea(int[][] grid) {
        int result = 0;
        for(int i = 0;i < grid.length;i++){
            for(int j = 0;j < grid[0].length;j++){
                result +=(grid[i][j]*4+2);
                int right = j == grid[0].length-1?0:Math.min(grid[i][j],grid[i][j+1]);
                int down = i == grid.length-1?0:Math.min(grid[i][j], grid[i+1][j]);
                result -= 2*(right+down);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,0},{0,2}};
        System.out.println(surfaceArea(grid));
    }
}
