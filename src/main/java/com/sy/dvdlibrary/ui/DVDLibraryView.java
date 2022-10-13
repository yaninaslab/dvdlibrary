/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sy.dvdlibrary.ui;

import com.sy.dvdlibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author yanina
 */
public class DVDLibraryView {
    
    private UserIO io;

    public DVDLibraryView(UserIO io) {
        this.io = io;
    }
    
    
    public int printMenuAndGetSelection() {
        io.print("*** MAIN MENU ***");
            io.print("1. Create a DVD");
            io.print("2. Remove a DVD");
            io.print("3. Edit a DVD");
            io.print("4. List DVDs");
            io.print("5. View a DVD");
            io.print("6. Exit");

        return io.readInt("Please select from the above choices.", 1, 6);
    }
    
    public DVD addNewDVDInfo() {
    String title = io.readString("Please enter DVD title");
    String releaseDate = io.readString("Please enter DVD release date");
    String MPAA = io.readString("Please enter DVD MPAA rating");
    String directorName = io.readString("Please enter DVD director's name");
    String Studio = io.readString("Please enter DVD studio name");
    String userNote = io.readString("Please enter user rating or note");
    DVD newDVD = new DVD(title);
    newDVD.setTitle(title);
    newDVD.setReleaseDate(releaseDate);
    newDVD.setMPAA(MPAA);
    newDVD.setDirectorName(directorName);
    newDVD.setStudio(Studio);
    newDVD.setUserNote(userNote); 
    return newDVD;
}
    
    public void displayDVDList(List<DVD> DVDList) {
    for (DVD currentDVD : DVDList) {
        String DVDInfo = String.format("%s : %s %s %s %s %s",
              currentDVD.getTitle(),
              currentDVD.getReleaseDate(),
              currentDVD.getMPAA(),
              currentDVD.getDirectorName(),
              currentDVD.getStudio(),
              currentDVD.getUserNote());
        
        io.print(DVDInfo);
    }
    io.readString("Please hit enter to continue.");
}
    
    
   public void displayCreateDVDBanner() {
    io.print("=== Create DVD ===");
}
   
   public void displayCreateSuccessBanner() {
    io.readString(
            "DVD successfully created.  Please hit enter to continue");
}
   
   public void displayDisplayAllBanner() {
    io.print("=== Display All DVDs ===");
}
   
   public void displayDisplayDVDBanner() {
    io.print("=== Display a DVD ===");
}

public String getDVDTitleChoice() {
    return io.readString("Please enter the DVD's title.");
}

public void displayDVD(DVD dvd) {
    if (dvd != null) {
        io.print(dvd.getTitle());
        io.print(dvd.getReleaseDate() + " " + dvd.getMPAA());
        io.print(dvd.getDirectorName() + " " + dvd.getStudio());
        io.print(dvd.getUserNote());
        io.print("");
    } else {
        io.print("No DVD found.");
    }
    io.readString("Please hit enter to continue.");
}

public void displayRemoveDVDBanner () {
    io.print("=== Remove DVD ===");
}

public void displayRemoveResult(DVD dvdRecord) {
    if(dvdRecord != null){
      io.print("DVD successfully removed.");
    }else{
      io.print("No such DVD.");
    }
    io.readString("Please hit enter to continue.");
}

public void displayEditDVDBanner() {
    io.print("=== Edit DVD ===");
}

public void displayEditedResult(DVD dvdRecord) {
    if(dvdRecord != null){
      io.print("DVD successfully edited.");
    }else{
      io.print("No such DVD.");
    }
    io.readString("Do you want to edit another DVD? y/n");

    }   


public void displayExitBanner() {
    io.print("Good Bye!!!");
}

public void displayUnknownCommandBanner() {
    io.print("Unknown Command!!!");
}

public void displayErrorMessage(String errorMsg) {
    io.print("=== ERROR ===");
    io.print(errorMsg);
}
}
