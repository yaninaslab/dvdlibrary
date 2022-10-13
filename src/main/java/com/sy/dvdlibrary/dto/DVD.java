/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sy.dvdlibrary.dto;

/**
 *
 * @author yanina
 */
public class DVD {
    
    private String title;
    private String releaseDate;
    private String MPAA;
    private String directorName;
    private String Studio;
    private String userNote;

    public DVD(String title, String releaseDate, String MPAA, String directorName, String Studio, String userNote) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.MPAA = MPAA;
        this.directorName = directorName;
        this.Studio = Studio;
        this.userNote = userNote;
    }
    
    public DVD(String title) {
        this.title = title;
}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMPAA() {
        return MPAA;
    }

    public void setMPAA(String MPAA) {
        this.MPAA = MPAA;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getStudio() {
        return Studio;
    }

    public void setStudio(String Studio) {
        this.Studio = Studio;
    }

    public String getUserNote() {
        return userNote;
    }

    public void setUserNote(String userNote) {
        this.userNote = userNote;
    }
    
    
    
}
    
