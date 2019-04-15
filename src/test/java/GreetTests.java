
import greetings.Languages;
import greetings.greet.GreetAPerson;
import greetings.GreetBase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GreetTests {
    @Test
    public void testGreet(){
       GreetAPerson greetperson =new GreetAPerson();
       GreetBase greetBase = new GreetBase();
       assertEquals(greetBase.greet("Phumlani","zulu"),"Saw'bona, Phumlani");



//        assertEquals(greetperson.greet("jack","xhosa"), "Molo, jack");
//        assertEquals(greetperson.greet("Phumlani","zulu"), "Saw'bona, Phumlani");
//        assertEquals(greetperson.greet("Phumlani","zulu"), "Saw'bona, Phumlani");
//        assertEquals(greetperson.greet("Mabaso","english"), "Hello, Mabaso");

    }

    @Test
    public void getCountForAllUser(){
        GreetAPerson greetPerson =new GreetAPerson();

        GreetBase greetBase = new GreetBase();
//        assertEquals(greetPerson.greet("jack","xhosa"), "Molo, jack");
//        assertEquals(greetPerson.greet("jack","chinese"), "Nǐ hǎo, jack");

        assertEquals(greetBase.greet("jack","xhosa"), "Molo, jack");
        assertEquals(greetBase.greet("jack","chinese"), "Nǐ hǎo, jack");

//        assertEquals(greetPerson.greet("Phumlani","zulu"), "Saw'bona, Phumlani");
//        assertEquals(greetPerson.greet("Phumlani","zulu"), "Saw'bona, Phumlani");
//        assertEquals(3, greetPerson.getCountForAllUser());
        assertEquals(1,greetBase.getCountForAllUser());
    }
    @Test
    public void testGreetednames(){
        GreetAPerson greetPerson = new GreetAPerson();
        GreetBase greetBase = new GreetBase();

//        assertEquals(greetPerson.greet("jack","xhosa"), "Molo, jack");
//        assertEquals(greetPerson.greet("Phumlani","zulu"), "Saw'bona, Phumlani");
//        assertEquals(greetPerson.greet("Mabaso","english"), "Hello, Mabaso");
//
//        assertEquals(1,greetPerson.totalNumberGreeted("Phumlani"));
//        assertEquals(1,greetPerson.totalNumberGreeted("Phumlani"));
//        assertEquals(1,greetPerson.totalNumberGreeted("jack"));
//        assertEquals(1,greetPerson.totalNumberGreeted("Mabaso"));

    }
// testting 'counterNUmber' from base
    @Test
    public void testCounterNUmberFromBase(){
        GreetAPerson greetPerson = new GreetAPerson();
        GreetBase greetBase = new GreetBase();

        assertEquals(greetBase.greet("jack","xhosa"), "Molo, jack");
        assertEquals(greetBase.greet("Phumlani","zulu"), "Saw'bona, Phumlani");
        assertEquals(greetBase.greet("Phumlani","zulu"), "Saw'bona, Phumlani");
        assertEquals(greetBase.greet("Mabaso","english"), "Hello, Mabaso");

        assertEquals(2,greetBase.totalNoOfDifferentnamesGreeted());


    }
    @Test
    public void totalNoOfDifferentnamesGreeted(){
        /*this test adds duplicates*/
        GreetAPerson greetPerson =new GreetAPerson();
        GreetBase greetBase = new GreetBase();
//        assertEquals(greetPerson.greet("jack","xhosa"), "Molo, jack");
        assertEquals(greetBase.greet("Phumlani","zulu"),"Saw'bona Phumlani");
        assertEquals(greetBase.greet("Phumlani","zulu"),"Saw'bona Phumlani");
//        assertEquals(greetPerson.greet("jack","xhosa"), "Molo, jack");
//        assertEquals(greetPerson.greet("chun li","chinese"), "Nǐ hǎo, chun li");
//        assertEquals(greetPerson.greet("jack","xhosa"), "Molo, jack");
//        assertEquals(greetPerson.greet("joe","english"), "Hello, joe");
//        assertEquals(greetPerson.greet("Phumlani","zulu"), "Saw'bona, Phumlani");
//        assertEquals(greetPerson.greet("Mabaso","english"), "Hello, Mabaso");

//        assertEquals(7,greetPerson.totalNoOfDifferentnamesGreeted());
        assertEquals(1,greetBase.totalNoOfDifferentnamesGreeted());


    }

    @Test
    public void languageTest() {
        String username = "Bheki", ullimi = "xhosa";

      //  assertEquals(Languages.valueOf(ullimi).getGreeting(), "Saw'bona");
    }
}
