/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author spookydylan
 */
public class DVDLibraryDaoStubImpl implements DVDLibraryDao {
    
    DVD onlyDVD;
    List<DVD> DVDList = new ArrayList<>();
    
    public DVDLibraryDaoStubImpl(){
        onlyDVD = new DVD("01");
        onlyDVD.setTitle("My Giant");
        onlyDVD.setReleaseYear("1999");
        onlyDVD.setRating("R");
        onlyDVD.setDirector("Alan Smithee");
        onlyDVD.setStudio("Warner Bros");
        onlyDVD.setUserNote("WOW.");
        
        DVDList.add(onlyDVD);
    }
    

    @Override
    public DVD addDVD(String UPC, DVD DVD) throws DVDLibraryPersistenceException {
        if(UPC.equals(onlyDVD.getUPC())){
            return onlyDVD;
        }else{
            return null;
        }
    }

    @Override
    public List<DVD> getAllDVDs() throws DVDLibraryPersistenceException {
        return DVDList;
    }

    @Override
    public DVD getDVD(String UPC) throws DVDLibraryPersistenceException {
        if(UPC.equals(onlyDVD.getUPC())){
            return onlyDVD;
        } else{
            return null;
        }
    }

    @Override
    public DVD removeDVD(String UPC) throws DVDLibraryPersistenceException {
        if(UPC.equals(onlyDVD.getUPC())){
            return onlyDVD;
        }else{
            return null;
        }
    }
    
}
