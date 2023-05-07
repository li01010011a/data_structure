import java.io.*;
import java.util.*;

public class Fourth_lab {
    public static void main(String[] args) {
        int[] array = {12,2,34,6342,-13,34,0,-432,3,6};
        int key = 2;
        int k = searchSequential(array,key);
        Sort_func.sortBubble(array);
        Array_func.showArray(array);
        int kk = searchBinary(array,key);
        int kkk = searchInterpolation(array,key);
        System.out.println("Key Sequential: " + k);
        System.out.println("Key Binary: " + kk);
        System.out.println("Key Interpolation: " + kkk);
        Array_func.showArrayAsterix(array, array[kk], array[kk]);
    }

    public static int searchSequential(int[] array, int key){
        for (int i=0;i<array.length;i++){
            if (array[i]==key){
                return i;
            }
        }
        return -1;
    }

    
    public static int searchBinary(int[] array, int key){
        int l = 0;
        int r = array.length-1;

        while (l<=r){
            int x = (l+r)/2;
            if (array[x]==key) return x;
            else if (array[x]<key) l = x+1;
            else r=x-1;
        }
        return -1;
    }


    public static int searchInterpolation(int[] array, int key){
        int l = 0,r = array.length-1;
        while (l<=r && key >= array[l] && key <= array[r]){
            int x = l + (r-l) * ((key-array[l])/(array[r]-array[l]));
            if (array[x]==key)return x;
            if (array[x]<key) l = x+1;
            else r = x-1;
        }
        return -1;
    }
}
