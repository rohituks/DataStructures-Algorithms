package com.DS.Sorting;

public class MergeTwoSortedArrays {

    public static void main(String[] args)
    {
        int[] firstSortedArray = {1,4,7};
        int[] secondSortedArray = {2,5,6,0,0,0};

        sortArrays(firstSortedArray,secondSortedArray);

        for (int i=0; i< secondSortedArray.length ; i++){
            System.out.println(secondSortedArray[i]);
        }

    }

    private static void sortArrays(int[] nums2, int[] nums1) {
        int m = 3;
        int n = 3;
        int p1 = m - 1;
        int p2 = n - 1;

        // And move p backwards through the array, each time writing
        // the smallest value pointed at by p1 or p2.
        for (int p = m + n - 1 ; p>=0 ; p --){
            if( p2 < 0){
                return;
            }
            if(p1 >= 0 && nums1[p1] > nums2[p2]){
                nums1[p] = nums1[p1--];
            } else {
                nums1[p] = nums2[p2--];
            }
        }
    }
}


