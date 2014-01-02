package com.lister.product.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.Transient;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

import com.lister.product.enums.ProductType;

@Entity
@Table(name="product_variant")
public class ProductVariant implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//@Field(index = Index.YES, analyze = Analyze.YES, store = Store.YES)
	@Column(name="VARIANT_TYPE")
	private ProductType type;
	
	//@Field(index = Index.YES, analyze = Analyze.YES, store = Store.YES)
	@Column(name="VARIANT_SIZE")
	private String size;
	
	//@Field(index = Index.YES, analyze = Analyze.YES, store = Store.YES)
	@Column(name="VARIANT_COLOR")
	private String color;
	
	@ManyToOne(targetEntity=Product.class)
	@JoinColumn(name = "ID", nullable = false)
	private Product product;
	
	@Id
	//@Field(index = Index.YES, analyze = Analyze.YES, store = Store.YES)
	@Column(name="VARIANTID")
	@GeneratedValue
    @DocumentId(name="id")
	private Integer variantID;
	
	@Transient
	private Integer prodId;

	public ProductType getType() {
		return type;
	}

	public void setType(ProductType type) {
		this.type = type;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	@Override
	public String toString() {
		return "ProductVariant [type=" + type + ", size=" + size + ", color="
				+ color + ", product=" + product + "]";
	}

	public Integer getVariantID() {
		return variantID;
	}

	public void setVariantID(Integer variantID) {
		this.variantID = variantID;
	}

	public static ProductVariant getProductVariant(ProductVariant product) {
		ProductVariant prodvar = new ProductVariant();
		prodvar.setColor(product.getColor());
		prodvar.setProduct(product.getProduct());
		prodvar.setSize(product.getSize());
		prodvar.setType(product.getType());
		prodvar.setVariantID(product.getVariantID());
		
		return prodvar;
	}

	public Integer getProdId() {
		return prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}
}
