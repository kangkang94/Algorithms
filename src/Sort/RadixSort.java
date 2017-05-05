package Sort;

/**
 * Created by kang on 17/5/5.
 */
public class RadixSort {

    /**
     * 获取数组的最大值
     */
    public static int getMax(int a[],int n){

        int max = a[0];

        for (int i=0;i<n;i++){

            if (a[i]>max){
                max = a[i];
            }
        }
        return  max;
    }



    public static void radixSort(int[] a,int n){

        int exp=1; //指数，对数组按照个位排序时，exp=1;对数组按照十位排序时，exp=10

        int max = getMax(a,n);

        // 从个位开始，对数组a按"指数"进行排序
        for ( ; max/exp>0 ; exp*=10 ){
            bucketSort(a,exp,n);
        }

    }

    /**
     * 例如，对于数组a={50, 3, 542, 745, 2014, 154, 63, 616}；
     *    (01) 当exp=1表示按照"个位"对数组a进行排序
     *    (02) 当exp=10表示按照"十位"对数组a进行排序
     *    (03) 当exp=100表示按照"百位"对数组a进行排序
     *    ...
     * @param a
     * @param exp
     * @param n
     */

    public static void bucketSort(int[] a,int exp,int n){

        int[] output = new int[n]; // 存储被排序数据的临时数组

        int[] buckets = new int[10]; //桶数组，范围为【0，10)

        //将数据出现的次数存到桶数组中
        for (int i=0;i<n;i++){

            buckets[(a[i]/exp)%10]++;

        }

        //更改bucket[i],让bucekt[i]的值为output数组的下标
        for (int i=1;i<10;i++){

            buckets[i]+= buckets[i-1];

        }

        for (int i=n-1;i>=0;i--){

            output[buckets[(a[i]/exp)%10]-1] = a[i];

            buckets[(a[i]/exp)%10]--;
        }

        //将排序好的数据赋值
        for (int i=0;i<n;i++){

            a[i] = output[i];
        }



    }

    public static void main(String[] args) {
        int i;
        int a[] = {53, 3, 542, 748, 14, 214, 154, 63, 616};

        System.out.printf("before sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

        radixSort(a,9);    // 基数排序

        System.out.printf("after  sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }




}
