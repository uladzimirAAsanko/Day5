package by.sanko.stringproject.service;

import by.sanko.stringproject.service.impl.StringReplaceService;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestStringReplaceService {
    StringReplaceService stringReplaceService;
    @BeforeTest
    public void startUp() {
        stringReplaceService = new StringReplaceService();
    }

    @Test
    public void testReplaceLetterFromPosition() {

    }
}
