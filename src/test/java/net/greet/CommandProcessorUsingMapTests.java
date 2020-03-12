package net.greet;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandProcessorUsingMapTests {




    @Test
    void greetInZuluBYDefault() throws SQLException, ClassNotFoundException {
        Commands commands = new CommandsUsingMap();
        CommandProcessor commandProcessor = new CommandProcessor(commands);

        assertEquals("Saw'bona, Phumlani",commandProcessor.mainProcessor("greet Phumlani"));


    }

    @Test
    void  greetINaLanguage() throws SQLException, ClassNotFoundException {

        Commands commands = new CommandsUsingMap();
        CommandProcessor commandProcessor = new CommandProcessor(commands);
        assertEquals("Hello, Sthe",commandProcessor.mainProcessor("greet Sthe english"));
    }
    @Test
    void greetWithoutName() throws SQLException, ClassNotFoundException {
        Commands commands = new CommandsUsingMap();
        CommandProcessor commandProcessor = new CommandProcessor(commands);

        assertEquals("please try greeting with a name ",commandProcessor.mainProcessor("greet"));
    }

    @Test
    void GreetWithInvalidLang() throws SQLException, ClassNotFoundException {
        Commands commands = new CommandsUsingMap();
        CommandProcessor commandProcessor = new CommandProcessor(commands);

        assertEquals("VENDA language is not available yet. \n" + "Saw'bona, Jabu",commandProcessor.mainProcessor("greet Jabu Venda"));
    }
    @Test
    void testCounter() throws SQLException, ClassNotFoundException {
        Commands commands = new CommandsUsingMap();
        CommandProcessor commandProcessor = new CommandProcessor(commands);

        commandProcessor.mainProcessor("clear");
        commandProcessor.mainProcessor("greet jabu");
        commandProcessor.mainProcessor("greet Jack");
        commandProcessor.mainProcessor("greet Mvelo");
        assertEquals("The total counter is (3)",commandProcessor.mainProcessor("counter"));

    }

    @Test
    void greetedWithAName() throws SQLException, ClassNotFoundException {
        Commands commands = new CommandsUsingMap();
        CommandProcessor commandProcessor = new CommandProcessor(commands);

        commandProcessor.mainProcessor("clear");
        commandProcessor.mainProcessor("greet Mazibuko");
        commandProcessor.mainProcessor("greet Mazibuko");
        assertEquals("Mazibuko has been greeted 2 times",commandProcessor.mainProcessor("greeted Mazibuko"));
    }
    @Test
    void greeted() throws SQLException, ClassNotFoundException {
        Commands commands = new CommandsUsingMap();
        CommandProcessor commandProcessor = new CommandProcessor(commands);

        commandProcessor.mainProcessor("clear");
        commandProcessor.mainProcessor("greet Mazwi");
        commandProcessor.mainProcessor("greet Muzi");
        commandProcessor.mainProcessor("greet Jackson");

        assertEquals("Greeted Names:\n{Mazwi=1, Muzi=1, Jackson=1}",commandProcessor.mainProcessor("greeted"));
    }
    @Test
    void clearWithname() throws SQLException, ClassNotFoundException {
        Commands commands = new CommandsUsingMap();
        CommandProcessor commandProcessor = new CommandProcessor(commands);

        commandProcessor.mainProcessor("clear");
        commandProcessor.mainProcessor("greet Musa");
        commandProcessor.mainProcessor("greet Njabulo");

        commandProcessor.mainProcessor("clear Musa");
        assertEquals("Greeted Names:\n{Njabulo=1}",commandProcessor.mainProcessor("greeted"));
    }
    @Test
    void clear() throws SQLException, ClassNotFoundException {
        Commands commands = new CommandsUsingMap();
        CommandProcessor commandProcessor = new CommandProcessor(commands);

        commandProcessor.mainProcessor("clear");
        commandProcessor.mainProcessor("greet musa");
        commandProcessor.mainProcessor("greet Njabulo");

        commandProcessor.mainProcessor("clear");

        assertEquals("The total counter is (0)",commandProcessor.mainProcessor("counter"));

    }

}
