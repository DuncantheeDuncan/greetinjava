package net.greet;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import static java.lang.String.valueOf;
public class CommandsUsingJDBC implements Commands {


    final String FIND_ALL_USERS_SQL = "select * from PERSON "; // greeted
    final String FIND_NAME_SQL = "select * from PERSON where name = ?";
    final String PUT_INTO_THE_DB_SQL = "insert into PERSON (name, counter) values (?, ?)";
    final String UPDATE_NAME = "update PERSON set counter = counter + 1 where name = ?";
    final String DELETE_A_NAME_SQL = "delete PERSON  where name = ?"; //delete
    final String DELETE_ALL_FROM_DB_SQL = "delete PERSON";

    final PreparedStatement findAllUsersPreparedStatement;
    final PreparedStatement addUserToDBPreparedStatement;
    final PreparedStatement updateName;
    final PreparedStatement findName;
    final PreparedStatement deleteANames;
    final PreparedStatement deleteAllNames;

    final String jdbcURL = "jdbc:h2:./target/jdbc_greetinjava";
    Connection conn;

    public CommandsUsingJDBC() throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");
        conn = DriverManager.getConnection(jdbcURL, "sa", "");
        findAllUsersPreparedStatement = conn.prepareStatement(FIND_ALL_USERS_SQL);
        addUserToDBPreparedStatement = conn.prepareStatement(PUT_INTO_THE_DB_SQL);
        updateName = conn.prepareStatement(UPDATE_NAME);
        findName = conn.prepareStatement(FIND_NAME_SQL);
        deleteANames = conn.prepareStatement(DELETE_A_NAME_SQL);
        deleteAllNames = conn.prepareStatement(DELETE_ALL_FROM_DB_SQL);
    }


    public void exit(){
        System.exit(0);
    }
    public String help() {
        String n = "\t\tPOSSIBLE COMMANDS THAT CAN BE USED\n\n" +
                "greet\t---->\tname (default language)\n" +
                "greet\t---->\tname\t---->\tlanguage\n" +
                "greeted\t---->\treturns a map{}\n" +
                "greeted\t---->\tname (returns number of times name have been greeted\n" +
                "counter\t---->\treturns unique names been greeted\n" +
                "clear\t---->\tset the map{} to 0\n" +
                "clear\t---->\tname (decrease the counter by 1)\n" +
                "exit\t---->\texits the application\n\n";

        return n;
    }
    public void clear(){
        try {

            deleteAllNames.executeUpdate();
            System.out.println("To make sure your command went successfully try 'counter' it should be set to 0. ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String counter(){
        Map<String, Integer> databaseMap = new HashMap<>();
        try {
            findAllUsersPreparedStatement.execute();
            ResultSet rs = findAllUsersPreparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                int counter = rs.getInt("counter");
                databaseMap.put(name, counter);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return "The total counter is (" + databaseMap.size()+")";
    }
    public  String greet(String name, String language) throws IllegalArgumentException, SQLException  {
        Map<String, Integer> databaseMap = new HashMap<>();
        System.out.println("greeting from the Database");
        try{
            ResultSet rs = findAllUsersPreparedStatement.executeQuery();
            findName.setString(1, name);
            ResultSet resultSet = findName.executeQuery();

            if (resultSet.next()) {
                updateName.setString(1, name);
                updateName.execute();
            }
            else {
                addUserToDBPreparedStatement.setString(1, name);
                addUserToDBPreparedStatement.setInt(2, 1);
                addUserToDBPreparedStatement.execute();
            }
            while (rs.next()){
                String nameDB = rs.getString("name");
                int counter = rs.getInt("counter");
                databaseMap.put(nameDB, counter);
                System.out.println(databaseMap);
            }

            return Languages.valueOf(language).getGreeting() + ", " + name;
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            return language.toUpperCase() + " language is not available yet. \n"+ Languages.valueOf("zulu").getGreeting() + ", " + name;

        }


    }
    public void clearWithAName(String name){
        Map<String, Integer> databaseMap = new HashMap<>();

        try {
            deleteANames.setString(1, name);
            deleteANames.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("To make sure your command went successfully try 'greeted' it should not be there ");
      }
    public String greeted(){
        Map<String, Integer> databaseMap = new HashMap<>();
        System.out.println("Querying from DataBase...");
        try {
            ResultSet rs = findAllUsersPreparedStatement.executeQuery();
            System.out.println("Greeted names \tCounter");
            while (rs.next()) {
                String name = rs.getString("name");
                int counter = rs.getInt("counter");
                databaseMap.put(name, counter);
                System.out.println("-------> " + name+"\t"+counter );// verify...
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return String.valueOf(databaseMap);
    }


    public String greetedWithName(String person) throws SQLException {
        Map<String, Integer> databaseMap = new HashMap<>();
        System.out.println("Querying from DataBase...");

        findName.setString(1, person);

        ResultSet rs = findName.executeQuery();
        if (rs.next()) {
            int counter = rs.getInt("counter");
            databaseMap.put(person, counter);

            try {
                return person + " has been greeted " + counter + " timess";
            } catch (Exception e) {
                return person + " has been greeted 0 times";
            }
            }

return null;
    }




//    public String getDBNames(){
//        Map<String, Integer> databaseMap = new HashMap<>();
//        return databaseMap.toString() + "thuuuuuus";
//    }



//-----------------------------------------------------------------------
//    not yet fixed.
//-----------------------------------------------------------------------









//
//    public String namesInDB(){
////        String names = s;
//        Map<String, Integer> databaseMap = new HashMap<>();
//         String namesInTheDatabase = valueOf(databaseMap);
////        String s = databaseMap.get(names).toString();
//
//        return namesInTheDatabase;
//    }
}
