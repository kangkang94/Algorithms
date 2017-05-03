package Sort;

/**
 * Created by kang on 17/5/3.
 */
public class MergeSort {
    

    //从上往下归并排序
    public static void mergeSort(int a[],int start,int end){

        //边界条件判断
        if ((a==null) || (start>=end))
            return;

        int mid = (start + end)/2;

        mergeSort(a,start,mid);// 递归排序a[start...mid]
        mergeSort(a,mid+1,end);// 递归排序a[mid+1...end]

        merge(a,start,mid,end);

    }

    private static void merge(int[] a, int start, int mid, int end) {


        int[] temp = new int[end-start +1];//暂时存储俩个分区的数组元素
        int l =start; //左分区开始
        int r =mid+1; //右分区开始
        int k=0;
        while ((l<=mid)&&(r<=end)){

            if (a[l]<=a[r]){

                temp[k++]= a[l++];
            }else {
                temp[k++]= a[r++];
            }

        }
        //其中有一个分区复制完毕
        while(l<=mid){
            temp[k++] = a[l++];
        }
        while (r<=end){
            temp[k++] = a[r++];
        }

        //所有复制完毕
        for (int i=0;i<k; i++){

            a[start+i] = temp[i];
        }

        temp = null;
    }

    public static void main(String[] args) {
        int i;
        int a[] = {80,30,60,40,20,10,50,70};

        System.out.printf("before sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

       mergeSort(a, 0, a.length-1);        // 归并排序(从上往下)
        //mergeSortDown2Up(a);                    // 归并排序(从下往上)

        System.out.printf("after  sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }



}
