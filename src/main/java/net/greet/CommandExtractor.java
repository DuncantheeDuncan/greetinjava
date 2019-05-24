package net.greet;

public class CommandExtractor {
    //todo: greeted + name should not return 'null' if name is not greeted
    //todo: greet + name should capitalize Name


    String name;
    String command;
    String Language;

    CommandExtractor(String command) {

        if (command == null || command.trim().length() == 0) {
            this.command = "help";
        }
        else {
            String[] commandsOfArrays = command.split(" ");

            this.command = commandsOfArrays[0];
            if (commandsOfArrays.length >= 2) {

                this.name = commandsOfArrays[1].toUpperCase();
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
