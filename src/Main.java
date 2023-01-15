import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // Source array
        int[] array = new int[]{1, 5, 6, 3, 4, 5, 9, 6, 7};
        // Array after executing the method /function/
        int[] returnArray = new int[5];
        // Array after executingi the method /function1/
        int[] returnArray1 = new int[5];

        // output of the original array
        Arrays.stream(array).forEach(s -> System.out.print(" " + s));
        System.out.print("   ");

        //output array after executing the method /function/
        returnArray = function(array);
        Arrays.stream(returnArray).forEach(s -> System.out.print(" " + s));
        System.out.print("   ");

        //output array after executing the method /function1/
        returnArray1 = function1(array);
        Arrays.stream(returnArray1).forEach(s -> System.out.print(" " + s));

    }

    // classic execution method
    private static int[] function(int[] inputArray) {

        int[] returnArray = new int[5];

        checkingForThePresenceOfTheSeventhIndex(inputArray);
        // iteration over all elements of the array
        for (int i = 0; i < inputArray.length; i++) {
            // checking for an even number
            if (inputArray[i] % 2 == 0) {
                inputArray[i]++;
            }
            // Selecting elements by index
            if (i >= 2 & i <= 6) {
                returnArray[i - 2] = inputArray[i];
            }
        }
        return returnArray;
    }

    // executing the method using Stream API
    private static int[] function1(int[] inputArray) {
        checkingForThePresenceOfTheSeventhIndex(inputArray);
        return Arrays.stream(inputArray).map(s -> s % 2 == 0 ? s : s++).skip(2).limit(5).toArray();

    }

    // The method of checking the index is seven, if it is not there, then throwing an error.
    private static void checkingForThePresenceOfTheSeventhIndex(int[] array) {
        if (array.length < 7) {
            throw new ArrayIndexOutOfBoundsException("Not enough elements");
        }
    }

}