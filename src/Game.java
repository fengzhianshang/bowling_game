public class Game {
    private int itsScore = 0;
    private int[] itsThrows = new int[21];
    private int itsCurrentThrow = 0;
    private int itsCurrentFrame = 1;
    private boolean firstThrowInFrame = true;
    private int ball;
    private int firstThrow;
    private int secondThrow;

    public int score(){
        return scoreForFrame(itsCurrentFrame - 1);
    }
    public void add(int pins){
        itsThrows[itsCurrentThrow++] = pins;
        itsScore += pins;
        adjustCurrentFrame(pins);
    }
    private void adjustCurrentFrame(int pins){
        if (firstThrowInFrame == true){
            if (pins == 10)
                itsCurrentFrame++;
            else
                firstThrowInFrame = false;
        }else
        {
            firstThrowInFrame = true;
            itsCurrentFrame++;
        }
        itsCurrentFrame = Math.min(11, itsCurrentFrame);
    }
    public int scoreForFrame(int theFrame){
        int score = 0;
        ball = 0;
        for (int currentFrame = 0; currentFrame < theFrame; currentFrame++){
            firstThrow = itsThrows[ball++];
            if (firstThrow ==  10){
                score += 10 + itsThrows[ball] + itsThrows[ball+1];
            }else{
                score += handleSecondThrow();
            }
        }
        return score;
    }

    public int handleSecondThrow(){
        int score = 0;
        secondThrow = itsThrows[ball++];
        int frameScore = firstThrow + secondThrow;
        if (frameScore == 10)
            score += frameScore + itsThrows[ball];
        else
            score += frameScore;
        return score;
    }

    public int getCurrentFrame(){
        return itsCurrentFrame;
    }
}
