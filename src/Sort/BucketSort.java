package Sort;

/**
 * Created by kang on 17/5/3.
 */

/**
 * 桶排序   有俩个数组，一个是待排序数组，一个是桶数组  桶数组的下标是待排序数组的值
 *
 *
 *
 */
public class BucketSort {
    /**
     * @param a
     * @param max  a的元素最大范围  [0,max)  右闭合，所以i<max
     */
    public static void bucketSort(int a[],int max){

        if ((a==null)|| max<1){
            return;
        }
       // 桶数组
        int[] bucket = new int[max];

        for (int i=0;i<a.length;i++){
            bucket[a[i]]++;
        }
        int j=0;
        for (int i=0;i<max;i++){

            while ((bucket[i]--)>0){
                a[j++]= i;
            }

        }


    }

    public static void main(String[] args) {
        int i;
        int a[] = {8,2,3,4,3,6,6,3,9};

        System.out.printf("before sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

        bucketSort(a, 10); // 桶排序

        System.out.printf("after  sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }

}
