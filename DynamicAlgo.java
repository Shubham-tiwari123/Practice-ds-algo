package socketpro;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

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
    
    public void partionPalindrome(String input){
        int strLen = input.length();
        boolean table[][]= new boolean[strLen][strLen];
        
        for(int i=0;i<strLen;i++)
            table[i][i]=true;
        
        for(int L=2;L<=strLen;L++){   //L is length of substring taken at a time
            for(int i=0;i<strLen-L+1;i++){
                int j= i+L-1;
                if(L==2)
                    table[i][j]= (input.charAt(i)==input.charAt(j));
                else
                    table[i][j]= (input.charAt(i)==input.charAt(j) && table[i+1][j-1]);
            }
        }
        
        int c[] = new int[strLen];
        for(int i=0;i<strLen;i++){
            if(table[0][i]==true)
                c[i]=0;
            else{
                c[i]=Integer.MAX_VALUE;
                for(int j=0;j<i;j++){
                    if(table[j+1][i]==true && 1+c[j]<c[i])
                        c[i]=1+c[j];
                }
            }
        }
        
        System.out.println("partion:-"+c[strLen-1]);
    }
    
    public void partionPalindromeInt(int arr[],int len){
        int arrLen = len;
        boolean table[][]= new boolean[arrLen][arrLen];
        
        for(int i=0;i<arrLen;i++)
            table[i][i]=true;
        
        for(int L=2;L<=arrLen;L++){   //L is length of substring taken at a time
            for(int i=0;i<arrLen-L+1;i++){
                int j= i+L-1;
                if(L==2)
                    table[i][j]= (arr[i]==arr[j]);
                else
                    table[i][j]= (arr[i]==arr[j] && table[i+1][j-1]);
            }
        }
        
        int c[] = new int[arrLen];
        for(int i=0;i<arrLen;i++){
            if(table[0][i]==true)
                c[i]=0;
            else{
                c[i]=Integer.MAX_VALUE;
                for(int j=0;j<i;j++){
                    if(table[j+1][i]==true && 1+c[j]<c[i])
                        c[i]=1+c[j];
                }
            }
        }
        int res = c[arrLen-1]+1;
        System.out.println(c[arrLen-1]);
    }
    
    public void solution(int arr[],int len){
        HashMap<Integer,Integer> hash = new HashMap<>();
        for(int i=0;i<len;i++){
            if(hash.containsKey(arr[i])){
                int value=hash.get(arr[i]);
                hash.remove(arr[i]);
                hash.put(arr[i], value+1);
            }
            else
                hash.put(arr[i], 1);
        }  
        System.out.println(hash);
        int cost=0;
        for(Integer num: hash.keySet()){
            //System.out.println("key:-"+num+" value:-"+hash.get(num));
            if(hash.get(num)%2!=0)
                cost=cost+1;
        }
        System.out.println("cost:-"+cost);
    }
}
