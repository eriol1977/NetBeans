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
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Francesco
 */
@ManagedBean(name = "characterListController")
@ViewScoped
public class CharacterListController {

    private List<String> names = new ArrayList<>();

    private String selectedName;

    private Character character;

    private int offset = 0;

    /**
     * Creates a new instance of CharacterListController
     */
    public CharacterListController() {
        final String json = Cache.getInstance().getResource().queryParam("ts", "1").queryParam("limit", "100").queryParam("offset", String.valueOf(offset)).queryParam("apikey", "7a4c44e4becce8ad14abb4f92544dc45").queryParam("hash", "2553dc60bbf63062a13e64194ae026f5").accept(MediaType.APPLICATION_JSON).get(String.class);

        JsonElement jelement = new JsonParser().parse(json);
        JsonObject jobject = jelement.getAsJsonObject();
        jobject = jobject.getAsJsonObject("data");
        JsonArray jarray = jobject.getAsJsonArray("results");

        for (JsonElement obj : jarray) {
            names.add(obj.getAsJsonObject().get("name").toString().replace("\"", ""));
        }
    }

    public Character getCharacter() {
        final Cache cache = Cache.getInstance();
        character = cache.getCharacter(selectedName);
        if (character == null) {
            final String json = cache.getResource().queryParam("ts", "1").queryParam("name", selectedName).queryParam("apikey", "7a4c44e4becce8ad14abb4f92544dc45").queryParam("hash", "2553dc60bbf63062a13e64194ae026f5").accept(MediaType.APPLICATION_JSON).get(String.class);
            JsonElement jelement = new JsonParser().parse(json);
            JsonObject jobject = jelement.getAsJsonObject();
            jobject = jobject.getAsJsonObject("data");
            JsonArray jarray = jobject.getAsJsonArray("results");
            jobject = jarray.get(0).getAsJsonObject();
            character = cache.addCharacter(jobject);
        }
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public boolean isCharacterSelected() {
        return this.selectedName != null;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public String getSelectedName() {
        return selectedName;
    }

    public void setSelectedName(String selectedName) {
        this.selectedName = selectedName;
    }
}
