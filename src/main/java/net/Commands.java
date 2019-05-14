package net;

import java.sql.SQLException;

public interface Commands {

    void exit();
    String help();
    void clear();
    String  counter();
    String greet(String name, String language) throws SQLException;
    void clearWithAName(String name);
    String greeted();
//    Map<String, Integer> greetedWithName();
    String greetedWithName(String name);
}


