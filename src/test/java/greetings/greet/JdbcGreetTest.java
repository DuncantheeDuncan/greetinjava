package greetings.greet;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class jdbcGreetTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void testingConnection() throws SQLException, ClassNotFoundException {

        JdbcGreet db = new JdbcGreet();

        assertEquals("{axel=1}", db.findUsers().toString());

    }
    @Test
    void testingTheCounter() throws SQLException, ClassNotFoundException {

        JdbcGreet db = new JdbcGreet();


        assertEquals("{axel=1}", db.findUsers().toString());

//        assertEquals("{Phumlani=1}", db.findUsers().toString());
//        assertEquals("{axel=1}", db.findUsers().toString());
//        System.out.println("the counter is " +db.counterDB().size());
        assertEquals(1,db.counterDB().size());

    }

    @Test
    void testNamesIndb() throws SQLException, ClassNotFoundException {
        JdbcGreet jdbcGreet = new JdbcGreet();
//        assertEquals("{axel=1}",jdbcGreet.findUsers().toString());
        assertEquals("{axel=1}",jdbcGreet.findUsers().toString());
//        assertEquals(jdbcGreet.greet("jo","xhosa"),"Molo, jo");

        assertEquals("{axel=1}",jdbcGreet.namesInDB());
//        assertEquals("{jo=1}",jdbcGreet.namesInDB());



    }
    @Test
    void addingNmaesTodb() throws SQLException, ClassNotFoundException {
        JdbcGreet jdbcGreet =  new JdbcGreet();
//        assertEquals(greetBase.greet("jack","xhosa"), "Molo, jack");

        assertEquals(jdbcGreet.greet("Njabulo","xhosa"), "Molo, Njabulo");
        assertEquals(jdbcGreet.greet("jack","zulu"),"Saw'bona, jack");



    }
    @Test
    void DeleteName() throws SQLException, ClassNotFoundException {
        JdbcGreet jdbcGreet = new JdbcGreet();
//
        assertEquals("{axel=1}",jdbcGreet.findUsers().toString());

        assertEquals("axel deleted",jdbcGreet.clearNames("axel").toString());
    }
}