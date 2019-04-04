
import greetings.greet.GreetPerson;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GreetTests {
 @Test
 public void testGreet(){
  GreetPerson greetperson = new GreetPerson();


  assertEquals(greetperson.greet("jack","Xhosa"), "Molo, jack");
  assertEquals(greetperson.greet("Phumlani","Zulu"), "Saw'bona, Phumlani");
  assertEquals(greetperson.greet("Phumlani","English"), "Hello, Phumlani");
  assertEquals(2, greetperson.getCountForAllUser());


 }

}
