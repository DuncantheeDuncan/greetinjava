package greetings.greet;

import greetings.Languages;

import java.util.HashMap;
import java.util.Map;

public class GreetAPerson {

    Map< String, Integer> namesMap = new HashMap<>();
    private int counter = 1;

    public String greet(String name, String language) {
        if(!namesMap.containsKey(name)){
            System.out.println("EXECUTED1");
            namesMap.put(name,0);
        }


        int userNameCounter = namesMap.get(name);
        userNameCounter++;
        namesMap.put(name, userNameCounter);
        ///////////////////////////////////////
//        while (namesMap.size() > 1 ) {
//
////            System.out.println(counter+" THIS IS counter");
//
//            counter++;
//            break;
//        }
//        //////////////////

        System.out.println(Languages.valueOf(language).getGreeting() + ", " + name+ " "+ userNameCounter);

        return Languages.valueOf(language).getGreeting() + ", " + name;
    }



    public int totalNoOfDifferentNamesGreeted(){
        int tnumberGreeted = 0;
        for (Integer nameCount :namesMap.values()){

            tnumberGreeted+=nameCount;
            System.out.println("EXECUTED3 New user found " +tnumberGreeted+" ");
        }
        return tnumberGreeted;
    }



    public int totalNumberGreeted(String namesGreeted){
        if (!namesMap.containsKey(namesGreeted)){
            System.out.println("EXECUTED2");
            return 0;
        }
        System.out.println(namesGreeted+" names greeted ");
        return namesMap.get(namesGreeted);
    }



    public void clear(){

        namesMap.clear();

    }



    public void clear(String namesGreeted){
        namesMap.put(namesGreeted,0);
    }



    public int getCountForAllUser() {
        System.out.println("Total users "+namesMap.size());


        return namesMap.size();
    }
}
