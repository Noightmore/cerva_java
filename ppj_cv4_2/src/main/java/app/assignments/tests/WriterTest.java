package app.assignments.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import app.assignments.message.CustomMessage;
import app.assignments.writer.StdoutWriter;
import org.junit.Before;
import org.junit.Test;

public class WriterTest {

    private StdoutWriter writer;
    private CustomMessage message;

    @Before
    public void setUp() {
        writer = new StdoutWriter();
        message = new CustomMessage();
        message.setSender("Ping");
        message.setRecipient("Pong");
        message.setText("Ping message content!");
    }

    @Test
    public void testWriterIsNotNull() {
        assertNotNull(writer);
    }

    @Test
    public void testWriterWritesMessage() {
        try {
            writer.write(message);
            assertTrue(true);
        } catch (Exception e) {
            assertTrue("Writer threw an exception", false);
        }
    }
}
