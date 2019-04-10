package greetings;

import java.util.HashMap;
import java.util.Map;

public enum Languages {

     Zulu("Saw'bona"),
    Xhosa("Molo"),
    English("Hello");

    private String greeting;

    Languages(String greeting) {
        this.greeting = greeting;

    }


    public String getGreeting() {

        return greeting;
    }
}
