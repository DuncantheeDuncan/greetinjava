package greetings;

import java.util.Map;

public interface Commands {

    int counter(); // counts the user greeted
    void clear();
    String greet(String name, String lang);
    Map<String, Integer> greeted();
    /*clear followed by a username delete
    the greet counter for the specified
    user and decrement the greet counter by 1,*/
//    String help(); // returns help
    void exit(); // exit the  application




}
