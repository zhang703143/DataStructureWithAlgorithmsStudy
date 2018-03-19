package algorithms.character_1;


import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
*@author:hp(15172426627@163.com)
*@date:2018-03-17 16:43
*@description：欧几里得算法  求两数的最大公约数
*@version:1.0
*/
public class Euclidean {

    /*求最大公约数*/
    public static int getCommonDivisor(int n , int m){
        if(m==0) return n;
        int r = n%m;
        System.out.println("被除数为:"+n);
        System.out.println("除数为:"+m);
        return getCommonDivisor(m,r);
    }

    public static void main(String[] args){
        int n = 1111111;
        int m = 1234567;
        int i = getCommonDivisor(n, m);
        System.out.println("最大公约数为:"+i);

    }
}
