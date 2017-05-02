package Search;

/**
 * Created by kang on 17/5/2.
 */
public class BiSearch {

    public static int biSearch(int[] array,int key){

        int low=0;
        int high = array.length-1;
        int mid;

        while (low<=high){

            mid=(low+high)/2;
            if (key>array[mid]){
                low = mid+1;
            }else if (key<array[mid]){
                high = mid-1;
            }else if (key == array[mid]){
                return mid;
            }

        }

        return -1;
    }


}
