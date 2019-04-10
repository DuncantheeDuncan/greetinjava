package greetings;

import java.util.HashMap;
import java.util.Map;

public enum Languages {

     zulu("Saw'bona"),
    xhosa("Molo"),
    english("Hello");


    public String greeting;

   Languages(String greeting) {
        this.greeting = greeting;

    }


    public String getGreeting() {

        return greeting;
    }
}
