package org.example;

public class DictionaryCommandline extends Dictionary {
    public static String showAllWords() {
        String s = "";
        System.out.printf("%-6s%c %-15s%c %-20s%n","No", '|' ,"English", '|', "Vietnamese");
        for (int i = 0; i < words.size(); i++) {
            System.out.printf("%-6d%c %-15s%c %-15s%n", i + 1,'|', words.get(i).getTarget(), '|',words.get(i).getExplain());
        }
        return s;
    }

    public static void main(String[] args) {
        DictionaryManagement.insertFromCommandLine();
        DictionaryCommandline.showAllWords();
    }
}
