/* Copyright (C) 2016 Sapient. All Rights Reserved. */
package com.sapient.auction.domain.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.auction.domain.dao.UserDao;
import com.sapient.auction.domain.model.User;

/**
 * @author avish9
 * JDBC DAO implementation for {@link User}.
 */
@Repository
@Transactional
public class UserDaoImpl extends BaseDaoImpl implements UserDao {
	
	private static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class);
	
	/**
	 * Adds a user record in the system.
     *
     * @param user The person POJO to persist.
	 */
	@Override
	public void create(User user) {
		String createUserQuery = "insert into users (username,password,fname,lname,address,created_date_time) values (?,?,?,?,?,?);";

		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		Date date = new Date();
		String dateObj = sdf.format(date);

		jdbcTemplate.update(createUserQuery,
				new Object[] { user.getUserName(), user.getPassword(), user.getFirstName(), user.getLastName(),
						 user.getAddress(), dateObj });
		LOGGER.debug("user created");
	}

	/**
	 * return the user of given id.
	 */
	@Override
	public User getUser(Integer userid) {
		String query = "select * from users where userid=?";
		RowMapper<User> rm = new UserRowMapper();
		return jdbcTemplate.queryForObject(query, rm, userid);
	}
	
	/**
	 * return the user details of given user name.
	 */
	@Override
	public User getUserByUserName(String username) {
		String query = "select * from users where username=?";
		RowMapper<User> rm = new UserRowMapper();
		return jdbcTemplate.queryForObject(query, rm, username);
	}
	
	/**
	 * {@link RowMapper} implementation that creates a {@link User} for each row.
	 */
	class UserRowMapper implements RowMapper<User> {

		@Override
		public User mapRow(ResultSet rs, int arg1) throws SQLException {
			User user = new User();
			user.setFirstName(rs.getString("fname"));
			user.setLastName(rs.getString("lname"));
			user.setUserName(rs.getString("username"));
			user.setUserId(rs.getInt("userid"));
			user.setAddress(rs.getString("address"));
			return user;
		}
	}
	
	
	@Override
	public boolean isUserExist(String username) {
		String query = "select count(username) from users where username=?";
		Integer cnt = jdbcTemplate.queryForObject(query, Integer.class, username);
		return cnt != null && cnt > 0 ;
	}
}
