package algorithms.character_1;

import java.util.Arrays;

/**
*@author:hp(15172426627@163.com)
*@date:2018-03-17 18:26
*@description：二分查找的实现
 * 原理在于：在一个顺序表中，由小到大升序排列的数组，在数组的中间位置开始比较需要查找的元素
 * 在中间位置如果没有查到，比较该元素与中间位置元素的大小，如果比数组元素大，则最大范围减1否则最小范围加一
 * 再重复以上操作至 最小范围大于最大范围 （最大执行次数） 如果还没有找到 说明该元素不存在，   如果有  则返回下标
 * 最小执行次数 为1  即  正好在数组的中间
*@version:1.0
*/
public class BinarySearch {

    /*找到数组array中key的位置,没有则返回-1*/
    public static int rank(int [] array , int key){
        //将array升序排列
        Arrays.sort(array);

        //下标从0开始
        int low = 0;

        //下标从最大位置开始
        int high = array.length-1;
        while(low<=high){
            //中间索引值
            int mid = low + (high - low)/2;
            if(array[mid]>key){
                high = mid -1;
            }else if (array[mid]<key){
                low = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int []a = {3,6,3,1,4,2,5};
        int b =7;
        int rank = rank(a, b);
        System.out.println(rank);
        System.out.println(11/2);
    }
}
