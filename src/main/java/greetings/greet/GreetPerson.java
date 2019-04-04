package greetings.greet;

import greetings.Languages;

import java.util.HashMap;
import java.util.Map;

public class GreetPerson {

    Map< String, Integer> names = new HashMap<>();

    public String greet(String name, String language) {
        names.put(name, 1);

        return Languages.valueOf(language).getGreeting() + ", " + name;
    }

    public int getCountForAllUser() {
        System.out.println(names);
        return names.size();
    }
}
