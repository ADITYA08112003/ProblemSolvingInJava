//Problem7
package ProblemOfArrays;
import java.util.*;
import java.util.List;
import java.util.Scanner;

public class CreateTargetArrayInTheGivenArray {
	
	public static void Print(int []arr) {
		for(int i : arr) {
			System.out.print(i+" ");
		}
	}
	
//	Time Complexity:O(N)
//	Space Complexity:O(1)
	public static int[] TargetArray(int[] arr,int[] index) {
		List<Integer> list=new ArrayList<>();
		for(int i=0;i<index.length;i++) {
			// Insert the element from nums at the specified index
			list.add(index[i],arr[i]);
		}
		int target[]=new int[index.length];
		for(int j=0;j<index.length;j++) {
			// Convert the List to an array
			target[j]=list.get(j);
		}
		return target;
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int arr[]=new int[n];
		int index[]=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=s.nextInt();
		}
		for(int j=0;j<n;j++) {
			index[j]=s.nextInt();
		}
		int target[]=TargetArray(arr,index);
		Print(target);
	}
}
