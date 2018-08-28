public class Game {
    private int itsScore = 0;
    private int[] itsThrows = new int[21];
    private int itsCurrentThrow = 0;
    private int itsCurrentFrame = 1;
    private boolean firstThrowInFrame = true;
    private int ball;

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
            if (strike()){
                ball++;
                score += 10 + nextTwoBalls();
            }else{
                score += handleSecondThrow();
            }
        }
        return score;
    }

    private boolean strike(){
        return itsThrows[ball] == 10;
    }

    private int nextTwoBalls(){
        return itsThrows[ball] + itsThrows[ball+1];
    }

    public int handleSecondThrow(){
        int score = 0;
        if (spare()) {
            ball += 2;
            score += 10 + nextBall();
        }else {
            score += towBallsInFrame();
            ball += 2;
        }
        return score;
    }

    private int towBallsInFrame(){
        return itsThrows[ball] + itsThrows[ball+1];
    }

    private boolean spare(){
        return (itsThrows[ball] + itsThrows[ball+1]) == 10;
    }
    private int nextBall(){
        return itsThrows[ball];
    }

    public int getCurrentFrame(){
        return itsCurrentFrame;
    }
}
