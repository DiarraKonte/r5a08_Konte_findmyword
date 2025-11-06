package r5a08_findmyword;

import java.util.ArrayList;
import java.util.*;

public class Score {

    private final String correct;
    private final List<Letter> results = new ArrayList<>();

    private int position = 0;

    public Score(String correct) {
        this.correct=correct;
    }

    public Letter letter(int i) {
        return results.get(i);
    }

    private boolean isCorrectLetter(char currentLetter) {
        return correct.charAt(position) == currentLetter;
    }

    private boolean isLetterOccursInWord(char currentLetter) {
        return correct.contains(String.valueOf(currentLetter));
    }


    public void assess(String attempt) {
        for (char currentLetter : attempt.toCharArray()) {
            results.add(scoreForLetter(currentLetter));
            this.position++;
        }
    }


    private Letter scoreForLetter(char current) {
        if (isCorrectLetter(current)) {
            return Letter.CORRECT;
        }
        if (isLetterOccursInWord(current)) {
            return Letter.PART_CORRECT;
        }
        return Letter.INCORRECT;
    }

}

