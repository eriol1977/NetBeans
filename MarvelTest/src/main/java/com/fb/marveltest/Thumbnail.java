/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fb.marveltest;

/**
 *
 * @author Francesco
 */
public class Thumbnail {
    
    private String path;
    
    private String extension;

    public Thumbnail(String path, String extension) {
        this.path = path;
        this.extension = extension;
    }
    
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getFileName()
    {
        return path + "." + extension;
    }
    
    @Override
    public String toString() {
        return getFileName();
    }
    
    
}
