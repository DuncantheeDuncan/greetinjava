package net.greet;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

class CommandsUsingMapTests {
    @Test
    public void testGreet() throws SQLException, ClassNotFoundException {
        CommandsUsingMap greetBase = new CommandsUsingMap();
        assertEquals(greetBase.greet("Xui","chinese"),"Nǐ hǎo, Xui");
        assertEquals(greetBase.greet("Phumlani","zulu"),"Saw'bona, Phumlani");
        assertEquals(greetBase.greet("Johan","english"),"Hello, Johan");
        assertEquals(greetBase.greet("Muziwakhe","xhosa"),"Molo, Muziwakhe");
    }

    @Test
     void getCounter() throws SQLException, ClassNotFoundException {
        CommandsUsingMap greetBase = new CommandsUsingMap();
        assertEquals(greetBase.greet("jack","xhosa"), "Molo, jack");
        assertEquals(greetBase.greet("jack","chinese"), "Nǐ hǎo, jack");
        assertEquals(greetBase.greet("Johan","english"),"Hello, Johan");
        assertEquals("The total counter is (2)",greetBase.counter());

    }
    @Test
    public void testHowManyTimesANameHasBeenGreeted() throws SQLException, ClassNotFoundException {
        CommandsUsingMap greetBase = new CommandsUsingMap();
        greetBase.greet("jack","xhosa");
        assertEquals(greetBase.greet("jack","xhosa"), "Molo, jack");
        assertEquals(greetBase.greet("jack","xhosa"), "Molo, jack");
        assertEquals(greetBase.greet("Xiou","chinese"), "Nǐ hǎo, Xiou");

        assertEquals("jack has been greeted 3 times",greetBase.greetedWithName("jack"));
//        assertEquals("Xiou has been greeted 1 times",greetBase.greetedWithName("Xiou"));

    }
    @Test
    void testingTheNullLanguage() throws SQLException, ClassNotFoundException {
        CommandsUsingMap greetBase = new CommandsUsingMap();
        assertEquals(greetBase.greet("jack","shangan"), "Saw'bona, jack");
        assertEquals(greetBase.greet("jack","xhosa"), "Molo, jack");
        assertEquals(greetBase.greet("jack","spanish"), "Saw'bona, jack");
        assertEquals(greetBase.greet("jack","venda"), "Saw'bona, jack");

    }

    @Test
     void testGreeted() throws SQLException, ClassNotFoundException {
        CommandsUsingMap greetBase = new CommandsUsingMap();
        assertEquals(greetBase.greet("jack","xhosa"), "Molo, jack");
        assertEquals(greetBase.greet("Phumlani","zulu"), "Saw'bona, Phumlani");
        assertEquals(greetBase.greet("Phumlani","zulu"), "Saw'bona, Phumlani");
        assertEquals(greetBase.greet("Mabaso","english"), "Hello, Mabaso");

        assertEquals("{Mabaso=1, jack=1, Phumlani=2}",greetBase.greeted());
    }

    @Test
    void  greetedWithname(){//----------------------------
        CommandsUsingMap greetBase = new CommandsUsingMap();

        greetBase.greet("Yegan","xhosa");
        greetBase.greet("Yegan","xhosa");
        greetBase.greet("Phumlani","xhosa");


        assertEquals("Yegan has been greeted 2 times",greetBase.greetedWithName("Yegan"));


    }
    @Test
    void clearMap(){
        CommandsUsingMap greetBase  = new CommandsUsingMap();

        greetBase.greet("Sandile","chinese");
        greetBase.greet("Sifiso","xhosa");
        greetBase.greet("Phumlani","xhosa");

        greetBase.clear();

    }
    @Test
    void clearAName(){

        CommandsUsingMap greetBase = new CommandsUsingMap();
        greetBase.greet("Sandile","chinese");
        greetBase.greet("Sifiso","xhosa");
        greetBase.greet("Phumlani","xhosa");

        greetBase.clearWithAName("Sandile");
        greetBase.clearWithAName("Phumlani");
    }
}