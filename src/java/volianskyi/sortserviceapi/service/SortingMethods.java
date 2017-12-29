/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volianskyi.sortserviceapi.service;

/**
 *
 * @author tarasvolianskyi
 */
public class SortingMethods {

    public static void bubble_srt(int array[]) {
        int n = array.length;
        int k;
        for (int m = n; m >= 0; m--) {
            for (int i = 0; i < n - 1; i++) {
                k = i + 1;
                if (array[i] > array[k]) {
                    int temp;
                    temp = array[i];
                    array[i] = array[k];
                    array[k] = temp;
                }
            }
        }
    }

    public static void doSelectionSort(int array[]) {
        for (int i = 0; i < array.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[index]) {
                    index = j;
                }
            }
            int smallerNumber = array[index];
            array[index] = array[i];
            array[i] = smallerNumber;
        }
    }

    public static void doInsertionSort(int input[]) {
        int temp;
        for (int i = 1; i < input.length; i++) {
            for (int j = i; j > 0; j--) {
                if (input[j] < input[j - 1]) {
                    temp = input[j];
                    input[j] = input[j - 1];
                    input[j - 1] = temp;
                }
            }
        }
    }

    //qiuik sort
    private int array4[];
    private int length4;

    public void sort(int inputArr[]) {

        if (inputArr == null || inputArr.length == 0) {
            return;
        }
        this.array4 = inputArr;
        length4 = inputArr.length;
        quickSort(0, length4 - 1);
    }

    private void quickSort(int lowerIndex, int higherIndex) {
        int i = lowerIndex;
        int j = higherIndex;
        int pivot = array4[lowerIndex + (higherIndex - lowerIndex) / 2];
        while (i <= j) {
            while (array4[i] < pivot) {
                i++;
            }
            while (array4[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = array4[i];
                array4[i] = array4[j];
                array4[j] = temp;
                i++;
                j--;
            }
        }
        if (lowerIndex < j) {
            quickSort(lowerIndex, j);
        }
        if (i < higherIndex) {
            quickSort(i, higherIndex);
        }
    }

    //last one
    private int[] array;
    private int[] tempMergArr;
    private int length;

    public void sortMerge(int inputArr[]) {
        this.array = inputArr;
        this.length = inputArr.length;
        this.tempMergArr = new int[length];
        doMergeSort(0, length - 1);
    }

    private void doMergeSort(int lowerIndex, int higherIndex) {
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            doMergeSort(lowerIndex, middle);
            doMergeSort(middle + 1, higherIndex);
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }

    private void mergeParts(int lowerIndex, int middle, int higherIndex) {

        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }

    }
/*
Test of speed for sorting methods
1. 32.669	
2. 10.135	
3. 13.718	
4. 5.057	
5. 5.059
     */

}
