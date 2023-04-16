import java.io.*;
import java.util.*;

public class Sort_func {
    public static void chooseSort(int[] array) {
        Scanner in = new Scanner(System.in);
        System.out.println(">Enter type of Sort: 1 - for Bubble, 2 - for Insertion, 3 - for Selection");
        int type = in.nextInt();
        in.close();
        if (type == 1) sortBubble(array);
        else if (type == 2) sortInsertion(array);
        else if (type == 3) sortSelection(array);
        else System.out.println(">>You entered wrong number!!!");
    }
    //BUBBLE SORT
    public static void sortBubble(int[] array) {
        System.out.println(">Sort Bubble!!!");
        int size = array.length -1, iteration_count = 0;
        boolean arrayChanged = false; // 1st improvement
        for (int i = 0;i<size;i++) {
            iteration_count++;
            arrayChanged = false;
            for (int j = 0;j<size-i; j++){  // 2nd improvement
                if (array[j]>array[j+1]){
                    swap(array, j + 1, j);
                    arrayChanged = true;
                }
            }
            if (!arrayChanged)break;
        }
        System.out.println("Iteration count: " + iteration_count + " Using Bubble Sort.");
    }
    //INSERTION SORT
    public static void sortInsertion(int[] array) {
        System.out.println(">Sort Insertions!!!");
        int size = array.length, iteration_count = 0;
        for (int i = 1;i<size;i++) {
            iteration_count++;
            for (int j = i-1;j >= 0; j--){
                if (array[j]>array[j+1]){
                    swap(array, j + 1, j);
                }
                else break;
            }
        }
        System.out.println("Iteration count: " + iteration_count + " Using Insertion Sort.");
    }
    //SELECTION SORT
    public static void sortSelection(int[] array) {
        System.out.println("Sort Selection!!!");
        int min_first_pos = Array_func.getMinIndex(array), iteration_count = 0;
        swap(array, 0, min_first_pos);
        for (int i = 1;i<array.length-1;i++) {
            iteration_count++;
            int min = i;
            for (int j = i+1;j < array.length; j++){
                if (array[j] < array[min])min = j;
            }
            swap(array, i, min);
        }
        System.out.println("Iteration count: " + iteration_count + " Using Insertion Sort.");
    }
    // Switch values i and j
    public static void swap(int[] array, int i, int j){
        //System.out.println("Swapping");
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    // SHELL SORT
    public static void sortShell(int[] array){
        int size = array.length;
        for (int gap = size/2; gap>0; gap /=2){
            for (int i = gap; i<size; i++){
                int temp = array[i];
                int j;
                for(j=i;j>=gap && array[j-gap]>temp; j -= gap){
                    array[j] = array[j-gap];
                }
                array[j] = temp;
            }
        }
    }
    // QUICK SORT
    // public static void sortQuick(int[] array) {
    //     if (array == null || array.length == 0) {
    //         return;
    //     }
    //     quickSort(array, 0, array.length - 1);
    // }
    
    // private static void quickSort(int[] arr, int low, int high) {
    //     if (low >= high) {
    //         return;
    //     }
    //     int pivotIndex = partition(arr, low, high);
    //     quickSort(arr, low, pivotIndex - 1);
    //     quickSort(arr, pivotIndex + 1, high);
    // }
    
    // private static int partition(int[] arr, int low, int high) {
    //     int pivotValue = arr[high];
    //     int i = low - 1;
    //     for (int j = low; j < high; j++) {
    //         if (arr[j] <= pivotValue) {
    //             i++;
    //             int temp = arr[i];
    //             arr[i] = arr[j];
    //             arr[j] = temp;
    //         }
    //     }
    //     int temp = arr[i + 1];
    //     arr[i + 1] = arr[high];
    //     arr[high] = temp;
    //     return i + 1;
    // }
    // SELECT SORT TYPE
    static void selectSortType(int type, int[] array){
        switch (type){
            case 1:
                sortBubble(array);
                break;
            case 2:
                sortInsertion(array);
                break;
            case 3:
                sortSelection(array);
                break;
            case 4:
                sortShell(array);
                break;
            case 5:
                QuickSort.sortQuick(array);
                break;
            default:
                System.out.println("You entered wrong number");
        }
    }
    static int sortTypeInput(Scanner in) {
        System.out.println(">Enter type of Sort: 1 - for Bubble sort, 2 - for Insertion sort, 3 - for Selection sort, 4 - Shell sort, 5 - Quick sort");
        return in.nextInt();
    }
    //TODO ComparingSort,  
}
