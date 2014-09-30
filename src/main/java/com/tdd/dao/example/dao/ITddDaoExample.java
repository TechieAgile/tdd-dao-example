package com.tdd.dao.example.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.tdd.dao.example.exception.ApplicationException;

public interface ITddDaoExample {
	SqlRowSet getResults(String sqlQuery) throws ApplicationException;

	<T> T getObject(String sqlQuery, RowMapper<T> rowMapper,
			Map<String, Object> map) throws ApplicationException;

	<T> List<T> getResults(String sqlQuery, RowMapper<T> rowMapper,
			MapSqlParameterSource parameters) throws ApplicationException;

	<T> List<T> getResults(String sqlQuery, RowMapper<T> rowMapper,
			Map<String, Object> map) throws ApplicationException;

	int update(String sqlQuery, Object[] args) throws ApplicationException;

	int update(String sqlQuery, Object[] args, int[] types)
			throws ApplicationException;

	int update(String sqlQuery) throws ApplicationException;

	int[] batchUpdate(String sqlQuery,
			BatchPreparedStatementSetter batchPreparedStatementSetter)
			throws ApplicationException;
}
