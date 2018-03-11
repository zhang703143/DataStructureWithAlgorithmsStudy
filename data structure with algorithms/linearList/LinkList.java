package linearList;

/**
*@author:hp(15172426627@163.com)
*@date:2018-03-11 17:53
*@description：数据结构之线性表——单链表
*@version:1.0
*/
public class LinkList<T> {

    //头结点
    Node<T> first;

    //节点元素
    int size = 0;

    public LinkList() {
    }

    //检索下标是否越界
    public void checkIndex(int index){
        if(index<0 || index>size){
            throw new RuntimeException("下标越界");
        }
    }

    //获取头结点，然后根据index，找到第index位置的节点
    public Node<T> localIndex(int index){
        //首先获取头节点，然后根据单链表性质，每个节点都记录下一节点位置，找到位于index的元素
        Node<T> x = first;
        //当元素从0找到第index位置时，节点x也从0来到了第index的位置，返回该位置的元素即可
        while(size<index){
            x =x.next ;
            size++;
        }
        return x;
    }

    //得到第index个元素
    public T getElement(int index){
        checkIndex(index);
        //首先获取头节点，然后根据单链表性质，每个节点都记录下一节点位置，找到位于index的元素
        Node<T> x = localIndex(index);
        return x.item;
    }

    //在第index位置上，插入节点元素t
    public void insert(T t,int index){
        checkIndex(index);
        //先获取到第index-1位置上的节点
        Node<T> tNode = localIndex(index - 1);
        //取到tNode的下一个节点元素
        Node<T> next = tNode.next;
        //通过构造器，新建一个节点，元素为t，节点为index-1的下一个元素
        Node<T> node = new Node<>(t, next);
        //指定index-1的节点为node，node的下一个节点为原本index-1的next，元素为t
        tNode.next = node;
    }

    //在第index位置上删除元素
    public void delete(int index){
        checkIndex(index);
        //先获取到第index位置上的节点
        Node<T> tNode = localIndex(index);
        //取到tNode的index+1位置上的节点
        Node<T> next = tNode.next;
        //再获取到tNode的index-1位置上的节点
        Node<T> node = localIndex(index-1);
        //指定index-1的节点node，指向index+1节点的地址
        node.next = next;
    }

    //自定义节点类
    private class Node<T> {
    //元素item
    T item ;
    //下一个节点的位置
    Node<T> next;

        public Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }
    }
}
