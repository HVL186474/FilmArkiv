package no.hvl.data102.filmarkiv.klient;

import java.util.Scanner;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class Tekstgrensesnitt {
	private Scanner scanner;

	public Tekstgrensesnitt() {
		scanner = new Scanner(System.in);
	}

	// Leser inn opplysninger om en film fra tastatur og returnere et Film-objekt
	public Film lesFilm() {
		System.out.println("Skriv inn filmer: ");
		int filmnr = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Skriv inn produsent: ");
		String produsent = scanner.nextLine();

		System.out.println("Skriv inn tittel: ");
		String tittel = scanner.nextLine();

		System.out.println("Skriv årstall: ");
		int aarstall = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Skriv inn filmselskap: ");
		String filmselskap = scanner.nextLine();

		System.out.println("Skriv inn sjanger: ");
		String sjangerNavn = scanner.nextLine();
		Sjanger sjanger = Sjanger.finnSjanger(sjangerNavn);

		return new Film(filmnr, produsent, tittel, aarstall, filmselskap, sjanger);
	}

	// Skriver ut en film med alle opplysninger på skjerm (husk tekst for sjanger)
	public void skrivUtFilm(Film film) {
		System.out.println("Filmnummer:" + film.getFilmnr());
		System.out.println("Filmprodusent: " + film.getProdusent());
		System.out.println("Tittel: " + film.getTittel());
		System.out.println("Lanseringsår: " + film.getArstall());
		System.out.println("Filmselskap: " + film.getFilmselskap());
		System.out.println("Sjanger: " + film.getSjanger());

	}

	// Skriver ut alle filmer med en spesiell delstreng i tittelen
	public void skrivUtFilmDelstrengITittel(FilmarkivADT arkiv, String delstreng) {

		System.out.println("Her er alle filmene som har '" + delstreng + "' i tittelen:");

		Film[] filmer = arkiv.soekTittel(delstreng);

		if (filmer == null || filmer.length == 0) {
			System.out.println("Ingen filmer var funnet i arkivet med: '" + delstreng + "' i tittelen.");
			return;
		}

		for (Film film : filmer) {
			System.out.println(film.getTittel() + " - Produsent: " + film.getProdusent());
		}
	}

	// Skriver ut alle Filmer av en produsent (produsent er delstreng)
	public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {

		System.out.println("Her er alle filmene som '" + delstreng + "' har laget:");

		Film[] filmer = arkiv.soekProdusent(delstreng);

		if (filmer == null || filmer.length == 0) {
			System.out.println("Ingen filmer var funnet i arkivet for produsenten: '" + delstreng + "'.");
			return;
		}

		for (Film film : filmer) {
			System.out.println(film.getTittel() + " - Produsent: " + film.getProdusent());
		}
	}

	// Skriver ut en enkel statistikk som inneholder antall filmer totalt
	// og hvor mange det er i hver sjanger.
	public void skrivUtStatistikk(FilmarkivADT arkiv) {
		int totaltAntallFilmer = arkiv.antall();

		int shrek = arkiv.antall(Sjanger.SHREK);
		int action = arkiv.antall(Sjanger.ACTION);
		int drama = arkiv.antall(Sjanger.DRAMA);
		int romanse = arkiv.antall(Sjanger.ROMANSE);

		System.out.println("Totalt antall filmer: " + totaltAntallFilmer);
		System.out.println("Action: " + shrek);
		System.out.println("Drama: " + action);
		System.out.println("Komedie: " + drama);
		System.out.println("Sci-Fi: " + romanse);
	}

	// osv ... andre metoder
}
