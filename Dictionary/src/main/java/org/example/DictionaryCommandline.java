package org.example;

import java.util.Collections;
import java.util.Comparator;

public class DictionaryCommandline {
    private Dictionary dictionary;

    public DictionaryCommandline() {
        this.dictionary = new Dictionary();
    }

    public void showAllWords() {
        Collections.sort(dictionary.getWords(), new Comparator<Word>() {
            @Override
            public int compare(Word word1, Word word2) {
                return word1.getWordTarget().compareTo(word2.getWordTarget());
            }
        });

        System.out.println("No | English | Vietnamese");
        int i = 1;
        for (Word word : dictionary.getWords()) {
            System.out.printf("%d | %-20s | %s\n", i, word.getWordTarget(), word.getWordExplain());
            i++;
        }
    }
}


