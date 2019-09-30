package practicealgo;

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
    
    public static void main(String[] args) {
        DPquestion dp = new DPquestion();
        //dp.longestCommenSequence("shubham", "shivam");
        //dp.longestCommenString("GeeksforGeeks", "GeeksQuiz");
        dp.longestPalindromicSubstring("geeksskeeg");
        
    }
    
}
