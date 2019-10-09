package parallelalgo;

class BinarySearch extends Thread{
    int arr[];
    int k;
    boolean status;

    public BinarySearch() {
    }
    
    public BinarySearch(int array[],int k) {
        arr = array;
        this.k=k;
    }
    
    @Override
    public void run(){
        int n = arr.length;
        boolean flag = false;
        for (int i = 0; i < n; i++){
            if(arr[i]==k){
                flag =true;
                break;
            }
        }
        if(flag)
            status=true;
        else
            status=false;
    }
}

