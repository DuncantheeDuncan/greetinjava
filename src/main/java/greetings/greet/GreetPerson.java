package greetings.greet;

import greetings.Languages;

import java.util.HashMap;
import java.util.Map;

public class GreetPerson {

    Map< String, Integer> names = new HashMap<>();
   private int counter = 1;

    public String greet(String name, String language) {
//        int j = 0;
        names.put(name, counter);
//        names.put(name,j);
////        names.put(name, 3);
//       for (int i = 1; i < 2;i++){
//           int sum = counter +=counter;
//           System.out.println(sum+" this is sum value");
//           names.put(name,sum);
//       }

        while (names.size() > 1 ) {

//            System.out.println(counter+" THIS IS counter");

            counter++;
            break;
        }


        System.out.println(Languages.valueOf(language).getGreeting() + ", " + name+ " "+ counter);

        return Languages.valueOf(language).getGreeting() + ", " + name;
    }

    public int getCountForAllUser() {
        System.out.println("Total users "+names.size());

        return names.size();
    }
}
