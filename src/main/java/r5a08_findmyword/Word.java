package r5a08_findmyword;

public class Word {
    private final String word;

    public Word(String correctWord) {
        this.word = correctWord;
    }

    public Score guess(String attempt) {
        Score score = new Score(word);

        score.assess(attempt);

        return score;
    }
}