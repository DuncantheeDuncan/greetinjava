package greetings;

import greetings.Languages;

import greetings.GreetBase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class GreetTest {
    @Test
    public void testGreet(){
       GreetBase greetBase = new GreetBase();
       assertEquals(greetBase.greet("Xui","chinese"),"Nǐ hǎo, Xui");
       assertEquals(greetBase.greet("Phumlani","zulu"),"Saw'bona, Phumlani");
       assertEquals(greetBase.greet("Johan","english"),"Hello, Johan");
       assertEquals(greetBase.greet("Muziwakhe","xhosa"),"Molo, Muziwakhe");
    }

    @Test
    public void getCountForAllUser(){
        GreetBase greetBase = new GreetBase();

//        assertEquals(greetBase.greet("jack","xhosa"), "Molo, jack");
//        assertEquals(greetBase.greet("jack","chinese"), "Nǐ hǎo, jack");
        assertEquals(greetBase.greet("Johan","spanish"),"Saw'bona, Johan");
//        assertEquals(2,greetBase.getCountForAllUser());
        // returns only number of unique users/names
    }
    @Test
    public void testGreetednames(){
        GreetBase greetBase = new GreetBase();

        assertEquals(greetBase.greet("jack","xhosa"), "Molo, jack");
        assertEquals(greetBase.greet("jack","xhosa"), "Molo, jack");
        assertEquals(greetBase.greet("jack","xhosa"), "Molo, jack");
        assertEquals(greetBase.greet("Xiou","chinese"), "Nǐ hǎo, Xiou");

        assertEquals(3,greetBase.totalNumberGreeted("jack"));
        assertEquals(1,greetBase.totalNumberGreeted("Xiou"));

    }

    @Test
    public void testCounterNUmberFromBase(){
        GreetBase greetBase = new GreetBase();

        assertEquals(greetBase.greet("jack","xhosa"), "Molo, jack");
        assertEquals(greetBase.greet("Phumlani","zulu"), "Saw'bona, Phumlani");
        assertEquals(greetBase.greet("Phumlani","zulu"), "Saw'bona, Phumlani");
        assertEquals(greetBase.greet("Mabaso","english"), "Hello, Mabaso");

        assertEquals(4,greetBase.totalNoOfDifferentnamesGreeted());
        // this takes in duplicates
        }

}