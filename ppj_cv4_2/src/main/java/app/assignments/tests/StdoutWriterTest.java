package app.assignments.tests;

import app.assignments.message.CustomMessage;
import app.assignments.message.Message;
import app.assignments.writer.StdoutWriter;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

public class StdoutWriterTest {

    private StdoutWriter writer;
    private ByteArrayOutputStream outputStreamCaptor;

    @Before
    public void setUp() {
        writer = new StdoutWriter();  // Create writer instance
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));  // Redirect console output
    }

    @Test
    public void testPostConstructExecuted() {
        writer.init();  // Manually call PostConstruct method

        String output = outputStreamCaptor.toString();
        assertTrue("PostConstruct should be executed", output.contains("PostConstruct executed in StdoutWriter"));
    }

    @Test
    public void testWriterWritesMessage() {
        Message message = new CustomMessage("UnitTest", "TestReceiver", "Hello from test!");
        writer.write(message);

        String output = outputStreamCaptor.toString();
        assertTrue("Writer should print message text", output.contains("Hello from test!"));
    }
}
