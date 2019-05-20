
package net.greet;

import java.util.HashMap;
import java.util.Map;
public class CommandsUsingMap implements Commands {
    private int greetCounter = 1;

    Map<String, Integer> namesMap = new HashMap<>();

    //todo: remove all the system out and return instead of printing

    public void exit() {
        System.out.println("Till next time -:) goodbye!");
        System.exit(0);
    }

    public String help() {
        String help = "\t\tPOSSIBLE COMMANDS THAT CAN BE USED\n\n" +
                "greet\t---->\tname (default language)\n" +
                "greet\t---->\tname\t---->\tlanguage\n" +
                "greeted\t---->\treturns a map{}\n" +
                "greeted\t---->\tname (returns number of times name have been greeted\n" +
                "counter\t---->\treturns unique names been greeted\n" +
                "clear\t---->\tset the map{} to 0\n" +
                "clear\t---->\tname (decrease the counter by 1)\n" +
                "exit\t---->\texits the application\n\n";
        return help;
    }

    public void clear() {
        namesMap.clear();
    }

    public String counter() {
        return "The total counter is (" + namesMap.size() + ")";

    }

    public String greet(String name, String language) {
        try {

//            System.out.println(namesMap+"1");//------------------
            if (!namesMap.containsKey(name)) {
//                System.out.println(namesMap+"2");//------------------
                namesMap.put(name, 0);
//                System.out.println(namesMap+"3");//------------------
            }
//            int usernameCounter = namesMap.get(name);
//            usernameCounter++;
            namesMap.put(name, namesMap.get(name) + 1);
//            System.out.println(namesMap+"4");//------------------
            return Languages.valueOf(language).getGreeting() + ", " + name;
        } catch (IllegalArgumentException e) {
            return language.toUpperCase() + " language is not available yet. \n"+ Languages.valueOf("zulu").getGreeting() + ", " + name;
        }
    }

    public void clearWithAName(String name) {
        if (namesMap.containsKey(name)) {
            namesMap.remove(name);

          System.out.println("successfully removed " + name.toUpperCase() + " from the list");
        } else {
            System.out.println("try greeting " + name.toUpperCase() + " first");
        }
    }

    public String greeted() {
//        System.out.println(namesMap+"1");//------------------
        int totalNumberOfGreetedNames = 0;
//        System.out.println(namesMap+"2");//------------------
        for (Integer nameCount : namesMap.values()) {
//            System.out.println(namesMap+"4");//------------------
            totalNumberOfGreetedNames += nameCount;

        }

        return "Greeted Names:\n"+namesMap;
    }

    public String greetedWithName(String name) {
        try {
            int count = namesMap.get(name);
            return name + " has been greeted " + count + " times";
        }catch (NullPointerException e) {
            return name + " has not been greeted ";
        }
    }

}


