package Sort;

/**
 * Created by kang on 17/5/2.
 */
public class SelectSort {


    /**
     * 选择排序
     * @param a
     */
    public static void selectSort(int a[]){

        int n=a.length-1;
        int i; //有序区的末尾位置
        int j;//无序区的起始位置

        int min;//无序区中最小元素的位置

        for (i =0;i<n;i++){

            min = i;
            for (j=i+1;j<n;j++){

                if (a[min]>a[j]){
                    min = j;
                }

            }
            if (min!=i){
                swap(a,i,min);
            }

        }

    }

    private static void swap(int a[],int i,int j) {

        int temp = a[i];
        a[i]=a[j];
        a[j]=temp;

    }

    public static void main(String[] args) {
        int i;
        int[] a = {20,40,30,10,60,50};

        System.out.printf("before sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

        selectSort(a);

        System.out.printf("after  sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }


}
