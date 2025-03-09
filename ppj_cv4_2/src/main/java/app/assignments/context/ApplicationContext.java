package app.assignments.context;

import app.assignments.writer.Writer;

public interface ApplicationContext {
    <T> T getBean(String beanName, Class<T> requiredType);

   // Message getBean(String customMessage, Class<CustomMessage> customMessageClass);
}