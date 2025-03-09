package app.assignments.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import app.assignments.message.CustomMessage;
import org.junit.Before;
import org.junit.Test;

public class CustomMessageTest {

    private CustomMessage message;

    @Before
    public void setUp() {
        message = new CustomMessage();
        message.setSender("Alice");
        message.setRecipient("Bob");
        message.setText("Hello, Bob!");
    }

    @Test
    public void testMessageProperties() {
        assertNotNull(message);
        assertEquals("Alice", message.getSender());
        assertEquals("Bob", message.getRecipient());
        assertEquals("Hello, Bob!", message.getText());
    }
}
