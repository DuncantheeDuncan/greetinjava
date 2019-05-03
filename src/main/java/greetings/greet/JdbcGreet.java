package greetings.greet;

import greetings.Languages;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import static java.lang.String.valueOf;


public class JdbcGreet {


    final String FIND_ALL_USERS_SQL = "select * from PERSON ";
    final String FIND_NAME_SQL = "select * from PERSON where name = ?";
    final String COUNT_ALL_GREETED_NAMES_SQL = "select count(*) from PERSON";
    final String PUT_INTO_THE_DB_SQL = "insert into PERSON (name, counter) values (?, ?)";
    final String UPDATE_NAME = "update PERSON set counter = counter + 1 where name = ?";




    final PreparedStatement findAllUsersPreparedStatement;
    final PreparedStatement countAllGreetedNamesPreparedStatement;
    final PreparedStatement addUserToDBPreparedStatement;
    final PreparedStatement updateName;
    final PreparedStatement findName;


    final String jdbcURL = "jdbc:h2:./target/jdbc_greetinjava";
    Connection conn;


    public JdbcGreet() throws SQLException, ClassNotFoundException {


            Class.forName("org.h2.Driver");
        conn = DriverManager.getConnection(jdbcURL, "sa", "");


        findAllUsersPreparedStatement = conn.prepareStatement(FIND_ALL_USERS_SQL);
        countAllGreetedNamesPreparedStatement = conn.prepareStatement(COUNT_ALL_GREETED_NAMES_SQL);
        addUserToDBPreparedStatement = conn.prepareStatement(PUT_INTO_THE_DB_SQL);
        updateName = conn.prepareStatement(UPDATE_NAME);
        findName = conn.prepareStatement(FIND_NAME_SQL);

    }

    Map<String, Integer> databaseNames = new HashMap<>();
       public Map<String, Integer> findUsers() {

        System.out.println("Querying from DataBase..");


        try {
//            findAllUsersPreparedStatement.execute();
//            countAllGreetedNamesPreparedStatement.execute();
            ResultSet rs = findAllUsersPreparedStatement.executeQuery(); //coming from db: database

            //if you are finding one user by name, use if not while
            while (rs.next()) {
                String name = rs.getString("name");
                int counter = rs.getInt("counter");
//                String language =rs.getString("language");
//             String   Languages.valueOf(language).getGreeting() = rs.getString("language");
                databaseNames.put(name, counter);
                System.out.println(databaseNames + name +" " + counter);
            }

            return databaseNames;


        } catch (Exception e) {
            e.printStackTrace();
        }

        return databaseNames;
    }

    public  String greet(String name, String language) {
//           public Map<String, String>greet(){
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
                databaseNames.put(nameDB, counter);
                System.out.println(databaseNames);


            }
           // return databaseNames+ Languages.valueOf(language).getGreeting();
//            return String.valueOf(databaseNames);
//            return Languages.valueOf(language).getGreeting() + ", " + name;


        }catch (Exception e){
            e.printStackTrace();

        }

//        return databaseNames+ Languages.valueOf(language).getGreeting();
        return Languages.valueOf(language).getGreeting() + ", " + name;
    }

    public int counter(){



        return databaseNames.size();
    }
    public String namesInDB(){
//        String names = s;
         String namesInTheDatabase = valueOf(databaseNames);
//        String s = databaseNames.get(names).toString();

        return namesInTheDatabase;
    }




}
