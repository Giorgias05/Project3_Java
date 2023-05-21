package model;

import javax.persistence.*;


import enum_.enum_genere;

@Entity
@DiscriminatorValue(value="book")
public class Book extends Archive {
	@Column(name="author")
	String author;
	@Enumerated(EnumType.STRING)
	private enum_genere  genere;

	public Book(String author, enum_genere genre,  String titolo, int yearOfPublishing,
			int numberOfPages) {
		super( titolo, yearOfPublishing, numberOfPages);
		this.author = author;
		this.genere = genre;
	}

	public Book() {
		super();
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}


	public enum_genere getGenere() {
		return genere;
	}


	public void setGenere(enum_genere genere) {
		this.genere = genere;
	}


	public String toString() {
		return "\n" + "\nTitle: " + this.getTitolo() + "\nAuthor: " + this.author + "\nGenre: " + this.genere
				+ "\nNumber of pages: " + this.getNumberOfPages() + "\nYear of publishing: " + this.getYearOfPublishing()
				+ "\nISBN Code: " + this.getISBNcode();

	}
}