package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryManagement {
    private Dictionary dictionary = new Dictionary();


    public void insertFromCommandline() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng từ vựng: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Word> words = new ArrayList<Word>();
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập từ tiếng Anh: ");
            String word_target = scanner.nextLine();
            System.out.print("Nhập nghĩa tiếng Việt: ");
            String word_explain = scanner.nextLine();
            words.add(new Word(word_target, word_explain));
        }

        dictionary.setWords(words);
    }
}

