package parallelalgo;

public class ParallelAlgo {

    static void mergeTwoArr(int arr1[],int arr2[],int n){
        int len1= arr1.length;
        int len2= arr2.length;
        int arr3[] = new int[n];
        int i=0,j=0,k=0;
        
        while(i<len1 && j<len2){
            if (arr1[i] < arr2[j]) 
                arr3[k++] = arr1[i++]; 
            else
                arr3[k++] = arr2[j++]; 
        }
        while (i < len1) 
            arr3[k++] = arr1[i++]; 
        while (j < len2) 
            arr3[k++] = arr2[j++]; 
        
        System.out.print("\nSorted array after merge:-\n");
        for(i=0;i<n;i++)
            System.out.print(arr3[i]+" ");
    }
    
    static void bubbleSortParallel() throws InterruptedException{
        int arr[] = {64, 34, 25, 12, 22, 11, 90};
        int len = arr.length/2;
        System.out.println("len:-"+len);
        int arr1[] = new int[len];
        int arr2[] = new int[arr.length-len];
        for(int i=0;i<len;i++)
            arr1[i] = arr[i];
        for(int i=len,j=0;i<arr.length;i++,j++)
            arr2[j] = arr[i];
        
        BubbleSort bs = new BubbleSort(arr1);
        BubbleSort bs1 = new BubbleSort(arr2);
        bs.start();
        bs1.start();
        bs1.join();
        
        System.out.print("\nSorted array1:-\n");
        for(int i=0;i<len;i++)
            System.out.print(arr1[i]+" ");
        System.out.print("\nSorted array2:-\n");
        for(int i=0;i<arr2.length;i++)
            System.out.print(arr2[i]+" ");
        mergeTwoArr(arr1, arr2, arr.length);
    }
    
    static void binarySearch() throws InterruptedException{
         int arr[] = {64, 34, 25, 12, 22, 11, 90};
        int len = arr.length/2;
        System.out.println("len:-"+len);
        int arr1[] = new int[len];
        int arr2[] = new int[arr.length-len];
        for(int i=0;i<len;i++)
            arr1[i] = arr[i];
        for(int i=len,j=0;i<arr.length;i++,j++)
            arr2[j] = arr[i];
        
        BinarySearch bs = new BinarySearch(arr1,20);
        BinarySearch bs1 = new BinarySearch(arr2,20);
        bs.start();
        bs1.start();
        bs1.join();
        
        if(bs.status || bs1.status)
            System.out.println("Key found");
        else
            System.out.println("Key not found");
    }
    
    static void multiplyArr(){
        int [][] A = {{1,2,3}, {4,5,6}, {7,8,9}};
        int [][] B = {{9,7,8}, {6,5,4}, {3,2,1}};
        int [][] result= new int[3][3];
        MatrixMul [][] Threads = new MatrixMul[3][3];
        
        for (int i = 0; i<3; i++){
            for (int j=0; j<3; j++){
                Threads[i][j] = new MatrixMul(A, B, result, i, j, 3);
                Threads[i][j].start();
            }
        }
        
        System.out.print("\nElements of Matrix res:\n");
        for (int i = 0; i<3; i++){
            for (int j=0; j<3; j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.print("\n");
        }  
    }
    
    public static void main(String[] args) throws InterruptedException {
        //bubbleSortParallel();
        //binarySearch();
        multiplyArr();
    }
    
}
