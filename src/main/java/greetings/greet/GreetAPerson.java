package greetings.greet;

import greetings.GreetBase;


import java.sql.*;
import java.util.Scanner;

public class GreetAPerson {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        GreetBase db = new GreetBase();
        JdbcGreet db = new JdbcGreet();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Waiting for your command... ");
            String commands = scanner.nextLine();
            String[] commandArray = commands.split(" ");
                try {

                    if (commandArray.length == 1){
                        String command = commandArray[0].toLowerCase();
                        if (command.equals("exit")) {//DONE ------------------------------
                            db.exit();
                        }


                        else if (command.equals("greeted")) {//Done-------------------------
//                            db.greeted(); // dataBase
                            db.greeted(); // In-Memory

                        }else if(command.equals("help")){//DONE -----------------------------
                            System.out.println(db.help());

                        }else if(command.equals("clear")){ //DONE ---------------------------

//                            db.clear(); // works as intended
                            db.clear(); //In-Memory

                        }else if(command.equals("greet")){//DONE -------------------------------
                            System.out.println("Expected greet + name  and or language name.\n");

                        }else if(command.equals("counter")){//DONE -------------------------------

//                            System.out.println(db.counter()); // works as intended
                            System.out.println(db.counter());// In-Memory
                        }else {
                            System.out.println("your command "+'"'+command.toUpperCase()+'"'+
                                    " is not recognised try 'help'");
                        }
                    }
                }catch (Exception e){
                    System.out.println(e);
                    e.printStackTrace();
                }

                try {
                    if (commandArray.length == 2) {
                        String command = commandArray[0].toLowerCase();
                        if (command.equals("greet")){//DONE ----------------------------
                            String name = commandArray[1].toLowerCase();
                            String language = "zulu";
                            System.out.println(db.greet(name, language));
//                            System.out.println("from the database "+ db.greet(name, language));

                        }
                        else if (command.equals("greeted")){//DONE-------------------
                            try {
                                String name = commandArray[1].toLowerCase();
                                int mapNumber = db.greetedWithName().get(name);
//                                int mapNumber  =  db.greetedWithName().get(name);
                                System.out.println(name +" have been greeted: "+ mapNumber + " time(s)");
                            }
                            catch (Exception e){
                                String name = commandArray[1].toLowerCase();
                                System.out.println("this person "+"("+name.toUpperCase() +")"+ " has not been greeted yet");
                            }


                        }else if(command.equals("clear")){// DONE-----------------------------
                            String name =commandArray[1].toLowerCase();
                             // TO-DO  have a conditional statement.
//                                System.out.println(db.clearWithAName(name)); // works as intended database
//                                System.out.println( greetBase.clearWithAName(name));
//                                db.clearWithAName(name);
                                db.clearWithAName(name);
                        } else {
                            String name = commandArray[1].toLowerCase();

                            System.out.println("your command "+'"'+command.toUpperCase()+
                                    '"'+'"'+name.toUpperCase()+'"'+
                                    "is not recognised try 'help'");
                        }
                    }

                }catch (Exception e){
                    System.out.println(e);
                    e.printStackTrace();
                }
//      LAST STOP!!!
                try {
                    if (commandArray.length == 3) {// ------------------------DONE // Works but they might be a bug
                        String command = commandArray[0].toLowerCase();
                        if (command.equals("greet")) {//DONE-----------------------------------
                            String name = commandArray[1].toLowerCase();
                            String language = commandArray[2].toLowerCase();
//                            System.out.println(db.greet(name, language));
                            System.out.println(db.greet(name, language));
                        }else {
                            String name = commandArray[1].toLowerCase();
                            String language = commandArray[2].toLowerCase();
                            System.out.println("your command "+'"'+command.toUpperCase()+'"'
                                    +'"'+language.toUpperCase()+'"'+
                                    '"'+name.toUpperCase()+'"'+" is not recognised try 'help'");
                        }
                    }
                }catch (Exception e){
                    System.out.println(e);
                    e.printStackTrace();
                }
        }
    }
}