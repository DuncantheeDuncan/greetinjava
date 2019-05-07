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
                        if (command.equals("exit")) {
                            greetBase.exit();
                        }


                        else if (command.equals("greeted")) {
//                            System.out.println(greetBase.DBCounter()); // dataBase // works not as intended
//                            db.findUsers(); // dataBase
                            greetBase.totalNoOfDifferentnamesGreeted(); // In-Memory

                        }else if(command.equals("help")){
                            System.out.println(greetBase.help());

                        }else if(command.equals("clear")){

//                            db.clearTheWHoleDB(); // works as intended
                            greetBase.clear(); //In-Memory

                        }else if(command.equals("greet")){

                            System.out.println("Expected greet + name  and or language name.\n");

                        }else if(command.equals("counter")){
//                            System.out.println("The total counter is ("+db.counterDB().size()+")"); // works as intended

//                            ------------------------------------------------------------
//                            System.out.println(greetBase.greeted().size()); // works
//                            System.out.println(greetBase.DBCounter());
//                            System.out.println(db.counterDB().size()); // not working
//                            System.out.println("COUNTER CURRENTLY NOT WORKING FOR DATABASE!!!");
//                            ---------------------------------------------------------------
                            System.out.println(greetBase.getCountForAllUser());// In-Memory
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
                        if (command.equals("greet")){
                            String name = commandArray[1].toLowerCase();
                            String language = "zulu";
                            System.out.println(greetBase.greet(name, language));
//                            System.out.println("from the database "+ jdbcGreet.greet(name, language));

                        }
                        else if (command.equals("greeted")){
                            try {
                                String name = commandArray[1].toLowerCase();
                                int mapNumber = greetBase.greeted().get(name);

                                System.out.println(name + " have been greeted: " + mapNumber + " time(s)");
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
                                int deletUserName = greetBase.greeted().remove(name);
                                System.out.println("successfully removed " + name.toUpperCase() + " from the list");
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