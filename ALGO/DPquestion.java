package practicealgo;

public class DPquestion {
    
    void longestCommenSequence(String x,String y){
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
        
        for(int i=0;i<=xLen;i++){
            System.out.print("\n");
            for(int j=0;j<=yLen;j++){
                System.out.print(mat[i][j]+" ");
            }
        }
        
        System.out.println("\nLength:-"+mat[xLen][yLen]);
    }
    
    void longestCommenString(String x,String y){
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
        
        for(int i=0;i<=xLen;i++){
            System.out.print("\n");
            for(int j=0;j<=yLen;j++){
                System.out.print(mat[i][j]+" ");
            }
        }
        System.out.println("\nLongest substring length:-"+len);
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
        
    }
}
