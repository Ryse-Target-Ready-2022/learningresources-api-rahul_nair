package com.tgt.rysetti.learningresourcesapi.entity;

import java.util.Date;

public class LearningResource {

	private Integer id;
	private String name;
	private Double costPrice;
	private Double sellingPrice;
	private LearningResourceStatus productStatus;
	private Date createdDate;
	private Date publishedDate;
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
