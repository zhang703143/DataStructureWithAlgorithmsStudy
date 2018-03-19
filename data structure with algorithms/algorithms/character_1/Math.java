package algorithms.character_1;

/**
*@author:hp(15172426627@163.com)
*@date:2018-03-18 19:32
*@description：数学的基本操作
*@version:1.0
*/
public final class Math {

    //找出数组中最大值
    public static int max(int [] array){
        int length = array.length;
        int max = 0;
        for (int i = 0; i <length ; i++) {
            if(array[i]>max){
                max = array[i];
            }
        }
        return max;
    }

    //计算数组元素的平均值
    public static double avg(int [] array){
        int length = array.length;
        double add = 0;
        for (int i = 0; i <length ; i++) {
            add += array[i];
        }
        if(length!=0){
            return add/length;
        }
        return add;
    }

    //倒序数组
    public static int[] descArray(int[] array){
        int length = array.length;
        int[] newArray = new int[length];
        int j = 0;
        for (int i = length-1; i >=0 ; i--) {
            newArray[j] = array[i];
            j++;
        }
        return newArray;
    }

    //颠倒元素位置   头尾元素借助中间变量  逐一交换位置
    public static void change(int[] array){
        int length = array.length;
        for (int i = 0; i <length/2 ; i++) {
            int temp = array[i];
            array[i] = array[length-1-i];
            array[length-1-i] = temp;
        }
    }

    //矩阵相乘（方阵）
    public static void doubleArray(int[]array,int[][]a,int[][]b){
        int length = array.length;
        double [][] c = new double[length][length];
        for (int i = 0; i <length ; i++) {
            for (int j = 0; j <length ; j++) {
                //计算行i和列j的点乘
                for (int k = 0; k <length ; k++) {
                    c[i][j] = a[i][k] * b[k][j];
                }
            }
        }
    }

    //计算一个整数的绝对值
    public static int abs(int i){
        if(i<0){
            return -i;
        }
        return i;
    }

    //计算一个浮点数的绝对值
    public static double abs(double f){
        if(f<0.0){
            return -f;
        }
        return f;
    }

    //判断一个数是否为素数  取模不为0  开根号无整数
    public static boolean isPrime(int i){
        boolean b =false;
        if(i<2){
            return false;
        }
        for (int j = 2; j * j<=i ; j++) {
            if(i%j==0){
                return false;
            }
        }
        return true;
    }

    //计算平方根
    public static double squareRoot(double c){
        if(c<0){
            return 0.0;
        }
        double err = 1e-15;
        double t = c;
        while(Math.abs(t-c/t)>err*t){
            t=(c/t+t)/2.0;
        }
        return t;
    }

    //求直角三角形的斜边
    public static double hypotenuse(double a ,double b){
        return squareRoot(a*a+b*b);
    }

    //计算调和级数
    public static double H(int N){
        double sum = 0.0;
        for (int i = 1; i <=N ; i++) {
            sum +=1.0/i;
        }
        return sum;
    }

    public static void main(String[] args){
        System.out.println(Integer.parseInt(args[0]));
    }


}
