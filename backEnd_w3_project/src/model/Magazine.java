package model;

import javax.persistence.*;

import enum_.enum_frequency;

@Entity
@DiscriminatorValue(value = "magazine")
public class Magazine extends Archive {

	@Enumerated(EnumType.STRING)
	private enum_frequency frequencyOfPublishing;

	public Magazine() {
		super();
	}

	public Magazine(Long iSBNcode, String titolo, int yearOfPublishing, int numberOfPages,
			enum_frequency frequencyOfPublishing) {
		super(iSBNcode, titolo, yearOfPublishing, numberOfPages);
		this.frequencyOfPublishing = frequencyOfPublishing;
	}

	public Magazine(enum_frequency frequencyOfPublishing, String titolo, int yearOfPublishing, int numberOfPages) {
		super(titolo, yearOfPublishing, numberOfPages);
		this.frequencyOfPublishing = frequencyOfPublishing;
	}

	public String toString() {
		return "\n" + "\nTitle: " + this.getTitolo() + "\nFrequency of publishing: " + this.frequencyOfPublishing
				+ "\nNumber of pages: " + this.getNumberOfPages() + "\nYear of publishing: "
				+ this.getYearOfPublishing() + "\nISBN Code: " + this.getISBNcode();

	}

	public enum_frequency getFrequencyOfPublishing() {
		return frequencyOfPublishing;
	}

	public void setFrequencyOfPublishing(enum_frequency frequencyOfPublishing) {
		this.frequencyOfPublishing = frequencyOfPublishing;
	}

}