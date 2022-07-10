package com.tgt.rysetti.learningresourcesapi.entity;

import java.util.Date;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "learningresources")
public class LearningResource implements Serializable {
    @Id
    @Column(name = "learning_resource_id")
    private Integer id;

    @Column(name = "learning_resource_name")
    private String name;

    @Column(name = "cost_price")
    private Double costPrice;

    @Column(name = "selling_price")
    private Double sellingPrice;

    @Column(name = "learning_resource_status")
    @Enumerated(EnumType.STRING)
    private LearningResourceStatus productStatus;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "published_date")
    private Date publishedDate;

    @Column(name = "retired_date")
    private Date retiredDate;
	
	//Constructors
	
	public LearningResource(Integer id, String name, Double costPrice, Double sellingPrice,
			LearningResourceStatus productStatus, Date createdDate, Date publishedDate, Date retiredDate) {
		super();
		this.id = id;
		this.name = name;
		this.costPrice = costPrice;
		this.sellingPrice = sellingPrice;
		this.productStatus = productStatus;
		this.createdDate = createdDate;
		this.publishedDate = publishedDate;
		this.retiredDate = retiredDate;
	}
	
	public LearningResource()
	{
	}

	
	//Getters and Setters 
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(Double costPrice) {
		this.costPrice = costPrice;
	}

	public Double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(Double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public LearningResourceStatus getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(LearningResourceStatus productStatus) {
		this.productStatus = productStatus;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	public Date getRetiredDate() {
		return retiredDate;
	}

	public void setRetiredDate(Date retiredDate) {
		this.retiredDate = retiredDate;
	}
	
	
	
	@Override
	public String toString() {
		return "LearningResource [id=" + id + ", name=" + name + ", costPrice=" + costPrice + ", sellingPrice="
				+ sellingPrice + ", productStatus=" + productStatus + ", createdDate=" + createdDate
				+ ", publishedDate=" + publishedDate + ", retiredDate=" + retiredDate + "]";
	}
	
}
