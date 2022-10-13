/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sy.dvdlibrary.dao;

import com.sy.dvdlibrary.dto.DVD;
import com.sy.dvdlibrary.ui.UserIO;
import com.sy.dvdlibrary.ui.UserIOConsoleImpl;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author yanina
 */
public class DVDLibraryDaoFileImpl implements DVDLibraryDao {
    
    private UserIO io = new UserIOConsoleImpl();
    private Map<String, DVD> dvds = new HashMap<>();
    
    
    public static final String LIBRARY_FILE = "dvdlib.txt";
    public static final String DELIMITER = "::";

    @Override
    public DVD addDVD(String title, DVD dvd) throws DVDLibraryDaoException {
        loadLibrary();
        DVD newDVD = dvds.put(title, dvd);
        writeLibrary();
        return newDVD;
    }

    @Override
    public DVD removeDVD(String title) throws DVDLibraryDaoException {
        loadLibrary();
        DVD removedDVD = dvds.remove(title);
        writeLibrary();
        return removedDVD;
    }

    @Override
    public DVD editDVD(String title) throws DVDLibraryDaoException {
        io.print("What would you like to edit?");
        io.print("1. Edit release date");
        io.print("2. Edit MPAA Rating");
        io.print("3. Edit Director's name");
        io.print("4. Edit Studio");
        io.print("5: Edit user note");
        loadLibrary();
        DVD editedDVD = dvds.get(title);
        int choice = io.readInt("Please select from the above choices.", 1, 5);
        
        switch(choice) {

            case 1:
                if(editedDVD != null) {
                editedDVD.setReleaseDate(io.readString("Enter the new release date"));
                }
                break;
                
            case 2:
                if(editedDVD != null) {
                editedDVD.setMPAA(io.readString("Enter the new MPAA rating"));
                }
                break;
                
            case 3:
                
                editedDVD.setDirectorName(io.readString("Enter the new director name"));
                break;
                
            case 4: 
                
                editedDVD.setStudio(io.readString("Enter the new studio name"));
                break;
                
            case 5:
   
                editedDVD.setUserNote(io.readString("Enter the new user note"));
                break;
                
            default:
                break;                
                
        }
        writeLibrary();
        return editedDVD;
    }

    @Override
    public List<DVD> displayDVDs() throws DVDLibraryDaoException {
        loadLibrary();
        return new ArrayList<DVD>(dvds.values());
    }

    @Override
    public DVD viewDVD(String title) throws DVDLibraryDaoException  {
        loadLibrary();
        return dvds.get(title);
    }
    
    
    private DVD unmarshallDVD(String DVDAsText) {
        
        String[] dvdTokens = DVDAsText.split(DELIMITER);
        
        String title = dvdTokens[0];
        
        DVD DVDFromFile = new DVD(title);
        
        DVDFromFile.setReleaseDate(dvdTokens[1]);

        DVDFromFile.setMPAA(dvdTokens[2]);
   
        DVDFromFile.setDirectorName(dvdTokens[3]);
        
        DVDFromFile.setStudio(dvdTokens[4]);
        
        DVDFromFile.setUserNote(dvdTokens[5]);

    
    return DVDFromFile;
        
    }
    
        private void loadLibrary() throws DVDLibraryDaoException {
    Scanner scanner;

    try {
        scanner = new Scanner(
                new BufferedReader(
                        new FileReader(LIBRARY_FILE)));
    } catch (FileNotFoundException e) {
        throw new DVDLibraryDaoException(
                "-_- Could not load library data into memory.", e);
    }
    String currentLine;
    DVD currentDVD;
    while (scanner.hasNextLine()) {

        currentLine = scanner.nextLine();

        currentDVD = unmarshallDVD(currentLine);

        dvds.put(currentDVD.getTitle(), currentDVD);
    }
    scanner.close();
}
        
    private String marshallDVD(DVD aDVD){
    
    String DVDAsText = aDVD.getTitle() + DELIMITER;

    DVDAsText += aDVD.getReleaseDate() + DELIMITER;

    DVDAsText += aDVD.getMPAA() + DELIMITER;

    DVDAsText += aDVD.getDirectorName() + DELIMITER;
    
    DVDAsText += aDVD.getStudio() + DELIMITER;
    
    DVDAsText += aDVD.getUserNote();

    return DVDAsText;
}
    
    private void writeLibrary() throws DVDLibraryDaoException {
        
    PrintWriter out;

    try {
        out = new PrintWriter(new FileWriter(LIBRARY_FILE));
    } catch (IOException e) {
        throw new DVDLibraryDaoException(
                "Could not save student data.", e);
    }

    String DVDAsText;
    List<DVD> DVDList = this.displayDVDs();
    for (DVD currentDVD : DVDList) {
        DVDAsText = marshallDVD(currentDVD);
        out.println(DVDAsText);
        out.flush();
    }
    out.close();
}
}
