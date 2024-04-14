package ProblemOfSearchingAndSorting;

import java.util.Random;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KthSmallestLargestElementInUnsortedArrays {
//	Process1
//	Time Complexity:O(NlogN)
//	Space Complexity:O(1)
	public static int Smallest1(int arr[],int k) {
		Arrays.sort(arr);
		return arr[k-1];
	}
	public static int Largest1(int arr[],int k) {
		return arr[arr.length-k];
	}
	
//	Process2
//	Time Complexity:O(KlogN)
//	Space Complexity:O(1)
	public static int Smallest2(int arr[],int k) {
		// Create a min heap (priority queue)
		PriorityQueue<Integer> minHeap=new PriorityQueue<>();
		// Add all elements of the array to the min heap
		for(int i : arr) {
			minHeap.offer(i);
		}
		// Extract the k-1 smallest elements from the min heap
		for(int i=0;i<k-1;i++) {
			minHeap.poll();
		}
		// The kth smallest element will be at the top of the min heap
		return minHeap.peek();
	}
	
//	Time Complexity:O(KlogN)
//	Space Complexity:O(1)
	public static int Largest2(int arr[],int k) {
		// Create a min heap (priority queue)
		PriorityQueue<Integer> minHeap=new PriorityQueue<>();
		// Add all elements of the array to the min heap
		for(int i : arr) {
			minHeap.offer(i);
		}
		// Extract the k-1 smallest elements from the min heap
		for(int i=0;i<arr.length-k;i++) {
			minHeap.poll();
		}
		// The kth smallest element will be at the top of the min heap
		return minHeap.peek();		
	}
	
//	Time Complexity:O(NlogK)
//	Space Complexity:O(1)
	public static int Largest2_1(int nums[],int k) {
		 // Create a min heap (priority queue) of size k
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add the first k elements to the min heap
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }

        // For the remaining elements, if the element is greater than the root of the heap (smallest element),
        // remove the root and add the new element to maintain a heap of size k
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }

        // The kth largest element will be the root of the heap
        return minHeap.peek();
	}
	
//	Process3
	public  static int findKthLargest(int[] nums, int k) {
        return select(nums, 0, nums.length - 1, nums.length - k);
    }
    
    private  static int partition(int[] nums, int left, int right, int pivotIndex) {
        int pivot = nums[pivotIndex];
        // Move pivot to end
        swap(nums, pivotIndex, right);
        
        int storeIndex = left;
        for (int i = left; i < right; i++) {
            if (nums[i] < pivot) {
                swap(nums, storeIndex, i);
                storeIndex++;
            }
        }
        // Move pivot to its final place
        swap(nums, right, storeIndex);
        
        return storeIndex;
    }
    
    private  static int select(int[] nums, int left, int right, int kSmallest) {
        if (left == right) {
            return nums[left];
        }
        
        // Select a random pivot index
        int pivotIndex = left + new Random().nextInt(right - left);
        
        // Find the pivot position in a sorted list
        pivotIndex = partition(nums, left, right, pivotIndex);
        
        // The pivot is in its final sorted position
        if (kSmallest == pivotIndex) {
            return nums[kSmallest];
        } else if (kSmallest < pivotIndex) {
            // Go left
            return select(nums, left, pivotIndex - 1, kSmallest);
        } else {
            // Go right
            return select(nums, pivotIndex + 1, right, kSmallest);
        }
    }
    
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=s.nextInt();
		}
		int arr1[]=arr.clone();
		int arr2[]=arr.clone();
		System.out.println("Enter  the Kth element:");
		int k=s.nextInt();
//		Process1
		System.out.println("Process1:");
		System.out.println("Smallest Kth Element:");
		System.out.println(Smallest1(arr,k));
		System.out.println("Largest Kth Element:");
		System.out.println(Largest1(arr,k));
		System.out.println();
//		Process2
		System.out.println("Process2:");
		System.out.println("Smallest Kth Element:");
		System.out.println(Smallest2(arr1,k));
		System.out.println("Largest Kth Element:");
		System.out.println(Largest2(arr1,k));
		System.out.println("Largest Kth Element By 2nd:");
		System.out.println(Largest2_1(arr1, k));
		System.out.println();
//		Process3
		System.out.println("Process3:");
		System.out.println("Largest Kth Element:");
		System.out.println(findKthLargest(arr2,k));
	}
}
