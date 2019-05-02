package greetings.greet;

import greetings.Languages;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import static java.lang.String.valueOf;


public class JdbcGreet {

    final String FIND_ALL_USERS_SQL = "select * from PERSON ";
    final String COUNT_ALL_GREETED_NAMES_SQL = "select count(*) from PERSON";
    final String PUT_INTO_THE_DB_SQL = "select * from PERSON";


    final PreparedStatement findAllUsersPreparedStatement;
    final PreparedStatement countAllGreetedNamesPreparedStatement;
    final PreparedStatement addUserToDBPreparedStatement;


    final String jdbcURL = "jdbc:h2:./target/jdbc_greetinjava";
    Connection conn;


    public JdbcGreet() throws SQLException {


//            Class.forName("org.h2.Driver");
        conn = DriverManager.getConnection(jdbcURL, "sa", "");

        findAllUsersPreparedStatement = conn.prepareStatement(FIND_ALL_USERS_SQL);
        countAllGreetedNamesPreparedStatement = conn.prepareStatement(COUNT_ALL_GREETED_NAMES_SQL);
        addUserToDBPreparedStatement = conn.prepareStatement(PUT_INTO_THE_DB_SQL);

    }

    Map<String, Integer> databaseNames = new HashMap<>();
       public Map<String, Integer> findUsers() {

        System.out.println("Querying from DataBase..");


        try {
            findAllUsersPreparedStatement.execute();
            countAllGreetedNamesPreparedStatement.execute();
            ResultSet rs = findAllUsersPreparedStatement.executeQuery(); //coming from db: database
//           ResultSet resultSet = countAllGreetedNamesPreparedStatement.executeQuery();

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
//            return Languages.valueOf(language).getGreeting() + ", " + name;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return databaseNames;
    }

    public  String greet(String name, String language) {
//           public Map<String, String>greet(){
        System.out.println("greeting from db");
        try{
            addUserToDBPreparedStatement.execute();
            ResultSet rs =addUserToDBPreparedStatement.executeQuery();
            while (rs.next()){

                name = rs.getString("name");
                language = rs.getString("language");
                databaseNames.put(name,1 );
                System.out.println("G "+databaseNames.put(name,counter));


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
    public String namesIndb(){
//        String names = s;
         String namesInTheDatabase = valueOf(databaseNames);
//        String s = databaseNames.get(names).toString();

        return namesInTheDatabase;
    }




}
