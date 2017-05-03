package Sort;

/**
 * Created by kang on 17/5/2.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉堆（最大堆）
 * @param <T>
 */
public class MaxHeap<T extends Comparable<T>> {

    private List<T> mHeap; //动态数组ArrayList

    public MaxHeap(){
        mHeap = new ArrayList<T>();
    }

    /**
     * 最大堆的向上调整算法，从start开始向上直到0，调整堆
     *
     *
     * 数组实现的堆中，第N个节点的做孩子的索引值是（2N+1），右孩子的索引值是（2N+2）
     *
     *start----被上调点的起始位置，一般为数组的最后一个元素
     */


    private void filterUp(int start) {

        int c= start ;  //当前节点的位置
        int p = (c-1)/2; //父节点

        T temp = mHeap.get(c);
        //不断地和父节点比，直到父节点大或者到了根节点
        while (c>0){

            int cmp = mHeap.get(p).compareTo(temp);

            if (cmp>=0){
                break;
            }

            mHeap.set(c,mHeap.get(p));

            c=p;
            p=(p-1)/2;

        }

        mHeap.set(c,temp);

    }


    /**
     * 将data插入二叉堆中
     */
    public void insert(T data){

        int size = mHeap.size();

        mHeap.add(data); //将"数组"插在表尾
        filterUp(size);

    }


    /**
     * 删除最大堆中的data
     *
     * 返回值：0，成功  -1 ，失败
     */
    public int remove(T data){

        if (mHeap.isEmpty() ==true){
            return  -1;
        }
        //通过元素得到在ArrayList的索引
        int index = mHeap.indexOf(data);

        if (index ==-1){
            return -1;
        }
        int size = mHeap.size();
        mHeap.set(index,mHeap.get(size-1));

        mHeap.remove(size-1);

        if (mHeap.size()>1){
            filterDown(index,mHeap.size()-1);
        }

        return 0;
    }

    /**
     * 最大堆的向下调整算法
     * @param start   开始的第一个节点
     * @param end     最大堆（数组）的最后一个元素索引
     */
    private void filterDown(int start, int end) {

        int c = start;   //当前节点
        int l = 2*c +1;  //左节点
        T temp = mHeap.get(c);

        while (l<=end){
            //左右孩子比较大小
            int cmp = mHeap.get(l).compareTo(mHeap.get(l+1));
            //右孩子大
            if ((l<end)&&(cmp<0)){

                l++;
            }
            cmp = mHeap.get(c).compareTo(mHeap.get(l));

            if (cmp>=0){
                break;
            }else {
                mHeap.set(c,mHeap.get(l));
                c = l;
                l = 2*l+1;
            }
        }
        mHeap.set(c,temp);
    }


}
