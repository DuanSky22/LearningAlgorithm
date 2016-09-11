/**
 *�ؼ���Ҳ���ȵ��ˣ�ֻ����ϸ�ڴ����ϲ�̫���š�
 *һ����Ա߽�Ĵ�����ڷ���������ͳһ��Խ��ı߽�ֵ�����жϣ�������Ҫһ��һ�����жϣ�
 *��һ���棬����֮ǰ�Ƿ��߹����ַ������Բ���Ҫ�����µĿռ�����жϣ�
* @author DuanSky
* @date 2015��12��4�� ����4:31:02
* @content 
*/
package com.sky.leetcode.first;

public class _079_WordSearch {
	
	public static void main(String args[]){
		char[][] board={
				{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}
		};
		String word="ABCCED";
		System.out.println(exist(board,word));
	}

	public static boolean exist(char[][] board, String word) {
	    if(board==null || board.length==0 || word.length()==0)
	    	return false;
	    int hight=board.length;int length=board[0].length;
	    char[] array=word.toCharArray();
	    boolean result=false;
	    for(int i=0;i<hight;i++)
	    	for(int j=0;j<length;j++)
    			result |= _exist(board,array,0,new int[]{i,j});
	    return result;
	}
	
	

	
	/**
	 * @param board �ַ���
	 * @param word Ҫ���ҵ��ַ���
	 * @param current ��ǰ���ڲ��ҵ��ַ�����������
	 * @param position ��ǰ���ڵ�λ��
	 * @return
	 */
	public static boolean _exist(char[][] board,char[] word,int current, int[] position){
		if(current==word.length)
			return true;
		if(position[0]<0 || position[0]==board.length || position[1]<0 || position[1]==board[0].length)
			return false;
		if(word[current] != board[position[0]][position[1]])
			return false;
		boolean result=false;
		board[position[0]][position[1]]^=256;
		result  |= _exist(board,word,current+1,new int[]{position[0]+1,position[1]})
				|| _exist(board,word,current+1,new int[]{position[0],position[1]+1})
				|| _exist(board,word,current+1,new int[]{position[0]-1,position[1]})
				|| _exist(board,word,current+1,new int[]{position[0],position[1]-1});
		board[position[0]][position[1]]^=256;
		return result;
	}
	
	/**
	 * ���㷨���û��ݵ�˼�룬
	 * �ؼ�����
	 * 1.�߽�ֵ��δ���
	 * 2.��μ�¼ĳ���ַ�֮ǰ�Ѿ����������Ҳ��õ����½�һ������path����ʾ��λ�õ��ַ��Ƿ�֮ǰ������
	 * @param board �ַ���
	 * @param word Ҫ���ҵ��ַ�����
	 * @param current ��ǰ׼�����ҵ��ַ�����������
	 * @param position ��һ���ַ����ֵ�λ��
	 * @param path ��ĿǰΪֹ�ַ��Ĳ���·��
	 * @return
	 */
	public static boolean _exist_time_limited(char[][] board,char[] word, int current, int[] position, int[][] path){
		if(current==word.length){//ĿǰΪֹ���ҵ���word�����е��ַ�
			return true;
		}
		else{
			char c = word[current];//��ǰҪ���ҵ��ַ�
			int x=position[0];int y=position[1];
			int hight=board.length; int length=board[0].length;
			boolean result=false;
			if(0<x && board[x-1][y]==c && path[x-1][y]!=1){
				path[x-1][y]=1;
				result |= _exist_time_limited(board,word,current+1,new int[]{x-1,y},path);
				path[x-1][y]=0;
			}
			if(x<hight-1 && board[x+1][y]==c && path[x+1][y]!=1){
				path[x+1][y]=1;
				result |= _exist_time_limited(board,word,current+1,new int[]{x+1,y},path);
				path[x+1][y]=0;
			}
			if(0<y && board[x][y-1]==c && path[x][y-1]!=1){
				path[x][y-1]=1;
				result |= _exist_time_limited(board,word,current+1,new int[]{x,y-1},path);
				path[x][y-1]=0;
			}
			if(y<length-1 && board[x][y+1]==c && path[x][y+1]!=1){
				path[x][y+1]=1;
				result |= _exist_time_limited(board,word,current+1,new int[]{x,y+1},path);
				path[x][y+1]=0;
			}
			return result;
		}
	}
}

