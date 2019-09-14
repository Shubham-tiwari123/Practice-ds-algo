package socketpro;

import java.util.Scanner;

public class MatrixQue {
    Scanner sc = new Scanner(System.in);
    
    void printMatDiaonaly(){
        int test = sc.nextInt();
        while(test-->0){
            int size = sc.nextInt();
            int mat[][] = new int[size][size];
            for(int i=0;i<size;i++){
                for(int j=0;j<size;j++)
                    mat[i][j]=sc.nextInt();
            }
            int res[] = new int[size*size];
            
            for(int i=0;i<size;i++){
                int k=i;
                int j=0;
                while(k>=0){
                    System.out.print(mat[j][k]+" ");
                    k=k-1;
                    j=j+1;
                }
            }
            
            for(int i=1;i<size;i++){
                int k=size-1;
                int j=i;
                while(j<size){
                    System.out.print(mat[j][k]+" ");
                    k=k-1;
                    j=j+1;
                }
            }
        }
    }
}
