package algorithms.character_1;

/**
*@author:hp(15172426627@163.com)
*@date:2018-03-19 13:27
*@description：计数器
*@version:1.0
*/
public class Counter {

    private String id;

    private int count;

    private int num;

    public Counter() {
    }

    /*创建一个名为id的计数器*/
    public Counter(String id) {
        this.id = id;
    }

    /*将计数器的值加1*/
    public void  increment(){
        num++;
        count++;
    }

    /*该对象创建之后计数器被加1的次数*/
    public int tally(){
        return count;
    }


}
