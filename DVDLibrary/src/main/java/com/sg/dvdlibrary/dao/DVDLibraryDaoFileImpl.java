/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;
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
 * @author spookydylan
 */
public class DVDLibraryDaoFileImpl implements DVDLibraryDao {
   
    private Map<String, DVD> DVDs = new HashMap<>();
    private static final String DVDLIB_FILE = "dvdlib.txt";
    private static final String DELIMITER = "::";

    @Override
    public DVD addDVD(String UPC, DVD DVD)
            throws DVDLibraryPersistenceException {
        DVD newDVD = DVDs.put(DVD.getUPC(), DVD);
        writeLib();
        return newDVD;
    }

    @Override
    public List<DVD> getAllDVDs()
            throws DVDLibraryPersistenceException {
        loadLib();
        return new ArrayList<DVD>(DVDs.values());
    }

    @Override
    public DVD getDVD(String UPC)
            throws DVDLibraryPersistenceException {
        loadLib();
        return DVDs.get(UPC);
    }

    @Override
    public DVD removeDVD(String UPC)
            throws DVDLibraryPersistenceException {
        DVD removedDVD = DVDs.remove(UPC);
        writeLib();
        return removedDVD;
    }

    

    private void loadLib() throws DVDLibraryPersistenceException {
        Scanner scanner;

        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(DVDLIB_FILE)));
        } catch (FileNotFoundException e) {
            throw new DVDLibraryPersistenceException(
                    "-_- Could not load roster data into memory.", e);
        }

        String currentLine;
        String[] currentTokens;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            DVD currentDVD = new DVD(currentTokens[0]);
            currentDVD.setTitle(currentTokens[1]);
            currentDVD.setReleaseYear(currentTokens[2]);
            currentDVD.setRating(currentTokens[3]);
            currentDVD.setDirector(currentTokens[4]);
            currentDVD.setStudio(currentTokens[5]);
            currentDVD.setUserNote(currentTokens[6]);

            DVDs.put(currentDVD.getUPC(), currentDVD);
        }
    }

    private void writeLib() throws DVDLibraryPersistenceException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(DVDLIB_FILE));
        } catch (IOException e) {
            throw new DVDLibraryPersistenceException(
                    "Could not save DVD data.", e);
        }
        List<DVD> DVDList = this.getAllDVDs();
        for (DVD currentDVD : DVDList) {
            out.println(currentDVD.getUPC() + DELIMITER
                    + currentDVD.getTitle() + DELIMITER
                    + currentDVD.getReleaseYear() + DELIMITER
                    + currentDVD.getRating() + DELIMITER
                    + currentDVD.getDirector() + DELIMITER
                    + currentDVD.getStudio() + DELIMITER
                    + currentDVD.getUserNote());
            out.flush();
        }
        out.close();
    }

}
