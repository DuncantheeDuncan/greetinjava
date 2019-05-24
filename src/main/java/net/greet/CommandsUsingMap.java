
package net.greet;

import java.util.HashMap;
import java.util.Map;

public class CommandsUsingMap implements Commands {
    Map<String, Integer> namesMap = new HashMap<>();
    private int greetCounter = 1;

    public String exit() {
        System.exit(0);
        return "Till next time -:) goodbye!";
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

    public String clear() {
        namesMap.clear();
        return "cleared!!";
    }

    public String counter() {
        return "The total counter is (" + namesMap.size() + ")";
    }

    public String greet(String name, String language) {
//        name = name.substring(0,1).toUpperCase()+name.substring(1).toLowerCase();
        try {
            if (!namesMap.containsKey(name)) {
                namesMap.put(name, 0);
            }
            namesMap.put(name, namesMap.get(name) + 1);
            return Languages.valueOf(language).getGreeting() + ", " + name;
        } catch (IllegalArgumentException e) {
            return language.toUpperCase() + " language is not available yet. \n" + Languages.valueOf("zulu").getGreeting() + ", " + name;
        }
    }

    public String clearWithAName(String name) {
        if (namesMap.containsKey(name)) {
            namesMap.remove(name);
            return "successfully removed " + name.toUpperCase() + " from the list";
        } else {
            return "try greeting " + name.toUpperCase() + " first";
        }
    }
    public String greeted() {
        int totalNumberOfGreetedNames = 0;
        for (Integer nameCount : namesMap.values()) {
            totalNumberOfGreetedNames += nameCount;
        }
        return "Greeted Names:\n" + namesMap;
    }

    public String greetedWithName(String name) {
        try {
            int count = namesMap.get(name);
            return name + " has been greeted " + count + " times";
        } catch (NullPointerException e) {
            return name + " has not been greeted ";
        }
    }

}
