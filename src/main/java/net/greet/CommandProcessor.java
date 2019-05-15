package net.greet;

public class CommandProcessor {

    public static void main (String[] args){
        CommandExtractor commandExtractor = new CommandExtractor("greet Lungelo zulu");
        CommandsUsingMap db = new CommandsUsingMap();

        if (commandExtractor.getCommand().equals("greet")){
            if(!commandExtractor.getName().isEmpty()){


                db.greet("Phumlani","zulu");

//                System.out.println("phumlani beeen greeted");
            }


        }
    }

}
