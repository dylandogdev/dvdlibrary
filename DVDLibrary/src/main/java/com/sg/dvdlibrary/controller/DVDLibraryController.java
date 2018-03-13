 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.dao.DVDLibraryDao;
import com.sg.dvdlibrary.dao.DVDLibraryPersistenceException;
import com.sg.dvdlibrary.dto.DVD;
import com.sg.dvdlibrary.service.DVDLibraryDataValidationException;
import com.sg.dvdlibrary.service.DVDLibraryDuplicateUPCException;
import com.sg.dvdlibrary.service.DVDLibraryServiceLayer;
import com.sg.dvdlibrary.ui.DVDLibraryView;
import java.util.List;

/**
 *
 * @author spookydylan
 */
public class DVDLibraryController {

    DVDLibraryView view;
    DVDLibraryServiceLayer service;

    public DVDLibraryController(DVDLibraryServiceLayer service, DVDLibraryView view) {
        this.service = service;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        String menuSelection = "0";
        try {
            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case "1":
                        createDVD();
                        break;
                    case "2":
                        removeDVD();
                        break;
                    case "3":
                        viewDVD();
                        break;
                    case "4":
                        editDVD();
                        break;
                    case "5":
                        listDVDs();
                        break;
                    case "6":
                        searchByTitle();
                        break;
                    case "7":
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                        break;
                }

            }
            exitMsg();
        } catch (DVDLibraryPersistenceException e) {
            view.displayErrorMsg(e.getMessage());
        }

    }

    private String getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createDVD() throws DVDLibraryPersistenceException {
        view.displayCreateDVDBanner();
        boolean hasErrors = false;
        do {
            DVD newDVD = view.getNewDVDInfo();
            try {
                service.addDVD(newDVD.getUPC(), newDVD);
                view.displayCreateSuccessBanner();
                hasErrors = false;
            } catch (DVDLibraryDuplicateUPCException | DVDLibraryDataValidationException e) {
                hasErrors = true;
                view.displayErrorMsg(e.getMessage());
            }
        } while (hasErrors);
        }

    

    private void listDVDs() throws DVDLibraryPersistenceException {
        view.displayDisplayAllDVDsBanner();
        List<DVD> DVDList = service.getAllDVDs();
        view.displayDVDList(DVDList);
    }

    private void viewDVD() throws DVDLibraryPersistenceException {
        view.displayDVDBanner();
        String UPC = view.getUPCChoice();
        DVD DVD = service.getDVD(UPC);
        view.displayDVD(DVD);
        view.displayContinuePrompt();
    }

    private void removeDVD() throws DVDLibraryPersistenceException {
        view.displayRemoveDVDBanner();
        String UPC = view.getUPCChoice();
        DVD DVD = service.getDVD(UPC);
        view.displayDVD(DVD);
        //String UserConfirmation = view.getUserConfirmationToContinue();
        if(view.getUserConfirmationToContinue().equalsIgnoreCase("y")){
        service.removeDVD(UPC);
        view.displayRemoveSuccessBanner();} else{
            view.displayExitConfirmation();
        }
        
        // I'd like to make the view display the DVD info to the user and have
        // them confirm deletion prior to displaying success banner.
    }

    private void editDVD() throws DVDLibraryPersistenceException {
        view.displayEditDVDBanner();
        boolean hasErrors = false;
        do{
        DVD newDVD = view.getNewDVDInfo();
        try{
        service.addDVD(newDVD.getUPC(), newDVD);
        view.displayEditSuccessBanner();
        hasErrors = false;
        } catch (DVDLibraryDuplicateUPCException | DVDLibraryDataValidationException e){
            hasErrors = true;
            view.displayErrorMsg(e.getMessage());
        }
        } while (hasErrors);
    }

    private void searchByTitle() throws DVDLibraryPersistenceException {
        view.displaySearchByTitleBanner();
        String keyword = view.getTitleChoice();
        List<DVD> DVDList = service.getAllDVDs();
        for (DVD item : DVDList) {
            if (item.getTitle().contains(keyword)) {
                view.displayDVD(item);
            } 
        }
        view.displayContinuePrompt();

    }

    private void unknownCommand() {
        view.displayUnknownCommandMsg();
    }

    private void exitMsg() {
        view.displayExitBanner();
    }
}
