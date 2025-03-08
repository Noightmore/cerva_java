package app.assignments.message;

import org.springframework.stereotype.Component;

@Component
public class PingMessage implements Message {
    private String sender = "ping";
    private String recipient = "pong";
    private String text = "Ping has empty body";

    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getText() {
        return text;
    }
}