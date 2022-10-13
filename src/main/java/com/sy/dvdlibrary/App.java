/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.sy.dvdlibrary;

import com.sy.dvdlibrary.controller.DVDLibraryController;
import com.sy.dvdlibrary.dao.DVDLibraryDao;
import com.sy.dvdlibrary.dao.DVDLibraryDaoFileImpl;
import com.sy.dvdlibrary.ui.DVDLibraryView;
import com.sy.dvdlibrary.ui.UserIO;
import com.sy.dvdlibrary.ui.UserIOConsoleImpl;

/**
 *
 * @author yanina
 */
public class App {

    public static void main(String[] args) {
        
        UserIO myIo = new UserIOConsoleImpl();
        DVDLibraryView myView = new DVDLibraryView(myIo);
        DVDLibraryDao myDao = new DVDLibraryDaoFileImpl();
        DVDLibraryController controller = new DVDLibraryController(myView, myDao);
        
        controller.run();
    }   
}
