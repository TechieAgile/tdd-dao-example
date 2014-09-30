package com.tdd.dao.example.dao;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.tdd.dao.example.exception.ApplicationException;

public class TddDaoExample extends NamedParameterJdbcDaoSupport implements ITddDaoExample {

    private Properties queryProps;

    /**
     * Gets the query props.
     *
     * @return the query props
     */
    protected Properties getQueryProps() {
        return queryProps;
    }

    /**
     * Sets the query props.
     *
     * @param queryProps the query props
     */
    public void setQueryProps(Properties queryProps) {
        this.queryProps = queryProps;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.gmi.stars.dao.IGmiStarsCommonDao#getResults(java.lang.String)
     */
    public SqlRowSet getResults(String sqlQuery) throws ApplicationException {
        try {
            return this.getJdbcTemplate().queryForRowSet(sqlQuery);
        } catch (DataAccessException exception) {
            throw new ApplicationException(exception);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.gmi.stars.dao.IStarsCommonDao#getResults(java.lang.String, org.springframework.jdbc.core.RowMapper)
     */
    public <T> List<T> getResults(String sqlQuery, RowMapper<T> rowMapper, MapSqlParameterSource parameters)
            throws ApplicationException {
        try {
            return this.getJdbcTemplate().query(sqlQuery, rowMapper, parameters);
        } catch (DataAccessException exception) {
            throw new ApplicationException(exception);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.gmi.stars.dao.IStarsCommonDao#getResults(java.lang.String, org.springframework.jdbc.core.RowMapper,
     * java.util.Map)
     */
    public <T> List<T> getResults(String sqlQuery, RowMapper<T> rowMapper, Map<String, Object> map)
            throws ApplicationException {
        try {
            return this.getNamedParameterJdbcTemplate().query(sqlQuery, map, rowMapper);
        } catch (DataAccessException exception) {
            throw new ApplicationException(exception);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.gmi.stars.data.dao.IGmiStarsCommonDao#getObject(java.lang.String,
     * org.springframework.jdbc.core.RowMapper, java.util.Map)
     */
    public <T> T getObject(String sqlQuery, RowMapper<T> rowMapper, Map<String, Object> map)
            throws ApplicationException {
        try {
            return this.getNamedParameterJdbcTemplate().queryForObject(sqlQuery, map, rowMapper);
        } catch (DataAccessException exception) {
            throw new ApplicationException(exception);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.gmi.stars.dao.IStarsCommonDao#update(java.lang.String, java.lang.Object[])
     */
    public int update(String sqlQuery, Object[] args) throws ApplicationException {
        try {
            return this.getJdbcTemplate().update(sqlQuery, args);
        } catch (DataAccessException exception) {
            throw new ApplicationException(exception);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.gmi.stars.dao.IStarsCommonDao#update(java.lang.String, java.lang.Object[], int[])
     */
    public int update(String sqlQuery, Object[] args, int[] types) throws ApplicationException {
        try {
            return this.getJdbcTemplate().update(sqlQuery, args, types);
        } catch (DataAccessException exception) {
            throw new ApplicationException(exception);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.gmi.stars.dao.IStarsCommonDao#update(java.lang.String)
     */
    public int update(String sqlQuery) throws ApplicationException {
        try {
            return this.getJdbcTemplate().update(sqlQuery);
        } catch (DataAccessException exception) {
            throw new ApplicationException(exception);
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.gmi.stars.dao.IStarsCommonDao#batchUpdate(java.lang.String,
     * org.springframework.jdbc.core.BatchPreparedStatementSetter)
     */
    public int[] batchUpdate(String sqlQuery, BatchPreparedStatementSetter pss) throws ApplicationException {
        try {
            return this.getJdbcTemplate().batchUpdate(sqlQuery, pss);
        } catch (DataAccessException exception) {
            throw new ApplicationException(exception);
        }

    }
}
