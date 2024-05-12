package ProblemsOnStrings;

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;


public class FindFirstNonRepeatingCharacterInAStream {
//	Process1
//	Time Complexity:O(N)
//	Space Complexity:O(c) c=constant
	public static char FirstNonRepStream1(String str) {
		Map<Character,Integer> charCount=new LinkedHashMap<>();
		for(char c:str.toCharArray()) {
			charCount.put(c, charCount.getOrDefault(c, 0)+1);
		}
		for(Map.Entry<Character,Integer> entry:charCount.entrySet()) {
			if(entry.getValue()==1) {
				return entry.getKey();
			}
		}
		return '\0';
	}
//	Process2
//	Time Complexity:O(N)
//	Space Complexity:O(1)
	 public static char firstNonRepeatingCharacter(String stream) {
	        Map<Character, Integer> charCount = new LinkedHashMap<>();
	        Queue<Character> queue = new LinkedList<>();

	        for (char c : stream.toCharArray()) {
	            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
	            queue.offer(c);

	            while (!queue.isEmpty() && charCount.get(queue.peek()) > 1) {
	                queue.poll();
	            }
	        }

	        return queue.isEmpty() ? ' ' : queue.peek();
	    }
//	 Process3
	 public static String findFirstNonRepeating(String A) {
	        StringBuilder result = new StringBuilder();
	        Map<Character, Integer> charCount = new HashMap<>();
	        Queue<Character> queue = new LinkedList<>();

	        for (char c : A.toCharArray()) {
	            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
	            queue.offer(c);

	            while (!queue.isEmpty() && charCount.get(queue.peek()) > 1) {
	                queue.poll();
	            }

	            if (!queue.isEmpty()) {
	                result.append(queue.peek());
	            } else {
	                result.append("#");
	            }
	        }

	        return result.toString();
	    }
	 
	 
	 
//	 Process4
	 public static void nonRepeatingStream(String stream) {
	        Queue<Character> DLL = new LinkedList<>();
	        boolean[] checked = new boolean[256];

	        for (int i = 0; i < stream.length(); i++) {
	            char x = stream.charAt(i);
	            System.out.println("Reading " + x + " from stream");

	            if (!checked[x]) {
	                if (!DLL.contains(x) || DLL.isEmpty()) {
	                    DLL.add(x);
	                } else {
	                    DLL.remove(x);
	                    checked[x] = true;
	                }
	            }

	            if (!DLL.isEmpty()) {
	                System.out.println("First non-repeating character so far is " + DLL.peek());
	            }
	        }
	    }

	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String str=s.next();
//		Process1
		System.out.println("Process1");
		System.out.println(FirstNonRepStream1(str));
		System.out.println();
//		Process2
		System.out.println("Process2");
		System.out.println(firstNonRepeatingCharacter(str));
		System.out.println();
//		Process3
		System.out.println("process3");
		System.out.println(findFirstNonRepeating(str));
		System.out.println();
//		Process4
		System.out.println("Process4");
		nonRepeatingStream(str);
	}
}
