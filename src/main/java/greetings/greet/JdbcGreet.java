package greetings.greet;

import greetings.Commands;
import greetings.Languages;
import org.h2.mvstore.Chunk;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import static java.lang.String.valueOf;


public class JdbcGreet implements Commands {


    final String FIND_ALL_USERS_SQL = "select * from PERSON "; // greeted
    final String FIND_NAME_SQL = "select * from PERSON where name = ?";
//    final String COUNT_ALL_GREETED_NAMES_SQL = "select count(*) from PERSON"; // counter
//    final String COUNT_ALL_GREETED_NAMES_SQL = "SELECT COUNT(*) FROM PERSON  WHERE  counter >0";// counter
    final String PUT_INTO_THE_DB_SQL = "insert into PERSON (name, counter) values (?, ?)";
    final String UPDATE_NAME = "update PERSON set counter = counter + 1 where name = ?";
    final String DELETE_A_NAME_SQL = "delete PERSON  where name = ?"; //delete
    final String DELETE_ALL_FROM_DB_SQL = "delete PERSON";




    final PreparedStatement findAllUsersPreparedStatement;
//    final PreparedStatement countAllGreetedNamesPreparedStatement;
    final PreparedStatement addUserToDBPreparedStatement;
    final PreparedStatement updateName;
    final PreparedStatement findName;
    final PreparedStatement deleteANames;
    final PreparedStatement deleteAllNames;


    final String jdbcURL = "jdbc:h2:./target/jdbc_greetinjava";
    Connection conn;



    public JdbcGreet() throws SQLException, ClassNotFoundException {


            Class.forName("org.h2.Driver");
        conn = DriverManager.getConnection(jdbcURL, "sa", "");


        findAllUsersPreparedStatement = conn.prepareStatement(FIND_ALL_USERS_SQL);
//        countAllGreetedNamesPreparedStatement = conn.prepareStatement(COUNT_ALL_GREETED_NAMES_SQL);
        addUserToDBPreparedStatement = conn.prepareStatement(PUT_INTO_THE_DB_SQL);
        updateName = conn.prepareStatement(UPDATE_NAME);
        findName = conn.prepareStatement(FIND_NAME_SQL);
        deleteANames = conn.prepareStatement(DELETE_A_NAME_SQL);
        deleteAllNames = conn.prepareStatement(DELETE_ALL_FROM_DB_SQL);

    }


    public void exit(){ //exits
        System.exit(0);

    }
    public String help() {//help
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
    public void clear(){ //clear


        System.out.println("deleting..");

        try {

            deleteAllNames.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Map<String,Integer> counter()  { //counter // counterDB
//        public int counterDB() throws SQLException {

//        findName.execute();
        Map<String, Integer> databaseMap = new HashMap<>();
        try {
            findAllUsersPreparedStatement.execute();
            ResultSet rs = findAllUsersPreparedStatement.executeQuery(); //coming from db: database

            while (rs.next()) {
                String name = rs.getString("name");
                int counter = rs.getInt("counter");
                databaseMap.put(name, counter);

//                System.out.println("-------> " + name +" \t" + counter);
            }

//        findName.execute();

//            System.out.println("--------- "+ databaseMap.size());

            return  databaseMap;

        }catch (Exception e){

        }

        return databaseMap;
    }
    public  String greet(String name, String language) {// greet // greet
        Map<String, Integer> databaseMap = new HashMap<>();
        System.out.println("greeting from db");
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
            // return databaseMap+ Languages.valueOf(language).getGreeting();
//            return String.valueOf(databaseMap);
            return Languages.valueOf(language).getGreeting() + ", " + name;


        }catch (Exception e){
            e.printStackTrace();

        }

//        return databaseMap+ Languages.valueOf(language).getGreeting();
        return Languages.valueOf(language).getGreeting() + ", " + name;
    }








    public Map<String, Integer> findUsers() {
           Map<String, Integer> databaseMap = new HashMap<>();

        System.out.println("Querying from DataBase..");
        try {
//            findAllUsersPreparedStatement.execute();
//            countAllGreetedNamesPreparedStatement.execute();
            ResultSet rs = findAllUsersPreparedStatement.executeQuery(); //coming from db: database

            //if you are finding one user by name, use if not while
            System.out.println("\tGreeted names: ");
            while (rs.next()) {
                String name = rs.getString("name");
                int counter = rs.getInt("counter");
                databaseMap.put(name, counter);

                System.out.println("-------> " + name);
            }

          //  return databaseMap;


        } catch (Exception e) {
            e.printStackTrace();
        }

        return databaseMap;
    }









    public String namesInDB(){
//        String names = s;
        Map<String, Integer> databaseMap = new HashMap<>();
         String namesInTheDatabase = valueOf(databaseMap);
//        String s = databaseMap.get(names).toString();

        return namesInTheDatabase;
    }


public String clearNames(String name){



//    System.out.println("deleting..");

    try {

        deleteANames.setString(1, name);
//        deleteANames.setInt(2,counter);

        deleteANames.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
    }

        return "Successfully removed " +name.toUpperCase()+ " from the list";
       }





    public Map<String, Integer> greeted_DD() {// working for DATABASE
        System.out.println("checking...");
       // return namesMap;
//        return db.findUsers();///
        return null;
    }

    public String greetName(String name, String lang) {


        return null;
    }
}
