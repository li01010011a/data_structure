import java.io.*;
import java.util.*;

public class Array_func {
    //...
    //Print file to the console if such file Exists.
    static void showFile(String FileName) {
        try {
            System.out.println("The content of the file : " + FileName);
            Scanner file = new Scanner(new File(FileName));
            while (file.hasNextLine()) {
                System.out.println(file.nextLine());
            }
            file.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File: "+FileName+" Not found.\n Will be created new document 'result.txt' and fulfilled with random numbers.");
        }
    }
    //READ ARRAY from file
    static int[] fileToArray(String FileName, int[] array){
        try {
            Scanner file = new Scanner(new File(FileName));
            //int[] array = new int[10000];
            int i = 0;
            while (file.hasNextInt()) {
                array[i++] = file.nextInt();
            }
            file.close();
            return Arrays.copyOf(array, i); //i - Length of current array
        }
        catch (FileNotFoundException e) {
            System.out.println("File: "+FileName+" Not found.");
            return null;
        }
    }
    //WRITE ARRAY TO FILE
    static boolean fillFile(String FileName, int[] array){
        try {
            PrintWriter file = new PrintWriter(new FileWriter(FileName));
            for (int i = 0; i<array.length;i++) file.println(array[i]);
            file.close();
            return true;
        }
        catch (IOException e) {
            return false;
        }
    }
    //FILL ARRAY WITH RANDOM NUMBER
    static int[] randomArray(int size, int min, int max) {
        Random rand = new Random();
        int[] array = new int[size];
        for (int i=0; i<size; i++) {
            array[i] = rand.nextInt(max-min+1)+min;
            //System.out.println(i+1 +" " +array[i]);
        }
        return array;
    }
    //GET SIZE OF ARRAY FROM USER
    static int arraySizeInput(Scanner in) {
        System.out.println(">Enter size of Array: (less or equal 10000)");
        int size = in.nextInt();
        return size;
    }
    //PRINT ARRAY TO CONSOLE
    static void showArray(int[] array) {
        for (int i = 0; i<array.length; i++) {
            System.out.format("%7d", array[i]);
            if (i%10==9)System.out.println();
        }
    }
    //PRINT ARRAY with Marking min and max values with asterix
    static void showArrayAsterix(int[] array, int min, int max) {
        System.out.println("Array jwith asterixes: ");
        for (int i = 0; i<array.length; i++) {
            if (i==min||i==max) {
                System.out.format("\u001b[32m%9d*\u001b[0m",array[i]);
            }
            else {
                System.out.format(" %9d", array[i]);
            }
            if (i%10==9)System.out.println();
        }
    }
    //Returns index of minimal value in array
    static int getMinIndex(int[] array) {
        int  size = array.length, min=0;
        for (int i=0; i<size; i++) {
            if (array[i]<array[min]) min = i;
        }
        System.out.println("Array min value is: "+min);
        return min;
    }
    //Returns index of maximal value in array
    static int getMaxIndex(int[] array) {
        int  size = array.length, max=0;
        for (int i=0; i<size; i++) {
            if (array[i]>array[max]) max = i;
        }
        System.out.println("Array max value is: "+max);
        return max;
    }
    //Return bool value if array is Ascending
    static boolean isAscending(int[] array) {
        int  size = array.length;
        for (int i=0; i<size-1; i++) {
            if (array[i]>array[i+1]) return false;
        }
        return true;
    }

}