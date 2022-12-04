package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.logging.Logger;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class FizzBuzzTest {

    public FizzBuzz sut;
    static Logger log = Logger.getLogger(FizzBuzzTest.class.getName());


    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        log.info("BeforeAll");
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
        log.info("AfterAll");
    }

    @BeforeEach
    void setUp() throws Exception {
        log.info("BeforeEach");
        sut = new FizzBuzz();
    }

    @AfterEach
    void tearDown() throws Exception {
        log.info("AfterEach");
        sut = null;
    }

    @Test
    @DisplayName("Easy test in JUnit 4 or 5?")
    void testJunit() {
        assertEquals(2,2);
    }

    @Test
    @DisplayName("Wrong test")
    @Disabled
    void wrongTest() {
        assertEquals(2,1);
    }

    @DisplayName("Play FizzBuzz with number = 1")
    @Test
    void testNumber() {
        String fizzBuzz = sut.play(1);
        assertEquals(fizzBuzz,"1");
    }

    @DisplayName("Play FizzBuzz with number = 0")
    @Test
    void testNumberException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> sut.play(0));
    }

    @DisplayName("Example of repeated test")
    @Test
    @RepeatedTest(value = 4, name = "Repetition {currentRepetition} of {totalRepetition}")
    void exampleRepeatedTest() {
        assertEquals("Fizz", sut.play(3));
    }

    @Test
    void assumeExample() {
        //assumeTrue(!(5 != (3+3)));
        assertEquals("FizzBuzz", sut.play(15));
    }

    @Test
    void assertAllExample() {
        assertAll("Many asertions", () -> {
            assertTrue(true);
            assertEquals("FizzBuzz", sut.play(30));
        });

    }

    @Test
    @Disabled
    void assertAllExample2() {
        assertAll("Many asertions", () -> {
            assertFalse(true, () -> "Is false");
            assertEquals("FizzBuzz", sut.play(30), () -> "Not Fizz!!!");
        });

    }
}
