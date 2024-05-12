package ProblemsOnStrings;

import java.util.*;

public class PrintAllAnagramsInaListOfWords {
//	Process1
//	Time Complexity:O(NMlogM)
//	Space Complexity:O(NM)
//	N=Number of Word
//	M=Maximum Size of Word
	public static List<List<String>> Anagrams1(String[] words){
		 // Create a HashMap to store anagram groups
        Map<String, List<String>> anagramGroups = new HashMap<>();
        
        // Iterate through each word in the input array
        for (String word : words) {
            // Convert the word to a character array and sort it
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            // Convert the sorted character array back to a string
            String sortedWord = new String(charArray);
            
            // Check if the sorted word is already present as a key in the HashMap
            // If not, add a new entry with the sorted word as the key and an empty ArrayList as the value
            anagramGroups.putIfAbsent(sortedWord, new ArrayList<>());
            // Add the original word to the corresponding anagram group
            anagramGroups.get(sortedWord).add(word);
        }
        
        // Create a list to store the final result
        List<List<String>> result = new ArrayList<>();
        // Iterate through each group of anagrams in the HashMap
        for (List<String> group : anagramGroups.values()) {
            // Add the group to the result list
            result.add(group);
        }
        
        // Return the list of anagram groups
        return result;
	}
//	Process2
//	Time Complexity:O(NMlogM)
//	Space Complexity:O(NM)
	public static List<List<String>> Anagrams2(String[] words) {
        
        Map<String, List<String>> groupedWords = new HashMap<>();

        for (String word : words) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);

            if (!groupedWords.containsKey(sortedWord)) {
                groupedWords.put(sortedWord, new ArrayList<>());
            }
            groupedWords.get(sortedWord).add(word);
        }
        
        List<List<String>> result = new ArrayList<>();
        for (List<String> group : groupedWords.values()) {
            result.add(group);
        }
        
        return result;
        
    }
	public static void main(String[] args) {
//		Process1
		System.out.println("Process1");
		String[] words1= {"act","god","cat","dog","tac"};
		List<List<String>> result1=Anagrams1(words1);
		System.out.println(result1);
//		Process2
		System.out.println("Process2");
		String[] words2= {"act","god","cat","dog","tac"};
		List<List<String>> result2=Anagrams1(words2);
		System.out.println(result2);
	}
}
