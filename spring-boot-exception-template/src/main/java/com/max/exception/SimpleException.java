
package com.max.exception;

public class SimpleException extends RuntimeException
{

	/**
	 * serialVersionUID:TODO(describe the field in a word).
	 */

	private static final long serialVersionUID = -131037602927147564L;
	private String errMsg;

	public SimpleException(String errMsg)
	{
		this.errMsg = errMsg;
	}

	public String getErrMsg()
	{

		return errMsg;
	}

}
