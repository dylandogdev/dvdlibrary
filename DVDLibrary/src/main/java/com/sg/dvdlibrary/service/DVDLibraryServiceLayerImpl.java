/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.service;

import com.sg.dvdlibrary.dao.DVDLibraryAuditDao;
import com.sg.dvdlibrary.dao.DVDLibraryDao;
import com.sg.dvdlibrary.dao.DVDLibraryPersistenceException;
import com.sg.dvdlibrary.dto.DVD;
import java.util.List;


/**
 *
 * @author spookydylan
 */
public class DVDLibraryServiceLayerImpl implements DVDLibraryServiceLayer {
    
    private DVDLibraryAuditDao auditDao;
    DVDLibraryDao dao;
    
    public DVDLibraryServiceLayerImpl(DVDLibraryDao dao, DVDLibraryAuditDao auditDao){
        this.dao = dao;
        this.auditDao = auditDao;
    }

    @Override
    public void addDVD(String UPC, DVD DVD) throws DVDLibraryDuplicateUPCException, DVDLibraryDataValidationException, DVDLibraryPersistenceException {
         
    if (dao.getDVD(DVD.getUPC()) != null) {
        throw new DVDLibraryDuplicateUPCException(
        "ERROR: Could not create DVD. UPC" + DVD.getUPC()
        + " already exists.");
    }
    
    validateDVDData(DVD);
    
    dao.addDVD(DVD.getUPC(), DVD);
    
    auditDao.writeAuditEntry(
        "DVD " + DVD.getUPC() + " CREATED.");
    }

    @Override
    public List<DVD> getAllDVDs() throws DVDLibraryPersistenceException {
        return dao.getAllDVDs();
    }

    @Override
    public DVD getDVD(String UPC) throws DVDLibraryPersistenceException {
        return dao.getDVD(UPC);
    }
    
    @Override
    public DVD removeDVD(String UPC) throws DVDLibraryPersistenceException {
    DVD removedDVD = dao.removeDVD(UPC);
//    auditDao.writeAuditEntry("DVD " + UPC + " REMOVED.");
    return removedDVD;
    }
    
    private void validateDVDData(DVD DVD) throws
            DVDLibraryDataValidationException {
        
        if(DVD.getUPC() == null
                || DVD.getUPC().trim().length()==0
                || DVD.getTitle() == null
                || DVD.getTitle().trim().length()==0
                || DVD.getReleaseYear() == null
                || DVD.getReleaseYear().trim().length()==0
                || DVD.getRating()==null
                || DVD.getRating().trim().length()==0
                || DVD.getDirector()==null
                || DVD.getDirector().trim().length()==0
                || DVD.getStudio()==null
                || DVD.getStudio().trim().length()==0
                || DVD.getUserNote()==null
                || DVD.getUserNote().trim().length()==0){
            
            throw new DVDLibraryDataValidationException(
                    "Error! All fields are required.");
        }
                
    }
    
}
