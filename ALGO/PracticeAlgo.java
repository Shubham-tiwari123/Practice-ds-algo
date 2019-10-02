package practicealgo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PracticeAlgo {

    static void minuteToWinIt(int[] a, int k) {
        // Return the minimum amount of time in minutes.
        int count=0;
        for(int i=0;i<a.length-1;i++){
            int dif = Math.abs(a[i]-a[i+1]);
            if(dif!=Math.abs(k)){
                if(i<a.length-2){
                    System.out.print("\nif1");
                    int diff2 = Math.abs(a[i+1]-a[i+2]);
                    if(diff2!=Math.abs(k)){
                        System.out.println("if2");
                        a[i+1]=a[i]+dif;
                        count++;
                    }
                    else{
                        System.out.print("\nelse2");
                        count++;
                    }
                }
                else{
                    System.out.print("\nelse1");
                    a[i+1]=a[i]+dif;
                    count++;
                }
            }
        }
        System.out.println("count:-"+count);
        System.out.println("arry:-");
        for(int i=0;i<a.length;i++)
            System.out.print(a[i]+" ");
    }
    
    static void merger(List<Integer> p,int l,int m,int r){
        int n1 = m-l+1;
        int n2 = r-m;
        int L[] = new int[n1];
        int R[] = new int[n2];
        
        for (int i=0; i<n1; ++i) 
            L[i] = p.get(l + i); 
        for (int j=0; j<n2; ++j) 
            R[j] = p.get(m + 1+ j); 
        
        int i = 0, j = 0;
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                p.remove(k);
                p.add(k, L[i]);
                i++; 
            } 
            else
            { 
                p.remove(k);
                p.add(k, R[j]); 
                j++; 
            } 
            k++; 
        }
        while (i < n1) 
        { 
            p.remove(k);
            p.add(k, L[i]);
            i++; 
            k++; 
        }
        while (j < n2) 
        { 
            p.remove(k);
            p.add(k, R[j]); 
            j++; 
            k++; 
        } 
    }
    
    static void sort(List<Integer> p,int l,int r){
        if(l<r){
            int m= (l+r)/2;
            sort(p, l, m);
            sort(p, m+1, r);
            merger(p, l, m, r);
        }
    }
    static void solve(List<Integer> p){
        p.add(0);
        sort(p, 0, p.size()-1);
        int sum=0;
        for(int i=0;i<p.size()-1;i++){
            int diff = Math.abs(p.get(i)-p.get(i+1));
            sum = sum+diff;
        }
        System.out.println("sum:-"+sum);
    }
    public static void main(String[] args) {
        DPquestion dp = new DPquestion();
        /*dp.longestCommenSubSequence("shubham", "shivam");
        dp.longestCommenSubString("GeeksforGeeks", "GeeksQuiz");
        dp.longestPalindromicSubstring("GEEKSFORGEEKS");
        dp.longestPalindromicSubsequence("GEEKSFORGEEKS");
        dp.longestRepeatedSubSeq("AABEBCDD");
        int mat[]={2,3,5,10};
        dp.coinChange(mat, 15);
        int mat1[]={5,7,8,9};
        dp.minCoinRequired(mat1, 49);
        int matArr[] = {10, 22, 9, 33, 21, 50, 41, 60};
        dp.longestIncreasingSub(matArr);
        int set[] = {3, 34, 4, 12, 5, 2}; 
        dp.subsetSum(set, 9);*/
        
        GraphQuestion gq = new GraphQuestion();
        gq.createUndirectedGraphAdjList();
        gq.graphDFS(0);
        gq.graphBFS(0);
        gq.checkPath(1, 5);
    }
    
}
