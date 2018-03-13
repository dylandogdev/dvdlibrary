/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.ui;

import com.sg.dvdlibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author spookydylan
 */
public class DVDLibraryView {
    
    private UserIO io;
    
    public DVDLibraryView(UserIO io){
        this.io = io;
    }
    
    public String printMenuAndGetSelection(){
        io.print("Main Menu");
        io.print("1. Add DVD");
        io.print("2. Remove DVD");
        io.print("3. Display DVD");
        io.print("4. Edit Existing DVD");
        io.print("5. List all DVDs");
        io.print("6. Find DVD by Title");
        io.print("7. Exit");
        
        return io.readString("Please select from the above choices.");
    }
    
    public DVD getNewDVDInfo() {
        String UPC = io.readString("Enter UPC ");
        String title = io.readString("Enter title: ");
        String releaseYear = io.readString("Enter release year: ");
        String rating = io.readString("Enter MPAA rating or NR for not rated: ");
        String director = io.readString("Enter director: ");
        String studio = io.readString("Enter studio: ");
        String userNote = io.readString("Any notes? Add them here: ");
        DVD currentDVD = new DVD(UPC);
        currentDVD.setTitle(title);
        currentDVD.setReleaseYear(releaseYear);
        currentDVD.setRating(rating);
        currentDVD.setDirector(director);
        currentDVD.setStudio(studio);
        currentDVD.setUserNote(userNote);
        
        return currentDVD;
    }
    
    public void displayCreateDVDBanner(){
        io.print("=== Create/Edit DVD ===");
    }
    
    public void displayCreateSuccessBanner(){
        io.print("=== DVD Successfully Added. Press enter to continue ===");
    }
    
    public void displayDVDList(List<DVD> DVDList){
        for (DVD currentDVD : DVDList){
            if(currentDVD != null){
            io.print(currentDVD.getUPC() + " || "
            + currentDVD.getTitle() + " || "
            + currentDVD.getReleaseYear() + " || "
            + currentDVD.getRating() + " || "
            + currentDVD.getDirector() + " || "
            + currentDVD.getStudio() + " || "
            + currentDVD.getUserNote());
            } else if(DVDList == null){
                io.print("=== The DVD Library is Empty! ===");
            }
        }
        io.readString("Press enter to continue. ");
    }
    
    public void displayDisplayAllDVDsBanner(){
        io.print("=== Display All DVDs ===");
    }
    
    public void displayDVDBanner(){
        io.print("=== Display DVD ===");
    }
    
    public void displayContinuePrompt(){
        io.print("=== Press enter to continue. ===");
    }
    
    public String getTitleChoice(){
        return io.readString("Please enter the movie title. ");
    }
    
    public void displayDVD(DVD DVD){
        if (DVD != null){
            io.print("===============");
            io.print(DVD.getUPC() + " || "
            + DVD.getTitle() + " || "
            + DVD.getReleaseYear() + " || "
            + DVD.getRating() + " || "
            + DVD.getStudio() + " || "
            + DVD.getUserNote());
        } else {
            io.print("No DVDs found. ");
        }
    }
    
    
    
    public void displayRemoveDVDBanner(){
        io.print("=== Remove DVD ===");
    }
    
    public void displayRemoveSuccessBanner(){
        io.print("Success! DVD below was removed. Press enter to continue. ");
    }
    
    public void displayEditDVDBanner(){
        io.print("=== Edit DVD ===");
    }
    
    public void displayEditSuccessBanner(){
        io.print("DVD entry edited successfully. Press enter to continue. ");
    }
    
    public void displayUnknownCommandMsg(){
        io.print("Unknown Command!!! ");
    }
    
    public void displayExitBanner(){
        io.print("Good Bye!!! ");
    }
    
    public void displayErrorMsg(String errorMsg){
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
    
    public void displaySearchByTitleBanner(){
        io.print("=== Find DVD By Title ===");
    }
    
    public String getUPCChoice(){
        return io.readString("Please enter the DVD UPC: ");
        
    }
    
    public String getUserConfirmationToContinue(){
        return io.readString("Is this correct? Enter Y to continue, N to exit.");
    }
    
    public void displayExitConfirmation(){
        io.print("Cancelled. Return to menu.");
    }
}
