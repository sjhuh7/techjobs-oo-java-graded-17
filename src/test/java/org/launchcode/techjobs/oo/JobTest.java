package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;


public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();

        assertNotEquals("Job IDs should not be the same", job1.getId(),job2.getId());
    }
    @Test
    public void testJobConstructorSetsAllFields() {
        // Create a Job object using the full constructor
        Job job = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        // Test that the name is correctly set
        assertEquals("Product tester", job.getName());


        // Tests that employer is set correctly
        assertTrue("employer is supposed to be an instance of Employer", job.getEmployer() instanceof Employer);
        assertEquals("ACME", job.getEmployer().getValue());

        // Tests that location is set correctly
        assertTrue("location is supposed to be an instance of Location", job.getLocation() instanceof Location);
        assertEquals("Desert", job.getLocation().getValue());

        // Tests that positionType is set correctly
        assertTrue("positionType is supposed to be an instance of PositionType", job.getPositionType() instanceof PositionType);
        assertEquals("Quality control", job.getPositionType().getValue());

        // Test that coreCompetency is set correctly
        assertTrue("coreCompetency is supposed to be an instance of CoreCompetency", job.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", job.getCoreCompetency().getValue());
    }
    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        Job job2 = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        assertNotEquals("Two jobs that have the same values should not be equal", job1, job2);
    }
    //Test to see if it starts and ends with a new line
    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        String output= job.toString();
        assertTrue(output.startsWith(System.lineSeparator()));
        assertTrue(output.endsWith(System.lineSeparator()));      //Checking last character to see if it is a new line
        


    }
    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality Control"),
                new CoreCompetency("Persistence"));
        String expectedOutput = System.lineSeparator() +
                "ID: " +job.getId() + System.lineSeparator() +
                "Name: Product tester" + System.lineSeparator() +
                "Employer: ACME" + System.lineSeparator() +
                "Location: Desert" + System.lineSeparator() +
                "Position Type: Quality Control" + System.lineSeparator() +
                "Core Competency: Persistence" + System.lineSeparator();
        assertEquals(expectedOutput, job.toString());
    }
    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        String expectedOutput = System.lineSeparator() +
                "ID: " + job.getId() + System.lineSeparator() +
                "Name: Data not available" + System.lineSeparator() +
                "Employer: Data not available" + System.lineSeparator() +
                "Location: Data not available" + System.lineSeparator() +
                "Position Type: Data not available" + System.lineSeparator() +
                "Core Competency: Data not available" + System.lineSeparator();

        assertEquals(expectedOutput, job.toString());
    }


}

