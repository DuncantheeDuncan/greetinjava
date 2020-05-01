package net.greet;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

public class CommandExtractorTests {

    @Test
    void greetInZulu(){
        CommandExtractor commandExtractor = new CommandExtractor("greet Jack zulu");

       assertEquals("greet",commandExtractor.getCommand());
       assertEquals("Jack",commandExtractor.getName());
       assertEquals("zulu",commandExtractor.getLanguage());

    }

    @Test
    void greetInEnglish(){
        CommandExtractor commandExtractor = new CommandExtractor("greet Jack english");

        assertEquals("greet",commandExtractor.getCommand());
        assertEquals("Jack",commandExtractor.getName());
        assertEquals("english",commandExtractor.getLanguage());

    }

    @Test
    void greetUsingDefaultLanguage(){
        CommandExtractor commandExtractor = new CommandExtractor("greet Jack");

        assertEquals("greet",commandExtractor.getCommand());
        assertEquals("Jack",commandExtractor.getName());
        assertEquals("zulu",commandExtractor.getLanguage());

    }

    @Test
    void greeted(){
        CommandExtractor commandExtractor = new CommandExtractor("greeted Jack");

        assertEquals("greeted",commandExtractor.getCommand());
        assertEquals("Jack",commandExtractor.getName());
        assertEquals("zulu",commandExtractor.getLanguage());
    }

    @Test
    void zero_Index(){
        CommandExtractor commandExtractor = new CommandExtractor("greet");

        assertEquals("greet",commandExtractor.getCommand());
    }

    @Test
    void emptyCommand(){
        CommandExtractor commandExtractor = new CommandExtractor("");
//        breaks

        assertEquals("help", commandExtractor.getCommand());
    }
    @Test
    void clearWithName(){
        CommandExtractor commandExtractor = new CommandExtractor("clear Jack");

        assertEquals("clear",commandExtractor.getCommand());
        assertEquals("Jack",commandExtractor.getName());

    }


}
