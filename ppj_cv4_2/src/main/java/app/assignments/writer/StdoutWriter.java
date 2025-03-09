package app.assignments.writer;

import app.assignments.message.Message;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;


public class StdoutWriter implements Writer {

    @PostConstruct
    public void init() {
        System.out.println("PostConstruct executed in " + this.getClass().getSimpleName());
    }


    public void write(Message message) {
        System.out.println("MESSAGE");
        System.out.println("From: " + message.getSender());
        System.out.println("To: " + message.getRecipient());
        System.out.println("\n" + message.getText() + "\n");
    }
}