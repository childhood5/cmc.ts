package tm.api.exception;

import tm.api.constants.ErrorEnum;

/**
 * This is InvalidIdException class
 * 
 * @author tong
 */
@ErrorCode(status = 401, code = ErrorEnum.INVALID_ID)
public class InvalidIdException extends BaseException {

	public InvalidIdException() {
		super(ErrorEnum.INVALID_ID.getMessage());
	}
}