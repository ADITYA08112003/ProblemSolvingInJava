package ProblemOfArrays;

import java.util.*;
public class TheKWeakestRowsInAMatrix {
	public static void PrintMatrix(int [][]matrix) {
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void Print(int arr[]) {
		for(int i : arr) {
			System.out.print(i+" ");
		}
	}
//	Process1
//	Time Complexity:O(M*N)
//	Space Complexity:O(M)
	public static int[] kWeakestRows1(int[][] mat, int k) {
        int n=mat.length;
        int m=mat[0].length;
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            int c=0;
            for(int j=0;j<m;j++){
                if(mat[i][j]==1){
                    c++;
                }
            }
            arr[i]=c;
        }
        int a[]=arr.clone();
        Arrays.sort(a);
        int q=0;
        int ans[]=new int[k];
        for(int i=0;i<k;i++){
            for(int j=0;j<n;j++){
                if(a[i]==arr[j]){
                    ans[q]=j;
                    arr[j]=-1;
                    q++;
                    break;
                }
                if(q==k){
                    return ans;
                }
            }
        }
        return ans;
    }
	
//	Process2
//	Time Complexity:O(M*N)
//	Space Complexity:O(M)
	public static int[] kWeakestRows2(int[][] mat, int k) {
        int m = mat.length;
       int n = mat[0].length;

       int[][] counts = new int[m][2];

       for (int i = 0; i < m; i++) {
           int count = 0;
           for (int j = 0; j < n; j++) {
               count += mat[i][j];
           }
           counts[i] = new int[]{count, i};
       }

       Arrays.sort(counts, (a, b) -> Integer.compare(a[0], b[0]));

       int[] result = new int[k];
       for (int i = 0; i < k; i++) {
           result[i] = counts[i][1];
       }

       return result;
   }
//	Process3
//	Time Complexity:O(M*logN)
//	Space Complexity:O(M)
	 private static int binarySearch(int[] row) {
	        int low = 0;
	        int high = row.length;
	        while (low < high) {
	            int mid = (low + high) / 2;
	            if (row[mid] == 1) {
	                low = mid + 1;
	            } else {
	                high = mid;
	            }
	        }
	        return low;
	    }
	    public static int[] kWeakestRows3(int[][] mat, int k) {
	        List<int[]> counts = new ArrayList<>();
	        for (int i = 0; i < mat.length; i++) {
	            int[] row = mat[i];
	            counts.add(new int[]{binarySearch(row), i});
	        }
	        counts.sort((a, b) -> Integer.compare(a[0], b[0]));
	        int[] result = new int[k];
	        for (int i = 0; i < k; i++) {
	            result[i] = counts.get(i)[1];
	        }
	        return result;
	    }
//		Process4
//		Time Complexity:O(M*logNK)
//		Space Complexity:O(K)
	    private static int binarySearch1(int[] row) {
	        int low = 0;
	        int high = row.length;
	        while (low < high) {
	            int mid = (low + high) / 2;
	            if (row[mid] == 1) {
	                low = mid + 1;
	            } else {
	                high = mid;
	            }
	        }
	        return low;
	    }
	    public static int[] kWeakestRows4(int[][] mat, int k) {
	        PriorityQueue<int[]> pq = new PriorityQueue<>(k, new Comparator<int[]>() {
	            @Override
	            public int compare(int[] a, int[] b) {
	                if (a[0] == b[0]) {
	                    return a[1] - b[1];
	                }
	                return a[0] - b[0];
	            }
	        });

	        for (int i = 0; i < mat.length; i++) {
	            int strength = binarySearch1(mat[i]);
	            pq.offer(new int[]{strength, i});
	        }

	        int[] result = new int[k];
	        for (int i = 0; i < k; i++) {
	            result[i] = pq.poll()[1];
	        }

	        return result;
	    }
	public static void main(String[] args) {
		int matrix[][]= {{1,1,0,0,0},
		                 {1,1,1,1,0},
		                 {1,0,0,0,0},
		                 {1,1,0,0,0},
		                 {1,1,1,1,1}};
		int k=3;
		PrintMatrix(matrix);
//		Process1
		System.out.println("Process1:");
		int ans1[]=kWeakestRows1(matrix,k);
		Print(ans1);
		System.out.println();
//		Process2
		System.out.println("Process2:");
		int ans2[]=kWeakestRows2(matrix, k);
		Print(ans2);
		System.out.println();
//		Process3
		System.out.println("Process3:");
		int ans3[]=kWeakestRows3(matrix, k);
		Print(ans3);
		System.out.println();
//		Process4
		System.out.println("process4:");
		int ans4[]=kWeakestRows4(matrix, k);
		Print(ans4);
	}
}
