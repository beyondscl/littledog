package com.dog.algorithm;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by Administrator on 2017/3/17.
 * 快速排序算法实现
 * http://www.myexception.cn/other/1825523.html
 */
public class FastAlgo {

    private static Log log = LogFactory.getLog(FastAlgo.class);

    public static void main(String[] args) {

        int[] arr = new int[]{3, 2, 1,8,9};
        //排序一次

        int l = 0;
        int h = arr.length-1;
        while (l<h){
            if(arr[h]<arr[l]){
                sort(arr,h,l);
            }
            h--;
        }

        for (int a : arr) {
            System.out.print(a);
            System.out.print(",");
        }

    }

    /**
     * @param arr
     * @param indexL 大数据的下标识
     * @param indexR 小数据的下标识
     */
    public static void swap(int[] arr, int indexL, int indexR) {
        int t = arr[indexL];
        arr[indexL] = arr[indexR];
        arr[indexR] = t;
    }

    /**
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void sort(int[] arr, int left, int right) {
        int keyIndex = left;
        int middle = arr[left];
        while (left < right) {
            while (left < right && arr[right] <= middle) {
                right--;
                if (left < right) {
                    swap(arr, right, left);
                    left++;
                    keyIndex = right;
                }
            }
        }
        for (int a : arr) {
            System.out.print(a);
            System.out.print(",");
        }
    }

}
