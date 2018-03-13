/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.service;

import com.sg.dvdlibrary.dao.DVDLibraryPersistenceException;
import com.sg.dvdlibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author spookydylan
 */
public interface DVDLibraryServiceLayer {
    void addDVD(String UPC, DVD DVD) throws
        DVDLibraryDuplicateUPCException,
        DVDLibraryDataValidationException,
        DVDLibraryPersistenceException;
    
    List<DVD> getAllDVDs() throws
        DVDLibraryPersistenceException;
    
    DVD getDVD(String UPC) throws
        DVDLibraryPersistenceException;
    
    DVD removeDVD(String UPC) throws
        DVDLibraryPersistenceException;
}
