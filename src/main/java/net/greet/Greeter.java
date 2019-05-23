package net.greet;


import java.sql.*;
import java.util.Scanner;

public class Greeter {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
//        Commands commands = new CommandsUsingMap();
        Commands commands = new CommandsUsingJDBC();
        CommandProcessor commandProcessor = new CommandProcessor(commands);


        while (true) {
            System.out.println("Waiting for your command... ");
            String inputCommands = scanner.nextLine();
            System.out.println(commandProcessor.mainProcessor(inputCommands));
        }
}
}