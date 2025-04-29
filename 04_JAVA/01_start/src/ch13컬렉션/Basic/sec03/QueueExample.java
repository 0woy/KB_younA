package ch13컬렉션.Basic.sec03;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        Queue<Message> que = new LinkedList<>();
        que.add(new Message("sendMail", "홍길동"));
        que.add(new Message("sendSMS", "신용권"));
        que.add(new Message("sendKakaotalk", "김자바"));

        while (!que.isEmpty()) {
            Message msg = que.poll();
            String command ="";
            switch (msg.command){
                case "sendMail": command="메일"; break;
                case "sendSMS": command="SMS"; break;
                case "sendKakaotalk": command="카카오톡"; break;
            }
            System.out.println(msg.to+"님에게 "+command+"을/를 보냅니다.");
        }
    }
}
