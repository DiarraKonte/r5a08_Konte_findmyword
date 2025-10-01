package r5a08_findmyword;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WordTest {

    @Test
    void should_check_one_incorrect_letter(){
        // Arrange
        Word word = new Word("E");

        // Act
        Score score = word.guess("C"); // tentative incorrecte

        // Assert
        assertEquals(Letter.INCORRECT, score.letter(0));
    }

}
