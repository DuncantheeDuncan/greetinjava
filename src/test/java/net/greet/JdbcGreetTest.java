package net.greet;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;

class JdbcGreetTest {
    Connection conn;

    @BeforeEach
    void setUp() throws SQLException, ClassNotFoundException {
        JdbcGreet jdbcGreet = new JdbcGreet();
        conn = DriverManager.getConnection("jdbc:h2:./target/jdbc_greetinjava", "sa", "");
        Statement statement = conn.createStatement();
        statement.addBatch("delete from PERSON");
        statement.executeBatch();
    }

//    @Test
//    void testingConnection() throws SQLException, ClassNotFoundException {
//
//        JdbcGreet db = new JdbcGreet();
//
//        assertEquals("{phumlani=1}", db.greeted().toString());
//
//    }
//
//    @Test
//    void testingTheCounter() throws SQLException, ClassNotFoundException {
//
//        JdbcGreet db = new JdbcGreet();
//
//
//        assertEquals("{phumlani=1}", db.greeted().toString());
//
//        assertEquals(1, db.counter());
//
//    }
//
//    @Test
//    void testNamesIndb() throws SQLException, ClassNotFoundException {
//        JdbcGreet jdbcGreet = new JdbcGreet();
//
//        assertEquals("{phumlani=1}", jdbcGreet.greeted().toString());
//        assertEquals("{phumlani=1}", jdbcGreet.namesInDB());
//        assertEquals("{jo=1}",jdbcGreet.namesInDB());
//
//
//    }
//
//    @Test
//    void addingNmaesTodb() throws SQLException, ClassNotFoundException {
//        JdbcGreet jdbcGreet = new JdbcGreet();
//
//        assertEquals(jdbcGreet.greet("Njabulo", "xhosa"), "Molo, Njabulo");
//        assertEquals(jdbcGreet.greet("jack", "zulu"), "Saw'bona, jack");
//
//
//    }

    @Test
    void clearName() throws SQLException, ClassNotFoundException {

        JdbcGreet jdbcGreet = new JdbcGreet();


        jdbcGreet.greet("Sandile","zulu");
        jdbcGreet.greet("Sifiso","zulu");
        jdbcGreet.greet("Bavumile","zulu");

        jdbcGreet.clearWithAName("Sandile");
        jdbcGreet.clearWithAName("Sifiso");



        System.out.println(jdbcGreet.greeted());// remove

    }
    @Test
    void clearTheWholeDatabase() throws SQLException, ClassNotFoundException {
        JdbcGreet jdbcGreet = new JdbcGreet();

        jdbcGreet.greet("Sandile","zulu");
        jdbcGreet.greet("Sifiso","zulu");
        jdbcGreet.greet("Bavumile","zulu");
        jdbcGreet.greet("Sandile-Mthembu","zulu");
        jdbcGreet.greet("Sifiso-Mthebu","zulu");
        jdbcGreet.greet("Bavumile-Mthembu","zulu");

        jdbcGreet.clear();


        System.out.println(jdbcGreet.greeted()+ "the final");// remove
    }
    @Test
    void getCounter() throws SQLException, ClassNotFoundException {
        JdbcGreet jdbcGreet = new JdbcGreet();

        jdbcGreet.greet("Sandile","zulu");
        jdbcGreet.greet("Sifiso","zulu");
        jdbcGreet.greet("Bavumile","zulu");
        jdbcGreet.greet("Sandile-Mthembu","zulu");
        jdbcGreet.greet("Sifiso-Mthebu","zulu");
        jdbcGreet.greet("Michel-Mthebu","zulu");
        jdbcGreet.greet("Bavumile-Mthembu","zulu");

        assertEquals("The total counter is (7)",jdbcGreet.counter());

    }

    @Test
    void testGreet() throws SQLException, ClassNotFoundException {
        JdbcGreet jdbcGreet = new JdbcGreet();

        assertEquals("Saw'bona, Sifiso",jdbcGreet.greet("Sifiso","zulu"));
        assertEquals("Saw'bona, Bavumile",jdbcGreet.greet("Bavumile","zulu"));
        assertEquals("Saw'bona, Sandile",jdbcGreet.greet("Sandile","zulu"));
        assertEquals("Saw'bona, Sandile",jdbcGreet.greet("Sandile","zulu"));

        jdbcGreet.greeted();

    }
    @Test
    void findGreetedNamesandTesTheCounterOfThatName() throws SQLException, ClassNotFoundException {
        JdbcGreet jdbcGreet = new JdbcGreet();

        jdbcGreet.greet("Sandile","zulu");
        jdbcGreet.greet("Sandile","zulu");
        jdbcGreet.greet("Sifiso","zulu");
        jdbcGreet.greet("Sifiso","zulu");
        jdbcGreet.greet("Sifiso","zulu");
        jdbcGreet.greet("Bavumile","zulu");
        jdbcGreet.greet("Bavumile","zulu");
        jdbcGreet.greet("Bavumile","zulu");
        jdbcGreet.greet("Bavumile","zulu");
        jdbcGreet.greet("Bavumile","zulu");
        System.out.println(jdbcGreet.greetedWithName("Bavumile")+" one");

        jdbcGreet.greetedWithName("Bavumile");
        System.out.println(jdbcGreet.greetedWithName("Bavumile")+" two");


    }



}