import greetings.greet.Greet;
import greetings.greet.GreetPerson;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GreetTests {
 @Test
 public void testGreet(){
  GreetPerson greetperson = new GreetPerson();


  assertEquals(greetperson.greet("Phumlani","Xhosa"), "Molo, Phumlani");
 assertEquals(1, greetperson.getCountForAllUser());


 }

}
