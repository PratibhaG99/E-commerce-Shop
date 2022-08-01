package com.shop.helper;

public class UserFoundException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public UserFoundException() {
		super("User With This Username Already Exists!!");
	}

	
	public UserFoundException(String msg) {super(msg);}
}
