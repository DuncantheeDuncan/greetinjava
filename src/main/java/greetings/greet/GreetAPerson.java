package greetings.greet;

import greetings.GreetBase;
import greetings.Languages;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GreetAPerson {
    Map< String, Integer> namesMap = new HashMap<>();

//    GreetBase greetBase = new GreetBase();

//    private int counter = 1;

    public String greet(String name, String language) {
        if(!namesMap.containsKey(name)){
            System.out.println("EXECUTED1");
            namesMap.put(name,0);// Zero makes my test 'totalNumberOfDifferentNamesGreeted' to pass
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
            System.out.println("EXECUTED3 New user found " + tnumberGreeted+" ");
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



    public static void main(String[] args){
      //  Map< String, Integer> namesMap = new HashMap<>();
        GreetBase greetBase = new GreetBase();
        //GreetAPerson greetPerson = new GreetAPerson();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Waiting for your command... ");
            String commands = scanner.nextLine();
           // System.out.println(commands);
            String[] commandArray = commands.split(" ");

            if (commandArray.length == 1){
                String command = commandArray[0].toLowerCase(); // .trim() is not picking up?!!
                if (command.equals("exit")) {
                    greetBase.exit();
                }
                else if (command.equals("greeted")) {
                    System.out.println(greetBase.greeted());
                }else if(command.equals("help")){

                    System.out.println(greetBase.help());
                }else if(command.equals("clear")){

                    greetBase.clear();
                }else if(command.equals("greet")){

                    System.out.println("Expected greet + Name  and or language name.\n");

                }else if(command.equals("counter")){
                    System.out.println(greetBase.counter());// to Fix the counter
                }
                else {
                    System.out.println("Invalid command Try 'Help' \n");
                }

            }


            if (commandArray.length == 2) {
                String command = commandArray[0].toLowerCase();
                if (command.equals("greeted")) {
                    String name = commandArray[1].toLowerCase();
                    System.out.println(greetBase.greeted());
                }
            }



            else if (commandArray.length == 3) {
                String command = commandArray[0].toLowerCase();
                if (command.equals("greet")) {
                    String name = commandArray[1].toLowerCase();
                    String language = commandArray[2].toLowerCase();
                    System.out.println(greetBase.greet(name, language));
                }
//
            }
        }

    }



}