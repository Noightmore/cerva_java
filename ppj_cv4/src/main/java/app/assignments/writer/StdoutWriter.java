package app.assignments.writer;

import app.assignments.message.Message;
import org.springframework.stereotype.Component;

@Component
public class StdoutWriter implements Writer {

    public void write(Message message) {
        System.out.println("MESSAGE");
        System.out.println("From: " + message.getSender());
        System.out.println("To: " + message.getRecipient());
        System.out.println("\n" + message.getText() + "\n");
    }
}