package ProblemOfArrays;

import java.util.Scanner;

public class FindTwoMissingNumber {
//	Process1
//	Time Complexity:O(N^2)
//	Space Complexity:O(1)
	public static void TwoMissing1(int []arr,int n) {
		boolean flag=false;
		for(int i=1;i<=n+2;i++) {
			for(int j=0;j<n;j++) {
				if(arr[j]!=i) {
					flag=true;
				}
				else {
					flag=false;
					break;
				}
			}
			if(flag) {
				System.out.println(i);
			}
		}
	}
//	Process2
//	Time Complexity:O(N)
//	Space Complexity:O(N)
	public static void TwoMissing2(int[] arr,int n) { 
	    boolean []mark = new boolean[n+1]; 
	    for (int i = 0; i < n-2; i++) { 
	        mark[arr[i]] = true; 
	    } 
	    for (int i = 1; i <= n; i++) 
	    {
	    	if (! mark[i]) {
	    		System.out.print(i + " "); 
	    	}
	    }
	}
	
//	Process3
//	Time Complexity:O(N)
//	Space Complexity:O(1)
//	OverFlow Condition are active
	public static void TwoMissing3(int arr[],int n) {
		int m=n+2;
		int sum=m*(m+1)/2;
		
		int sum1=0;
		for(int i=0;i<n;i++) {
			sum1+=arr[i];
		}
		
		int val=sum-sum1;
		int val1=0;
		int avg=val/2;
		for(int i=0;i<n;i++) {
			if(arr[i]<=avg) {
				val1+=arr[i];
			}
		}
		int a1=val-val1;
		int a2=val-a1;
		System.out.println(a1);
		System.out.println(a2);
	}
//	Process4
//	Time Complexity:O(N)
//	Space Complexity:O(1)
//	No OverFlow Condition
	public static void TwoMissing4(int []arr,int n) {
		 /* Get the XOR of all elements in arr[] and 
        {1, 2 .. n} */
     int XOR = arr[0]; 
     for (int i = 1; i < n-2; i++) 
         XOR ^= arr[i]; 
     for (int i = 1; i <= n; i++) 
         XOR ^= i; 
    
     // Now XOR has XOR of two missing elements. 
     // Any set bit in it must be set in one missing 
     // and unset in other missing number 
    
     // Get a set bit of XOR (We get the rightmost 
     // set bit) 
     int set_bit_no = XOR & ~(XOR-1); 
    
     // Now divide elements in two sets by comparing 
     // rightmost set bit of XOR with bit at same  
     // position in each element. 
     int x = 0, y = 0; // Initialize missing numbers 
     for (int i = 0; i < n-2; i++) 
     { 
         if ((arr[i] & set_bit_no) > 0) 
               
             /*XOR of first set in arr[] */
             x = x ^ arr[i];  
         else
             /*XOR of second set in arr[] */
             y = y ^ arr[i];  
     } 
       
     for (int i = 1; i <= n; i++) 
     { 
         if ((i & set_bit_no)>0) 
           
             /* XOR of first set in arr[] and 
                {1, 2, ...n }*/
             x = x ^ i;  
         else
             /* XOR of second set in arr[] and 
                 {1, 2, ...n } */
             y = y ^ i;  
     }
     System.out.println(x+" "+y);
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=s.nextInt();
		}
//		Process1
		System.out.println("Process1:");
		TwoMissing1(arr,n);
		System.out.println();
//		Process2
		System.out.println("Process2:");
		TwoMissing2(arr, n+2);
		System.out.println();
//		Process3
		System.out.println("Process3:");
		TwoMissing3(arr, n);
		System.out.println();
//		Process4
		System.out.println("Process4:");
		TwoMissing4(arr, n);
	}
}
