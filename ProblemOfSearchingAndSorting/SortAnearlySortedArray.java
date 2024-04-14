package ProblemOfSearchingAndSorting;
import java.util.*;

public class SortAnearlySortedArray {
    // Function to check if a list is sorted
    public static boolean isSorted(List<Integer> a) {
        // Create a copy of the list and sort it
        List<Integer> b = new ArrayList<>(a);
        Collections.sort(b);
        // Check if the original list is equal to the sorted list
        return a.equals(b);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        // Input the size of the array
        int n = s.nextInt();
        // Create a list to store the array elements
        List<Integer> arr = new ArrayList<>();
        // Input the array elements
        for (int i = 0; i < n; i++) {
            arr.add(s.nextInt());
        }

        // Variables to store indices of elements to be swapped or reversed
        int i = -1, j = -1;
        // Find the first occurrence where element is greater than the next element
        for (int k = 0; k < n - 1; k++) {
            if (arr.get(k) > arr.get(k + 1)) {
                i = k;
                break;
            }
        }
        // Find the last occurrence where element is smaller than the previous element
        for (int k1 = n - 1; k1 > 0; k1--) {
            if (arr.get(k1) < arr.get(k1 - 1)) {
                j = k1;
                break;
            }
        }

        // Create a temporary list to perform operations
        List<Integer> temp = new ArrayList<>(arr.subList(0, i));
        temp.addAll(new ArrayList<>(arr.subList(i, j + 1)));
        // Reverse the sublist from index i to j
        Collections.reverse(temp.subList(i, j + 1));
        temp.addAll(new ArrayList<>(arr.subList(j + 1, n)));

        // Create a copy of the array to perform swap operation
        List<Integer> temp2 = new ArrayList<>(arr);
        // Swap elements at indices i and j
        Collections.swap(temp2, i, j);

        // Check conditions and print the result
        if (i == -1 && j == -1) {
            System.out.println("yes");
        } else if (isSorted(temp2)) {
            System.out.println("yes");
            System.out.println("swap " + (i + 1) + " " + (j + 1));
        } else if (isSorted(temp)) {
            System.out.println("yes");
            System.out.println("reverse " + (i + 1) + " " + (j + 1));
        } else {
            System.out.println("no");
        }
    }
}
