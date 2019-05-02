package greetings.greet;

import greetings.GreetBase;


import java.sql.*;
import java.util.Scanner;

public class GreetAPerson {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //       <----------------  database -   -   --  -       --  ->
//        Class.forName("org.h2.Driver");
//
     //   final String jdbcURL = "jdbc:h2:./target/jdbc_greetinjava";
//
//        Connection conn = DriverManager.getConnection(jdbcURL, "sa", "");
//
//        PreparedStatement ps = conn.prepareStatement("select * from your_table where your_field = ?");
//
//        ps.setString(1, "query_value");
//
//        ResultSet rs = ps.executeQuery();
//
//        while(rs.next()) {
//            System.out.println(rs.getString("column_name"));
//        }
////        <----------------  -   - end of database  --  -       --  ->


        GreetBase greetBase = new GreetBase();
        JdbcGreet jdbcGreet = new JdbcGreet();
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
                            System.out.println(greetBase.totalNoOfDifferentnamesGreeted());
                        }else if(command.equals("help")){
                            System.out.println(greetBase.help());
                        }else if(command.equals("clear")){
                            greetBase.clear();

                        }else if(command.equals("greet")){
                            System.out.println("Expected greet + name  and or language name.\n");
                        }else if(command.equals("counter")){
                            System.out.println(greetBase.greeted().size());
                           // System.out.println(greetBase.getCountForAllUser());
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
                                int deletUserName = greetBase.greeted().remove(name);
                                System.out.println("successfully removed " + name.toUpperCase() + " from the list");
                            }
                            catch (NullPointerException e){
//                                String s =commandArray[1].toLowerCase();
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