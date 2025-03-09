package app.assignments.context;

import app.assignments.writer.Writer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class AnnotationConfigApplicationContext implements ApplicationContext {

    private final Map<String, Object> beanMap = new HashMap<>();

    public AnnotationConfigApplicationContext(Class<?> configClass) {
        try {
            // Check if it's a valid configuration class
            if (!configClass.isAnnotationPresent(Configuration.class)) {
                throw new IllegalArgumentException("Given class is not a configuration class!");
            }

            // Loop through methods to initialize beans
            for (Method method : configClass.getDeclaredMethods()) {
                // Check if the method is annotated with @Bean
                if (method.isAnnotationPresent(Bean.class)) {
                    Object bean = method.invoke(configClass.getDeclaredConstructor().newInstance());
                    beanMap.put(method.getName(), bean); // Store bean by method name
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize context", e);
        }
    }

    @Override
    public <T> T getBean(String beanName, Class<T> requiredType) {
        Object bean = beanMap.get(beanName);
        if (bean == null) {
            throw new IllegalArgumentException("No bean found with name: " + beanName);
        }
        if (!requiredType.isInstance(bean)) {
            throw new IllegalArgumentException("Bean with name: " + beanName + " is not of type: " + requiredType.getName());
        }
        return requiredType.cast(bean);
    }

}