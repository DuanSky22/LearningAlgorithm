package com.sky.basic;

/**
 * Created by SkyDream on 2016/7/19.
 */
public class _Sort {

    public static void main(String args[]){
        _Sort sort = new _Sort();
        int[] nums = {4,1,2,8,1};

        sort.mergeSort(nums);
        print(nums);
    }

    public void mergeSort(int[] nums){
        if(nums == null || nums.length <= 1) return;
        int n = nums.length-1;
        mergeSort(nums,0,n);
    }

    private void mergeSort(int[] nums,int start,int end){
        if(start < end){
            int middle = (start + end) / 2;
            mergeSort(nums,start,middle);
            mergeSort(nums,middle+1,end);
            merge(nums,start,middle,end);
        }
    }

    /*
    The first part is [start,middle];
    the second part is [middle+1,end];
     */
    private void merge(int[] nums,int start,int middle,int end){
        int n1 = middle - start + 1;
        int n2 = end - middle;
        int[] left = new int[n1], right = new int[n2];

        System.arraycopy(nums,start,left,0,n1);
        System.arraycopy(nums,middle+1,right,0,n2);

        int p1 = 0, p2 = 0, k = start;

        while(p1 < n1 && p2 < n2){
            if(left[p1] < right[p2])
                nums[k++] = left[p1++];
            else
                nums[k++] = right[p2++];
        }

        if(p1 < n1)
            for(int i = p1; i < n1; i++)
                nums[k++] = left[i];
        else
            for(int i = p2; i < n2; i++)
                nums[k++] = right[i];

    }


    public void quickSort(int[] nums){
        if(nums == null || nums.length <= 1) return;
        quickSort0(nums,0,nums.length-1);
    }

    private void quickSort0(int[] nums,int start,int end){
        if(start >= end) return;
        int pivot = nums[start], middle = end;//middle is the last number that is no large than pivot.
        for(int i = start + 1; i <= middle; i++){
            if(nums[i] > pivot){
                swap(nums,i,middle);
                i--; middle--;
            }
        }
        swap(nums,start,middle);
        quickSort0(nums,start,middle-1);
        quickSort0(nums,middle+1,end);

    }

    public void heapSort(int[] nums){
        buildHeap(nums);
        int length = nums.length - 1;
        for(int i = length; i >= 1; i--){
            swap(nums,0,i);//swap the top of the heap and the last elem of the array.
            matainHeap(nums,0,i-1); //adjust the heap to maintain the heap feature.
        }
    }

    public static void print(int[] nums){
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i]+" ");
        }
    }

    private void buildHeap(int[] nums){
        int n = nums.length;
        for(int i = (n-2)/2; i >= 0; i--)
            matainHeap(nums,i,n-1);
    }

    private void matainHeap(int[] nums,int start,int end){
        int largest = start, left = start * 2 + 1, right = start * 2 + 2;
        if(left <= end && nums[left] > nums[largest])
            largest = left;
        if(right <= end && nums[right] > nums[largest])
            largest = right;
        if(largest != start) {
            swap(nums, start, largest);
            matainHeap(nums,largest,end);
        }

    }

    private void swap(int[] nums,int i,int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
