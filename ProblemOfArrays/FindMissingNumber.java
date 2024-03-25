//Problem1

package ProblemOfArrays;

import java.util.Scanner;

public class FindMissingNumber {
	
//	process1
//	Time Complexity:O(N)
//	Space Complexity:O(1)
//	OverFlow Condition Occur
	public static int FindMissNumProcess1(int arr[],int n) {
//		Addition based Solution
		int sum=n*(n+1)/2;
		int val=0;
		for(int i=0;i<arr.length;i++) {
			val+=arr[i];
		}
		return (sum-val);
	}
	
//	Process2
//	Time Complexity:O(N)
//	Space Complexity:(1)
//	No Overflow Condition Occur
	public static int FindMissNumProcess2(int arr[],int n) {
//		XOR based Solution
		int x1=0;
		for(int i=1;i<=n;i++) {
			x1=x1^i;
		}
		int x2=0;
		for(int i=0;i<arr.length;i++) {
			x2=x2^arr[i];
		}
		return x1^x2;
	}
	
//	Process3
//	Time Complexity:O(N^2)
//	Space Complexity:O(1)
//	public static int FindMissNumProcess3(int []arr,int n) {
//		boolean flag=false;
//		for(int i=1;i<=n;i++){
//            for(int j=0;j<n;j++){
//                if(i==arr[j]){
//                    flag=false;
//                    break;
//                }
//                else{
//                    flag=true;
//                }
//            }
//            if(flag){
//                return i;
//            }
//        }
//        return 0;
//	}
	
//	Process4
//	Time Complexity:O(N)
//	Space Complexity:O(N)
//	public static int FindMissNumProcess4(int []arr,int n) {
//		boolean temp[]=new boolean[n+1];
//		for(int i=0;i<n;i++) {
//			temp[arr[i]]=true;
//		}
//		for(int i=1;i<=n;i++) {
//			if(!temp[i]) {
//				return i;
//			}
//		}
//		return 0;
//	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
//		input of number is [1,n]
		int arr[]=new int[n-1];
		for(int i=0;i<=n-2;i++) {
			arr[i]=s.nextInt();
		}
//		process1
		System.out.println("Process1 val:");
		int val=FindMissNumProcess1(arr,n);
		System.out.println(val);
//		Process2
		System.out.println("Process2 val:");
		int val1=FindMissNumProcess2(arr,n);
		System.out.println(val1);
		System.out.println();
//		Process3
//		System.out.println("Process3:");
//		int val2=FindMissNumProcess3(arr, n);
//		System.out.println(val2);
//		Process4
//		System.out.println("Process4:");
//		int val3=FindMissNumProcess4(arr, n);
//		System.out.println(val3);
	}
}
