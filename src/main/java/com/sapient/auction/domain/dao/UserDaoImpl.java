package com.sapient.auction.domain.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Repository;

import com.sapient.auction.domain.model.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl implements UserDao {


	@Override
	public void create(User user) {
		String createUserQuery = "insert into users (username,password,fname,lname,emailid,mobile,address,created_date_time) values (?,?,?,?,?,?,?,?);";

		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		Date date = new Date();
		String dateObj = sdf.format(date);

		jdbcTemplate.update(createUserQuery,
				new Object[] { user.getUserName(), user.getPassword(), user.getFname(), user.getLname(),
						user.getEmialId(), user.getMobile(), user.getAddress(), dateObj });

		System.out.println("created");
	}
}
