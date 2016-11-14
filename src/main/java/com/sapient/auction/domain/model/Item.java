package com.sapient.auction.domain.model;

import java.util.Date;

public class Item {

	private int itemId;
	private String name;
	private String category;
	private String description;
	private double baseBidPrice;
	private Date createDateTime;
	private String createdBy;
	private Date updateDateTime;
	private String updatedBy;

	/**
	 * @return the itemId
	 */
	public int getItemId() {
		return itemId;
	}

	/**
	 * @param itemId
	 *            the itemId to set
	 */
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the baseBidPrice
	 */
	public double getBaseBidPrice() {
		return baseBidPrice;
	}

	/**
	 * @param baseBidPrice
	 *            the baseBidPrice to set
	 */
	public void setBaseBidPrice(double baseBidPrice) {
		this.baseBidPrice = baseBidPrice;
	}

	/**
	 * @return the createDate
	 */
	public Date getCreateDateTime() {
		return createDateTime;
	}

	/**
	 * @param createDate
	 *            the createDate to set
	 */
	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy
	 *            the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the updateDate
	 */
	public Date getUpdateDateTime() {
		return updateDateTime;
	}

	/**
	 * @param updateDate
	 *            the updateDate to set
	 */
	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	/**
	 * @return the updatedBy
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @param updatedBy
	 *            the updatedBy to set
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", name=" + name + ", category=" + category + ", description=" + description
				+ ", baseBidPrice=" + baseBidPrice + ", createDate=" + createDateTime + ", createdBy=" + createdBy
				+ ", updateDate=" + updateDateTime + ", updatedBy=" + updatedBy + "]";
	}

}
