/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lambda;

import java.util.List;

/**
 *
 * @author Francesco
 */
public class Album implements Comparable<Album>{
    
    private final String name;
    
    private List<Track> tracks;

    public Album(String name) {
        this.name = name;
    }
    
    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }
    
    public String getName() {
        return name;
    }
    
    public void print()
    {
        System.out.println(name);
    }

    @Override
    public int compareTo(Album other) {
        return this.name.compareTo(other.getName());
    }
}
