/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lambda;

/**
 *
 * @author Francesco
 */
public class Track {

    private final String name;
    
    private final int rating;

    public Track(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }
    
    public int getRating() {
        return rating;
    }
    
    
    
}
