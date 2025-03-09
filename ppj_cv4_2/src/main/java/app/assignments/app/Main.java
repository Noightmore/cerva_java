package app.assignments.app;

import app.assignments.context.AnnotationConfigApplicationContext;
import app.assignments.context.ApplicationContext;
import app.assignments.message.CustomMessage;
import app.assignments.message.Message;
import app.assignments.writer.StdoutWriter;
import app.assignments.writer.Writer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import javax.annotation.PostConstruct;
import java.util.logging.Logger;

@Configuration
@ComponentScan("app.assignments")
public class Main {

    //@Inject
    //Logger LOG;

    private static final Logger LOG = Logger.getLogger(Main.class.getName());


    @Bean
    @Scope("singleton") // Default Scope (Only one instance)
    public CustomMessage customMessage() {
        CustomMessage message = new CustomMessage();
        message.setSender("Alice");
        message.setRecipient("Bob");
        message.setText("Hello, Bob!");
        return message;
    }

    @Bean
    @Scope("prototype") // Prototype Scope (New instance each time)
    public CustomMessage pingMessage() {
        CustomMessage message = new CustomMessage();
        message.setSender("Ping");
        message.setRecipient("Pong");
        message.setText("Ping message content!");
        return message;
    }

    @Bean
    @Scope("singleton") // Singleton Scope (Only one instance)
    public CustomMessage replyMessage() {
        CustomMessage message = new CustomMessage();
        message.setSender("Pong");
        message.setRecipient("Ping");
        message.setText("Replying to Ping");
        return message;
    }

    @Bean
    @Scope("prototype") // Prototype Scope (New instance each time)
    public CustomMessage replyToAliceMessage() {
        CustomMessage message = new CustomMessage();
        message.setSender("Bob");
        message.setRecipient("Alice");
        message.setText("Hi Alice, I received your message!");
        return message;
    }

    @Bean
    public Writer writer() {
        return new StdoutWriter();
    }

    @PostConstruct
    public void init() {
        System.out.println("✅ PostConstruct executed in " + this.getClass().getSimpleName());
    }




    public static void main(String[] args) {
        // Initialize the custom application context
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        // Retrieve the Writer bean
        Writer writer = context.getBean("writer", Writer.class);

        // Retrieve and use the beans
        writer.write(context.getBean("customMessage", CustomMessage.class));
        writer.write(context.getBean("pingMessage", CustomMessage.class));
        writer.write(context.getBean("replyMessage",  CustomMessage.class));
        writer.write(context.getBean("replyToAliceMessage", CustomMessage.class));
    }
}
