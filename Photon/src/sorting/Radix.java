package sorting;

public class Radix {


    public static void main(String[] args) {

        int[] radixArray = { 4725, 4586, 1330, 8792, 1594, 5729 };

        radixSort(radixArray, 10, 4);

        for (int i = 0; i < radixArray.length; i++) {
            System.out.println(radixArray[i]);
        }
    }

    public static void radixSort(int[] input, int radix, int width) {
        for (int i = 0; i < width; i++) {
            radixSingleSort(input, i, radix);
        }
    }
//
    public static void radixSingleSort(int[] array, int position, int sizeofArray) {

        int numItems = array.length;
        int[] countArray = new int[sizeofArray];

        for (int value: array) {
            countArray[getDigit(position, value, sizeofArray)]++;
        }
        // Adjust the count array
        for (int j = 1; j < sizeofArray; j++) {
            countArray[j] += countArray[j - 1];
        }

        int[] temp = new int[numItems];
        for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
            temp[--countArray[getDigit(position, array[tempIndex], sizeofArray)]] =
                    array[tempIndex];
        }

        for (int tempIndex = 0; tempIndex < numItems; tempIndex++) {
            array[tempIndex] = temp[tempIndex];
        }

    }


    public static int getDigit(int position, int value, int radix) {
        return value / (int) Math.pow(radix, position) % radix;
    }
    
    //now I need to find what to study next.. search for interview questions 

}
