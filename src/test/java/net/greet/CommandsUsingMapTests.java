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

    @Test
    public void testHowManyTimesANameHasBeenGreeted() throws SQLException, ClassNotFoundException {
        CommandsUsingMap commandsUsingMap = new CommandsUsingMap();

        commandsUsingMap.greet("jack","xhosa");
        commandsUsingMap.greet("jack","xhosa");
        commandsUsingMap.greet("jack","xhosa");
        commandsUsingMap.greet("Xiou","chinese");

        assertEquals("jack has been greeted 3 times",commandsUsingMap.greetedWithName("jack"));


    }
    @Test
    void testingTheNullLanguage() throws SQLException, ClassNotFoundException {
        CommandsUsingMap commandsUsingMap = new CommandsUsingMap();

        commandsUsingMap.greet("jack","Spanish");
        assertEquals("SPANISH language is not available yet. \nSaw'bona, jack",commandsUsingMap.greet("jack","Spanish"));

    }

    @Test
     void testGreeted() throws SQLException, ClassNotFoundException {
        CommandsUsingMap commandsUsingMap = new CommandsUsingMap();

        commandsUsingMap.greet("jack","xhosa");
        commandsUsingMap.greet("Phumlani","zulu");
        commandsUsingMap.greet("Phumlani","zulu");
        commandsUsingMap.greet("Mabaso","english");

        assertEquals("{Mabaso=1, jack=1, Phumlani=2}",commandsUsingMap.greeted());
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