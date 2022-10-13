/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sy.dvdlibrary.controller;

import com.sy.dvdlibrary.dao.DVDLibraryDao;
import com.sy.dvdlibrary.dao.DVDLibraryDaoException;
//import com.sy.dvdlibrary.dao.DVDLibraryDaoFileImpl;
import com.sy.dvdlibrary.dto.DVD;
import com.sy.dvdlibrary.ui.DVDLibraryView;
//import com.sy.dvdlibrary.ui.UserIO;
//import com.sy.dvdlibrary.ui.UserIOConsoleImpl;
import java.util.List;

/**
 *
 * @author yanina
 */
public class DVDLibraryController {
    
    private DVDLibraryView view;
    private DVDLibraryDao dao;

    public DVDLibraryController(DVDLibraryView view, DVDLibraryDao dao) {
        this.view = view;
        this.dao = dao;
    }

    
    
    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        
        try {
        while (keepGoing) {

            menuSelection = getMenuSelection();

            switch (menuSelection) {
                case 1:
                    createDVD();
                    break;
                case 2:
                    removeDVD();
                    break;
                case 3:
                    editDVD();
                    break;
                case 4:
                    listDVDs();
                    break;
                case 5:
                    viewDVD();
                    break;
                case 6:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }

        }
        exitMessage();
    } catch (DVDLibraryDaoException e) {
        view.displayErrorMessage(e.getMessage());
    }
    }
    
        private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    
    private void createDVD() throws DVDLibraryDaoException {
    view.displayCreateDVDBanner();
    DVD newDVD = view.addNewDVDInfo();
    dao.addDVD(newDVD.getTitle(), newDVD);
    view.displayCreateSuccessBanner();
}
    
    private void listDVDs() throws DVDLibraryDaoException {
    view.displayDisplayAllBanner();
    List<DVD> DVDList = dao.displayDVDs();
    view.displayDVDList(DVDList);
}
    
    private void viewDVD() throws DVDLibraryDaoException {
    view.displayDisplayDVDBanner();
    String title = view.getDVDTitleChoice();
    DVD dvd = dao.viewDVD(title);
    view.displayDVD(dvd);
}
    
    private void removeDVD() throws DVDLibraryDaoException {
    view.displayRemoveDVDBanner();
    String title = view.getDVDTitleChoice();
    DVD removedDVD = dao.removeDVD(title);
    view.displayRemoveResult(removedDVD);
}
    
    private void editDVD() throws DVDLibraryDaoException {
        view.displayEditDVDBanner();
        String title = view.getDVDTitleChoice();
        DVD editedDVD = dao.editDVD(title);
        view.displayEditedResult(editedDVD); 
    }
    
    private void unknownCommand() {
    view.displayUnknownCommandBanner();
}

private void exitMessage() {
    view.displayExitBanner();
}
}
