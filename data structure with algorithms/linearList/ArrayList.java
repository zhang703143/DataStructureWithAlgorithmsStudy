package linearList;

/**
*@author:hp(15172426627@163.com)
*@date:2018-03-10 14:32
*@description：数据结构之线性表——顺序表
*@version:1.0
*/
public class ArrayList<E> {
    //基于数组实现顺序表

    //默认空数组
    private static final Object[] EMPTY_ELEMENTDATA = {};

    //默认数组容器大小
    private static final int DEFAULT_CAPACITY=10;

    //当前数组大小
    private int length;

    //实际元素个数
    private int size;

    //存放元素
    private Object[] elementData;

    //每次容器增量
    private static final int INCREASE_CAPACITY=10;

    //初识容器，为10；若指定容器大小，则新建一个容器，容器大小为指定的大小
    public ArrayList(){
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(int capacity){
        if(capacity>0){
            this.elementData=new Object[capacity];
            length=capacity;
        }else if(capacity==0){
            elementData=EMPTY_ELEMENTDATA;
        }else{
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    //线性表——顺序表的基本操作
    //销毁线性表
    public void destroy(){
        elementData=null;
    }

    //清空线性表
    public void clear(){
        if(elementData.length==0){
            return;
        }
        for (int i = 0; i <size ; i++) {
            elementData[i]=null;
        }
    }

    //判断线性表元素是否为空
    public boolean isEmpty(){
        return size==0;
    }

    //将length调整为size
    public void trimToSize(){
        if(size<elementData.length){
            elementData=size==0?EMPTY_ELEMENTDATA:copyOf(size);
        }
    }

    //求线性表长度
    public int getSize(){
        return size;
    }

    //检查下标
    public void checkIndex(int index){
        if(index<0||index>length){
            throw new ArrayIndexOutOfBoundsException();
        }
        if(index>=size){
            index=size;
        }
    }

    private E elementData(int index){
        return (E)elementData[index];
    }

    //取线性表的第i个元素
    public E getElement(int index){
        checkIndex(index);
        return elementData(index);
    }

    //检索线性表中元素E的位置;因为数组允许存null，所以也要返回null的下标
    public int getIndex(E e){
        if(e==null){
            for (int i = 0; i <size ; i++) {
                if(e==elementData[i]){
                    return i;
                }
            }
        }
        for (int i = 0; i <size ; i++) {
            if(e.equals(elementData[i])){
                return i;
            }
        }
        return -1;
    }

    //返回线性表中元素E的前驱元素
    public E getPreviousElement(E e){
        int index = getIndex(e);
        if(index ==-1){
            return null;
        }
        return elementData(index);
    }

    //返回线性表中元素E的后继元素
    public E getNextElement(E e){
        int index = getIndex(e);
        if(index ==-1){
            return null;
        }
        return elementData(index);
    }

    //复制当前数组元素至新的数组中去
    public Object[] copyOf(int newLength){
        Object[] newData=new Object[newLength];
        for (int i = 0; i <length ; i++) {
            newData[i]=this.elementData[i];
        }
        return this.elementData=newData;
    }

    //复制当前数组第index位置的元素至新的数组中去
    public void copyOf(int newLength,int index){
        Object[] newData=new Object[newLength];
        for (int i = index; i <newLength ; i++) {
            newData[i+1]=this.elementData[i];
        }
        this.elementData=newData;
    }

    //在插入或者删除元素之前，需要先确保数组的容量大小是否能插入或删除
    //如果容器太小，就增加增量,并将原来数组重新赋给新的数组；否则就使用当前容器
    public void ensureCapacity(int minCapacity){
        if(minCapacity<length){
            return;
        }
        if(minCapacity>=length){
            length=length+INCREASE_CAPACITY;
        }
        copyOf(length);
    }

    //插入元素
    public void insert(E e){
        ensureCapacity(size+1);
        elementData[size++]=e;
    }

    //在第index元素前插入元素
    public void insert(int index,E e){
        checkIndex(index);
        ensureCapacity(size++);
        Object[] objects = new Object[size];
        for (int i = 0; i <size ;i++) {
            if(i<index){
                objects[i]=elementData[i];
            }else if(i==index){
                objects[i]=e;
            }else {
                objects[i]=elementData[i-1];
            }
        }
        elementData=objects;
    }

    //删除第index个元素
    public void delete(int index){
        checkIndex(index);
        ensureCapacity(size--);
        Object[] objects = new Object[size];
        for (int i = 0; i <size ;i++) {
            if(i<index){
                objects[i]=elementData[i];
            }else {
                objects[i]=elementData[i+1];
            }
        }
        elementData=objects;
    }

    //比较A,B两个线性表大小,若A大则返回1，小则返回-1,相等返回0
    public int compare(ArrayList<Integer> a,ArrayList<Integer> b){
        int aSize = a.getSize();
        int bSize = b.getSize();
        if(aSize!=bSize){
            for (int i = 0; i <aSize|i<bSize ; i++) {
                if(a.getElement(i)>b.getElement(i)){
                    return 1;
                }else if (a.getElement(i)<b.getElement(i)){
                    return -1;
                }
            }
        }
        for (int i = 0; i < aSize; i++) {
            if(a.getElement(i)>b.getElement(i)){
                return 1;
            }else if (a.getElement(i)<b.getElement(i)){
                return -1;
            }else {
                return 0;
            }
        }
        return 0;
    }

    //将m个元素和n个元素整体互换位置      ---错误的算法
    public void changeNum(int m){
        checkIndex(m);
        int n = size - m;
        Object[] objects = new Object[size];
        Object[] objects2 = new Object[size];
        if(n!=0){
            for (int i = 0; i <n ; i++) {
                objects[i]=elementData[m+i];
                for (int j = m-1; j >=0 ; j--) {
                    objects2[j+1]=elementData[j];
                }
                objects2[i]=objects[i];
            }
            for (int i = 0; i <objects2.length ; i++) {
                System.out.println(objects2[i]);
            }
            elementData=objects2;
        }
    }



}
