package test;

import java.io.*;

/*单例设计模式之懒汉式  线程不安全
——每次都会被实例 可能会出现被线程抢占 在第一个线程调用getInstance()时，
第二个线程也调用了getInstance();但是此时的singleton初始化未完成，依旧为空，
所以导致两个线程创建了两个实例*/
public class Singleton {

    private Singleton(){
    };

    private Singleton singleton ;

    public Singleton getInstance() {
        if(singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }
}

/*单例设计模式之饿汉式  线程安全
——都指向的同一个实例对象*/
class SingletonHungry{
    private SingletonHungry() {
    }

    private SingletonHungry singletonHungry = new SingletonHungry();

    public SingletonHungry getInstance() {
        return singletonHungry;
    }
}

/*单例设计模式之synchronized 懒汉式*/
class SingletonSafeThread{

    private SingletonSafeThread() {

    }

    private SingletonSafeThread singletonSafeThread;

    public synchronized SingletonSafeThread getSingletonSafeThread() {
        if(singletonSafeThread==null){
                singletonSafeThread=new SingletonSafeThread();
        }
        return singletonSafeThread;
    }
}

/*单例设计模式之双重检验锁--懒汉式  */
class SingletonDoubleCheck{
    /*此处的volatile关键字的意义在于：
    当创建实例化时，jvm会做三件事：
    1、在堆内存中开辟一部分空间
    2、创建实例化
    3、将实例对象指向分配好的空间
    而编译器在编译文件过程中，会对顺序流程进行优化，可能会按1-2-3执行，也可能会按1-3-2去执行
    (指令重排序——在不影响最终结果的情况下，编译器会对排序进行优化，提高程序运行效率，但保证最终结果是一致的)
    该线程此时如果执行第三步的同时，如果此刻有线程2，抢占到线程1释放的时间片（线程1在执行过程中是可能释放时间片的），
    读取到instance,如果此时的instance没有执行构造方法对参数初始化，而线程2又要对参数进行操作，就可能会崩溃
    */
    private volatile SingletonDoubleCheck singletonDoubleCheck;

    private SingletonDoubleCheck() {
    }

    public SingletonDoubleCheck singletonDoubleCheck() {
        if(singletonDoubleCheck==null){
            synchronized (SingletonDoubleCheck.class){
                if(singletonDoubleCheck==null){
                    singletonDoubleCheck=new SingletonDoubleCheck();
                }
            }
        }
        return singletonDoubleCheck;
    }
}

/*单例设计模式之静态内部类*/
class SingletonInnerClass{
    private final static class StaticInnerClass{
        private final static SingletonInnerClass singletonInnerClass =new SingletonInnerClass();
    }

    private SingletonInnerClass() {
    }

    public SingletonInnerClass getInstance(){
        return StaticInnerClass.singletonInnerClass;
    }
}

/*单例设计模式之静态内部类--防止被反序列化攻击*/
class SingletonInnerClassImprove implements Serializable{
    private final static class StaticInnerClass{
        private final static SingletonInnerClassImprove instance =new SingletonInnerClassImprove();
    }

    private SingletonInnerClassImprove() {
    }

    public SingletonInnerClassImprove getInstance(){
        return StaticInnerClass.instance;
    }

    /*防止被反序列化攻击*/
    private SingletonInnerClassImprove readResolve() {
        return StaticInnerClass.instance;
    }
}

/*单例设计模式之枚举*/
enum SingletonEnum{
    INSTANCE;
}