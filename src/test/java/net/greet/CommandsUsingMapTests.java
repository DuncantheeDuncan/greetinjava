package net.greet;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;
import static org.junit.Assert.assertEquals;
class CommandsUsingMapTests {
    @Test
    public void testGreet() throws SQLException, ClassNotFoundException {
        CommandsUsingMap commandsUsingMap = new CommandsUsingMap();

        assertEquals("Nǐ hǎo, Xui",commandsUsingMap.greet("Xui","chinese"));
        assertEquals("Saw'bona, Phumlani",commandsUsingMap.greet("Phumlani","zulu"));
        assertEquals("Molo, Mvulo",commandsUsingMap.greet("Mvulo","xhosa"));

    }

    @Test
     void getCounter() throws SQLException, ClassNotFoundException {
        CommandsUsingMap commandsUsingMap = new CommandsUsingMap();

        commandsUsingMap.greet("Steven","Venda");
        commandsUsingMap.greet("Steve","chinese");
        commandsUsingMap.greet("Jack","english");

        assertEquals("The total counter is (3)",commandsUsingMap.counter());

    }
//    Last stop ---------------------------------------------------------------------------
    @Test
    public void testHowManyTimesANameHasBeenGreeted() throws SQLException, ClassNotFoundException {
        CommandsUsingMap greetBase = new CommandsUsingMap();
        greetBase.greet("jack","xhosa");
        assertEquals(greetBase.greet("jack","xhosa"), "Molo, jack");
        assertEquals(greetBase.greet("jack","xhosa"), "Molo, jack");
        assertEquals(greetBase.greet("Xiou","chinese"), "Nǐ hǎo, Xiou");

        assertEquals("jack has been greeted 3 times",greetBase.greetedWithName("jack"));


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