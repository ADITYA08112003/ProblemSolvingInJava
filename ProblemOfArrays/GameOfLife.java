package ProblemOfArrays;

public class GameOfLife {
//	Process1
//	Time Complexity:O(N*M)
//	Space Complexity:O(N*M)
	 public static void gameOfLife1(int[][] board) {
	        int rows = board.length;
	        int cols = board[0].length;
	        int[][] copyBoard = new int[rows][cols]; // Create a copy of the board
	        int[][] neighbors = {{1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}};

	        // Copy the original board to the copyBoard
	        for (int row = 0; row < rows; row++) {
	            for (int col = 0; col < cols; col++) {
	                copyBoard[row][col] = board[row][col];
	            }
	        }

	        // Iterate over each cell of the board
	        for (int row = 0; row < rows; row++) {
	            for (int col = 0; col < cols; col++) {
	                int liveNeighbors = 0;
	                // Iterate over the neighbors of the current cell
	                for (int[] neighbor : neighbors) {
	                    int r = row + neighbor[0];
	                    int c = col + neighbor[1];
	                    // Check if the neighbor is within the bounds and alive
	                    if (r < rows && r >= 0 && c < cols && c >= 0 && copyBoard[r][c] == 1) {
	                        liveNeighbors++;
	                    }
	                }
	                // Apply the rules of Conway's Game of Life to update the cell state
	                if (copyBoard[row][col] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
	                    // Any live cell with fewer than two live neighbors dies
	                    // Any live cell with more than three live neighbors dies
	                    board[row][col] = 0;
	                }
	                if (copyBoard[row][col] == 0 && liveNeighbors == 3) {
	                    // Any dead cell with exactly three live neighbors becomes a live cell
	                    board[row][col] = 1;
	                }
	            }
	        }
	    }
	 
//	 Process2
//	 Time Complexity:O(N*M)
//	 Space Complexity:O(1)
	 public static  void gameOfLife2(int[][] board) {
	        int rows = board.length;
	        int cols = board[0].length;
	        int[][] neighbors = {{1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}};

	        for (int row = 0; row < rows; row++) {
	            for (int col = 0; col < cols; col++) {
	                int liveNeighbors = 0;
	                for (int[] neighbor : neighbors) {
	                    int r = row + neighbor[0];
	                    int c = col + neighbor[1];
	                    if (r < rows && r >= 0 && c < cols && c >= 0 && Math.abs(board[r][c]) == 1) {
	                        liveNeighbors++;
	                    }
	                }
	                if (board[row][col] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
	                    board[row][col] = -1;
	                }
	                if (board[row][col] == 0 && liveNeighbors == 3) {
	                    board[row][col] = 2;
	                }
	            }
	        }

	        for (int row = 0; row < rows; row++) {
	            for (int col = 0; col < cols; col++) {
	                if (board[row][col] > 0) {
	                    board[row][col] = 1;
	                } else {
	                    board[row][col] = 0;
	                }
	            }
	        }
	    }
	 public static void Print(int board[][]) {
		 for (int[] row : board) {
	            for (int cell : row) {
	                System.out.print(cell + " ");
	            }
	            System.out.println();
	        }
	 }
	 public static void main(String[] args) {
		 int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
		 Print(board);
//		 Process1
		 System.out.println("Process1:");
		 gameOfLife1(board);
		 Print(board);
		 System.out.println();
		 System.out.println();
		 
		 int[][] board1 = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
//		 Process2
		 System.out.println("Process2:");
		 gameOfLife2(board1);
		 Print(board1);
		 
		 
		 
	}
}
