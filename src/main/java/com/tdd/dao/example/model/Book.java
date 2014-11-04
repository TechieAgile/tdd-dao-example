package com.tdd.dao.example.model;

import java.io.Serializable;

/**
 * The Class Book.
 */
public final class Book implements Serializable {

	private static final long serialVersionUID = 6405194974534520861L;

	private String name;
	private String isbin;
	private Double price;
	private String author;

	public Book() {
		super();
	}

	public Book(String name, String isbin, Double price, String author) {
		super();
		this.name = name;
		this.isbin = isbin;
		this.price = price;
		this.author = author;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the isbin.
	 *
	 * @return the isbin
	 */
	public String getIsbin() {
		return isbin;
	}

	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * Gets the author.
	 *
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Sets the name.
	 *
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the isbin.
	 *
	 * @param isbin
	 *            the new isbin
	 */
	public void setIsbin(String isbin) {
		this.isbin = isbin;
	}

	/**
	 * Sets the price.
	 *
	 * @param price
	 *            the new price
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * Sets the author.
	 *
	 * @param author
	 *            the new author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", isbin=" + isbin + ", price=" + price + ", author=" + author + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((isbin == null) ? 0 : isbin.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
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
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (isbin == null) {
			if (other.isbin != null)
				return false;
		} else if (!isbin.equals(other.isbin))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}

}
