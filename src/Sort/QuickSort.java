package Sort;

/**
 * Created by kang on 17/5/3.
 */
public class QuickSort {
    /**
     * 1.先选取一个基准:x
     *
     * 2.从右到左遍历直到找到一个小于等于基准的值，将其交换到基准前面，从左到右遍历直到找到一个大于或等于基准的值，将其交换到基准右边
     * 一次分区就可以确定基准在排序后的真正位置
     *
     *3.递归实现基准左分区和基准的右分区
     *
     */
    public static  void quickSort(int a[],int l,int end){

        if (l>=end){
            return;

        }

        int i = l;//最左元素下标（ 一般为0）
        int j = end; //最末元素下标
        int x = a[i];
        //当i>=j,则表示查找完毕
        while(i<j){

            while((i<j)&&a[j]>x){
                j--;
            }
            if (i<j){
                a[i++] =a[j];
            }

            while ((i<j)&&(a[i]<x)){
                i++;
            }
            if (i<j){
                a[j--]=a[i];
            }

        }
        //找到基准的正确位置
        a[i] = x;
        quickSort(a,l,i-1);
        quickSort(a,i+1,end);

    }

    public static void main(String[] args) {
        int i;
        int a[] = {30,40,60,10,20,50};

        System.out.printf("before sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

        quickSort(a, 0, a.length-1);

        System.out.printf("after  sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }

}
