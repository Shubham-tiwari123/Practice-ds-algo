package parallelalgo;

class MatrixMul extends Thread{
    int arrA[][], arrB[][] , result[][];
    boolean status;
    int i, j,len;
    public MatrixMul() {
    }

    public MatrixMul(int[][] arrA, int[][] arrB, int[][] result,int i, int j,int len ) {
        this.arrA = arrA;
        this.arrB = arrB;
        this.result = result;
        this.i = i;
        this.j = j;
        this.len = len;
    }
    
    @Override
    public void run(){
        for (int a = i; a <=i; a++)  
            for (int b = j; b <=j; b++)  
                for (int k = 0; k < len; k++)  
                    result[i][j] += arrA[i][k] * arrB[k][j]; 
    }
}

