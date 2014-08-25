package model;

import java.io.PrintStream;
import java.util.Collection;

import de.umass.lastfm.Album;
import de.umass.lastfm.Artist;
import de.umass.lastfm.Caller;
import de.umass.lastfm.Track;
import de.umass.lastfm.User;

/**
 * Levy-luokka
 * Voi olla joko toivelistalla tai omistuslistalla, mutta ei samanaikaisesti.
 * TODO:
 * - Tracklisting (haetaan netistä)
 * - Kansitaide ( - = - )
 * - Jokaisella levyllä uniikki ID (musicbrainz?)
 * @author Johannes Stenberg
 * @since 04.08.2014
 * @version 10.08.2014
 */

public class Levy {
	private int id;
	private String nimi;
	private String artisti;
	private String formaatti;
	private String kommentti;
	private String kuva;
	private int vuosi;
	private Collection<Track> biisit;
	
	
	/**
	 * Oletusmuodostin.
	 */
	public Levy() {
		this.id = 0;
		this.setNimi("");
		this.setArtisti("");
		this.setFormaatti("");
		this.setVuosi(0);
		this.setKommentti("");
	}


	private void setKommentti(String string) {
		this.kommentti = string;	
	}
	
	public String getKommentti() {
		return this.kommentti;
	}
	

	public void setKuva(String kuva) {
		this.kuva = kuva;
	}
	
	public String getKuva() {
		return kuva;
	}

	public int getVuosi() {
		return vuosi;
	}
	
	public int getId() {
		return id;
	}


	public void setVuosi(int vuosi) {
		this.vuosi = vuosi;
	}


	public String getFormaatti() {
		return formaatti;
	}


	public void setFormaatti(String formaatti) {
		this.formaatti = formaatti;
	}
	
	
	public Collection<Track> getBiisit() {
		return biisit;
	}


	public void setBiisit(Collection<Track> biisit) {
		this.biisit = biisit;
	}


	public String getArtisti() {
		return artisti;
	}


	public void setArtisti(String artisti) {
		this.artisti = artisti;
	}


	public String getNimi() {
		return nimi;
	}


	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	
	/**
	 * Palauttaa levyn tiedot tiedostoon kirjoitettavassa muodossa
	 */
	@Override
	public String toString() {
		return artisti+"|"+nimi+"|"+vuosi+"|"+formaatti+"|"+kommentti;
	}
	
	
	
	/**
	 * Tulostetaan levyn tiedot.
	 * @param out tietovirta
	 */
	public void tulosta(PrintStream out) {
		out.println(artisti);
		out.println(nimi);
		out.println(vuosi);
		out.println(formaatti);
		out.println(kommentti);
	}
	
	/**
	 * Haetaan albumin tiedot netistä. TESTI
	 */
	public void haeTiedot() {
		//Alustetaan kutsuja
		//Caller.getInstance().setUserAgent("tst");
		//Last.fm API avain
		String key = "0da25a92d8ab16d9fcfe5448c7b57c56";
		String artist = "Prince";
		Collection<Album> albums = Artist.getTopAlbums(artist, key);
		for (Album al : albums) {
			System.out.println(al.getArtist() + " " + al.getName());
		}
		
		
		
	}
	
	/**
	 * Päämetodi testausta varten.
	 * @param args ei käytössä
	 */
	public static void main(String[] args) {
		Levy lev = new Levy();
		lev.setNimi("In Rock");
		lev.haeTiedot();
	}


	
	
}
