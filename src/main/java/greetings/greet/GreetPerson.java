package greetings.greet;

import greetings.Languages;

import java.util.HashMap;
import java.util.Map;

public class GreetPerson {

    Map< String, Integer> names = new HashMap<>();
   public int counter = 1;

    public String greet(String name, String language) {
        int j = 0;
        names.put(name, j);
        names.put(name,j);
//        names.put(name, 3);



        System.out.println(Languages.valueOf(language).getGreeting() + ", " + name);

        return Languages.valueOf(language).getGreeting() + ", " + name;
    }

    public int getCountForAllUser() {
        System.out.println(names.size() + counter); // conditional statements ?

        return names.size();
    }
}
