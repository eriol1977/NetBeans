/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fb.marveltest;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

/**
 *
 * @author Francesco
 */
@ManagedBean(name = "characterController")
@ViewScoped
public class CharacterController {

    private String selectedName;

    private Character character;

    /**
     * Creates a new instance of CharacterController
     */
    public CharacterController() {
    }

    public Character getCharacter() {
        if (character == null) {
            final ClientConfig config = new DefaultClientConfig();
            final Client client = Client.create(config);
            final WebResource resource = client.resource(UriBuilder.fromUri("http://gateway.marvel.com/v1/public/characters").build());
            final String json = resource.queryParam("ts", "1").queryParam("name", selectedName).queryParam("apikey", "7a4c44e4becce8ad14abb4f92544dc45").queryParam("hash", "2553dc60bbf63062a13e64194ae026f5").accept(MediaType.APPLICATION_JSON).get(String.class);

            JsonElement jelement = new JsonParser().parse(json);
            JsonObject jobject = jelement.getAsJsonObject();
            jobject = jobject.getAsJsonObject("data");
            JsonArray jarray = jobject.getAsJsonArray("results");
            jobject = jarray.get(0).getAsJsonObject();

            String id = jobject.get("id").toString();
            String name = jobject.get("name").toString().replace("\"", "");
            String description = jobject.get("description").toString().replace("\"", "");

            jobject = jobject.getAsJsonObject("thumbnail");
            String thumbnailPath = jobject.get("path").toString().replace("\"", "");
            String thumbnailExtension = jobject.get("extension").toString().replace("\"", "");

            Thumbnail thumbnail = new Thumbnail(thumbnailPath, thumbnailExtension);
            character = new Character(Long.valueOf(id), name, description, thumbnail);
        }
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public String getSelectedName() {
        return selectedName;
    }

    public void setSelectedName(String selectedName) {
        this.selectedName = selectedName;
    }
}
