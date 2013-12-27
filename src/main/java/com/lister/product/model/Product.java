package com.lister.product.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;


@Entity
@Table(name="products")
@Indexed
public class Product {

	
	public static final Product getProduct(Product product) {
		Product newprod = new Product();
		newprod.setCategory(product.getCategory());
		newprod.setCurrency(product.getCurrency());
		newprod.setDescription(product.getDescription());
		newprod.setId(product.getId());
		newprod.setName(product.getName());
		newprod.setPrice(product.getPrice());
		newprod.setUom(product.getUom());
		return newprod;
	}
	
    public Product() {
		
	}

	@Id
    @Column(name="ID")
    @GeneratedValue
    @DocumentId
    private Integer id;

    
	@Column(name="NAME")
    private String name;

	
    @Column(name="DESCRIPTION")
    private String description;

    @Column(name="CATEGORY")
    private String category;

    @Column(name="PRICE")
    private String price;
    
    @Column(name="UOM")
    private String uom;
    
    @Column(name="CURRENCY")
    private String currency;


    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Field(index=Index.YES)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getUom() {
		return uom;
	}
	public void setUom(String uom) {
		this.uom = uom;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    
    @Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description="
				+ description + ", category=" + category + ", price=" + price
				+ ", uom=" + uom + ", currency=" + currency + "]";
	}
}