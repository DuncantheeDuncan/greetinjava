package greetings;

import java.util.Map;

public interface Commands {



//    String greet(String name, String lang);
//    Map<String, Integer> greeted();


    void clear();
    String help(); // returns help
    void exit(); // exit the  application
    int counter(); //counts unique users
    int totalNoOfDifferentnamesGreeted();




}


