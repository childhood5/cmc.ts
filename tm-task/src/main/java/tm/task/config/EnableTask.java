package tm.task.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Import({ServiceConfig.class})
public @interface EnableTask {
}
