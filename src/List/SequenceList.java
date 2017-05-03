package List;

/**
 * Created by kang on 17/4/28.
 */

import java.util.Arrays;

/**
 * 线性表顺序存储的实现方式，底层为一维数组实现
 */
public class SequenceList<T> {

    private int DEFAULT_SIZE =16;
    //保存数组长度
    private int capacity;
    //数组
    private Object[] elements;
    //保存数据元素个数
    private int size=0;

    //以默认数组长度创建空顺序线性表
    public SequenceList(){
        capacity = DEFAULT_SIZE;
        elements = new Object[capacity];

    }

    //以一个初始化元素来创建顺序存储的线性表
    public SequenceList(T o){
        this();
        elements[0] =o;
        size++;
    }

    //以指定长度的大小来初始化顺序存储的线性表
    public SequenceList(T o,int initSize){

        capacity=1;
        //capacity的大小是大于initSize里的数中最小的2的n次方值
        while(capacity<initSize){

            capacity <<=1;
        }

        elements = new Object[capacity];
        elements[0] = o;
        size++;

    }

    //获取顺序线性表的大小
    public int size(){

        return size;
    }

    //获取顺序线性表中处于索引i处的元素
    public T get(int i){

        if (i<0 ||i>size-1){
            throw new IndexOutOfBoundsException("线性表索引越界了！");
        }

        return (T) elements[i];
    }
    //获取顺序线性表中元素的索引值
    public int getIndex(T o){

        for (int i=0;i<size;i++){
            if (elements[i].equals(o)){
                return i;
            }
        }
        return -1;
    }

    //capacity大小不够，数组扩容(插入操作导致)
    private void ensureCapacity(int minCapacity){
        //如果数组原有长度小于数组所需长度
        if (capacity<minCapacity){

            //不断*2 直到大于所需长度
            while(capacity<minCapacity){
                capacity<<=1;
            }
            //新建一个长度为newLength的数组，内部实现是调用了System.arrayCopy();
            elements = Arrays.copyOf(elements,capacity);

        }

    }

    //向顺序线性表中在指定位置插入一个元素
    public void insert(T element,int i){
        //边界判断
        if (i<0 ||i>size){
            throw new IndexOutOfBoundsException("线性表索引越界了！");
        }
        //插入元素需要扩容
        ensureCapacity(size+1);
        System.arraycopy(elements,i,elements,i+1,size-i);
        elements[i] = element;
        size++;
    }

    //在顺序线性表的开始处添加一个元素
    public void add(T element){

        insert(element,size);
    }

    //删除顺序线性表中指定索引处的元素
    public T remove(int i){
        //边界判断
        if (i<0 ||i>size-1){
            throw new IndexOutOfBoundsException("线性表索引越界了！");
        }

        T oldValue = (T) elements[i];
        int num = size - i-1;

        System.arraycopy(elements,i+1,elements,i,num);
        //清空最后一个元素，并把长度减一
        elements[--size]=null;
        return oldValue;
    }

    //删除线性表中最后一个元素
    public void remove(){
        remove(size-1);
    }

    //判断顺序线性表是否为空表
    public boolean empty()
    {
        return size == 0;
    }

    //清空线性表
    public void clear()
    {
        //将底层数组所有元素赋为null
        Arrays.fill(elements , null);
        size = 0;
    }


}
