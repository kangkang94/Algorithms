package StackPackage;

/**
 * Created by kang on 17/4/28.
 */

/**
 * 链式存储的栈
 * @param <T>
 */
public class LinkStack<T> {

    //定义一个内部类Node,Node的实例代表栈的节点
    public class Node{

        T data;
        Node next;

        public Node() {
        }
        //节点数据和下一个节点的引用初始化
        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    //保存该链栈的栈顶元素
    private Node top;

    //保存该链栈中已包含的节点数
    private int size;

    //创建空链栈
    public LinkStack()
    {
        //空链栈，top的值为null
        top = null;
    }

    //以指定数据元素来创建链栈，该链栈只有一个元素
    public LinkStack(T element)
    {
        top = new Node(element , null);
        size++;
    }

    //返回链栈的长度
    public int length()
    {
        return size;
    }

    //进栈
    public void push(T element)
    {
        //让top指向新创建的元素，新元素的next引用指向原来的栈顶元素
        top = new Node(element , top);
        size++;
    }

    //出栈
    public T pop(){

        Node oldTop = top;
        top=top.next;

        oldTop.next=null;
        size--;
        return oldTop.data;

    }
    //访问栈顶元素，但不删除栈顶元素
    public T peek()
    {
        return top.data;
    }

    //判断链栈是否为空栈
    public boolean empty()
    {
        return size == 0;
    }

    //清空链栈
    public void clear()
    {
        //将底层数组所有元素赋为null
        top = null;
        size = 0;
    }



}
