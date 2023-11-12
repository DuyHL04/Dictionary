package org.example;

public class Word implements Comparable<Word> {
    private String target;
    private String explain;

    public Word() {

    }

    public Word(String target, String explain) {
        this.target = target;
        this.explain = explain;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    @Override
    public int compareTo(Word o) {
        return this.target.compareToIgnoreCase(o.target);
    }
}