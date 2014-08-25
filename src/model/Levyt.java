package model;

import java.util.ArrayList;
import java.util.List;


/**
 * Levyt-luokka.
 * Kokoelma omistetuille levyille.
 * @author Johannes "J-dog" Stenberg
 * @since 06.08.2014
 * @version 07.08.2014
 *
 */
public class Levyt {
	
	private int lkm;
	ArrayList<Levy> alkiot = new ArrayList<Levy>();
	
	/**
	 * Muodostin.
	 */
	public Levyt() {
		lkm = 0;
	}
	
	
	/**
	 * Lis‰‰ kokoelmaan annetun levyn.
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
	 * Palauttaa kokoelmassa olevan levyjen lukum‰‰r‰n
	 * @return
	 */
	public int getLkm() {
		return lkm;
	}
	
	
	
	/**
	 * Palauttaa annettuna vuosilukuna julkaistut levyt.
	 * @param vuosi vuosiluku, esim. 1976
	 * @return vuotta vastaavat levyt
	 */
	public List<Levy> haeLevytVuosi(int vuosi) {
		List<Levy> loydetyt = new ArrayList<Levy>();
		for (Levy lev : alkiot) {
			if (lev.getVuosi() == vuosi)
				loydetyt.add(lev);
		}
		return loydetyt;
	}
	
	
	/**
	 * Palauttaa annettua formaattia olevat levyt
	 * @param forma tietty formaatti, esim. CD, LP
	 * @return formaattia olevat levyt
	 */
	public List<Levy> haeLevytFormaatti(String forma) {
		List<Levy> loydetyt = new ArrayList<Levy>();
		for (Levy lev : alkiot) {
			if (lev.getFormaatti().equals(forma))
				loydetyt.add(lev);
		}
		return loydetyt;
	}
	

}
