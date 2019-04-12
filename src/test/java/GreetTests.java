
import greetings.Languages;
import greetings.greet.GreetAPerson;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GreetTests {
    @Test
    public void testGreet(){
       GreetAPerson greetperson =new GreetAPerson();



        assertEquals(greetperson.greet("jack","xhosa"), "Molo, jack");
        assertEquals(greetperson.greet("Phumlani","zulu"), "Saw'bona, Phumlani");
        assertEquals(greetperson.greet("Phumlani","zulu"), "Saw'bona, Phumlani");
        assertEquals(greetperson.greet("Mabaso","english"), "Hello, Mabaso");

    }

    @Test
    public void getCountForAllUser(){
        GreetAPerson greetPerson =new GreetAPerson();
        assertEquals(greetPerson.greet("jack","xhosa"), "Molo, jack");
        assertEquals(greetPerson.greet("Phumlani","zulu"), "Saw'bona, Phumlani");
        assertEquals(greetPerson.greet("Phumlani","zulu"), "Saw'bona, Phumlani");
        assertEquals(3, greetPerson.getCountForAllUser());
    }
    @Test
    public void testGreetedNames(){
        GreetAPerson greetPerson = new GreetAPerson();
        assertEquals(greetPerson.greet("jack","xhosa"), "Molo, jack");
        assertEquals(greetPerson.greet("Phumlani","zulu"), "Saw'bona, Phumlani");
        assertEquals(greetPerson.greet("Mabaso","english"), "Hello, Mabaso");

        assertEquals(1,greetPerson.totalNumberGreeted("Phumlani"));
        assertEquals(1,greetPerson.totalNumberGreeted("jack"));
        assertEquals(1,greetPerson.totalNumberGreeted("Mabaso"));

    }

    @Test
    public void totalNoOfDifferentNamesGreeted(){
        /*this test adds duplicates*/
        GreetAPerson greetPerson =new GreetAPerson();
        assertEquals(greetPerson.greet("jack","xhosa"), "Molo, jack");
        assertEquals(greetPerson.greet("jack","xhosa"), "Molo, jack");
        assertEquals(greetPerson.greet("chun li","chinese"), "Nǐ hǎo, chun li");
        assertEquals(greetPerson.greet("jack","xhosa"), "Molo, jack");
        assertEquals(greetPerson.greet("joe","english"), "Hello, joe");
        assertEquals(greetPerson.greet("Phumlani","zulu"), "Saw'bona, Phumlani");
        assertEquals(greetPerson.greet("Mabaso","english"), "Hello, Mabaso");

        assertEquals(7,greetPerson.totalNoOfDifferentNamesGreeted());


    }

    @Test
    public void languageTest() {
        String userName = "Bheki", ullimi = "xhosa";

      //  assertEquals(Languages.valueOf(ullimi).getGreeting(), "Saw'bona");
    }
}
