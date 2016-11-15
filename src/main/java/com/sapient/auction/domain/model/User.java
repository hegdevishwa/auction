package com.sapient.auction.domain.model;

import java.util.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class User {

	private int userId;

	@NotEmpty(message = "Please enter name")
	private String fname;
	private String lname;

	@NotEmpty(message = "Please enter valid email address")
	@Email
	private String emialId;

	@NotEmpty(message = "Please enter user name")
	private String userName;

	@NotEmpty(message = "Please enter your password.")
	@Size(min = 6, max = 15, message = "Your password must between 6 and 15 characters")
	private String password;

	@NotEmpty(message = "Please enter mobile number")
	@Pattern(regexp = "(^$|[0-9]{10})")
	private String mobile;

	@NotEmpty(message = "Please enter address")
	private String address;

	private Date createDate;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmialId() {
		return emialId;
	}

	public void setEmialId(String emialId) {
		this.emialId = emialId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emialId == null) ? 0 : emialId.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		result = prime * result + userId;
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
		User other = (User) obj;
		if (emialId == null) {
			if (other.emialId != null)
				return false;
		} else if (!emialId.equals(other.emialId))
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", fname=" + fname + ", lname=" + lname + ", emialId=" + emialId
				+ ", userName=" + userName + ", password=" + password + ", mobile=" + mobile + ", address=" + address
				+ ", createDate=" + createDate + "]";
	}
}
