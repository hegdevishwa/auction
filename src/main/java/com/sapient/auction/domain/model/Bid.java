package com.sapient.auction.domain.model;

import java.util.Date;

public class Bid {
	
	private int bidId;
	private Item itemId;
	private User userId;
	private double bidPrice;
	private Date createDate;
	private String createdBy;
	private Date updateDate;
	private String updatedBy;
	
	public int getBidId() {
		return bidId;
	}
	public void setBidId(int bidId) {
		this.bidId = bidId;
	}
	public Item getItemId() {
		return itemId;
	}
	public void setItemId(Item itemId) {
		this.itemId = itemId;
	}
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	public double getBidPrice() {
		return bidPrice;
	}
	public void setBidPrice(double bidPrice) {
		this.bidPrice = bidPrice;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bidId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bid other = (Bid) obj;
		if (bidId != other.bidId)
			return false;
		return true;
	}
}
