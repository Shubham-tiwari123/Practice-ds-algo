package sortingalgos;

import java.util.Arrays;

public class Sorting {
    static int heapArr[];
    static void bubbleSort(int a[]){
        boolean swapped;
        for(int i=0;i<a.length-1;i++){
            swapped=false;
            for(int j=0;j<a.length-1;j++){
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                    swapped=true;
                }
            }
            if(!swapped)
                break;
        }
        System.out.print("\nBubble Sort: ");
        for(int num:a)
            System.out.print(num+" ");
    }
    
    static void selectionSort(int a[]){
        for(int i=0;i<a.length-1;i++){
            int min =i;
            for(int j=i+1;j<a.length;j++){
                if(a[j]<a[min]){
                    min = j;
                }
            }
            int temp = a[min];
            a[min]=a[i];
            a[i]=temp;
        }
        System.out.print("\nSelection Sort: ");
        for(int num:a)
            System.out.print(num+" ");
    }
    
    static void insertionSort(int a[]){
        for(int i=1;i<a.length;i++){
            int v = a[i];
            int j=i;
            while(a[j-1]>v && j>=1){
                a[j]=a[j-1];
                j--;
            }
            a[j]=v;
        }
        System.out.print("\nInsertion Sort: ");
        for(int num:a)
            System.out.print(num+" ");
    }
    
    static void mergeSort(int a[],int l,int r){
        if(l<r){
            int mid = (l+r)/2;
            mergeSort(a, l, mid);
            mergeSort(a, mid+1, r);
            mergeArray(a, l, mid, r);
        }
    }
    
    static void mergeArray(int a[],int l,int m, int r){
        int len1 = m-l+1;
        int len2 = r-m;
        int L[] = new int[len1];
        int R[] = new int[len2];
        
        for(int i=0;i<len1;++i)
            L[i]=a[l+i];
        
        for(int i=0;i<len2;++i)
            R[i]=a[m+1+i];
        
        int i=0,j=0,k=l;
        while(i<len1 && j<len2){
            if(L[i]<R[j]){
                a[k]=L[i];
                i++;
            }
            else{
                a[k]=R[j];
                j++;
            }
            k++;    
        }
        while(i<len1){
            a[k]=L[i];
            i++;
            k++;
        }
        while(j<len2){
            a[k]=R[j];
            j++;
            k++;
        }
    }
    
    static void printSortArray(int arr[]){
        
        for(int i:arr)
            System.out.print(i+" ");
    }
    
    static void heapSort(int arr[]){
        //Min heap
        heapArr = arr;
        int lastNonLeaf = (arr.length)/2 - 1;
        for(int i =lastNonLeaf;i>=0;i--)
            buildMinHeap(i);
    }
    
    static void buildMinHeap(int i){
        int min = i;
        int left = 2*i+1;
        int right = 2*i+2;
        if(left<heapArr.length && heapArr[left]<heapArr[min])
            min=left;
        if(right<heapArr.length && heapArr[right]<heapArr[min])
            min=right;
        if(min!=i){
            int temp = heapArr[i]; 
            heapArr[i] = heapArr[min]; 
            heapArr[min] = temp; 
            buildMinHeap(min);
        }
    }
    
    static int partitionArr(int l,int h,int arr[]){
        int pivot = arr[l];
        int i=l,j=h;
        
        while(i<j){
            do{
                i++;
            }while(arr[i]<=pivot);
            do{
                j--;
            }while(arr[j]>pivot);
            if(i<j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[l];
        arr[l] = arr[j];
        arr[j] = temp;
        return j;
    }
    
    static void quickSort(int a[],int l,int r){
        if(l<r){
            int j = partitionArr(l, r, a);
            quickSort(a, l, j);
            quickSort(a, j+1, r);
        }
    }
    
    static void countSort(int arr[]){
        int max= Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int range = max-min+1;
        System.out.print("\nMax: "+max+" Min: "+min+" Range: "+range+"\n");
        int count[]= new int[range];
        int output[] = new int[arr.length];
        
        for(int i=0;i<arr.length;i++){
            count[arr[i]-min]++;
        }
        for(int i=1;i<count.length;i++)
            count[i] = count[i]+count[i-1];
        
        for(int i=arr.length-1;i>=0;i--){
            output[count[arr[i] - min] - 1] = arr[i]; 
            count[arr[i]-min]--;
        }
        for(int i=0;i<arr.length;i++)
            arr[i]=output[i];
    }
    
    static void radixSort(int arr[]){
        int max = Arrays.stream(arr).max().getAsInt();
        int maxlen =0;
        int temp = max;
        while(temp>0){
            temp = temp/10;
            maxlen++;
        }
        System.out.print("\nLen:"+maxlen+" max: "+max);
        for(int i=0;i<arr.length;i++){
            int len =0;
            temp = arr[i];
            while(temp>0){
                temp = temp/10;
                len++;
            }
            System.out.print("\nLen:"+len);
        }
        
    }
}
