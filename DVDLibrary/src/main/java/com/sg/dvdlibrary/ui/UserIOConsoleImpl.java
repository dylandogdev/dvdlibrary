package com.sg.dvdlibrary.ui;


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author spookydylan
 */
public class UserIOConsoleImpl implements UserIO {
    
    Scanner sc = new Scanner(System.in);

    @Override
    public void print(String message) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println(message);
    }

    @Override
    public double readDouble(String prompt) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println(prompt);
        String newValue = sc.nextLine();
        double newValueDouble = Double.parseDouble(newValue);
        return newValueDouble;
        
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        double result;
        do {
            result = readDouble(prompt);
        } while (result < min || result > max);
        return result;
         
    }

    @Override
    public float readFloat(String prompt) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println(prompt);
        String newValue = sc.nextLine();
        float newValueFloat = Float.parseFloat(newValue);
        return newValueFloat;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        float result;
        do {
            result = readFloat(prompt);
        } while (result < min || result > max);

        return result;
    }

    @Override
    public int readInt(String prompt) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println(prompt);
        String newValue = sc.nextLine();
        int newValueInt = Integer.parseInt(newValue);
        return newValueInt;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int result;
        do {
            result = readInt(prompt);
        } while (result < min || result > max);

        return result;
    }
    

    @Override
    public long readLong(String prompt) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println(prompt);
        String newValue = sc.nextLine();
        long newValueLong = Long.parseLong(newValue);
        return newValueLong;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        long result;
        do {
            result = readLong(prompt);
        } while (result < min || result > max);

        return result;
    }

    @Override
    public String readString(String prompt) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println(prompt);
        String newString = sc.nextLine();
        return newString;
    }
    
}
