package ex2.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayHandler {

    public static void main(String[] args) {

        String[] stringArray = {"aa", "bb", "cc"};
        Integer[] intArray = {1, 2, 3, 4, 5};

        changeArrayMembers(stringArray, 0, 2);
        changeArrayMembers(intArray, 0, 3);

        System.out.println(Arrays.toString(stringArray));
        System.out.println(Arrays.toString(intArray));

        List<String> arrList1 = convertToArrayList(stringArray);
        List<Integer> arrList2 = convertToArrayList(intArray);

        System.out.println("Type of arraylist1 = " + arrList1.getClass());
        System.out.println("Type of arraylist2 = " + arrList2.getClass());

    }

    public static <T> void changeArrayMembers(T[] array, int index1, int index2) {
        int maxIndex = array.length - 1;

        if (index1 > maxIndex
                || index2 > maxIndex) {
            throw new ArrayIndexOutOfBoundsException();
        }

        T el1 = array[index1];

        array[index1] = array[index2];
        array[index2] = el1;
    }

    public static <T> List<T> convertToArrayList(T[] array) {
        List<T> result = new ArrayList<>();
        Collections.addAll(result, array);
        return result;
    }

}
