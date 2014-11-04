package com.tdd.dao.example.model.test.util;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.file.FlatFileItemReader;

import com.tdd.dao.example.context.TddExampleAppContext;
import com.tdd.dao.example.model.Book;

public class ResultSetData {
	private static final String BOOK = "bookDataList";

	public static List<Book> getTestBookData() throws UnexpectedInputException, ParseException, Exception {
		List<Book> bookData = new LinkedList<Book>();

		@SuppressWarnings("unchecked")
		FlatFileItemReader<Book> csvReader = (FlatFileItemReader<Book>) TddExampleAppContext.getBean(BOOK);

		csvReader.open(new ExecutionContext());
		Book data = null;
		while ((data = csvReader.read()) != null) {
			bookData.add(new Book(data.getName(), data.getIsbin(), data.getPrice(), data.getAuthor()));
		}

		return bookData;
	}

	public static LinkedList<LinkedHashMap<String, String>> getTestBookResultSet() throws UnexpectedInputException,
			ParseException, Exception {
		LinkedList<LinkedHashMap<String, String>> resultSetData = new LinkedList<LinkedHashMap<String, String>>();

		@SuppressWarnings("unchecked")
		FlatFileItemReader<Book> csvReader = (FlatFileItemReader<Book>) TddExampleAppContext.getBean(BOOK);

		csvReader.open(new ExecutionContext());
		Book data = null;
		LinkedHashMap<String, String> temp;
		while ((data = csvReader.read()) != null) {
			temp = new LinkedHashMap<String, String>();
			temp.put("name".toUpperCase(), data.getName());
			temp.put("isbin".toUpperCase(), data.getIsbin());
			temp.put("price".toUpperCase(), Double.toString(data.getPrice()));
			temp.put("author".toUpperCase(), data.getAuthor());

			resultSetData.add(temp);
		}

		return resultSetData;
	}
}
