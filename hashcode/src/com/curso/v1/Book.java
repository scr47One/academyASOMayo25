package com.curso.v1;

import java.util.Objects;

public class Book  {

	private int ISBN;
	private String author, title;
	private int pageCount;
	
	public Book(int ISBN, String author, String title) {
		this.ISBN = ISBN;
		this.author = author;
		this.title = title;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Book)) {
			return false;
		}
		Book other = (Book)obj;
		return this.ISBN == other.ISBN;
	}

	@Override
	public String toString() {
		return "Book [ISBN=" + ISBN + ", author=" + author + ", title=" + title + "]";
	}
	
}
