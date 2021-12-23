package tm.api.exception;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import tm.api.constants.ErrorEnum;

@Target({ TYPE })
@Retention(RUNTIME)
public @interface ErrorCode {

	int status();

	ErrorEnum code();
}