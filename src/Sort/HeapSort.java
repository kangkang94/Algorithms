package Sort;

/**
 * Created by kang on 17/5/3.
 */
public class HeapSort {

    /**
     * 最大堆的向下调整，start为要向下调整的节点（一般为下标为0）
     *
     * end 为数组的最后一个元素下标
     */

    public static void filterDown(int a[],int start,int end){

        int c = start;//当前节点
        int l = c*2 +1; //左孩子

        int temp = a[c];

        while(l<=end){
            //找出左右节点中更大的
            if ((l<end)&&a[l]<a[l+1]){
                l++;
            }

            if (a[c]>= a[l]){
                break;
            }else {
                //将当前节点的值与孩子的值相交换
                a[c] = a[l];
                a[l] = temp;
                //把当前节点指向孩子
                c = l;
                //把孩子指向孩子的孩子
                l = 2*l+1;
            }

        }


    }

    /**
     * 堆排序（从小到大）
     */
    public static void heapSortAsc(int a[],int n){

        //从（n/2 -1）将之后的一个个元素都向下调整，直到将整个数组构造成最大堆
        for(int i = n/2-1;i>=0;i--){

            filterDown(a,i,n-1);
        }

        //从最后一个元素开始与根节点开始交换，然后再进行最大堆的构建
        for (int i = n-1;i>0;i--){

            swap(a,0,i);

            // 调整a[0...i-1]，使得a[0...i-1]仍然是一个最大堆。
            // 即，保证a[i-1]是a[0...i-1]中的最大值。
            filterDown(a,0,i-1);

        }



    }

    public static void swap(int a[],int i,int j){

        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;

    }

    public static void main(String[] args) {
        int i;
        int a[] = {20,30,90,40,70,110,60,10,100,50,80};

        System.out.printf("before sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

        heapSortAsc(a, a.length);            // 升序排列


        System.out.printf("after  sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }


}
