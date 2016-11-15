package com.sapient.auction.domain.model;

import java.util.Date;

public class Bid {

	private int bidId;
	private Item itemId;
	private User userId;
	private double bidPrice;
	private Date createdDate;

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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createDate) {
		this.createdDate = createDate;
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

	@Override
	public String toString() {
		return "Bid [bidId=" + bidId + ", itemId=" + itemId + ", userId=" + userId + ", bidPrice=" + bidPrice
				+ ", createdDate=" + createdDate + "]";
	}

}
