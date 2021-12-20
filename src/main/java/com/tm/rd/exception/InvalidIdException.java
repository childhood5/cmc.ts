package com.tm.rd.exception;
import com.tm.rd.constants.ErrorEnum;

/**
 * This is InvalidIdException class
 * 
 * @author tong
 */
@ErrorCode(status = 400, code = ErrorEnum.INVALID_ID)
public class InvalidIdException extends BaseException {

	public InvalidIdException() {
		super(ErrorEnum.INVALID_ID.getMessage());
	}
}