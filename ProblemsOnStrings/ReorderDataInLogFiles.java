package ProblemsOnStrings;


import java.util.*;
public class ReorderDataInLogFiles {
	public static void Print(String[] str) {
		for(String s:str) {
			System.out.println(s);
		}
	}
//	Process1
//	Time Complexity:O(NlogN)
//	Space Complexity:O(N)
	public static String[] ReorderLog1(String[] logs) {
//		We start by creating two ArrayLists to store the digit logs (digitLogs) and letter logs (letterLogs).
		List<String> digitLogs = new ArrayList<>();
        List<String> letterLogs = new ArrayList<>();
        
//        We iterate through each log in the input array logs.
        for (String log : logs) {
//        	For each log, we split it into two parts: identifier and content.
           String[] words = log.split(" ", 2); // Split log into identifier and content
//           If the content of the log starts with a digit, we add it to the digitLogs list;
//           otherwise, we add it to the letterLogs list. 
            if (Character.isDigit(words[1].charAt(0))) {
                digitLogs.add(log);
            } else {
                letterLogs.add(log);
            }
        }
//        We sort the letterLogs list using a custom comparator. 
//        The comparator first compares the content of the logs (excluding the identifier) using compareTo. 
//        If the content is the same, it compares the identifiers.
        Collections.sort(letterLogs, new Comparator<String>() {
            @Override
            public int compare(String log1, String log2) {
                String[] split1 = log1.split(" ", 2);
                String[] split2 = log2.split(" ", 2);
                int cmp = split1[1].compareTo(split2[1]);
                if (cmp != 0) return cmp;
                return split1[0].compareTo(split2[0]);
            }
        });
        
//        Finally, we append the digitLogs list to the end of the letterLogs list and return the merged list.
        letterLogs.addAll(digitLogs);
//        return letterLogs;
        return letterLogs.toArray(new String[0]);
	}
	
//	Process2
//	Time Complexity:O(NlogN)
//	Space Complexity:O(N)
	public static String[] ReorderLog2(String[] logs) {
//		Create two lists: one for storing letter-logs (letterLogs) and another for storing digit-logs (digitLogs).
		 	List<String> letterLogs = new ArrayList<>();
	        List<String> digitLogs = new ArrayList<>();
//	        Iterate through the input array logs.
	        for (String log : logs) {
//	        	For each log, determine if it is a letter-log or a digit-log based on the character after the identifier.
//	        	Add the log to the appropriate list.
	            if (Character.isDigit(log.charAt(log.indexOf(" ") + 1))) {
	                digitLogs.add(log);
	            } else {
	                letterLogs.add(log);
	            }
	        }
//	        Sort the letterLogs list using a custom comparator. 
//	        The comparator should first compare the contents of the logs (excluding the identifier).
//	        If the contents are the same, then it should compare the identifiers lexicographically.
	        
	        Collections.sort(letterLogs, new Comparator<String>() {
	            @Override
	            public int compare(String log1, String log2) {
	                String content1 = log1.substring(log1.indexOf(" ") + 1);
	                String content2 = log2.substring(log2.indexOf(" ") + 1);
	                int cmp = content1.compareTo(content2);
	                if (cmp != 0) return cmp;
	                return log1.compareTo(log2);
	            }
	        });
//	        Combine the sorted letterLogs list with the digitLogs list and return the result.
	        letterLogs.addAll(digitLogs);
	        
	        return letterLogs.toArray(new String[0]);
	}
	public static void main(String[] args) {
		String str[]= {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
		Print(str);
		System.out.println();
//		Process1
		System.out.println("Process1");
		String ans1[]=ReorderLog1(str);
		Print(ans1);
		System.out.println();
//		Process2
		System.out.println("Process2");
		String ans2[]=ReorderLog2(str);
		Print(ans2);
		
	}
}
