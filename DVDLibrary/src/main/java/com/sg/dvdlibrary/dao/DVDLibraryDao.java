/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author spookydylan
 */
public interface DVDLibraryDao {
    
    DVD addDVD(String UPC, DVD DVD)
        throws DVDLibraryPersistenceException;
    
    List<DVD> getAllDVDs()
        throws DVDLibraryPersistenceException;
    
    DVD getDVD(String UPC)
        throws DVDLibraryPersistenceException;
    
    DVD removeDVD(String UPC)
        throws DVDLibraryPersistenceException;
}
