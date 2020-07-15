package by.sanko.stringproject.service;

import by.sanko.stringproject.exception.ProjectException;
import by.sanko.stringproject.reader.TextReader;
import by.sanko.stringproject.service.impl.StringReplaceService;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestStringReplaceService {
    private StringReplaceService stringReplaceService;

    @BeforeTest
    public void startUp() {
        stringReplaceService = new StringReplaceService();
    }

    @Test
    public void testReplaceLetterFromPosition() throws ProjectException {
        String text = "text word not1word wor wordless";
        String expected = "texF worF not1word wor worFless";
        String actual = stringReplaceService.replaceLetterFromPosition(text,'F',4);
        assertEquals(actual,expected);
    }

    @Test
    public void testCorrectMisprint() throws ProjectException {
        String text = "PAext tPAxt tePt texP tePPPAPt";
        String actual = stringReplaceService.correctMisprint(text);
        String expected = "POext tPOxt tePt texP tePPPOPt";
        assertEquals(actual,expected);
    }

    @Test
    public void testReplaceWordOnSubstring() throws ProjectException {
        String text = "text word not1word wor wordless wordlepp wordfuck fuckfuck";
        String expected = "text word not1word wor fuck fuck fuck fuck";
        String actual = stringReplaceService.replaceWordsOnSubstring(text,8 , "fuck");
        assertEquals(actual,expected);
    }
}
