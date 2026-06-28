import java.util.*;

public class TextAnalysisTool {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 1. User Input
        System.out.println("Enter a paragraph or text:");
        String input = scanner.nextLine();

        // Input validation
        if (input == null || input.trim().isEmpty()) {
            System.out.println("Invalid input. Please enter non-empty text.");
            return;
        }

        // Normalize text
        String lowerInput = input.toLowerCase();

        // 2. Character Count
        int charCount = input.length();

        // 3. Word Count
        String[] words = input.trim().split("\\s+");
        int wordCount = words.length;

        // 4. Most Common Character
        Map<Character, Integer> charMap = new HashMap<>();

        for (char c : lowerInput.toCharArray()) {
            if (c != ' ') {
                charMap.put(c, charMap.getOrDefault(c, 0) + 1);
            }
        }

        char mostCommonChar = ' ';
        int maxCount = 0;

        for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostCommonChar = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        // 5. Character Frequency
        System.out.print("Enter a character to check frequency: ");
        char userChar = scanner.next().toLowerCase().charAt(0);

        int charFrequency = charMap.getOrDefault(userChar, 0);

        // Consume leftover newline
        scanner.nextLine();

        // 6. Word Frequency
        System.out.print("Enter a word to check frequency: ");
        String userWord = scanner.nextLine().toLowerCase();

        int wordFrequency = 0;
        for (String w : words) {
            if (w.equalsIgnoreCase(userWord)) {
                wordFrequency++;
            }
        }

        // 7. Unique Words
        Set<String> uniqueWords = new HashSet<>();
        for (String w : words) {
            uniqueWords.add(w.toLowerCase());
        }

        int uniqueWordCount = uniqueWords.size();

        // OUTPUT
        System.out.println("\nText Analysis Results");
        System.out.println("Character Count: " + charCount);
        System.out.println("Word Count: " + wordCount);
        System.out.println("Most Common Character: '" + mostCommonChar + "' (" + maxCount + " times)");
        System.out.println("Frequency of character '" + userChar + "': " + charFrequency);
        System.out.println("Frequency of word \"" + userWord + "\": " + wordFrequency);
        System.out.println("Unique Words Count: " + uniqueWordCount);

        scanner.close();
    }
}