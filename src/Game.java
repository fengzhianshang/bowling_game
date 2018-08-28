public class Game {
    private int itsScore = 0;
    private int[] itsThrows = new int[21];
    private int itsCurrentThrow = 0;
    private int itsCurrentFrame = 1;
    private Boolean firstThrow = true;

    public int score(){
        return scoreForFrame(itsCurrentFrame - 1);
    }
    public void add(int pins){
        itsThrows[itsCurrentThrow++] = pins;
        itsScore += pins;
        adjustCurrentFrame();
    }
    private void adjustCurrentFrame(){
        if (firstThrow == true){
            firstThrow = false;
        }else
        {
            firstThrow = true;
            itsCurrentFrame++;
        }
    }
    public int scoreForFrame(int theFrame){
        int score = 0;
        int ball = 0;
        for (int currentFrame = 0; currentFrame < theFrame; currentFrame++){
            int firstThrow = itsThrows[ball++];
            int secondThrow = itsThrows[ball++];
            int frameScore = firstThrow + secondThrow;
            if (frameScore == 10)
                score += frameScore + itsThrows[ball];
            else
                score += frameScore;
        }
        return score;
    }
    public int getCurrentFrame(){
        return itsCurrentFrame;
    }
}
