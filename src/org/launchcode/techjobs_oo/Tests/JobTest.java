package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;

public class JobTest {

    Job jobTest1;
    Job jobTest2;
    Job jobTest3;

    @Before
    public void createJobObject(){
        jobTest1 = new Job();
        jobTest2 = new Job();
        jobTest3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
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
        assertEquals(1, jobTest1.getId(), .001);
        assertEquals(2, jobTest2.getId(), .001);
        assertFalse(jobTest1.equals(jobTest2));
    }


}
