package by.sanko.stringproject.service;

import by.sanko.stringproject.exception.ProjectException;
import by.sanko.stringproject.service.impl.CharDeleteService;
import by.sanko.stringproject.service.impl.StringDeleteService;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestCharDeleteService {
    private CharDeleteService charDeleteService;

    @BeforeTest
    public void startUp() {
        charDeleteService = new CharDeleteService();
    }

    @Test
    public void testDeleteNotLetters() throws ProjectException {
        String text = "12word word w0124rd w7ord w!rd w0rd w/rd w%rd word54$";
        String actual = charDeleteService.deleteNotLetters(text);
        String expected = "word word w rd w ord w rd w rd w rd w rd word";
        assertEquals(actual,expected);
    }

    @Test
    public void testDeleteWordSameLength() throws ProjectException {
        String text = "test tes1 estt testt test";
        String actual = charDeleteService.deleteWordsSameLongStartedOnConsonant(text, 4);
        String expected = "tes1 estt testt";
        assertEquals(actual,expected);
    }
}
