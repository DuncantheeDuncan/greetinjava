package greetings.greet;

import greetings.GreetBase;

import java.sql.*;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JdbcGreet {

    final String FIND_ALL_USERS_SQL = "select * from PERSON";


    final PreparedStatement findAllUsersPreparedStatement;


    final String jdbcURL = "jdbc:h2:./target/jdbc_greetinjava";
    Connection conn;


     public JdbcGreet() throws SQLException{

//        try {
//            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection(jdbcURL, "sa", "");

            findAllUsersPreparedStatement = conn.prepareStatement(FIND_ALL_USERS_SQL);

//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public Map<String, Integer> findUsers() {
         Map<String, Integer> databaseNames = new HashMap<>();
        System.out.println("Quering from db");

       try {
            findAllUsersPreparedStatement.execute();
           ResultSet rs = findAllUsersPreparedStatement.executeQuery(); //coming from db: database

           //if you are finding one user by name, use if not while
           while (rs.next()){
                String name = rs.getString("name");
                int counter = rs.getInt("counter");
               databaseNames.put(name, counter);
           }

           return databaseNames;

       }catch (Exception e){
           e.printStackTrace();
       }

       return databaseNames;
    }


//    GreetBase greetBase = new GreetBase();
//    Scanner scanner = new Scanner(System.in);


//    {
//        System.out.println("Waiting for your command Database... ");
//        String commands = scanner.nextLine();
//        String[] commandArray = commands.split(" ");
//
//            if (commandArray.length == 1) {
//                String command = commandArray[0].toLowerCase();
//                if (command.equals("exit")) {
//                    greetBase.exit();
//                } else if (command.equals("help")) {
//                    System.out.println(greetBase.help());
//                } else if (command.equals("clear")) {
//                    greetBase.clear();
//
//                }
//            }
//
//
//    }

    }
