package com.sapient.auction.domain.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public abstract class BaseDaoImpl implements BaseDao {

	protected JdbcTemplate jdbcTemplate;

	/**
	 * @param dataSource
	 *            the dataSource to set
	 */
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

}
