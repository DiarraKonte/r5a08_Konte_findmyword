package r5a08_findmyword;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WordTest {

    @Test
    public void should_check_one_incorrect_letter() {
        // Arrange
        Word word = new Word("B");

        Score score = word.guess("D");

        // Assert
        assertThat(score.letter(0)).isEqualTo(Letter.INCORRECT);
    }

    @Test
    public void should_check_one_correct_letter() {
        // Arrange
        Word word = new Word("E"); // Le mot a déviner fait une lettre

        //Act
        Score score = word.guess("E");

        // Assert
        assertThat(score.letter(0)).isEqualTo(Letter.CORRECT);
    }

    @Test
    public void should_check_two_incorrect_letter() {
        //Arrange
        Word word = new Word("EC");

        //Act
        Score score = word.guess("FR");

        //Assert
        assertThat(score.letter(0)).isEqualTo(Letter.INCORRECT);
    }

    @Test
    public void should_check_two_correct_letter() {
        //Arrange
        Word word = new Word("EC");

        //Act
        Score score = word.guess("EC");

        //Assert
        assertThat(score.letter(0)).isEqualTo(Letter.CORRECT);
    }


    private void assertScoreForLetter(Score score, int position, Letter expected) {
        assertThat(score.letter(position)).isEqualTo(expected);
    }

    @Test
    void should_check_second_letter_wrong_position() {
        //Arrange
        Word word = new Word("GE");

        //Act
        Score score = word.guess("FG");

        //Assert
        assertScoreForLetter(score, 1, Letter.PART_CORRECT);
    }

    private void assertScoreForGuess(Score score, Letter... expectedScores){
        for(int position = 0; position < expectedScores.length; position++){
            Letter expected =  expectedScores[position];
            assertThat(score.letter(position)).isEqualTo(expected);
        }
    }

    @Test
    void should_check_all_score_combinaisons_correct() {
        //Arrange
        Word word = new Word("EMT");

        //Act
        Score score = word.guess("GET");

        //Assert
        assertScoreForGuess(score,
                Letter.INCORRECT,
                Letter.PART_CORRECT,
                Letter.CORRECT
        );
    }
}