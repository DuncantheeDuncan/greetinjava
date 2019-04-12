package greetings;

public enum Languages {

    zulu("Saw'bona"),
    xhosa("Molo"),
    chinese("Nǐ hǎo"),
    english("Hello");


    private String greeting;

    Languages(String greeting) {
        this.greeting = greeting;

    }


    public String getGreeting() {

        return greeting;
    }
}
