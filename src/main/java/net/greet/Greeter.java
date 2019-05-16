package net.greet;


import java.sql.*;
import java.util.Scanner;

public class Greeter {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        CommandsUsingMap db = new CommandsUsingMap();
//        CommandsUsingJDBC db = new CommandsUsingJDBC();

        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Waiting for your command... ");
            String commands = scanner.nextLine();

            CommandExtractor commandExtractor = new CommandExtractor(commands);

            // String[] commandArray = commands.split(" ");


//           if ("greeted".equals(commandExtractor.getCommand() && commandExtractor.getName())){
//                String name = commandExtractor.getName();
//                System.out.println(db.greetedWithName(name));
//            }
            if ("greeted".equals(commandExtractor.getCommand())) {
                if(commandExtractor.hasName()) {
                    System.out.println(db.greetedWithName(commandExtractor.getName()));
                } else {
                    db.greeted();
                }
            }
            if ("greet".equals(commandExtractor.getCommand())) {
                if (commandExtractor.hasName()){
                    String name = commandExtractor.getName(), language = commandExtractor.getLanguage();
                    System.out.println(db.greet(name, language));
                }
                //todo: check if hasName is true then greet person

            }


            if ("clear".equals(commandExtractor.getCommand())) {
                db.clear();
            }  if ("counter".equals(commandExtractor.getCommand())) {
                System.out.println(db.counter());
            }  if ("exit".equals(commandExtractor.getCommand())) {
                db.exit();
            }  if ("help".equals(commandExtractor.getCommand())) {
                System.out.println(db.help());
            }






//                try {
//                    if (getCommand.length == 1){
//                        String command = commandArray[0].toLowerCase();
//                        if (command.equals("exit")) {
//                            db.exit();
//                        }else if (command.equals("greeted")) {
//                            db.greeted();
//                        }else if(command.equals("help")){
//                            System.out.println(db.help());
//                        }else if(command.equals("clear")){
//                          db.clear();
//                        }else if(command.equals("greet")){
//                            System.out.println("Expected greet + name  and or language name.\n");
//                        }else if(command.equals("counter")){
//                            System.out.println(db.counter());
//                        }else {
//                            System.out.println("your command "+'"'+command.toUpperCase()+'"'+
//                                    " is not recognised try 'help'");
//                        }
//                    }
//                }catch (Exception e){
//                    System.out.println(e);
//                    e.printStackTrace();
//                }
//
//                try {
//                    if (commandArray.length == 2) {
//                        String command = commandArray[0].toLowerCase();
//                        if (command.equals("greet")){
//                            String name = commandArray[1].toLowerCase();
//                            String language = "zulu";
//                            System.out.println(db.greet(name, language));
//                        }else if (command.equals("greeted")){
//                            try {
////                                String name = commandArray[1].toLowerCase();
////                                System.out.println(db.greetedWithName(name));
//
//
//                            }
//                            catch (Exception e){
//                                String name = commandArray[1].toLowerCase();
//                                System.out.println("this person "+"("+name.toUpperCase() +")"+ " has not been greeted yet");
//                            }
//                        }else if(command.equals("clear")){
//                            String name =commandArray[1].toLowerCase();
//                                db.clearWithAName(name);
//                        } else {
//                            String name = commandArray[1].toLowerCase();
//                            System.out.println("your command "+'"'+command.toUpperCase()+
//                                    '"'+'"'+name.toUpperCase()+'"'+
//                                    "is not recognised try 'help'");
//                        }
//                    }
//
//                }catch (Exception e){
//                    System.out.println(e);
//                    e.printStackTrace();
//                }
//                try {
//                    if (commandArray.length == 3) {
//                        String command = commandArray[0].toLowerCase();
//                        if (command.equals("greet")) {
//                            String name = commandArray[1].toLowerCase();
//                            String language = commandArray[2].toLowerCase();
//                            System.out.println(db.greet(name, language));
//                        }else {
//                            String name = commandArray[1].toLowerCase();
//                            String language = commandArray[2].toLowerCase();
//                            System.out.println("your command "+'"'+command.toUpperCase()+'"'
//                                    +'"'+language.toUpperCase()+'"'+
//                                    '"'+name.toUpperCase()+'"'+" is not recognised try 'help'");
//                        }
//                    }
//                }catch (Exception e){
//                    System.out.println(e);
//                    e.printStackTrace();
//                }
        }
    }
}