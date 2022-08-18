package ua.ithillel.lesson6.homework;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        findSymbolOccurance("Hello, World", 'l');
        System.out.println(reverseString("Hello"));
        System.out.println(findWordPosition("Apollo","pollo"));
        System.out.println(isPalindrome("tenet"));
        wordGame();


    }
    //Задача 2.
    public static void findSymbolOccurance (String str1, char ch1) {
        System.out.println(str1.chars().filter(findSymbol -> findSymbol == ch1).count());
    }

    //Задача 3.
    public static int findWordPosition(String source, String target) {

        if (source.contains(target)) {
            return source.indexOf(target);
        } else {
            return -1;
        }
    }

    //Задача 4
    public static String reverseString(String str1) {
        String result = "";
        for (int i = 0; i < str1.length(); i++) {
            result = str1.charAt(i) + result;
        }
        return result;
    }

    //Задача 5
    public static boolean isPalindrome(String str1){
        String revertStr = new StringBuilder(str1).reverse().toString();
        return str1.equals(revertStr);
    }

    //Задача 6
    public static String wordGame() {
        Scanner scanner = new Scanner(System.in);
        String[] words = {
                "apple", "orange", "lemon", "banana", "apricot",
                "avocado", "broccoli", "carrot", "cherry", "garlic",
                "grape", "melon", "leak", "kiwi", "mango", "mushroom",
                "nut", "olive", "pea", "peanut", "pear", "pepper",
                "pineapple", "pumpkin", "potato"};
        String selectedWord = words[(int) Math.floor(Math.random() * words.length)];
        String str1;
        StringBuilder charPosition;
        do {
            System.out.println("Try to guess the word");
            str1 = scanner.nextLine().toLowerCase();
            if (Objects.equals(str1, selectedWord)) {
                System.out.println("Congratulation!");

            } else {
                charPosition = new StringBuilder("###############");
                int length;
                if (selectedWord.length() < str1.length()) {
                    length = selectedWord.length();
                } else {
                    length = str1.length();
                }
                for (int i = 0; i < length; i++) {
                    if (str1.charAt(i) == selectedWord.charAt(i)) {
                        charPosition.setCharAt(i, str1.charAt(i));
                    }
                }
                System.out.println("Wrong! Guessed the following letters:");
                System.out.println(charPosition);
                System.out.println("Try again!");
            }
        } while (!Objects.equals(str1, selectedWord));
        return selectedWord;
    }

}
