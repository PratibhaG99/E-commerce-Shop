package com.shop.helper;

public class AlreadyInCart extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AlreadyInCart() {
		super("Product AlreadyIn Cart!!");
	}

	
	public AlreadyInCart(String msg) {super(msg);}

}
