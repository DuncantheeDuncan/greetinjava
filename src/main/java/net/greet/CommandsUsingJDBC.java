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


    public String exit(){
        System.exit(0);
        return "";
    }
    public String help() {
        String help = "\t\tPOSSIBLE COMMANDS THAT CAN BE USED\n\n" +
                "type\tgreet\tname (default language)\n" +
                "type\tgreet\tname\t---->\tlanguage\n" +
                "type\tgreeted\treturns a map{}\n" +
                "type\tgreeted\tname (returns number of times name have been greeted\n" +
                "type\tcounter\treturns unique names been greeted\n" +
                "type\tclear\tset the map{} to 0\n" +
                "type\tclear\tname (decrease the counter by 1)\n" +
                "type\texit\texits the application\n\n";
        return help;
    }
    public String clear(){
        try {

            deleteAllNames.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "To make sure your command went successfully try 'counter' it should be set to 0. ";
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

        }
        try{
            return Languages.valueOf(language).getGreeting() + ", " + name;
        }catch (IllegalArgumentException e){
            return language.toUpperCase() + " language is not available yet. \n"+ Languages.valueOf("zulu").getGreeting() + ", " + name;

        }


    }
    public String clearWithAName(String name) throws SQLException {
        deleteANames.setString(1, name);
        deleteANames.executeUpdate();
        try {
            return "deleted";
        } catch (Exception e) {
            return "To make sure your command went successfully try 'greeted' it should not be there ";
        }
      }


    public String greeted(){
        Map<String, Integer> databaseMap = new HashMap<>();
        try {
            ResultSet rs = findAllUsersPreparedStatement.executeQuery();
            String name;
            int counter;
            while (rs.next()) {
                 name = rs.getString("name");
                 counter = rs.getInt("counter");
                databaseMap.put(name, counter);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return "Greeted Names:\n"+databaseMap;
    }


    public String greetedWithName(String person) throws SQLException {
        Map<String, Integer> databaseMap = new HashMap<>();
        findName.setString(1, person);

        ResultSet rs = findName.executeQuery();
        if (rs.next()) {
            int counter = rs.getInt("counter");
            databaseMap.put(person, counter);

            try {
                return person + " has been greeted " + counter + " times";
            } catch (Exception e) {
                return person + " has been greeted 0 times";
            }
            }

return null;
    }
}
