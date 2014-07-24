/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fb.marveltest;

import com.google.gson.JsonObject;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.UriBuilder;

/**
 *
 * @author Francesco
 */
public class Cache {

    private final static Cache instance = new Cache();

    Set<Character> characters = new HashSet<>();

    final WebResource resource;

    public static Cache getInstance() {
        return Cache.instance;
    }

    private Cache() {
        final ClientConfig config = new DefaultClientConfig();
        final Client client = Client.create(config);
        resource = client.resource(UriBuilder.fromUri("http://gateway.marvel.com/v1/public/characters").build());
    }

    public WebResource getResource() {
        return resource;
    }
    
    public Set<Character> getCharacters() {
        return characters;
    }

    public Character getCharacter(final String nome) {
        for (Character c : characters) {
            if (c.getName().equals(nome)) {
                return c;
            }
        }
        return null;
    }

    public Character addCharacter(final JsonObject jobject) {
        final Character c = createCharacter(jobject);
        this.characters.add(c);
        return c;
    }

    private Character createCharacter(final JsonObject jobject) {
        String id = jobject.get("id").toString();
        String name = jobject.get("name").toString().replace("\"", "");
        String description = jobject.get("description").toString().replace("\"", "");

        JsonObject t = jobject.getAsJsonObject("thumbnail");
        String thumbnailPath = t.get("path").toString().replace("\"", "");
        String thumbnailExtension = t.get("extension").toString().replace("\"", "");

        Thumbnail thumbnail = new Thumbnail(thumbnailPath, thumbnailExtension);
        return new Character(Long.valueOf(id), name, description, thumbnail);
    }
}
