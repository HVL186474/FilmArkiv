package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class Meny {
	private Tekstgrensesnitt tekstgr;
	private FilmarkivADT filmarkiv;

	public Meny(FilmarkivADT filmarkiv) {
		tekstgr = new Tekstgrensesnitt();
		this.filmarkiv = filmarkiv;
	}

	public void start() {
		Film film1 = new Film(1, "produsent a ", "Film1", 1945, "filmselskap A", Sjanger.ACTION);
		Film film2 = new Film(2, "produsent b", "Film2", 1969, "filmselskap A", Sjanger.SHREK);
		Film film3 = new Film(3, "produsent c", "Film3", 2001, "filmselskap A", Sjanger.ACTION);
	}
}
