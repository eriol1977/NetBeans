/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Francesco
 */
public class Exercise {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Album> albums = initAlbums();

        // devolve uma lista ordenada por nome de todos os Album que possuem pelo menos uma Track com rating >= 4
        List<Album> favs = albums.stream()
                .filter(a -> a.getTracks().stream()
                        .filter(t -> t.getRating() >= 4)
                        .count() > 0)
                .sorted()
                .collect(Collectors.toList());
        favs.stream().forEach(Album::print);

        System.out.println();

        // solução oficial do site:
        List<Album> sortedFavs
                = albums.stream()
                .filter(a -> a.getTracks().stream()
                        .anyMatch(t -> (t.getRating() >= 4)))
                .sorted(Comparator.comparing(a -> a.getName()))
                .collect(Collectors.toList());
        sortedFavs.stream().forEach(Album::print);
    }

    private static List<Album> initAlbums() {
        List<Album> albums = new ArrayList<>();
        List<Track> tracks = new ArrayList<>();

        Album war = new Album("War");
        tracks.add(new Track("Sunday Bloody Sunday", 10));
        tracks.add(new Track("Seconds", 6));
        tracks.add(new Track("New Year's Day", 8));
        war.setTracks(tracks);
        albums.add(war);

        tracks = new ArrayList<>();
        Album unforgettable = new Album("The Unforgettable Fire");
        tracks.add(new Track("A Sort of Homecoming", 5));
        tracks.add(new Track("Pride", 9));
        tracks.add(new Track("Indian Summer Sky", 4));
        tracks.add(new Track("4th of July", 7));
        unforgettable.setTracks(tracks);
        albums.add(unforgettable);

        tracks = new ArrayList<>();
        Album zooropa = new Album("Zooropa");
        tracks.add(new Track("Zooropa", 1));
        tracks.add(new Track("Numb", 3));
        tracks.add(new Track("Lemon", 2));
        zooropa.setTracks(tracks);
        albums.add(zooropa);

        return albums;
    }
}
