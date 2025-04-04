package ppj.assignments.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import ppj.assignments.writer.Writer;
import ppj.assignments.writer.DevelWriter;
import ppj.assignments.writer.ProdWriter;

@Configuration
public class WriterConfiguration {

    @Bean
    @Profile("devel")
    public Writer develWriter() {
        return new DevelWriter();
    }

    @Bean
    @Profile("!devel")
    public Writer prodWriter() {
        return new ProdWriter();
    }
}
