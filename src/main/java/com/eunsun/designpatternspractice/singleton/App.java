package com.eunsun.designpatternspractice.singleton;

public class App {
    public static void main(String[] args) {
//        Settings settings = new Settings();
//        Settings settings1 = new Settings();
//        System.out.println(settings != settings1); // true

//        Settings settings = Settings.getInstance();
//        Settings settings1 = Settings.getInstance();
//        System.out.println(settings != settings1); //true

        Settings settings = Settings.getInstance2();
        Settings settings1 = Settings.getInstance2();
        System.out.println(settings == settings1); //true
    }
}
