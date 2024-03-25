package ProblemOfArrays;

public class CountNegativeNumberInASortedMatrix {
//	Process1
//	Time Complexity:O(N*M)
//	Space Complexity:O(1)
	public static int CountNegative(int [][]matrix) {
		int n=matrix.length;
		int m=matrix[0].length;
		int count=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(matrix[i][j]<0) {
					count++;
				}
			}
		}
		return count;
	}
//	Process2
//	Time Complexity:O(N*M)
//	Space Complexity:O(1)
//	All array are sorted in descending order
		public static int CountNegayive1(int[][] matrix) {
		int n=matrix.length;
		int m=matrix[0].length;
		int count=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(matrix[i][j]<0) {
					count+=m-j;
					break;
				}
			}
		}
		return count;
	}
//	Process3
//	Time Complexity:O(N+M)
//	Space Complexity:O(1)
	public static int CountNegayive2(int[][] matrix) {
		int n=matrix.length;
		int m=matrix[0].length;
		int count=0;
		int i=n-1,j=0;
		while(i>=0 && j<m) {
			if(matrix[i][j]<0) {
				count+=m-j;
				i-=1;
			}
			else {
				j++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		int matrix[][]= {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
//		Process1
		System.out.println("Process1:");
		System.out.println(CountNegative(matrix));
		System.out.println();
//		Process2
		System.out.println("Process2:");
		System.out.println(CountNegayive1(matrix));
		System.out.println();
//		Process3
		System.out.println("Process3:");
		System.out.println(CountNegayive2(matrix));
		
	}
}
