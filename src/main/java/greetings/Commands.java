package greetings;

import java.util.Map;

public interface Commands {



    void exit();
    String help();
    void clear();
    String  counter();
    String greet(String name, String language);
    void clearWithAName(String name);
    String greeted();
    Map<String, Integer> greetedWithName();
//    String greetedWithName();






}


