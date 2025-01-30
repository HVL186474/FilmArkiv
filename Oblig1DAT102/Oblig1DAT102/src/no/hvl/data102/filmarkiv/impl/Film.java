package no.hvl.data102.filmarkiv.impl;

import java.util.Objects;

public class Film {

	private int filmnr;
	private String produsent;
	private String tittel;
	private int arstall;
	private Sjanger sjanger;
	private String filmselskap;

	public Film() {
		filmnr = 0;
		produsent = "";
		tittel = "";
		arstall = 0;
		filmselskap = "";
	}

	public Film(int filmnr, String produsent, String tittel, int arstall, String filmselskap, Sjanger sjanger) {
		this.filmnr = filmnr;
		this.produsent = produsent;
		this.tittel = tittel;
		this.arstall = arstall;
		this.sjanger = sjanger;
		this.filmselskap = filmselskap;

	}

	public int getFilmnr() {
		return filmnr;
	}

	public void setFilmnr(int filmnr) {
		this.filmnr = filmnr;
	}

	public String getProdusent() {
		return produsent;
	}

	public void setProdusent(String produsent) {
		this.produsent = produsent;
	}

	public String getTittel() {
		return tittel;
	}

	public void setTittel(String tittel) {
		this.tittel = tittel;
	}

	public int getArstall() {
		return arstall;
	}

	public void setArstall(int arstall) {
		this.arstall = arstall;
	}

	public String getFilmselskap() {
		return filmselskap;
	}

	public void setFilmselskap(String filmselskap) {
		this.filmselskap = filmselskap;
	}

	public Sjanger getSjanger() {
		return sjanger;
	}

	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}

	@Override
	public int hashCode() {
		return Objects.hash(arstall, filmnr, filmselskap, produsent, tittel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if ((obj == null) || (getClass() != obj.getClass())) {
			return false;
		}
		Film other = (Film) obj;
		return arstall == other.arstall && filmnr == other.filmnr && Objects.equals(filmselskap, other.filmselskap)
				&& Objects.equals(produsent, other.produsent) && Objects.equals(tittel, other.tittel);
	}

}