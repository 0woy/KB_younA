package ch11멀티스레드.Advanced;

public class Main {
    public static void main(String[] args) {
        Thread mt = new MovieThread();
        Thread ms = new Thread(new MusicRunnable());
        mt.start();
        ms.start();
    }
}
