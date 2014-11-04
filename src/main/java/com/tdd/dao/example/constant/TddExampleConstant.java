package com.tdd.dao.example.constant;

public enum TddExampleConstant {
	// database queries
	GET_ALL_BOOK_DATA("getAllBookData"),
	GET_AUTHOR_ALL_BOOK("getAuthorAllBook"),
	GET_PARTICULAR_BOOK("getparticularBook"),
	INSERT_BOOK_DATA("insertBookData"),
	
	;

    private TddExampleConstant(final String value) {
        this.value = value;
    }

    private String value;

    /**
     * Gets the value.
     *
     * @return the value
     */
    public String getValue() {
        return this.value;
    }

}
