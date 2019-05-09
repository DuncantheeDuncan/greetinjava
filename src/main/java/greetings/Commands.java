package greetings;

import java.util.Map;

public interface Commands {



    void exit();
    String help();
    void clear();
    String  counter();
    String greet(String name, String language);
    String clearWithAName(String name);
    String greeted();






}


