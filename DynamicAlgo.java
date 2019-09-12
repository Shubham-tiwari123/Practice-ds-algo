package socketpro;

public class DynamicAlgo {
    
    public void longestPalindromeSubstring(String input){
        int strLen = input.length();
        boolean table[][] = new boolean[strLen][strLen];
        for(int i=0;i<strLen;i++)
            table[i][i]=true;
        int maxLen=0;
        for(int i=0;i<strLen-1;i++){
            if(input.charAt(i)==input.charAt(i+1)){
                table[i][i+1]=true;
                maxLen=2;
            }
        }
        
        for(int k=3;k<=strLen;k++){
            for(int i=0;i<strLen-k+1;i++){
                int j = i+k-1;
                if(table[i+1][j-1] && input.charAt(i)==input.charAt(j)){
                    table[i][j]=true;
                    if(maxLen<k)
                        maxLen=k;
                }
            }
        }
        System.out.println("max:-"+maxLen);
    }
    
    public void totalPalindromeSubstring(String input){
        int strLen = input.length();
        int totalPalindrome=0;
        boolean table[][] = new boolean[strLen][strLen];
        
        for(int i=0;i<strLen;i++)
            table[i][i]=true;
        for(int i=0;i<strLen-1;i++){
            if(input.charAt(i)==input.charAt(i+1)){
                table[i][i+1]=true;
                totalPalindrome++;
            }
        }
        
        for(int k=3;k<=strLen;k++){
            for(int i=0;i<strLen-k+1;i++){
                int j = i+k-1;
                if(table[i+1][j-1] && input.charAt(i)==input.charAt(j)){
                    table[i][j]=true;
                    totalPalindrome++;
                }
            }
        }
        System.out.println("Total palindrome substring:-"+totalPalindrome);
    }
    
    public void longestPalindromeSubsequce(String input){
        int strLen = input.length();
        int table[][]= new int[strLen][strLen];
        for(int i=0;i<strLen;i++)
            table[i][i]=1;
        
        for(int k=2;k<=strLen;k++){
            for(int i=0;i<strLen-k+1;i++){
                int j= i+k-1;
                if(input.charAt(i)==input.charAt(j) && k==2){
                    table[i][j]=2;
                }else if(input.charAt(i)==input.charAt(j)){
                    table[i][j]=table[i+1][j-1]+2;
                }
                else{
                    table[i][j]= Integer.max(table[i][j-1],table[i+1][j]);
                }
            }
        }
        System.out.println("max:-"+table[0][strLen-1]);
    }
}
