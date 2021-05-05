package com.DS.Sorting;

public class MergeTwoSortedArrays_test {

    public static void main(String[] args)
    {
        int[] firstSortedArray = {1,4,7};
        int[] secondSortedArray = {2,5,6,0,0,0};
        merger_first_into_second(firstSortedArray,secondSortedArray);

        for (int i=0; i< secondSortedArray.length ; i++){
            System.out.println(secondSortedArray[i]);
        }
    }


    /*
     * Complete the merger_first_into_second function below.
     */
    static void merger_first_into_second(int[] arr1, int[] arr2) {
        /*
         * Write your code here.
         */
        int m = arr1.length;
        int n = arr1.length;

        int p1 = m - 1;
        int p2 = m - 1;
        for ( int p = m + n - 1; p >= 0; p-- ){
            if ( p2 < 0){
                return;
            }
            if(p1>=0 && arr2[p1] > arr1[p2] ){
                arr2[p] = arr2[p1--];
            } else {
                arr2[p] = arr1[p2--];
            }
        }

    }

}


