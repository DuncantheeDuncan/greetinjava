package greetings.greet;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class jdbcGreetTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void test() throws SQLException {

        JdbcGreet db = new JdbcGreet();

        assertEquals("{Axel=1}", db.findUsers().toString());

    }
}