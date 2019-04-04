package greetings;

public abstract class GreetBase implements Commands {
private  int greetCounter = 0;

protected  void counterNUmber(int numOfUsers){
    greetCounter+= numOfUsers;

}


    public int counter() {


        return greetCounter;
    }


    // im setting the greet counter to 0
    //when clear() is called.
public void clear(){

    greetCounter = 0;

}

public void  exit(){
    System.exit(0);
}

}
