package org.example;

public class Main {
    public static void main(String[] args) {
        DictionaryManagement dictionaryManagement = new DictionaryManagement();
        dictionaryManagement.insertFromCommandline();

        DictionaryCommandline dictionaryCommandline = new DictionaryCommandline();

        dictionaryCommandline.showAllWords();
    }
}

