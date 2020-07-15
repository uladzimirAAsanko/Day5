package by.sanko.stringproject.service;

import by.sanko.stringproject.exception.ProjectException;
import by.sanko.stringproject.service.impl.CharReplaceService;
import by.sanko.stringproject.service.impl.RegExReplaceService;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestRegExReplaceService {
    private RegExReplaceService regExReplaceService;

    @BeforeTest
    public void startUp() {
        regExReplaceService = new RegExReplaceService();
    }

    @Test
    public void testReplaceLetterFromPosition() throws ProjectException {
        String text = "text word not1word wor wordless";
        String expected = "texF worF not1word wor worFless";
        String actual = regExReplaceService.replaceLetterFromPosition(text,'F',4);
        assertEquals(actual,expected);
    }

    @Test
    public void testCorrectMisprint() throws ProjectException {
        String text = "PAext tPAxt tePt texP tePPPAPt";
        String actual = regExReplaceService.correctMisprint(text);
        String expected = "POext tPOxt tePt texP tePPPOPt";
        assertEquals(actual,expected);
    }

    @Test
    public void testReplaceWordOnSubstring() throws ProjectException {
        String text = "text word not1word wor wordless wordlepp wordfuck fuckfuck";
        String expected = "text word not1word wor fuck fuck fuck fuck";
        String actual = regExReplaceService.replaceWordsOnSubstring(text,8 , "fuck");
        assertEquals(actual,expected);
    }
}
