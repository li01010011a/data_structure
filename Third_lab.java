import java.io.*;
import java.util.*;

public class Third_lab {
    public static void main(String[] args) {
        System.out.println("Author: Lidija Sokolova");
        int[] array = new int[10000];
        Scanner in = new Scanner(System.in);
        //Sort_func.sortTypeInput(in);
        // int size = Array_func.arraySizeInput(in);
        // System.out.println(size);
        
        Array_func.showFile("new.txt");
        int array_size = Array_func.arraySizeInput(in);
        array = Array_func.randomArray(array_size, -10000, 10000);
        //showArray(array);
        Array_func.fillFile("source.txt", array);
        Array_func.showArray(array);
        boolean isAscending = Array_func.isAscending(array);
        System.out.println("Statement that array is Ascending is :\u001b[33m"+isAscending+"\u001b[0m");
        // Select type of sort
        int type = Sort_func.sortTypeInput(in);
        Sort_func.selectSortType(type,array);
        //Sort_func.sortInsertion(array);
        Array_func.fillFile("result.txt", array);
        Array_func.showArray(array);
        isAscending = Array_func.isAscending(array);
        System.out.println("Statement that array is Ascending is :\u001b[33m"+isAscending+"\u001b[0m");
        in.close();
    }
}

