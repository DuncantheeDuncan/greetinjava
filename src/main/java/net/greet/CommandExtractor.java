package net.greet;

public class CommandExtractor {

   private String name;
    private String command;
    private String Language;

    CommandExtractor(String command) {

        if (command == null || command.trim().length() == 0) {
            this.command = "help";
        }
        else {
            String[] commandsOfArrays = command.split(" ");

            this.command = commandsOfArrays[0];
            if (commandsOfArrays.length >= 2) {

                this.name = commandsOfArrays[1];
            } else {
                this.name = "";
            }

            if (commandsOfArrays.length == 3) {
                this.Language = commandsOfArrays[2];
            } else {
                this.Language = "zulu";
            }
        }

    }


    public String getName() {

        return name;
    }

    public String getCommand() {
        return command;
    }

    public String getLanguage() {
        return Language;
    }

    public boolean hasName() {
        return !name.isEmpty();
    }

}
