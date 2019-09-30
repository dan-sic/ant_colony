package com.daniel;

public class Queen extends Ant implements IQueen {

    private static final int MATING_TURNS = 5;
    private static final int TURNS_WITHOUT_MATING_MOOD = 30;

    private static Queen instance = null;

    private boolean isInTheMatingMood;
    private boolean isMating;
    private int matingTurnsCounter;
    private int matingMoodCounter;

    private Queen() {
        this.isInTheMatingMood = true;
        this.isMating = false;
        this.matingTurnsCounter = 0;
        this.matingMoodCounter = 0;
    }

    public static Queen getInstance() {
        if (instance == null) {
            instance = new Queen();
        }
        return instance;
    }

    @Override
    void makeTurnAction() {
        controlMatingState();
        controlMoodState();
    }

    @Override
    String displayValue() {
        return "Q";
    }

    public boolean isInTheMatingMood() {
        return isInTheMatingMood;
    }

    public void startMating() {
        isMating = true;
    }

    private void controlMatingState() {
        if (isMating && matingTurnsCounter >= MATING_TURNS ) {
            isMating = false;
            isInTheMatingMood = false;
            matingTurnsCounter = 0;
        } else if (isMating) {
            matingTurnsCounter++;
        }
    }

    private void controlMoodState() {
        if (!isMating && !isInTheMatingMood && matingMoodCounter >= TURNS_WITHOUT_MATING_MOOD) {
            isInTheMatingMood = true;
            matingMoodCounter = 0;
        } else if (!isMating && !isInTheMatingMood) {
            matingMoodCounter++;
        }
    }
}
