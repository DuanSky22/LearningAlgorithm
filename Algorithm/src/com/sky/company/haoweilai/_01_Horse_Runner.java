package com.sky.company.haoweilai;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by DuanSky on 2016/9/21.
 * [pay attention]
 *      这个问题描述的有缺陷啊。棋盘的大小是8*8的，但是中国象棋的走法是走格子的交叉线，而不是方格内部。
 *   那么最左边的线（标号为0的线）是否可以走呢？最右边的线（标号为8的线）是否也可以走呢？如果都可以走的话，
 *   这样的棋盘应该叫做9*9吧。在本题中，我按照最左和最后都可以走的条件来求解。
 * [idea]
 *     这道题可以有两种方式来解答，第一种是考虑到棋盘本身比较小，可以存储所有从p点位置开始的能够到达的位置，因为本身
 * 棋盘比较小，这对内存来说是可以接受的，而且缓存这些结果后，后续的访问就很方便，而且可以很快判断q是否在该集合中。
 * 这种方式比较simple,因此第二种方式是采用深度优先遍历，从头到尾遍历所有可能走过的路径，同时记录之前走过的路径来避免重复
 * 判断q是否在这个路径内。
 */
public class _01_Horse_Runner {


    /**
     * BOARD_SIZE: the size of the chess board. Here is 8.
     */
    private static int BOARD_SIZE = 8;


    /**
     * Can the horse ride from p to q.
     * @param p the start position of the horse.
     * @param q the end position of the horse.
     * @return true if the horse can get to q from p, otherwise false.
     */
    public boolean isReachable(int[] p,int[] q){
        boolean res = achieveablePos(p,q,new LinkedList<>());
        return res;
    }

    /**
     * get the path from p to q.
     * @param p the start position.
     * @param q the end position.
     * @return null if there is no path from p to q, otherwise the path from p to q.
     */
    public int[][] getPath(int[] p,int[] q){
        List<Integer> list = new LinkedList<>();
        boolean res = achieveablePos(p,q,list);
        if(res == false) return null;
        int[][] pos = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++){
            int t = list.get(i);
            pos[i][0] = t / 10;
            pos[i][1] = t % 10;
        }
        return pos;
    }


    /**
     * get the path(the cache store the path) from p to q.
     * @param p the start position.
     * @param q the end position.
     * @param cache the path
     * @return null if there is no path from p to q, other wise the path from p to q.
     */
    private boolean achieveablePos(int[] p, int[] q,List<Integer> cache){
        int x = p[0], y = p[1];

        //arrive to the q.
        if(x == q[0] && y == q[1]){
            cache.add(hash(p));
            return true;
        }

        //the next eight position that the horse can arrive.

        int[] leftUp1 = new int[]{ x-2, y+1};
        int[] leftUp2 = new int[]{ x-1, y+2};

        int[] rightUp1 = new int[]{ x+2, y+1};
        int[] rightUp2 = new int[]{ x+1, y+2};

        int[] leftDown1 = new int[]{ x-2, y-1};
        int[] leftDown2 = new int[]{ x-1, y-2};

        int[] rightDown1 = new int[]{ x+2, y-1};
        int[] rightDown2 = new int[]{ x+1, y-2};


        if(testAndAddToCache(leftUp1,q,cache)) return true;
        if(testAndAddToCache(leftUp2,q,cache)) return true;
        if(testAndAddToCache(leftDown1,q,cache)) return true;
        if(testAndAddToCache(leftDown2,q,cache)) return true;
        if(testAndAddToCache(rightUp1,q,cache)) return true;
        if(testAndAddToCache(rightUp2,q,cache)) return true;
        if(testAndAddToCache(rightDown1,q,cache)) return true;
        if(testAndAddToCache(rightDown2,q,cache)) return true;
        return false;
    }

    /**
     *if the current position is illegal or is in cache, return false;
     * then we add this to the cache and keep finding.
     * @param pos the current position.
     * @param q the desinition.
     * @param cache the cache position.
     * @return true when arrived the desinition, otherwise false.
     */
    private boolean testAndAddToCache(int[] pos,int[] q,List<Integer> cache){
        boolean res = false;
        if(isIllegalPosition(pos) && !cache.contains(hash(pos))){
            cache.add(hash(pos));
            res = achieveablePos(pos,q,cache);
            if(res) return true;
            else cache.remove((Integer) hash(pos));
        }
        return res;
    }

    /**
     * test if the position is illegal postion.
     * @param pos the position that under test.
     * @return true if its illegal, otherwise false.
     */
    private boolean isIllegalPosition(int[] pos){
        if(pos[0] >= 0 && pos[0] <=BOARD_SIZE && pos[1] >= 0 && pos[1] <= BOARD_SIZE)
            return true;
        else
            return false;
    }

    /**
     * calculate the hash of the given position.
     * @param pos the position that under hash algorithm.
     * @return the hash number of the given position.
     */
    private int hash(int[] pos){
        return pos[0] * 10 + pos[1];
    }



}
