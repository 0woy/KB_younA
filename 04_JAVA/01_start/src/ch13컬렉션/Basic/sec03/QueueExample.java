package ch13컬렉션.Basic.sec03;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        Queue<Message> que = new LinkedList<>();
        Command [] commands = new Command[]{
                new sendMail(),
                new sendSMS(),
                new sendKakaotalk()
        };
        que.add(new Message("sendMail", "홍길동"));
        que.add(new Message("sendSMS", "신용권"));
        que.add(new Message("sendKakaotalk", "김자바"));

        while (!que.isEmpty()) {
            Message msg = que.poll();
            int idx =0;
            switch (msg.command){
                case "sendMail": idx=0; break;
                case "sendSMS": idx=1; break;
                case "sendKakaotalk": idx=2; break;
            }
            commands[idx].execute(msg.to);
        }
    }
}
