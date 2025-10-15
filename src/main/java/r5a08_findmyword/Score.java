package r5a08_findmyword;

public class Score {

    private final String correct;
    private final Letter[] result;

    public Score(String correct) {
        this.correct=correct;
        this.result = new Letter[correct.length()];
    }

    public Letter letter(int i) {
        return result[i];
    }

    private boolean isCorrectLetterAt(int position, String attempt) {
        return this.correct.charAt(position) == attempt.charAt(position);
    }


    public void assess(String attempt) {
        for(int i=0;i<attempt.length();i++) {
            if(isCorrectLetterAt(i, attempt)) {
                result[i] = Letter.CORRECT;
            }  else{
                result[i] = Letter.INCORRECT;
            }
        }
    }
}

