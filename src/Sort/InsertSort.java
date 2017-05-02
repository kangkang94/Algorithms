package Sort;

/**
 * Created by kang on 17/5/2.
 */
public class InsertSort {


    public static void insertSort(int a[]){

        int n =a.length-1;

        int i;//无序区的第一个元素下标,也就是要插入的元素
        int j;//要插入元素在有序区里的合适位置的前一个下标
        int k;

        for (i = 1;i<=n;i++){

            //为a[i]找出在有序区中合适的位置
            for (j=i-1;j>=0;j--){

                if (a[i]>a[j]){
                    break;
                }
            }

            //如果找到了一个合适的位置
            if (j!=i-1){

                int temp = a[i];
                //将比a[i]大的数据向后移
                for (k=i-1;k>j;k--){

                    a[k+1] = a[k];

                }
                ////将a[i]放到正确位置上
                a[k+1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int i;
        int[] a = {20,40,30,10,60,50};

        System.out.printf("before sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

        insertSort(a);

        System.out.printf("after  sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }


}
