package tm.api.util;

import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import tm.api.exception.InvalidIdException;
import tm.api.exception.InvalidTaskIdException;


/**
 * Validation class
 * 
 *
 */
public final class ValidatorUtil {

	private ValidatorUtil() {
		// Default constructor.
	}

	/**
	 * Binding the field to occur error
	 * 
	 * @param result
	 */
	public static void validateRequest(BindingResult result) {
		if (result.hasErrors()) {
			List<FieldError> errors = result.getFieldErrors();
			errors.forEach(error -> {
				String fieldName = error.getField();
				switch (fieldName) {
					case "id":
						throw new InvalidIdException();
					case "taskId":
						throw new InvalidTaskIdException();
					default:
						break;
				}
			});
		}
	}

}
