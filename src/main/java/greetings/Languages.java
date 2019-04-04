package greetings;

public enum Languages {

     zulu("Sawubona"),
    Xhosa("Molo"),
    English("Hello");
private String Languages;
    Languages(String greeting) {

        this.Languages = greeting;
        System.out.println(greeting);
    }


    public void setLanguages(String languages) {
        Languages = languages;
    }
}
