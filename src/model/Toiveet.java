package model;

import java.util.ArrayList;

/**
 * Wishlist levyille.
 * @author Johannes
 * @since 10.08.2014
 * @version 12.08.2014
 */

public class Toiveet {
	
	private int lkm;
	ArrayList<Levy> alkiot = new ArrayList<Levy>();
	
	/**
	 * Muodostin.
	 */
	public Toiveet() {
		lkm = 0;
	}
	
	/**
	 * Lisää kokoelmaan annetun levyn.
	 * @param levy
	 */
	public void lisaa(Levy levy) {
		alkiot.add(levy);
		lkm++;
	}
	
	
	/**
	 * Poistaa kokoelmasta annetun levyn.
	 * @param levy
	 */
	public void poista(Levy levy) {
		alkiot.remove(levy);
		lkm--;
	}
	
	/**
	 * Palauttaa kokoelmassa olevan levyjen lukumäärän
	 * @return
	 */
	public int getLkm() {
		return lkm;
	}
	
	
	/**
	 * Hakee toivelistasta tietyn tunnuksen omaavaa levyä. Jos ei löydy, palauttaa nullin.
	 * @param id tunnus, jolla haetaan
	 * @return levy, jos löytyy; jos ei, null
	 */
	public Levy haeLevyId(int id) {
		for (Levy lev : alkiot) {
			if (lev.getId() == id) return lev;
		}
		return null;
	}
	
	
	/**
	 * Hakee toivelistasta tietyn nimisen levyn
	 * @param a
	 * @param n
	 * @return
	 */
	public Levy haeLevyNimet(String a, String n) {
		String artisti = a.toUpperCase(); String nimi = n.toUpperCase();
		for (Levy lev: alkiot) {
			if (lev.getArtisti().toUpperCase().equals(artisti) && lev.getNimi().toUpperCase().equals(nimi))
				return lev;
		}
		return null;
	}

}
