
import greetings.Languages;
import greetings.greet.GreetPerson;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GreetTests {
    @Test
    public void testGreet(){
        GreetPerson greetAPerson = new GreetPerson();

        assertEquals(greetAPerson.greet("jack","Xhosa"), "Molo, jack");
        assertEquals(greetAPerson.greet("Phumlani","Zulu"), "Saw'bona, Phumlani");
        assertEquals(greetAPerson.greet("Phumlani","Zulu"), "Saw'bona, Phumlani");
        assertEquals(greetAPerson.greet("Mabaso","English"), "Hello, Mabaso");

    }

    @Test

    public void getCountForAllUser(){
        GreetPerson greetPerson =new GreetPerson();
        assertEquals(greetPerson.greet("jack","Xhosa"), "Molo, jack");
        assertEquals(greetPerson.greet("Phumlani","Zulu"), "Saw'bona, Phumlani");
        assertEquals(greetPerson.greet("Phumlani","Zulu"), "Saw'bona, Phumlani");
        assertEquals(3, greetPerson.getCountForAllUser());
    }
    @Test
    public void testGreetedNames(){
        GreetPerson greetPerson = new GreetPerson();
        assertEquals(greetPerson.greet("jack","Xhosa"), "Molo, jack");
        assertEquals(greetPerson.greet("Phumlani","Zulu"), "Saw'bona, Phumlani");
        assertEquals(greetPerson.greet("Phumlani","Zulu"), "Saw'bona, Phumlani");
        assertEquals(greetPerson.greet("Mabaso","English"), "Hello, Mabaso");

        assertEquals(2,greetPerson.totalNumberGreeted("Phumlani"));
        assertEquals(1,greetPerson.totalNumberGreeted("jack"));
        assertEquals(1,greetPerson.totalNumberGreeted("Mabaso"));

    }

    @Test
    public void totalNoOfDifferentNamesGreeted(){
        GreetPerson greetPerson =new GreetPerson();
        assertEquals(greetPerson.greet("jack","Xhosa"), "Molo, jack");
        assertEquals(greetPerson.greet("jack","Xhosa"), "Molo, jack");
        assertEquals(greetPerson.greet("jack","Xhosa"), "Molo, jack");
        assertEquals(greetPerson.greet("joe","English"), "Hello, joe");
        assertEquals(greetPerson.greet("Phumlani","Zulu"), "Saw'bona, Phumlani");
        assertEquals(greetPerson.greet("Mabaso","English"), "Hello, Mabaso");

        assertEquals(6,greetPerson.totalNoOfDifferentNamesGreeted());


    }

    @Test
    public void languageTest() {
        String userName = "Bheki", ullimi = "Xhosa";

        assertEquals(Languages.valueOf(ullimi).getGreeting(), "Saw'bona");
    }
}
