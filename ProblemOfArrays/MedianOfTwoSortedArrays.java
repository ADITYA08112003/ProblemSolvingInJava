package ProblemOfArrays;

import java.util.Scanner;

public class MedianOfTwoSortedArrays {
	
//	Process1
//	Time Complexity:O(N+M)
//	Space Complexity:O(N+M)
	public static double Merge1(int []arr1,int []arr2) {
		int n=arr1.length;
		int m=arr2.length;
		int a=n+m;
		double arr[]=new double[a];
		int i=0,j=0,k=0;
		while(i<n && j<m) {
			if(arr1[i]<=arr2[j]) {
				arr[k]=arr1[i];
				i++;
				k++;
			}
			else {
				arr[k]=arr2[j];
				j++;
				k++;
			}
		}
		while(i<n) {
			arr[k]=arr1[i];
			i++;
			k++;
		}
		while(j<m) {
			arr[k]=arr2[j];
			j++;
			k++;
		}
		if(a%2!=0) {
			return arr[a/2];
		}
		else {
			return (arr[a/2]+arr[a/2-1])/2;
		}
	}
	
//	Process2
//	Special Case 
//	Time Complexity:O(logN)
//	Space Complexity:O(log(Max(N,M)))
	 public static double getMedian(int[] arr1, int[] arr2, int n) {
	        int i = 0;
	        int j = 0;

	        int count = 0;
	        int m1 = -1;
	        int m2 = -1;

	        while (count < n + 1) {
	            count++;
	            if (i == n) {
	                m1 = m2;
	                m2 = arr2[0];
	                break;
	            } else if (j == n) {
	                m1 = m2;
	                m2 = arr1[0];
	                break;
	            }
	            if (arr1[i] < arr2[j]) {
	                m1 = m2;
	                m2 = arr1[i];
	                i++;
	            } else {
	                m1 = m2;
	                m2 = arr2[j];
	                j++;
	            }
	        }
	        return (m1 + m2) / 2.0;
	    }
	
//	 Process3
//	 Time Complexity:O(log(N+M))
//	 Space Complexity:O(logN)
	 public static int findKele(int nums1[],int []nums2,int k) {
		 int m = nums1.length;
	        int n = nums2.length;
	        int index1 = 0;
	        int index2 = 0;
	        while (true) {
	            if (index1 == m) {
	                return nums2[index2 + k - 1];
	            }
	            if (index2 == n) {
	                return nums1[index1 + k - 1];
	            }
	            if (k == 1) {
	                return Math.min(nums1[index1], nums2[index2]);
	            }
	            int newIndex1 = Math.min(index1 + k / 2 - 1, m - 1);
	            int newIndex2 = Math.min(index2 + k / 2 - 1, n - 1);
	            if (nums1[newIndex1] <= nums2[newIndex2]) {
	                k -= (newIndex1 - index1 + 1);
	                index1 = newIndex1 + 1;
	            } else {
	                k -= (newIndex2 - index2 + 1);
	                index2 = newIndex2 + 1;
	            }
	        }
	 }
	 public static double Merge2(int []arr1,int []arr2) {
		 int n=arr1.length+arr2.length;
		 if(n%2==0) {
			 return (findKele(arr1,arr2,n/2)+findKele(arr1,arr2,n/2+1))/2.0;
		 }
		 else {
			 return findKele(arr1,arr2,n/2+1);
		 }
	 }
//	Process4
//	 Time Complexity:O(log(N+M))
//	 Space Complexity:O(logN)
	 
	 public static double Merge3(int[] nums1, int[] nums2) {
	        if(nums2.length<nums1.length){
	            return Merge3(nums2,nums1);
	        }
	        int m=nums1.length;
	        int n=nums2.length;
	        int start=0;
	        int end=m;
	        while(start<=end){
	            int part1=(start+end)/2;
	            int part2=(m+n+1)/2-part1;
	            
	            int maxleftnums1=part1==0?Integer.MIN_VALUE:nums1[part1-1];
	            int maxleftnums2=part2==0?Integer.MIN_VALUE:nums2[part2-1];
	            int minrightnums1=part1==m?Integer.MAX_VALUE:nums1[part1];
	            int minrightnums2=part2==n?Integer.MAX_VALUE:nums2[part2];
	            
	            if(maxleftnums1<=minrightnums2 && maxleftnums2<=minrightnums1){
	                if((m+n)%2==0){
	                    return (Math.max(maxleftnums1,maxleftnums2)+Math.min(minrightnums1,minrightnums2))/2.0;
	                }
	                else{
	                    return Math.max(maxleftnums1,maxleftnums2);
	                }
	                
	            }
	            else if(maxleftnums1>minrightnums2){
	                end=part1-1;
	            }
	            else{
	                start=part1+1;
	            }

	        }
	        throw new IllegalArgumentException();
	       
	    }
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int arr1[]=new int[n];
		for(int i=0;i<n;i++) {
			arr1[i]=s.nextInt();
		}
		int m=s.nextInt();
		int arr2[]=new int[m];
		for(int i=0;i<m;i++) {
			arr2[i]=s.nextInt();
		}
		
//		Process1
		System.out.println("Process1:");
		System.out.println(Merge1(arr1,arr2));
		
//		Process2
//		Special case
		System.out.println("Process2:");
		System.out.println("Special Case:");
		 int[] a1 = {1, 12, 15, 26, 38};
		 int[] a2 = {2, 13, 17, 30, 45};
	     int n1 = a1.length;
	     if (a1.length != a2.length) {
	         System.out.println("Median is not possible");
	     } 
	     else {
	         System.out.println(getMedian(a1, a2, n1 ));
	     }
	     
//	     Process3
	     System.out.println("Process3:");
	     System.out.println(Merge2(arr1,arr2));
	     System.out.println();
//	     Process4
	     System.out.println("process4:");
	     System.out.println(Merge3(arr1,arr2));
	        
	}
}
