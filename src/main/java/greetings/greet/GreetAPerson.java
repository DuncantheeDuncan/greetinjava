package greetings.greet;

import greetings.GreetBase;


import java.sql.*;
import java.util.Scanner;

public class GreetAPerson {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        GreetBase greetBase = new GreetBase();
        JdbcGreet db = new JdbcGreet();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Waiting for your command... ");
            String commands = scanner.nextLine();
            String[] commandArray = commands.split(" ");
                try {

                    if (commandArray.length == 1){
                        String command = commandArray[0].toLowerCase();
                        if (command.equals("exit")) {//DONE
                            greetBase.exit();
                        }


                        else if (command.equals("greeted")) {
                            db.findUsers(); // dataBase
                            greetBase.totalNoOfDifferentnamesGreeted(); // In-Memory

                        }else if(command.equals("help")){
                            System.out.println(greetBase.help());

                        }else if(command.equals("clear")){ //DONE

                            db.clear(); // works as intended
                            greetBase.clear(); //In-Memory

                        }else if(command.equals("greet")){//DONE
                            System.out.println("Expected greet + name  and or language name.\n");

                        }else if(command.equals("counter")){//DONE

                            System.out.println("The total counter is ("+db.counter().size()+")"); // works as intended
                            System.out.println("The total counter is ("+greetBase.counter().size()+")");// In-Memory
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
                        if (command.equals("greet")){//DONE
                            String name = commandArray[1].toLowerCase();
                            String language = "zulu";
                            System.out.println(greetBase.greet(name, language));
                            System.out.println("from the database "+ db.greet(name, language));

                        }
                        else if (command.equals("greeted")){
                            try {
                                String name = commandArray[1].toLowerCase();
//                                int mapNumber = greetBase.greeted___(name);
                                greetBase.greeted___();
// __ is for counter ____ 3 under score is for greeted
                                System.out.println(name + " have been greeted: " + greetBase.greeted___().size()+ " time(s)");
                            }
                            catch (NullPointerException e){
                                String name = commandArray[1].toLowerCase();
                                System.out.println("this person "+"("+name.toUpperCase() +")"+ " has not been greeted yet");
                                //return  ;
                            }


                        }else if(command.equals("clear")){
                            String name =commandArray[1].toLowerCase();
                            try {
//                                System.out.println(db.clearNames(name)); // works as intended database
//                                int deletUserName = greetBase.greeted__().remove(name);
//                                System.out.println("successfully removed " + name.toUpperCase() + " from the list 1");
                            }
                            catch (NullPointerException e){
                               System.out.println("try greeting "+name.toUpperCase() + " first" );
                            }


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
                    if (commandArray.length == 3) {
                        String command = commandArray[0].toLowerCase();
                        if (command.equals("greet"))
                        {
                            String name = commandArray[1].toLowerCase();
                            String language = commandArray[2].toLowerCase();
                            System.out.println(greetBase.greet(name, language));
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