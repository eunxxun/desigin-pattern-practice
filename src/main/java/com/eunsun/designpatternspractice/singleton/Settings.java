package com.eunsun.designpatternspractice.singleton;

public class Settings {
    private static volatile Settings instance;
//    private static final Settings INSTANCE = new Settings();
    private Settings() {}

    private static class SettingsHolder {
        private static final Settings INSTANCE = new Settings();
    }

    public static Settings getInstance() {
        return new Settings();
    }

//    public static synchronized Settings getInstance2() { //동시에 여러스레드가 들어올 수 없게 synchronized를 선언한다. (동기화 작업으로 성능이 떨어질 수 있음)
//        if (instance == null) {
//            instance = new Settings();
//        }
//        return instance;
//    }

//    public static Settings getInstance2() {
//        return INSTANCE;
//    }

//    public static Settings getInstance2() {
//        if (instance == null) {
//            synchronized (Settings.class) { //Settings.class를 락으로 쓰게끔 해준다.
//                if (instance == null) {
//                    instance = new Settings();
//                }
//            }
//        }
//        return  instance;
//    }

    public static Settings getInstance2() {
        return SettingsHolder.INSTANCE;
    }

}
