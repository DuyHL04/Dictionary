package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DictionaryManagement extends Dictionary {
    public static void insertFromCommandLine() {
        Scanner input = new Scanner(System.in);
        Scanner number = new Scanner(System.in);
        int size = number.nextInt();
        int i = 0;
        while (i < size) {
            String target = input.nextLine();
            String explain = input.nextLine();
            Word word = new Word(target, explain);
            words.add(word);
            i++;
        }
    }
    public static void insertFromFile() {
        try {
            File file = new File("dictionaries.txt");
            InputStream inputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String [] word = line.split("\t");
                Word newWord = new Word(word[0], word[1]);
                words.add(newWord);
            }
            Collections.sort(words);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void dictionaryLookup(String target) {
        Scanner in = new Scanner(System.in);
        target = in.nextLine().toLowerCase();
        int pos = Collections.binarySearch(words, new Word(target, null));
        if (pos >= 0) {
            System.out.println(words.get(pos));
        }
    }

    public static void addWord(String target, String explain) {
        target = target.toLowerCase();
        explain = explain.toLowerCase();
        int pos = Collections.binarySearch(words, new Word(target, explain));
        if (pos >= 0) {
            return;
        }
        words.add(new Word(target, explain));
    }

    public static void removeWord(String target) {
        int pos = Collections.binarySearch(words, new Word(target, null));
        if (pos >= 0) {
            words.remove(words.get(pos));
        }
    }

    public static void editWord(String target, String explain) {
        target = target.toLowerCase();
        explain = explain.toLowerCase();
        int pos = Collections.binarySearch(words, new Word(target, null));
        if (pos >= 0) {
            words.get(pos).setExplain(explain);
        } else {
            System.out.println("Không tìm thấy từ cần sửa.");
        }
    }





    public static void dictionaryExportToFile() {
        try {
            File file = new File("output.txt");
            OutputStream outputStream = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            String line = "%-10s %-10d%n";
            for (Word word : words) {
                bufferedWriter.write(String.format(line, word.getTarget(), word.getExplain()));
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


