package com.sapient.auction.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class Item {

	private int itemId;
	private String name;
	private String category;
	private String description;
	private double baseBidPrice;
	private LocalDateTime createDateTime;
	private int userId;
	private LocalDateTime expiryDate;
	private MultipartFile file;
	private byte[] imageByteArray;

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
	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}

	/**
	 * @param createDate
	 *            the createDate to set
	 */
	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}

	/**
	 * @return the createdBy
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param createdBy
	 *            the createdBy to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the file
	 */
	public MultipartFile getFile() {
		return file;
	}

	/**
	 * @param file
	 *            the file to set
	 */
	public void setFile(MultipartFile file) {
		this.file = file;
	}

	/**
	 * @return the imageByteArray
	 */
	public byte[] getImageByteArray() {
		return imageByteArray;
	}

	/**
	 * @param imageByteArray
	 *            the imageByteArray to set
	 */
	public void setImageByteArray(byte[] imageByteArray) {
		this.imageByteArray = imageByteArray;
	}

	/**
	 * @return the expiryDate
	 */
	public LocalDateTime getExpiryDate() {
		return expiryDate;
	}

	/**
	 * @param expiryDate
	 *            the expiryDate to set
	 */
	public void setExpiryDate(LocalDateTime expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", name=" + name + ", category=" + category + ", description=" + description
				+ ", baseBidPrice=" + baseBidPrice + ", createDate=" + createDateTime + ", userId=" + userId
				+ ", updateDate=" + "]";
	}

}
