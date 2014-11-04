package com.tdd.dao.example.dao.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;

import com.tdd.dao.example.constant.TddExampleConstant;
import com.tdd.dao.example.context.TddExampleAppContext;
import com.tdd.dao.example.dao.TddDaoExample;
import com.tdd.dao.example.dao.rowMapper.BookRowMapper;
import com.tdd.dao.example.model.Book;
import com.tdd.dao.example.model.test.util.DummyConcreteResultSet;
import com.tdd.dao.example.model.test.util.ResultSetData;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(locations = { "classpath:test-csv-data.xml" })
public class BookDaoTest {
	private TddDaoExample tddDaoExample;

	private DummyConcreteResultSet resultSet;

	@Mock
	private Connection connection;

	@Mock
	private DataSource datasource;

	@Mock
	private PreparedStatement preparedStatement;

	@Mock
	private NamedParameterJdbcTemplate jdbcTemplateMock;

	@Before
	public void setUp() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException,
			SecurityException, SQLException {
		tddDaoExample = new TddDaoExample();
		tddDaoExample.setDataSource(datasource);
		tddDaoExample.setQueryProps((Properties) TddExampleAppContext.getBean("queryProps"));
		Assert.assertNotNull(tddDaoExample);

		Mockito.when(connection.prepareStatement(Mockito.anyString())).thenReturn(preparedStatement);
		Mockito.when(datasource.getConnection()).thenReturn(connection);
	}

	@Test
	public void getUniverseDataTestForNam() throws UnexpectedInputException, ParseException, Exception {
		LinkedList<LinkedHashMap<String, String>> resultSetData = ResultSetData.getTestBookResultSet();
		resultSet = new DummyConcreteResultSet("BookData", resultSetData);
		Mockito.when(preparedStatement.executeQuery()).thenReturn(resultSet);

		Map<String, Object> param = new HashMap<String, Object>();

		String sqlQuery = tddDaoExample.getQueryProps().getProperty(TddExampleConstant.GET_ALL_BOOK_DATA.getValue());
		List<Book> data = tddDaoExample.getResults(sqlQuery, new BookRowMapper(), param);

		Assert.assertNotNull(data);
		Assert.assertTrue(data.size() > 0);
	}

}
