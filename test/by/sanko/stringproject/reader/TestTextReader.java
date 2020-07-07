package by.sanko.stringproject.reader;

import by.sanko.stringproject.exception.ProjectException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.testng.Assert.assertEquals;

public class TestTextReader {
    private TextReader textReader;

    @BeforeTest
    public void startUp() {
        textReader = new TextReader();
    }

    @Test
    public void testReadFromFileDefaultPathNull() throws ProjectException {
        String expected = "When Nicolai is resurrected, Isabel realises to her horror that the spell has damned his soul, leaving him a vampire. Stunned by this revelation, she breaks down and Markal seizes the chance to declare himself ruler of the Griffin Empire. When the Elven king, Alaron, takes in Griffin refugees, Markal's forces begin to raid Irollan, and the diplomat Findan is sent to stop the raids. He is later tasked to find the Emerald Dragons to turn the tide on the Undead, but returns to find Syris Thalla, the capital, besieged. Alaron dies in the siege, but tells Findan to seek Tieru. After defending the capital, Findan travels to the Dragonmist Islands, but is too late to stop Biara from killing Tieru, although the latter's spirit tells Findan about the Kha-Beleth's plan; the Demon Sovereign has placed a mark on Isabel so that she will bear the Demon Messiah. He also instructs Findan to get a scroll back from Biara, which, if used by a powerful mage, will be able to stop Kha-Beleth. The only such mage would be Zehir, the son of Cyrus. After pursuing Biara and getting the scroll back, Findan returns to Irollan, where the Elves are now on the verge of victory, but now face a terrible foe in Nicolai, who is now a Vampire Lord. With the help of Phoenixes or by destroying all the Spectral Dragons, Findan 'brings the dawn', and puts Nicolai to rest. He then sets off to find Zehir.";
        String actual = "";
        actual = textReader.readFromFile(null);
        assertEquals(actual,expected);
    }

    @Test
    public void testReadFromFileDefaultPathFileIsNotExisted() throws ProjectException {
        String expected = "When Nicolai is resurrected, Isabel realises to her horror that the spell has damned his soul, leaving him a vampire. Stunned by this revelation, she breaks down and Markal seizes the chance to declare himself ruler of the Griffin Empire. When the Elven king, Alaron, takes in Griffin refugees, Markal's forces begin to raid Irollan, and the diplomat Findan is sent to stop the raids. He is later tasked to find the Emerald Dragons to turn the tide on the Undead, but returns to find Syris Thalla, the capital, besieged. Alaron dies in the siege, but tells Findan to seek Tieru. After defending the capital, Findan travels to the Dragonmist Islands, but is too late to stop Biara from killing Tieru, although the latter's spirit tells Findan about the Kha-Beleth's plan; the Demon Sovereign has placed a mark on Isabel so that she will bear the Demon Messiah. He also instructs Findan to get a scroll back from Biara, which, if used by a powerful mage, will be able to stop Kha-Beleth. The only such mage would be Zehir, the son of Cyrus. After pursuing Biara and getting the scroll back, Findan returns to Irollan, where the Elves are now on the verge of victory, but now face a terrible foe in Nicolai, who is now a Vampire Lord. With the help of Phoenixes or by destroying all the Spectral Dragons, Findan 'brings the dawn', and puts Nicolai to rest. He then sets off to find Zehir.";
        String actual = "";
        actual = textReader.readFromFile("input/data2.txt");
        assertEquals(actual,expected);
    }

    @Test
    public void testReadFromFileNotDefaultPath() throws ProjectException {
        String expected = "test data";
        String actual = textReader.readFromFile("input/data1.txt");
        assertEquals(actual, expected);
    }

    @Test
    public void testReadFromConsole() throws ProjectException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("text text text\n");
        stringBuilder.append("STOP INPUT THE DATA");

        InputStream sysInBackup = System.in;
        InputStream inputStream = new ByteArrayInputStream(stringBuilder.toString().getBytes());
        System.setIn(inputStream);
        String expected = "text text text ";
        String actual = textReader.readFromConsole();
        assertEquals(actual, expected);
        System.setIn(sysInBackup);
    }
}
