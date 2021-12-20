package com.tm.rd.util;

import java.util.List;
import com.tm.rd.exception.InvalidIdException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

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
					case "Id":
						throw new InvalidIdException();
					default:
						break;
				}
			});
		}
	}

}
