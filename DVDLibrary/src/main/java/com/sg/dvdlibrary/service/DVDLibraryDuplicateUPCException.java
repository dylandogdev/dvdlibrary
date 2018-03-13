/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.service;

/**
 *
 * @author spookydylan
 */
public class DVDLibraryDuplicateUPCException extends Exception {
    
    public DVDLibraryDuplicateUPCException (String message){
        super(message);
    }
    
    public DVDLibraryDuplicateUPCException (String message,
        Throwable cause){
        super(message, cause);
    }
}
