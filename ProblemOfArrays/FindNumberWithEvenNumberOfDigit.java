package ProblemOfArrays;

import java.util.Scanner;

public class FindNumberWithEvenNumberOfDigit {
	
//	Process1
//	Time Complexity:O(N*K)
//	Space Complexity:O(1)
	public static int EvenNumberOfDigit1(int arr[]) {
		int count=0;
		for(int i=0;i<arr.length;i++) {
			if(String.valueOf(arr[i]).length()%2==0) {
				count++;
			}
		}
		return count;
	}
//	Process2
//	Time Complexity:O(N)
//	Space Complexity:O(1)
	public static int EvenNumberOfDigit2(int arr[]) {
		int count=0;
		for(int i=0;i<arr.length;i++) {
			if((int)(Math.log10(arr[i])+1)%2==0) {
				count++;
			}
		}
		return count;
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
		System.out.println(EvenNumberOfDigit1(arr));
		System.out.println();
//		Process2
		System.out.println("Process2:");
		System.out.println(EvenNumberOfDigit2(arr));
		
		
	}
}
