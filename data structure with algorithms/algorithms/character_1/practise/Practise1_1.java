package algorithms.character_1.practise;

/**
*@author:hp(15172426627@163.com)
*@date:2018-03-19 11:14
*@description：练习1.1
*@version:1.0
*/
public class Practise1_1 {
    /*1.1.1*/
    public static void test1(){
        System.out.println((0+15)/2);   //7
        System.out.println(2.0e-6*100000000.1); //2000.200000
        System.out.println(true&&false||true&&true);    //true
    }

    /*1.1.2*/
    public static void test2(){
        System.out.println((1+2.236)/2);    //1.618
        System.out.println(1+2+3+4.0);      //10.0
        System.out.println(4.1>=4);         //true
        System.out.println(1+2+"3");        //33
    }

    /*1.1.3*/
    public static void test3(){
        int a =3 ;
        int b =3 ;
        int c =3;
        if(a == b && b == c){
            System.out.println("equal");
        }else {
            System.out.println("not equal");
        }

    }

    /*1.1.4*/
    public static void test4(){
        int a = 3;
        int b = 4;
        int c = 0;
        /*if(a>b){
            then c =0;      //没有then这个关键字
        }*/
        if(a>b){
            c=0;            //初始化c
        }
        if(a>b) c=0;
        if(a>b)
            c=0;
        else
            b=0;
        System.out.println(a+""+b+""+c);
    }

    /*1.1.5*/
    public static void test5(){
        double x = 0.7;
        double y = 0.25;
        if(x>=0 && x <= 1 && y>=0 && y<=1){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }

    /*1.1.6*/
    public static void test6(){
        int f =0;
        int g =1;
        for (int i = 0; i <=15 ; i++) {
            System.out.println(f);
            f=f+g;  //1,1,2,3
            g=f-g;  //0,1,1,2
        }
    }

    /*1.1.7*/
    public static void test7(){
        /*double t = 9.0;
        while(Math.abs(t-9.0/t)>.001){
            t=(9.0/t+t)/2.0;
        }
        System.out.println(t);*/

        /*int sum=0;
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < i; j++) {
                sum++;
            }
        }
        System.out.println(sum);
        */

        int sum = 0;
        for (int i = 1; i < 1000; i*=2) {
            for (int j = 0; j <1000 ; j++) {
                sum++;
            }
        }
        System.out.println(sum);
    }

    /*1,1.8*/
    public static void test8(){
        System.out.println((char)('b'+1));
        System.out.println('b'+'c');
        System.out.println((char)('a'+4));
    }

    /*1.1.9*/
    public static void test9(){
        /*String s = Integer.toBinaryString(4);
        System.out.println(s);*/
        String s ="";
        for (int i = 7; i >0 ; i/=2) {
             s = (i%2)+s;
        }
        System.out.println(s);
    }

    /*1.1.11*/
    public static void test11(){
        boolean[][] b= new boolean[5][4];
        char a = '*';
        char c = ' ';
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                b[1][j] = true;
                b[i][3] = true;
            }
        }
        for (int i = 0; i <5 ; i++) {
            for (int j = 0; j <4 ; j++) {
                if(b[i][j]==true){
                    System.out.println("行号："+i+"列号："+j);
                }
            }
        }
    }

    /*1.1.12*/
    public static void test12(){
        int[] a = new int[10];
        for (int i = 0; i <10 ; i++) {
            a[i]=9-i;
        }
        for (int i = 0; i < 10; i++) {
            a[i]=a[a[i]];
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }

    /*1.1.14*/
    public static int test13(int N){
        for (int j = 0; j <N ; j*=2) {
            if(j>=N){
                return j;
            }
        }
        return 0;
    }

    /*1.1.15*/
    public static int[] test15(int[] a ,int M){
        int[] array = new int[M];
            for (int i = 0; i <a.length ; i++) {
                if (a[i] < M)
                    array[a[i]]++;
            }
        return array;
    }

    /*1.1.16*/
    public static String test16(int n){
        if(n<=0){
            return "";
        }
        return test16(n-3)+n+test16(n-2)+n;
    }

    /*1.1.17*/
    public static String test17(int n){
        String s = test17(n-3)+n+test17(n-2)+n;
        if(n<=0){
            return "";
        }
        return s;
    }

    /*1.1.18*/
    public static int test18(int a,int b ){
        /*if(b==0){return 0;};
        if(b%2==0)return test18(a+a,b/2);
        return test18(a+a,b/2)+a;*/
        if(b==0){return 1;};
        if(b%2==0)return test18(a*a,b/2);
        return test18(a*a,b/2)+a;
    }

    /*1.1.19*/
    public static long Fibonacci(int N){
        /*if(N==0) return 0;
        if(N==1) return 1;
        return Fibonacci(N-1)+Fibonacci(N-2);*/

        //改良后
        if (N == 0) return 0;
        if (N == 1) return 1;
        long f = 0;
        long g = 1;
        for (int i = 0; i < N ; i++) {
            f = f + g;
            g = f - g;
        }
        return f;
    }

    /*1.1.20*/
    public static double logarithmic(int N) {
        if (N == 0)
            return 0;
        if (N == 1)
            return 0;
        return (logarithmic(N - 1)  + Math.log(N));
    }

    public static void main(String[] args){
        double logarithmic = logarithmic(2);
        System.out.println(logarithmic);


    }
}
