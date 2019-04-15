package greetings.greet;

import greetings.GreetBase;
import greetings.Languages;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GreetAPerson {
//    Map< String, Integer> namesMap = new HashMap<>();

//    GreetBase greetBase = new GreetBase();



//    public String greet(String name, String language) {
//        if(!namesMap.containsKey(name)){
////            System.out.println("EXECUTED1");
//            namesMap.put(name,0);// Zero makes my test 'totalNumberOfDifferentnamesGreeted' to pass
//        }
//
//
//        int usernameCounter = namesMap.get(name);
//        usernameCounter++;
//        namesMap.put(name, usernameCounter);
//
//        System.out.println(Languages.valueOf(language).getGreeting() + ", " + name+ " "+ usernameCounter);
//
//        return Languages.valueOf(language).getGreeting() + ", " + name;
//    }



//    public int totalNoOfDifferentnamesGreeted(){
//        int tnumberGreeted = 0;
//        for (Integer nameCount :namesMap.values()){
//
//            tnumberGreeted+=nameCount;
//            System.out.println("EXECUTED3 New user found " + tnumberGreeted+" ");
//        }
//        return tnumberGreeted;
//    }



//    public int totalNumberGreeted(String namesGreeted){
//        if (!namesMap.containsKey(namesGreeted)){
////            System.out.println("EXECUTED2");
////            return ;
//        }
//        System.out.println(namesGreeted+" names greeted ");
//        return namesMap.get(namesGreeted);
//    }



//    public void clear(){
//
//        namesMap.clear();
//
//    }


//
//    public void clear(String namesGreeted){
//        namesMap.put(namesGreeted,0);
//    }


//
//    public int getCountForAllUser() {
//        System.out.println("Total users this one "+namesMap.size());
//
//
//        return namesMap.size();
//    }







    public static void main(String[] args){
//        Map< String, Integer> namesMap = new HashMap<>();

        GreetBase greetBase = new GreetBase();
        GreetAPerson greetAPerson = new GreetAPerson();

        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Waiting for your command... ");
            String commands = scanner.nextLine();
           // System.out.println(commands);
            String[] commandArray = commands.split(" ");
                try {
                    if (commandArray.length == 1){
                        String command = commandArray[0].toLowerCase(); // .trim() is not picking up?!!
                        if (command.equals("exit")) {
                            greetBase.exit();
                        }
                        else if (command.equals("greeted")) {// works but add duplicate
//
                            System.out.println(greetBase.totalNoOfDifferentnamesGreeted());
//

                        }else if(command.equals("help")){

                            System.out.println(greetBase.help());
                        }else if(command.equals("clear")){

                            greetBase.clear();
                        }else if(command.equals("greet")){

                            System.out.println("Expected greet + name  and or language name.\n");

                        }else if(command.equals("counter")){
                            System.out.println("counter not working yet ");
                        }else {

                            System.out.println("your command "+'"'+command.toUpperCase()+'"'+" is not recognised");
                        }

                    }

                }catch (Exception e){
                    System.out.println(e);
                    e.printStackTrace();
                }


                try {
                    if (commandArray.length == 2) {
                        String command = commandArray[0].toLowerCase();
                        if (command.equals("greet"))
                        {
                            String name = commandArray[1].toLowerCase();
                            String language = "zulu";
                            System.out.println(greetBase.greet(name, language));
                        }
                        else if (command.equals("greeted")){
                            String name = commandArray[1].toLowerCase();
                            int mapNumber  =  greetBase.greeted().get(name);
                            System.out.println(name +" have been greeted: "+ mapNumber + " time(s)");

                        }else if(command.equals("clear")){
                            String name =commandArray[1].toLowerCase();
                            int deletUserName = greetBase.greeted().remove(name);
                            System.out.println("successfully removed "+ name.toUpperCase()+" from the list");

                        }else {
                            String name = commandArray[1].toLowerCase();

                            System.out.println("your command "+'"'+command.toUpperCase()+
                                    '"'+'"'+name.toUpperCase()+'"'+
                                    "is not recognised try 'help'");
                        }
                    }

                }catch (Exception e){
                    System.out.println(e);
                    e.printStackTrace();
                }

                try {
                    if (commandArray.length == 3) {
                        String command = commandArray[0].toLowerCase();
                        if (command.equals("greet"))
                        {
                            String name = commandArray[1].toLowerCase();
                            String language = commandArray[2].toLowerCase();
                            System.out.println(greetBase.greet(name, language));
                        }else {
                            String name = commandArray[1].toLowerCase();
                            String language = commandArray[2].toLowerCase();
                            System.out.println("your command "+'"'+command.toUpperCase()+'"'
                                    +'"'+language.toUpperCase()+'"'+
                                    '"'+name.toUpperCase()+'"'+
                                    " is not recognised try 'help'");
                        }
//
                    }
                }catch (Exception e){
                    System.out.println(e);
                    e.printStackTrace();
                }


        }

    }



}