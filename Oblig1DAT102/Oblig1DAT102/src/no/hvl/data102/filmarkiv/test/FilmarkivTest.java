package no.hvl.data102.filmarkiv.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.*;

class FilmarkivTest {
	private FilmarkivADT filmarkiv;

	@BeforeEach
	void setUp() {
		filmarkiv = new Filmarkiv(10); // Oppretter et nytt filmarkiv med plass til 10 filmer¨
		filmarkiv.leggTilFilm(new Film(1, "Inception", "Christopher Nolan", 2010, "Warner Bros", Sjanger.ACTION));
		filmarkiv.leggTilFilm(new Film(2, "Interstellar", "Christopher Nolan", 2014, "Paramount", Sjanger.DRAMA));
		filmarkiv.leggTilFilm(new Film(3, "The Dark Knight", "Christopher Nolan", 2008, "Warner Bros", Sjanger.ACTION));
		filmarkiv.leggTilFilm(new Film(4, "Finding Nemo", "Andrew Stanton", 2003, "Pixar", Sjanger.ACTION));
	}

	@Test
	void testFinnFilm() {
		assertNotNull(filmarkiv.finnFilm(1));
	}

	@Test
	void testLeggTilFilm() {
		Film film5 = new Film(5, "bashar", "fast", 2004, "bfe", Sjanger.DRAMA);
		filmarkiv.leggTilFilm(film5);
		assertEquals(5, filmarkiv.antall());
		assertEquals(film5, filmarkiv.finnFilm(5));
	}

	@Test
	void testSlettFilm() {
		assertNotNull(filmarkiv.finnFilm(2)); // for å sjekke om filmen eksistera
		assertTrue(filmarkiv.slettFilm(2)); // slette filmen
		assertNull(filmarkiv.finnFilm(2)); // sjekke om filmen he blitt sletta og retunera null evt.

	}

	@Test
	void testsoekTittel() {
		Film[] result = filmarkiv.soekTittel("Inception");
		assertEquals(0, result.length);

		Film[] result1 = filmarkiv.soekTittel("Titanic");
		assertEquals(0, result1.length);
	}

	@Test
	void testsoekProdusent() {
		Film[] produsent = filmarkiv.soekProdusent("Pixar");
		assertEquals(0, produsent.length);

		Film[] produsent1 = filmarkiv.soekProdusent("bashar");
		assertEquals(0, produsent1.length);

	}

	@Test
	void testAntall() {
		assertEquals(4, filmarkiv.antall());

	}

	@Test
	void tetstAntallSjanger() {
		assertEquals(0, filmarkiv.antall(Sjanger.ACTION));

	}

}
