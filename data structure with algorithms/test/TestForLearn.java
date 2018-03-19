package test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*面试题*/
public class TestForLearn {

    /*第一题让你这一个对二维坐标系的n个点排序，先上后下，先左后右*/
    public void sort(int length,int x,int y ,int [][] array){
        /*int [][] system= new int [length][length];
        int [][] array = {{1,3},{1,5},{2,5},{2,4},{4,2},{3,6},{4,4}};
        *//*system[0][0] = {{3,1}};*//*
        for (int i = 0; i <array.length ; i++) {
        }*/
        /*x y 轴坐标*/
    }

    /*第二题对一个n阶的二叉树节点上记录的值求和，要求用递归*/
    public void addTree(){

    }

    /*第三题是写一个算法实现大字符串s里面，小字符串a出现的次数*/
    public void countStr(){
        System.out.println();
    }

    /*第四题是要你写一个类，能解析一组“a=1，b=2，c=3”这种格式的字符串，
    题目让你解析以后能够统计字符串数字的个数，并且可以求每个字母对应的值，如输入a可以得到1，*/
    public void analiyse(){

    }

        public static String replaceSpace(StringBuffer str) {
            String newStr = "%20";

            int n = str.length();
            for(int i=0;i<str.length();i++){
                if(str.charAt(i)==' '){
                    str.append("  ");
                }
            }
            int idxOfOriginal = n - 1;
            int idxOfNew = str.length() - 1;
            while (idxOfOriginal >= 0 && idxOfNew > idxOfOriginal) {
                if (str.charAt(idxOfOriginal) == ' ') {
                    str.setCharAt(idxOfNew--, '0');
                    str.setCharAt(idxOfNew--, '2');
                    str.setCharAt(idxOfNew--, '%');
                } else {
                    str.setCharAt(idxOfNew--, str.charAt(idxOfOriginal));
                }
                idxOfOriginal--;
            }
            return str.toString();
        }

        public static TestForLearn testForLearn;

        public static TestForLearn getTestForLearn() {
            if(testForLearn==null){
            }
            System.out.println(1);
            return testForLearn;
        }

        public static void main(String[] args){
            Set set = new HashSet();
            set.add("a");
            set.add("a");
            Iterator iterator = set.iterator();
            while(iterator.hasNext()){
                System.out.println(iterator.next());
            }
        }
}
