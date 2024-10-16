package com.example;

public class Main {
    public static void main(String[] args) {

        MyStringBuilder mySb = new MyStringBuilder();

        mySb.append("ля ля ля");
        mySb.append(" пу пу пу");
        mySb.insert(2, " пу");
        mySb.replace(0, 2, "пу");
        mySb.delete(0, 3);

        System.out.println(mySb);

        mySb.undo();
        System.out.println(mySb);

        mySb.undo();
        System.out.println(mySb);

        mySb.undo();
        System.out.println(mySb);

    }
}