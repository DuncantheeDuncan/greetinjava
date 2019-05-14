package net.greet;

import java.sql.SQLException;
import java.util.Map;

public interface Commands {

    void exit();
    String help();
    void clear();
    String  counter();
    String greet(String name, String language) throws SQLException;
    void clearWithAName(String name);
    String greeted();
//   String Map<String, Integer> greetedWithName();
//  ̣ String Map<String, Integer> greetedWithName();
    String greetedWithName(String name) throws SQLException;
}


