
package greetings;

import java.util.HashMap;
import java.util.Map;

public class GreetBase implements Commands {

    private  int greetCounter = 1;

    Map< String, Integer> namesMap = new HashMap<>();

    public   void counterNUmber(int numOfUsers){
    greetCounter+= numOfUsers;
    numOfUsers++;
    }

    public int counter() {


        return greetCounter;
    }



    public void clear(){
        namesMap.clear();

    }
    public String greet(String name, String lang) {
        if (namesMap.containsKey(name)) {
            namesMap.put(name, namesMap.get(name) + 1);
        }
        namesMap.put(name, greetCounter);

        return Languages.valueOf(lang).getGreeting() + " " + name;
    }
    public Map<String, Integer> greeted() {
        return namesMap;
    }

    public void exit() {

        System.exit(0);

    }

  public String help(){
        String n ="help! about !!";

        return n;
    }

}

