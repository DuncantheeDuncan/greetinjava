package net.greet;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import static org.junit.Assert.assertEquals;
class CommandsUsingJDBCTests {
    Connection conn;

    @BeforeEach
    void setUp() throws SQLException, ClassNotFoundException {
        CommandsUsingJDBC jdbcGreet = new CommandsUsingJDBC();
        conn = DriverManager.getConnection("jdbc:h2:./target/jdbc_greetinjava", "sa", "");
        Statement statement = conn.createStatement();
        statement.addBatch("delete from PERSON");
        statement.executeBatch();
    }

    @Test
    void clearName() throws SQLException, ClassNotFoundException {

        CommandsUsingJDBC jdbcGreet = new CommandsUsingJDBC();


        jdbcGreet.greet("Sandile","zulu");
        jdbcGreet.greet("Sifiso","zulu");
        jdbcGreet.greet("Bavumile","zulu");

        jdbcGreet.clearWithAName("Sandile");
        jdbcGreet.clearWithAName("Sifiso");
        assertEquals("Greeted Names:\n{Bavumile=1}",jdbcGreet.greeted());
    }
    @Test
    void clearTheWholeDatabase() throws SQLException, ClassNotFoundException {
        CommandsUsingJDBC jdbcGreet = new CommandsUsingJDBC();

        jdbcGreet.greet("Sandile","zulu");
        jdbcGreet.greet("Sifiso","zulu");
        jdbcGreet.greet("Bavumile","zulu");
        jdbcGreet.greet("Sandile-Mthembu","zulu");
        jdbcGreet.greet("Sifiso-Mthebu","zulu");
        jdbcGreet.greet("Bavumile-Mthembu","zulu");

        jdbcGreet.clear();

    }
    @Test
    void getCounter() throws SQLException, ClassNotFoundException {
        CommandsUsingJDBC jdbcGreet = new CommandsUsingJDBC();

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
        CommandsUsingJDBC jdbcGreet = new CommandsUsingJDBC();

        jdbcGreet.greet("Sifiso","zulu");
        jdbcGreet.greet("Bavumile","zulu");
        jdbcGreet.greet("Sandile","zulu");
        jdbcGreet.greet("Sandile","zulu");
        jdbcGreet.greeted();
    }
    @Test
    void findGreetedNamesandTesTheCounterOfThatName() throws SQLException, ClassNotFoundException {
        CommandsUsingJDBC jdbcGreet = new CommandsUsingJDBC();

        jdbcGreet.greet("Sifiso","zulu");
        jdbcGreet.greet("Sandile","zulu");
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

        assertEquals("Sandile has been greeted 3 times",jdbcGreet.greetedWithName("Sandile"));



    }



}
