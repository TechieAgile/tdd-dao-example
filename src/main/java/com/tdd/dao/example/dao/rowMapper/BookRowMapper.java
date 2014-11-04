package com.tdd.dao.example.dao.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.tdd.dao.example.model.Book;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

public class BookRowMapper implements ParameterizedRowMapper<Book> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet,
	 * int)
	 */
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		String name = rs.getString("name");
		String isbin = rs.getString("isbin");
		Double price = rs.getDouble("price");
		String author = rs.getString("author");

		Book book = new Book(name, isbin, price, author);

		return book;
	}

}
