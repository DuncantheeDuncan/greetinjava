package greetings;

public enum Languages {

     Zulu("Sawubona"),
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
