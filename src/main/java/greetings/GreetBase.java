
package greetings;

import greetings.greet.JdbcGreet;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class GreetBase implements Commands {

    private  int greetCounter = 1;
    JdbcGreet db = new JdbcGreet();

    Map< String, Integer> namesMap = new HashMap<>();

    public GreetBase() throws SQLException {
    }

    public int totalNoOfDifferentnamesGreeted(){
        int tnumberGreeted = 0;
        for (Integer nameCount :namesMap.values()){
            tnumberGreeted+=nameCount;
        }
        System.out.println( namesMap);
//        return tnumberGreeted;
        return db.findUsers().size();
    }

    public String greet(String name, String language) {
        try {
            if (!namesMap.containsKey(name)) {
                namesMap.put(name, 0);
            }

            int usernameCounter = namesMap.get(name);
            usernameCounter++;
            namesMap.put(name, usernameCounter);
            return Languages.valueOf(language).getGreeting() + ", " + name;
        }
        catch (IllegalArgumentException e) {
            System.out.println(language.toUpperCase() + " language is not available yet. " );
            return Languages.valueOf("zulu").getGreeting() + ", " + name;
        }
    }

    public void clear(){
        namesMap.clear();
    }

    public int getCountForAllUser() {
        return namesMap.size();
    }

    public int counter() {
        return greetCounter;
    }

    public Map<String, Integer> greeted() {
//        return db.findUsers();

        return namesMap;
        }


    public void exit() {
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
    public int totalNumberGreeted(String namesGreeted){
        if (!namesMap.containsKey(namesGreeted)){
             namesMap.get(namesGreeted);
        }
       return namesMap.get(namesGreeted);
    }
}


