package sortingalgos;

import static sortingalgos.Sorting.bubbleSort;
import static sortingalgos.Sorting.countSort;
import static sortingalgos.Sorting.heapSort;
import static sortingalgos.Sorting.insertionSort;
import static sortingalgos.Sorting.mergeSort;
import static sortingalgos.Sorting.printSortArray;
import static sortingalgos.Sorting.quickSort;
import static sortingalgos.Sorting.radixSort;
import static sortingalgos.Sorting.selectionSort;

public class SortingAlgos {
    
    
    public static void main(String[] args) {
        int a[] = {5,7,6,1,2,98,23,41};
        bubbleSort(a);
        selectionSort(a);
        insertionSort(a);
        mergeSort(a, 0, a.length-1);
        System.out.print("\nMerge Sort: ");
        printMergeSortArray(a);
        System.out.print("\nHeap Sort: ");
        heapSort(a);
        printSortArray(a);
        System.out.print("\nQuick Sort: ");
        int a1[] = {10,16,8,12,15,6,3,9,5,Integer.MAX_VALUE};
        quickSort(a1,0,a1.length-1);
        printSortArray(a1);
        System.out.print("\nCount Sort: ");
        int a2[] = {10,5,3,1,0,5,8,10};
        countSort(a2);
        printSortArray(a2);
        System.out.print("\nCount Sort: ");
        int a3[] = {15,1,321,10,802,2,123,9,109,11};
        radixSort(a3);
        //printSortArray(a3);
        
        
    }

    private static void printMergeSortArray(int[] a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
