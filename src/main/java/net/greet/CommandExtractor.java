package net.greet;

public class CommandExtractor {

    String name;
    String command;
    String Language;

    CommandExtractor(String command) {


        if (command == null || command.trim().length() == 0) {
            // the user entered nothing give them the help message
            this.command = "help";
        }
        else {
            String[] commandsOfArrays = command.split(" ");

            this.command = commandsOfArrays[0];
            if (commandsOfArrays.length >= 2) {

                this.name = commandsOfArrays[1];
            } else {
                this.name = " ";
            }

            if (commandsOfArrays.length == 3) {
                this.Language = commandsOfArrays[2];
            } else {
                this.Language = "zulu";
            }
        }

    }

    // getters
    public String getName() {

        return name;
    }

    public String getCommand() {

        return command;
    }

    public String getLanguage() {

        return Language;
    }


}
