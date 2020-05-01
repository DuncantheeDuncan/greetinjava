package net.greet;

import java.sql.SQLException;

public interface Commands {

    void exit();
//    void exit(String confirmation);
    String help();
    String clear();
    String  counter();
    String greet(String name, String language) throws SQLException;
    String clearWithAName(String name) throws SQLException;
    String greeted();
    String greetedWithName(String name) throws SQLException;
}


