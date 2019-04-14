
package greetings;

import java.util.HashMap;
import java.util.Map;

public class GreetBase implements Commands {

    private  int greetCounter = 1;

    Map< String, Integer> namesMap = new HashMap<>();

    public int totalNoOfDifferentnamesGreeted(){
        int tnumberGreeted = 0;
        for (Integer nameCount :namesMap.values()){
            tnumberGreeted+=nameCount;


        }
        System.out.println( namesMap);
        return tnumberGreeted;

    }

    public String greet(String name, String language) { //  works..
        if(!namesMap.containsKey(name)){
//            System.out.println("EXECUTED1");
            namesMap.put(name,0);// Zero makes my test 'totalNumberOfDifferentnamesGreeted' to pass
        }
        int usernameCounter = namesMap.get(name);
        usernameCounter++;
        namesMap.put(name, usernameCounter);

        // System.out.println(Languages.valueOf(language).getGreeting() + ", " + name+ " "+ usernameCounter);// remove userconter

        return Languages.valueOf(language).getGreeting() + ", " + name;
    }

    public void clear(){
        namesMap.clear();

    }

/////////

    public   void counterNUmber(int numOfUsers){
    greetCounter+= numOfUsers;
    numOfUsers++;

    }

    public int counter() {

        return greetCounter;
    }





   /* public String greet(String name, String lang) {
        if (namesMap.containsKey(name)) {
            namesMap.put(name, namesMap.get(name) + 1);
        }

        namesMap.put(name, greetCounter);

        return Languages.valueOf(lang).getGreeting() + " " + name;
    }*/




    public Map<String, Integer> greeted() {



        return namesMap;
    }



    public void exit() {

        System.exit(0);

    }

  public String help(){
        String n ="\t\tCOMMANDS THAT CAN BE USED\n\n"+
                "greet\t---->\tname (default language)\n"+
                "greet\t---->\tname\t---->\tlanguage\n"+
                "greeted\t---->\treturns a map{}\n"+
                "greeted\t---->\tname (returns number of times name have been greeted\n"+
                "counter\t---->\treturns unique names been greeted\n"+
                "clear\t---->\tset the map{} to 0\n"+
                "clear\t---->\tname (decrease the counter by 1)\n+" +
                "exit\t---->\texits the application\n\n";

        return n;
    }



    //////////////////////////////////////

    public int getCountForAllUser() {
        System.out.println("users "+namesMap);


        return namesMap.size();
    }
/////////////////////////////////////////////


    public void greetwithtwo(){
//        namesMap.
    }



}


