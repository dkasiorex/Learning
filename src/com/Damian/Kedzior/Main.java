package com.Damian.Kedzior;

public class Main {

    public static void main(String[] args) {
        // write your code here
        //bubbleSort(new int[]{5, 1, 0, 6, 9, 10, 2});
        //countingSort(new int[]{5, 1, 0, 4, 3, 9});
        radixSort(new int[]{50, 21, 54, 1, 9, 93, 855, 51, 24, 4});
    }


    // Bubble sort O^2
    private static void bubbleSort(int[] array) {

        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        for (int j : array) {
            System.out.println(j);
        }
    }

    //Quick Sort
    private static int[] quickSort(int[] array, int p, int k) {

        int wall = p;
        for (int i = p; i < k; i++) {
            if (array[i] < array[k]) {
                if (wall != i) {
                    int temp = array[i];
                    array[i] = array[wall];
                    array[wall] = temp;
                }
                wall++;
            } else {

            }
            i++;
        }
        //walka na spokojnie
        //array[k] = array[k-1];
        int[] holder = new int[k - 1];
        int[] upperHolder = new int[array.length - k];
        System.arraycopy(array, 0, holder, 0, k - 1);
        System.arraycopy(array, k + 1, upperHolder, 0, array.length - k);
        int[] lowerPart = quickSort(holder, 0, holder.length - 1);
        int[] upperPart = quickSort(upperHolder, k + 1, upperHolder.length - 1);
        int[] result = new int[array.length];
        // for test xd
        return array;
    }

    private static int[] countingSort(int[] array) {
        int[] tab = new int[10];
        for (int i = 0; i < tab.length - 1; i++) {
            tab[i] = 0;
        }

        for (int j = 0; j < array.length - 1; j++) {
            if (array[j] <= 9) {
                int value = array[j];
                tab[value] += 1;
            }
        }
        int index = 0;
        for (int k = 0; k < tab.length - 1; k++) {
            while (tab[k] != 0) {
                array[index] = k;
                index++;
                tab[k] -= 1;
            }
        }

        for (int j : array) {
            System.out.println(j);
        }
        return array;
    }

    private static void radixSort(int[] array) {

        int max = array[0];
        int exp = 1;
        int[][] buckets = new int[10][10];
        int[] bucketCount = new int[10];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        while (max / exp > 0) {

            for(int i = 0; i<10; i++){
                bucketCount[i] = 0;
            }
            for (int i = 0; i < array.length; i++) {
                int remainder = (array[i]/exp) % 10;
                System.out.println(remainder);
                buckets[remainder][bucketCount[remainder]] = array[i];
                bucketCount[remainder] += 1;
            }
            int index = 0;
            for (int j = 0; j < 10; j++) {
                for(int k = 0; k < bucketCount[j]; k++){
                    array[index] = buckets[j][k];
                    index++;
                }
            }
            for (int value : array) {
                System.out.println(value);
            }
            exp *= 10;
        }
    }
}
