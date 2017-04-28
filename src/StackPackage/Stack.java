package StackPackage;

/**
 * Created by kang on 17/4/28.
 */
public class Stack {

    //存放在栈内的元素
    private Object[] elementData;
    //现在元素的个数
    private int size;
    //指定扩容增加的大小
    private int capacityIncrement;

    public Stack(int initialCapacity){
        elementData = new Object[initialCapacity];
    }
    //不仅指定了栈初始化大小，还指定了扩容大小
    public Stack(int initialCapacity,int capacityIncrement){
        this(initialCapacity);
        this.capacityIncrement=capacityIncrement;
    }

    //向栈顶压入一个元素
    public void push(Object o){
        //确保数组没有存满元素
        ensureCapacity();
        elementData[size++]=o;
    }

    //从栈顶出栈一个元素
    public Object pop(){

        if (size==0){
            throw new RuntimeException("空栈异常");
        }

        return elementData[--size];

    }
    public int size(){
        return size;
    }


    //当对栈中加入元素时需要确保是否空间足够！如果数组内都存满了元素需要扩容
    private void ensureCapacity(){

        if (elementData.length==size){

            Object[] oldElements = elementData;
            int newLength = 0;
            //已经设置capacityIncrement
            if (capacityIncrement > 0)
            {
                newLength = elementData.length + capacityIncrement;
            }
            else
            {
                //将长度扩充到原来的1.5倍
                newLength = (int)(elementData.length * 1.5);
            }
            elementData = new Object[newLength];
            //将原数组的元素复制到新数组中
            System.arraycopy(oldElements , 0 , elementData , 0 , size);
        }

    }


    public static void main(String[] args) {

        Stack stack = new Stack(20);
        for (int i=0;i<10;i++){
            stack.push("元素"+i);
            System.out.println("元素"+i+"入栈");
        }

        for(int i=0;i<10;i++){
            System.out.println(stack.pop()+"出栈");
        }

    }




}
