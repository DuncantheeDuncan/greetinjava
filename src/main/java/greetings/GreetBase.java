
package greetings;

import greetings.greet.JdbcGreet;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class GreetBase implements Commands {

    private  int greetCounter = 1;
    JdbcGreet db = new JdbcGreet();

//    -----------------------------------------------------
    Map<String, Integer> databaseMap = new HashMap<>();
    Map< String, Integer> namesMap = new HashMap<>();
//   -----------------------------------------------------

    public GreetBase() throws SQLException, ClassNotFoundException {
    }






    public String DBCounter(){
        return db.greeted();
//        return databaseMap.size();
    }
    public void greetedDB(){
        System.out.println(db.greeted());
    }







//    public int counter() {
//        return greetCounter;
//    }




    public String greeted___(String name) {// greeted //  fix conditional statent if name exists
//    public String greeted__(String name){
        System.out.println("checking...");
//        if (namesMap.containsKey(namesMap.values())){
//            System.out.println("55555555");
//        }

        return String.valueOf(namesMap);

    }
    public int totalNumberGreeted(String namesGreeted){
        if (!namesMap.containsKey(namesGreeted)){
            namesMap.get(namesGreeted);
        }
        return namesMap.get(namesGreeted);
    }







    public void exit() { // exit
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
    public void clear(){
        namesMap.clear();
    }
    public String counter(){ //counter // getCountForAllUser
        return "The total counter is ("+namesMap.size()+")";
    }
    public String greet(String name, String language) {// greet // greet

        try {
            if (!namesMap.containsKey(name)) {
                namesMap.put(name, 0);
            }

            int usernameCounter = namesMap.get(name);
            usernameCounter++;
            namesMap.put(name, usernameCounter);
            return Languages.valueOf(language).getGreeting() + ", " + name;
//            return db.greet(name, language);// -----Database----
        }
        catch (IllegalArgumentException e) {
            System.out.println(language.toUpperCase() + " language is not available yet. " );
            return Languages.valueOf("zulu").getGreeting() + ", " + name;
        }
    }

    public void clearWithAName(String name) { //clear // greeted__

        System.out.println("checking...");
        if (namesMap.containsKey(name)) {
            namesMap.remove(name);
            System.out.println("successfully removed " + name.toUpperCase() + " from the list");
        } else {

            System.out.println("try greeting "+name.toUpperCase() + " first" );
        }

//        String map = String.valueOf(namesMap.remove(name));
//       return String.valueOf(namesMap.remove(name + "dddd" ));

//        return map+ "num";

    }
    public String greeted(){

        Map<String, Integer> databaseMap = new HashMap<>();
        int tnumberGreeted = 0;
        for (Integer nameCount :namesMap.values()){
            tnumberGreeted+=nameCount;
        }
        System.out.println( namesMap);

        return String.valueOf(namesMap);
    }

    public Map<String, Integer> greetedWithName() {


        return namesMap;
    }


////    public Map<String, Integer> greeted_DD() {// working for DATABASE
//    public String greeted_DD(){
//        System.out.println("checking...");
//        Map<String, Integer> databaseMap = new HashMap<>();
//
//        // return namesMap;
//        return db.greeted();///
////        return databaseMap;

//    }



}


