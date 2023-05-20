import java.io.*;
import java.util.*;

public class Fourth_lab {
    public static void main(String[] args) {
        System.out.println("Author: Lidija Sokolova");
        int[] array = new int[10000];
        Scanner in = new Scanner(System.in);
        //int[] array = {12,2,34,6342,-13,34,0,-432,3,6};
        String filename = "sour.txt";
        if (Array_func.fileToArray(filename, array)==null){
            int array_size = Array_func.arraySizeInput(in);
            array = Array_func.randomArray(array_size, -10000, 10000);
            Array_func.fillFile(filename, array);
        }
        Array_func.showArray(array);
        System.out.println("Enter key...");
        int key = in.nextInt();
        int key_seq = searchSequential(array,key);
        if (key_seq==-1){
            System.out.println("Key : " + key + " not found...");
        }
        else {
            Sort_func.sortBubble(array);
            Array_func.showArray(array);
            int kk = searchBinary(array,key);
            int kkk = searchInterpolation(array,key);
            System.out.println("Key Sequential: " + key_seq);
            System.out.println("Key Binary: " + kk);
            System.out.println("Key Interpolation: " + kkk);
            Array_func.showArrayAsterix(array, kk, kkk);
        }
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
