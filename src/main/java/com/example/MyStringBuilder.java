package com.example;

import java.util.Stack;

public class MyStringBuilder {

    private StringBuilder stringBuilder;

    private Stack<Memento> history;


    public MyStringBuilder() {
        this.stringBuilder = new StringBuilder();
        this.history = new Stack<>();
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }

    private class Memento {

        private String state;

        public Memento(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
        }
    }

    private void saveState() {
        history.push(new Memento(stringBuilder.toString()));
    }

    public MyStringBuilder append(String str) {
        saveState();
        stringBuilder.append(str);
        return this;
    }

    public MyStringBuilder delete(int start, int end) {
        saveState();
        stringBuilder.delete(start, end);
        return this;
    }

    public MyStringBuilder insert(int pos, String str) {
        saveState();
        stringBuilder.insert(pos, str);
        return this;
    }

    public MyStringBuilder replace(int start, int end, String str) {
        saveState();
        stringBuilder.replace(start, end, str);
        return this;
    }

    public MyStringBuilder undo() {
        if (!history.isEmpty()) {
            Memento memento = history.pop();
            stringBuilder = new StringBuilder(memento.getState());
        }
        return this;
    }
}
