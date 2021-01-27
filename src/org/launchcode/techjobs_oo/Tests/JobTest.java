package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;


import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class JobTest {

    Job jobTest1;
    Job jobTest2;
    Job jobTest3;
    Job jobTest4;

    @Before
    public void createJobObject(){
        jobTest1 = new Job();
        jobTest2 = new Job();
        jobTest3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        jobTest4 = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobId(){
        assertEquals(1, jobTest1.getId());
        assertEquals(2, jobTest2.getId());
        assertTrue((jobTest2.getId())- (jobTest1.getId())== 1);
        assertEquals(1, jobTest2.getId()- jobTest1.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        assertEquals("Product tester", jobTest3.getName());
        assertEquals("ACME", jobTest3.getEmployer().getValue());
        assertEquals("Desert", jobTest3.getLocation().getValue());
        assertEquals("Quality control", jobTest3.getPositionType().getValue());
        assertEquals("Persistence", jobTest3.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality(){
        assertFalse(jobTest1.equals(jobTest2));
    }

    @Test
    public void testForBlankSpacesAtBeginningAndEnd(){
        Integer i = jobTest3.toString().length();
        assertEquals(0, jobTest3.toString().indexOf("\n"));
        assertTrue(jobTest3.toString().endsWith("\n"));
    }

    @Test
    public void TestThatEachLabelAndFieldIsStoredOnNewLine(){
        assertEquals('\n' , jobTest3.toString().charAt(jobTest3.toString().indexOf("Name: ")-1));
        assertEquals('\n' , jobTest3.toString().charAt(jobTest3.toString().indexOf("Employer: ")-1));
        assertEquals('\n' , jobTest3.toString().charAt(jobTest3.toString().indexOf("Location: ")-1));
        assertEquals('\n' , jobTest3.toString().charAt(jobTest3.toString().indexOf("Position Type: ")-1));
        assertEquals('\n' , jobTest3.toString().charAt(jobTest3.toString().indexOf("Core Competency: ")-1));
    }

    @Test
    public void testThatBlankFieldsContainErrorMessage(){
        assertEquals("Data not available", jobTest4.getEmployer().getValue());

    }






}
