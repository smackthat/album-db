package controller;

import java.util.Collection;

import model.Levyt;
import model.Toiveet;
import de.umass.lastfm.Album;
import de.umass.lastfm.Artist;
import de.umass.lastfm.Caller;
import de.umass.lastfm.Track;
import de.umass.lastfm.User;


/**
 * LevyHallinnoija-luokka
 * V�litt�� k�ytt�liittym�n kutsut tietorakenteille, hoitaa kaiken logistiikan (lis�ys, poisto,
 * rekister�inti, onko levy toivelistalla, jne. )
 * @author Johannes Stenberg
 * @since 12.08.2014
 * @version 18.08.2014
 */

public class LevyHallinnoija {
	private Levyt levyt;
    private Toiveet toiveet;
    private String[] artistiIDt;
    
    
    /**
     * Hakee netist� listauksen albumeista, joista k�ytt�j� valitsee lis�tt�v�n.
     * HUOM! Uudet haetut artistit voisi tallentaa erilliseen tiedostoon, jottei kutsua
     * tarvitsisi ihan aina tehd�. Sitten kaivetaan tiedostosta artisti ja etsit��n silt� levy.
     * @param artisti
     * @param albumi
     * @return listaus hakuehtoja vastaavista albumeista
     * 
     * Artistitiedot tallennetaan tiedostoon muodossa:
     * <pre>
     * mbid|artist
     * 0df3404|Prince
     * 0wj4304io|Queen
     * ...
     * </pre>
     */
    public Collection<Album> haeLevyt(String artisti, String albumi) {
    	String key = "0da25a92d8ab16d9fcfe5448c7b57c56";
    	Collection<Album> albums = Artist.getTopAlbums(artisti, key);
		for (Album al : albums) {
			System.out.println(al.getArtist() + " " + al.getName());
		}
		return albums;
    }
    
    
    
    /**
     * Testailua varten.
     * @param args
     */
    public static void main(String[] args) {
    	
    }
    
    

}
