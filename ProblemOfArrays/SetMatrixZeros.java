package ProblemOfArrays;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class SetMatrixZeros {
	
	public static void Print(int[][] matrix) {
		int m=matrix.length;
		int n=matrix[0].length;
		for(int[] num:matrix) {
			for(int i:num) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
	
//	Process1
//	Time Complexity:O(M*N)
//	Space Complexity:O(M+N)
	public static void SetZero(int[][] matrix) {
		int m = matrix.length;
        int n = matrix[0].length;

        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();

        // Identify rows and columns with zeros
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }

        // Set zeros based on identified rows and columns
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rows.contains(i) || columns.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
	}
	
//	Process2
//	Time Complexity:O(M*N)
//	Space Complexity:O(1)
    public static void setZeroes(int[][] matrix) {
    	  boolean rowFlag = false;
          boolean colFlag = false;

          int m = matrix.length;
          int n = matrix[0].length;

          for (int i = 0; i < m; i++) {
              for (int j = 0; j < n; j++) {
                  if (i == 0 && matrix[i][j] == 0) {
                      rowFlag = true;
                  }
                  if (j == 0 && matrix[i][j] == 0) {
                      colFlag = true;
                  }
                  if (matrix[i][j] == 0) {
                      matrix[0][j] = 0;
                      matrix[i][0] = 0;
                  }
              }
          }

          for (int i = 1; i < m; i++) {
              for (int j = 1; j < n; j++) {
                  if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                      matrix[i][j] = 0;
                  }
              }
          }

//          if (rowFlag) {
//              Arrays.fill(matrix[0], 0);
//          }
          if(rowFlag){
              for(int i=0;i<n;i++){
                  matrix[0][i]=0;
              }
          }
          if (colFlag) {
              for (int i = 0; i < m; i++) {
                  matrix[i][0] = 0;
              }
          }
    }
	public static void main(String[] args) {
		int matrix[][]= {{1,1,1},{1,0,1},{1,1,1}};
		Print(matrix);
//		Cpoy a matrix to another matrix1
//		int matrix1[][]=matrix.clone();
//		Process1
		System.out.println("Process1:");
		SetZero(matrix);
		Print(matrix);
		System.out.println();
//		Process2
		System.out.println("Process2:");
		int matrix1[][]= {{1,1,1},{1,0,1},{1,1,1}};
		setZeroes(matrix1);
		Print(matrix1);
		
	}
}
