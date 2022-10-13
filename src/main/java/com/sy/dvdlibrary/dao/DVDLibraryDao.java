/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sy.dvdlibrary.dao;

import com.sy.dvdlibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author yanina
 */
public interface DVDLibraryDao {
    
    DVD addDVD(String title, DVD dvd) throws DVDLibraryDaoException;
    
    DVD removeDVD(String title) throws DVDLibraryDaoException;
    
    DVD editDVD(String title) throws DVDLibraryDaoException;

    List<DVD> displayDVDs() throws DVDLibraryDaoException;

    DVD viewDVD(String title) throws DVDLibraryDaoException;

  
}
