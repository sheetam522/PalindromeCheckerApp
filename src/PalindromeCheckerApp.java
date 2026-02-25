import java.util.Stack;
import java.util.Scanner;

public class PalindromeCheckerApp {

    // Two Pointer Method
    public static boolean twoPointerCheck(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Stack Method
    public static boolean stackCheck(String str) {
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            stack.push(ch);
        }

        for (char ch : str.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    // Recursive Method
    public static boolean recursiveCheck(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return recursiveCheck(str, start + 1, end - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string to check palindrome:");
        String input = sc.nextLine().toLowerCase();

        // Two Pointer Timing
        long start1 = System.nanoTime();
        boolean result1 = twoPointerCheck(input);
        long end1 = System.nanoTime();

        // Stack Timing
        long start2 = System.nanoTime();
        boolean result2 = stackCheck(input);
        long end2 = System.nanoTime();

        // Recursive Timing
        long start3 = System.nanoTime();
        boolean result3 = recursiveCheck(input, 0, input.length() - 1);
        long end3 = System.nanoTime();

        System.out.println("\nResults:");
        System.out.println("Two Pointer: " + result1 + " | Time: " + (end1 - start1) + " ns");
        System.out.println("Stack: " + result2 + " | Time: " + (end2 - start2) + " ns");
        System.out.println("Recursive: " + result3 + " | Time: " + (end3 - start3) + " ns");

        sc.close();
    }
}