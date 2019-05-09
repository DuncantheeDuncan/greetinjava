package greetings;

public enum Languages {

    zulu("Saw'bona"),
    xhosa("Molo"),
    chinese("Nǐ hǎo"),
    english("Hello");

//    java -cp target/greet-in-java-1.0-SNAPSHOT.jar greetings.greet.GreetAPerson
    private String greeting;

    Languages(String greeting) {
        this.greeting = greeting;

    }


    public String getGreeting() {

        return greeting;
    }
}
