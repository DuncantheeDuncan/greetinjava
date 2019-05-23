package net.greet;

import java.sql.SQLException;

public class CommandProcessor {
    private Commands db;

    public CommandProcessor(Commands commands) throws SQLException, ClassNotFoundException {
        this.db = commands;
    }

    public String mainProcessor(String commandParts) throws SQLException {
        CommandExtractor commandExtractor = new CommandExtractor(commandParts);

        if (commandExtractor.getCommand().equals("greet")) {
            if (commandExtractor.hasName()) {
                return db.greet(commandExtractor.getName(), commandExtractor.getLanguage());
            } else {
                return "please try greeting with a name ";
            }
        } else if (commandExtractor.getCommand().equals("counter")) {
            return db.counter();
        } else if (commandExtractor.getCommand().equals("greeted")) {
            if (commandExtractor.hasName()) {
                return db.greetedWithName(commandExtractor.getName());
            } else {
                return db.greeted();
            }

        } else if (commandExtractor.getCommand().equals("clear")) {

            if (commandExtractor.hasName()) {
                return db.clearWithAName(commandExtractor.getName());
            } else {
                return db.clear();
            }
        } else if (commandExtractor.getCommand().equals("exit")) {
            return db.exit();
        } else if (commandExtractor.getCommand().equals("help")) {
            return db.help();
        }
        return "type help";
    }

}
