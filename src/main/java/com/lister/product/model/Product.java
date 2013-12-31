package com.lister.product.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;


import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Analyzer;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;


@Entity
@Table(name="products")
@Indexed
public class Product implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2531201081411600271L;


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
    @DocumentId(name="id")
    private Integer id;

	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.YES)
	@Column(name="NAME")
    private String name;

	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.YES)
    @Column(name="DESCRIPTION")
    private String description;

    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.YES)
    @Column(name="CATEGORY")
    private String category;

    @Column(name="PRICE")
    private String price;
    
    @Column(name="UOM")
    private String uom;
    
    @Column(name="CURRENCY")
    private String currency;
    
    //@OneToMany(fetch = FetchType.LAZY)
    //private List<ProductVariant> productvariants; // one-to-many


    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
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

	/*public List<ProductVariant> getProductvariants() {
		return productvariants;
	}

	public void setProductvariants(List<ProductVariant> productvariants) {
		this.productvariants = productvariants;
	}*/
}