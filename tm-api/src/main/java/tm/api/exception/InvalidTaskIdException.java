package tm.api.exception;

import tm.api.constants.ErrorEnum;

/**
 * This is InvalidIdException class
 * 
 * @author tong
 */
@ErrorCode(status = 400, code = ErrorEnum.INVALID_TASK_ID)
public class InvalidTaskIdException extends BaseException {

	public InvalidTaskIdException() {
		super(ErrorEnum.INVALID_TASK_ID.getMessage());
	}
}