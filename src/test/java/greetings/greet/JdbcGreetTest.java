package greetings.greet;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class jdbcGreetTest {
    Connection conn;

    @BeforeEach
    void setUp() throws SQLException, ClassNotFoundException {
        JdbcGreet jdbcGreet = new JdbcGreet();
        conn = DriverManager.getConnection("jdbc:h2:./target/jdbc_greetinjava", "sa", "");
        Statement statement = conn.createStatement();
        statement.addBatch("delete from PERSON");
        statement.executeBatch();
    }

    @Test
    void testingConnection() throws SQLException, ClassNotFoundException {

        JdbcGreet db = new JdbcGreet();

        assertEquals("{phumlani=1}", db.greeted().toString());

    }

    @Test
    void testingTheCounter() throws SQLException, ClassNotFoundException {

        JdbcGreet db = new JdbcGreet();


        assertEquals("{phumlani=1}", db.greeted().toString());

//        assertEquals("{Phumlani=1}", db.findUsers().toString());
//        assertEquals("{phumlani=1}", db.findUsers().toString());
//        System.out.println("the counter is " +db.counterDB().size());
        assertEquals(1, db.counter());

    }

    @Test
    void testNamesIndb() throws SQLException, ClassNotFoundException {
        JdbcGreet jdbcGreet = new JdbcGreet();
//        assertEquals("{phumlani=1}",jdbcGreet.findUsers().toString());
        assertEquals("{phumlani=1}", jdbcGreet.greeted().toString());
//        assertEquals(jdbcGreet.greet("jo","xhosa"),"Molo, jo");

        assertEquals("{phumlani=1}", jdbcGreet.namesInDB());
//        assertEquals("{jo=1}",jdbcGreet.namesInDB());


    }

    @Test
    void addingNmaesTodb() throws SQLException, ClassNotFoundException {
        JdbcGreet jdbcGreet = new JdbcGreet();
//        assertEquals(greetBase.greet("jack","xhosa"), "Molo, jack");

        assertEquals(jdbcGreet.greet("Njabulo", "xhosa"), "Molo, Njabulo");
        assertEquals(jdbcGreet.greet("jack", "zulu"), "Saw'bona, jack");


    }

    @Test
    void DeleteName() throws SQLException, ClassNotFoundException {
        JdbcGreet jdbcGreet = new JdbcGreet();
        String name = "Yegan";
        String language = "zulu";
        jdbcGreet.greet(name, language);
        jdbcGreet.clearWithAName(name);
        // jdbcGreet.getDBNames();

        //  assertEquals("{phumlani=1}",jdbcGreet.greeted().toString());

        assertEquals("Saw'bona, Yegan", jdbcGreet.greet(name,language));
        assertEquals("{}",jdbcGreet.getDBNames());


//    @Test
//    void notImportantTest() throws SQLException, ClassNotFoundException {
//
//        JdbcGreet db = new JdbcGreet();
//
////        assertEquals();
//        Map<String, Integer> databaseMap = new HashMap<>();
//        System.out.println(databaseMap);
//    }
    }
}