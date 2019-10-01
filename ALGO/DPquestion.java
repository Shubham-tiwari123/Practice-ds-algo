package practicealgo;

public class DPquestion {
    
    void longestCommenSubSequence(String x,String y){
        int xLen = x.length();
        int yLen = y.length();
        int mat[][] = new int[xLen+1][yLen+1];
        
        for(int i=0;i<yLen+1;i++)
            mat[0][i] = 0;
        
        for(int i=0;i<xLen+1;i++)
            mat[i][0] = 0;

        for(int i=1;i<=xLen;i++){
            for(int j=1;j<=yLen;j++){
                if(x.charAt(i-1)==y.charAt(j-1))
                    mat[i][j]= mat[i-1][j-1]+1;
                else
                    mat[i][j]= Math.max(mat[i-1][j],mat[i][j-1]);
            }
        }
        System.out.println("\nLength:-"+mat[xLen][yLen]);
        String res="";
        //get the string
        int i=xLen,j=yLen;
        while(i>0 && j>0){
            if(mat[i][j]==mat[i-1][j-1]+1){
                res = res+x.charAt(i-1);
                i--;
                j--;
            }
            else if(mat[i][j]==mat[i-1][j]){
                i--;
            }
            else
                j--;
        }
        System.out.println("res in reverse:-"+res);
    }
    
    void longestCommenSubString(String x,String y){
        int xLen = x.length();
        int yLen = y.length();
        int mat[][] = new int[xLen+1][yLen+1];
        int len =0; // to store the len of commen string
        
        for(int i=0;i<=yLen;i++)
            mat[0][i]=0;
        for(int i=0;i<=xLen;i++)
            mat[i][0]=0;
        
        for(int i=1;i<=xLen;i++){
            for(int j=1;j<=yLen;j++){
                if(x.charAt(i-1)==y.charAt(j-1)){
                    mat[i][j]=mat[i-1][j-1]+1;
                    len = Math.max(len, mat[i][j]);
                }
                else{
                    mat[i][j]=0;
                }
            }
        }
    }
    
    void longestPalindromicSubstring(String x){
        int xLen = x.length();
        boolean mat[][] = new boolean[xLen][xLen];
        int len=1;
        //substring of len 1
        for(int i=0;i<xLen;i++)
            mat[i][i]=true;
        //substring of len 2
        for(int i=0;i<xLen-1;i++){
            if(x.charAt(i)==x.charAt(i+1)){
                mat[i][i+1]=true;
                len=2;
            }
        }
        
        for(int k=3;k<=xLen;k++){
            //fixing start point
            for(int i=0;i<xLen-k+1;i++){
                //fixing sub string len
                int j=i+k-1;
                if(mat[i+1][j-1] && x.charAt(i)==x.charAt(j)){
                    mat[i][j]=true;
                    if(k>len)
                        len=k;
                }
            }
        }
        System.out.println("Len:-"+len);
    }
    
    void longestPalindromicSubsequence(String x){
        int xLen = x.length();
        int mat[][] = new int[xLen][xLen];
        
        for(int i=0;i<xLen;i++)
            mat[i][i]=1;
        
        for(int k=2;k<=xLen;k++){
            for(int i=0;i<xLen-k+1;i++){
                int j = i+k-1;
                if(x.charAt(i)==x.charAt(i+1) && k==2)
                    mat[i][i+1]=2;
                else if(x.charAt(i)==x.charAt(j))
                    mat[i][j]=mat[i+1][j-1]+2;
                else
                    mat[i][j]=Math.max(mat[i][j-1], mat[i+1][j]);
            }
        }
        
        System.out.println("Len:-"+mat[0][xLen-1]);
    }
    
    //same as longest common subsequence only that if char are equal then i!=j;
    void longestRepeatedSubSeq(String x){
        int xLen = x.length();
        int mat[][] = new int[xLen+1][xLen+1];
        for(int i=0;i<=xLen;i++){
            mat[0][i]=0;
            mat[i][0]=0;
        }
        for(int i=1;i<=xLen;i++){
            for(int j=1;j<=xLen;j++){
                if(x.charAt(i-1)==x.charAt(j-1) && i!=j)
                    mat[i][j]=mat[i-1][j-1]+1;
                else
                    mat[i][j]=Math.max(mat[i-1][j], mat[i][j-1]);
            }
        }
        
        String res="";
        //get the string
        int i=xLen,j=xLen;
        while(i>0 && j>0){
            if(mat[i][j]==mat[i-1][j-1]+1){
                res = res+x.charAt(i-1);
                i--;
                j--;
            }
            else if(mat[i][j]==mat[i-1][j]){
                i--;
            }
            else
                j--;
        }
        System.out.println("res in reverse:-"+res);
        
        
    }
    
    void coinChange(int value[],int total){
        int xLen = value.length+1;
        int yLen = total+1;
        //System.out.println("x:-"+xLen+" y:-"+yLen);
        int mat[][]=new int[xLen][yLen];
        
        for(int i=0;i<yLen;i++)
            mat[0][i]=0;
        
        for(int i=0;i<xLen;i++)
            mat[i][0]=1;
        int k=0;
        for(int i=1;i<xLen;i++){
            for(int j=1;j<yLen;j++){
                if(value[k]>j){
                    mat[i][j]=mat[i-1][j];
                }else{
                    int diff = Math.abs(value[k]-j);
                    mat[i][j]=mat[i][diff]+mat[i-1][j];
                }
            }
            k++;
        }
        for(int i=0;i<xLen;i++){
            System.out.print("\n");
            for(int j=0;j<yLen;j++)
                System.out.print(mat[i][j]+" ");
        }
        System.out.println("\nNumber of ways to get "+total+" is:"+mat[xLen-1][yLen-1]);
            
    }
    
    void minCoinRequired(int value[],int total){
        int xLen = value.length+1;
        int yLen = total+1;
        //System.out.println("x:-"+xLen+" y:-"+yLen);
        double mat[][]=new double[xLen][yLen];
        
        for(int i=1;i<yLen;i++)
            mat[0][i]=Double.POSITIVE_INFINITY;
        
        for(int i=0;i<xLen;i++)
            mat[i][0]=0;
        int k=0;
        for(int i=1;i<xLen;i++){     //xLen = tottalCoins yLen = totalsum
            for(int j=1;j<yLen;j++){
                if(value[k]>j){
                    mat[i][j]=mat[i-1][j];
                }else{
                    int diff = Math.abs(value[k]-j);
                    mat[i][j]= Math.min(1+mat[i][diff],mat[i-1][j]);
                }
            }
            k++;
        }
        System.out.println("\nMin coins required to get "+total+" is:"+mat[xLen-1][yLen-1]);
    }
    
    void matrixMultiplication(){
        //https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/
    }
}
