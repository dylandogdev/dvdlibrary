/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.service;

import com.sg.dvdlibrary.dto.DVD;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author spookydylan
 */
public class DVDLibraryServiceLayerTest {
    
    private DVDLibraryServiceLayer service;
    
    public DVDLibraryServiceLayerTest() {
//        DVDLibraryDao dao = new DVDLibraryDaoStubImpl();
//        DVDLibraryAuditDao auditDao = new DVDLibraryAuditDaoStubImpl();
//        
//        service = new DVDLibraryServiceLayerImpl(dao, auditDao);
    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    service = ctx.getBean("DVDLibraryServiceLayer", DVDLibraryServiceLayer.class);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addDVD method, of class DVDLibraryServiceLayer.
     */
    @Test
    public void testAddDVD() throws Exception {
        DVD DVD = new DVD("02");
        DVD.setTitle("Wolfen");
        DVD.setReleaseYear("1988");
        DVD.setRating("R");
        DVD.setDirector("Alan Smithee");
        DVD.setStudio("FOX");
        DVD.setUserNote("Amazing performance by Wolfen.");
    }
    
    @Test
    public void testCreateDuplicateDVD() throws Exception{
        DVD DVD = new DVD("01");
        DVD.setTitle("Alien");
        DVD.setReleaseYear("1977");
        DVD.setRating("R");
        DVD.setDirector("Ridley Scott");
        DVD.setStudio("FOX");
        DVD.setUserNote("The Alien is real.");
        
        try{
            service.addDVD(DVD.getUPC(), DVD);
            fail("Expected DVDLibraryDuplicateUPCException was not thrown.");
        } catch(DVDLibraryDuplicateUPCException e){
            return;
        }
    }
    
    @Test
    public void testCreateDVDInvalidData() throws Exception{
        DVD DVD = new DVD("02");
        DVD.setTitle("");
        DVD.setReleaseYear("1988");
        DVD.setRating("R");
        DVD.setDirector("Alan Smithee");
        DVD.setStudio("FOX");
        DVD.setUserNote("Amazing performance by Wolfen.");
        
        try {
            service.addDVD(DVD.getUPC(), DVD);
            fail("Expected DVDLibraryDataValidationException was not thrown.");
        }catch (DVDLibraryDataValidationException e){
            return;
        }
    }

    /**
     * Test of getAllDVDs method, of class DVDLibraryServiceLayer.
     */
    @Test
    public void testGetAllDVDs() throws Exception {
        assertEquals(1, service.getAllDVDs().size());
    }

    /**
     * Test of getDVD method, of class DVDLibraryServiceLayer.
     */
    @Test
    public void testGetDVD() throws Exception {
        DVD aDVD = service.getDVD("01");
        assertNotNull(aDVD);
        aDVD = service.getDVD("99");
        assertNull(aDVD);
    }

    /**
     * Test of removeDVD method, of class DVDLibraryServiceLayer.
     */
    @Test
    public void testRemoveDVD() throws Exception {
        DVD aDVD = service.removeDVD("01");
        assertNotNull(aDVD);
        aDVD = service.removeDVD("99");
        assertNull(aDVD);
    }

    
}
