package com.lister.product.enums;


/**
 * The Product type of the product
 * 
 * @author dineshkumar_s
 *
 */
public enum ProductType {
	NEW("NEW", "New Product"), RESALE("RESALE", "Resale second hand product");

	private String code;

	private String description;

	private ProductType(String code, String description) {
		this.code = code;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}
}
