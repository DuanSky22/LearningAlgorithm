package com.sky.company.netease;

import java.util.Scanner;

/**
 * Created by DuanSky on 2016/9/18.
 */
public class _02Black {

    private static char dot = '.';
    private static char black = '*';
    private static char white = 'o';

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int N = Integer.valueOf(in.nextLine());
        for(int t = 0; t < N; t++){
            char[][] board = new char[8][8];
            for(int i = 0; i < 8; i++){
                String line = in.nextLine();
                for(int j = 0; j < 8; j++){
                    board[i][j] = line.charAt(j);
                }
            }
            int step = Integer.valueOf(in.nextLine());
            int[][] steps = new int[step][3];
            for(int i = 0; i < step; i++){
                String[] line = in.nextLine().split(" ");
                for(int j = 0; j < 3; j++){
                    steps[i][j] = Integer.valueOf(line[j]);
                }
            }

            move(board,steps);
            print(board);

        }
    }

    public static void move(char[][] board,int[][] steps){
        for(int i = 0; i < steps.length; i++) {
            char mode = black;
            if(steps[i][2] == 1) mode = white;
            moveOneStep(board, steps[i][0], steps[i][1],mode);
        }
    }

    public static void moveOneStep(char[][] board,int x,int y, char mode){
        //left
        board[x][y] = mode;
        int left = testLeft(board,x,y,mode);
        if(left > 0){
            for(int i = y; i > left; i--){
                board[x][i]=mode;
            }
        }
        //right
        int right = testRight(board,x,y,mode);
        if(right > 0){
            for(int i = y;  i < right; i++){
                board[x][i] = mode;
            }
        }

        int up = testUp(board,x,y,mode);
        if(up > 0){
            for(int i = x; i > up; i--){
                board[i][y] = mode;
            }
        }

        int down = testDown(board,x,y,mode);
        if(down > 0){
            for(int i = x; i < down; i++){
                board[i][y] = mode;
            }
        }

        int leftUp = testLeftUp(board,x,y,mode);
        if(leftUp > 0){
            for(int i = 1; i < leftUp; i++){
                board[x-i][y-i] = mode;
            }
        }

        int leftDown = testLeftDown(board,x,y,mode);
        if(leftDown > 0){
            for(int i = 1; i < leftDown; i++){
                board[x+i][y-i] = mode;
            }
        }

        int rightUp = testRightUp(board,x,y,mode);
        if(rightUp > 0){
            for(int i = 1; i < rightUp; i++){
                board[x-i][y+i]=mode;
            }
        }

        int rightDown = testRightDown(board,x,y,mode);
        if(rightDown > 0){
            for(int i = 1; i < rightDown; i++){
                board[x+i][y+i] = mode;
            }
        }

    }

    public static int testLeft(char[][] board,int x,int y,char mode){
        char aside = white;
        if(mode == white) aside = black;

        int left = y - 1;
        for(; left >= 0; left--){
            if(board[x][left] == mode) return left;
            else if(board[x][left] == dot) return -1;
        }
        return -1;
    }

    public static int testRight(char[][] board,int x,int y,char mode){
        char aside = white;
        if(mode == white) aside = black;

        int right = y + 1;
        for(; right < board[0].length; right++){
            if(board[x][right] == mode) return right;
            else if(board[x][right] == dot) return -1;
        }
        return -1;
    }

    public static int testUp(char[][] board,int x,int y,char mode){
        char aside = white;
        if(mode == white) aside = black;
        int up = x - 1;
        for(; up >= 0; up--){
            if(board[up][y] == mode)
                return up;
            else if(board[up][y] == dot)
                return -1;
        }
        return -1;
    }

    public static int testDown(char[][] board,int x,int y,char mode){
        char aside = white;
        if(mode == white) aside = black;

        int down = x + 1;
        for(; down < board.length; down++){
            if(board[down][y] == mode) return down;
            else if(board[down][y] == dot) return -1;
        }
        return -1;
    }

    public static int testLeftUp(char[][] board,int x,int y,char mode){
        char aside = white;
        if(mode == white) aside = black;
        int k = 1;
        int xx = x - k; int yy = y - k;
        for(; xx >= 0 && yy >= 0; k++){
            if(board[xx][yy] == mode) return k;
            else if(board[xx][yy] == dot) return -1;
            xx = x - k; yy = y - k;
        }
        return -1;
    }

    public static int testLeftDown(char[][] board,int x,int y,char mode){
        char aside = white;
        if(mode == white) aside = black;
        int k = 1;
        int xx = x + k, yy = y - k;
        for(; xx < board.length && yy >= 0; k++){
            if(board[xx][yy] == mode) return k;
            else if(board[xx][yy] == dot) return -1;
            xx = x + k; yy = y - k;
        }
        return -1;
    }

    public static int testRightUp(char[][] board,int x,int y,char mode){
        char aside = white;
        if(mode == white) aside = black;
        int k = 1;
        int xx = x - k, yy = y + k;
        for(; xx >= 0 && yy < board[0].length; k++){
            if(board[xx][yy] == mode) return k;
            else if(board[xx][yy] == dot) return -1;
            xx = x - k; yy = y + k;
        }
        return -1;
    }

    public static int testRightDown(char[][] board,int x,int y,char mode){
        char aside = white;
        if(mode == white) aside = black;
        int k = 1;
        int xx = x + k, yy = y + k;
        for(; xx < board.length && yy < board[0].length; k++){
            if(board[xx][yy] == mode) return k;
            else if(board[xx][yy] == dot) return -1;
            xx = x + k; yy = y + k;
        }
        return -1;
    }

    public static void print(char[][] board){
        int blackNum = 0; int whiteNum = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == black) blackNum++;
                if(board[i][j] == white) whiteNum++;
            }
        }
        System.out.println(blackNum+","+whiteNum);
    }
}
