package greetings;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class GreetBaseTest {

    @Test
    void totalNoOfDifferentnamesGreeted() {
//        assertEquals(1,1);
    }
    @Test
    public void testGreet() throws SQLException, ClassNotFoundException {
        GreetBase greetBase = new GreetBase();
        assertEquals(greetBase.greet("Xui","chinese"),"Nǐ hǎo, Xui");
        assertEquals(greetBase.greet("Phumlani","zulu"),"Saw'bona, Phumlani");
        assertEquals(greetBase.greet("Johan","english"),"Hello, Johan");
        assertEquals(greetBase.greet("Muziwakhe","xhosa"),"Molo, Muziwakhe");
    }


    @Test
     void getCountForAllUser() throws SQLException, ClassNotFoundException {
        GreetBase greetBase = new GreetBase();

        assertEquals(greetBase.greet("jack","xhosa"), "Molo, jack");
        assertEquals(greetBase.greet("jack","chinese"), "Nǐ hǎo, jack");
        assertEquals(greetBase.greet("Johan","english"),"Hello, Johan");
        assertEquals(2,greetBase.counter());
        // returns only number of unique users/names
    }
    @Test
    public void testGreetednames() throws SQLException, ClassNotFoundException {
        GreetBase greetBase = new GreetBase();

        assertEquals(greetBase.greet("jack","xhosa"), "Molo, jack");
        assertEquals(greetBase.greet("jack","xhosa"), "Molo, jack");
        assertEquals(greetBase.greet("jack","xhosa"), "Molo, jack");
        assertEquals(greetBase.greet("Xiou","chinese"), "Nǐ hǎo, Xiou");

        assertEquals(3,greetBase.totalNumberGreeted("jack"));
        assertEquals(1,greetBase.totalNumberGreeted("Xiou"));

    }
    @Test
    void testinTheNullLanguage() throws SQLException, ClassNotFoundException {
        GreetBase greetBase = new GreetBase();
        assertEquals(greetBase.greet("jack","shangan"), "Saw'bona, jack");
        assertEquals(greetBase.greet("jack","xhosa"), "Molo, jack");
        assertEquals(greetBase.greet("jack","spanish"), "Saw'bona, jack");
        assertEquals(greetBase.greet("jack","venda"), "Saw'bona, jack");

    }

    @Test
    public void testCounterNUmberFromBase() throws SQLException, ClassNotFoundException {
        GreetBase greetBase = new GreetBase();

        assertEquals(greetBase.greet("jack","xhosa"), "Molo, jack");
//        assertEquals(greetBase.greet("Phumlani","zulu"), "Saw'bona, Phumlani");
        assertEquals(greetBase.greet("Phumlani","zulu"), "Saw'bona, Phumlani");
//        assertEquals(greetBase.greet("Mabaso","english"), "Hello, Mabaso");

        assertEquals(1,greetBase.totalNoOfDifferentnamesGreeted());
//        assertEquals(4,greetBase.totalNoOfDifferentnamesGreeted());
        // this takes in duplicates
    }

}