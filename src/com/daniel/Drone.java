package com.daniel;

import java.util.concurrent.ThreadLocalRandom;

public class Drone extends Ant {
    private static final int MINIMAL_DISTANCE_FROM_QUEEN = 3;

    private IQueen queen;
    private boolean isVerticallyAlignedAgainstQueen;

    Drone(int x, int y) {
        super();
        this.posX = x;
        this.posY = y;

        this.queen = Queen.getInstance();
        checkPositionAgainstQueen();
        trackDistanceFromQueen();
    }

    @Override
    void makeTurnAction() {
        moveTowardsQueen();
        controlMatingCycle();
    }

    @Override
    String displayValue() {
        return "d";
    }

    private void moveTowardsQueen() {
        trackDistanceFromQueen();
        if (distanceFromQueen <= MINIMAL_DISTANCE_FROM_QUEEN) return;

        checkPositionAgainstQueen();

        if (isVerticallyAlignedAgainstQueen){
            makeMoveVertically();
        } else {
            makeMoveHorizontally();
        }
    }

    private void makeMoveHorizontally() {
        boolean isDroneFurtherThanQueen = posX > queenPosX;
        int newPosX = isDroneFurtherThanQueen ? posX - 1 : posX + 1;
        moveAnt(newPosX, posY);
    }

    private void makeMoveVertically() {
        boolean isDroneFurtherThanQueen = posY > queenPosY;
        int newPosY = isDroneFurtherThanQueen ? posY - 1 : posY + 1;
        moveAnt(posX, newPosY);
    }

    private void checkPositionAgainstQueen() {
        isVerticallyAlignedAgainstQueen = posX == queenPosX;
    }

    private void controlMatingCycle() {
        if (queen.isInTheMatingMood() && (distanceFromQueen <= MINIMAL_DISTANCE_FROM_QUEEN)) {
            queen.startMating();
        } else if (distanceFromQueen <= MINIMAL_DISTANCE_FROM_QUEEN) {
            moveToRandomPositionAfterBeingKickedOut();
        }
    }

    private void moveToRandomPositionAfterBeingKickedOut() {
        int randomInt = ThreadLocalRandom.current().nextInt(1, 4 + 1);

        int newPosX = 0;
        int newPosY = 0;

        switch (randomInt) {
            case 1: {
                newPosX = 0;
                newPosY = 0;
                break;
            }
            case 2: {
                newPosX = Colony.getGridWidth() - 1;
                newPosY = 0;
                break;
            }
            case 3: {
                newPosX = Colony.getGridWidth() - 1;
                newPosY = Colony.getGridHeight() - 1;
                break;
            }
            case 4: {
                newPosX = 0;
                newPosY = Colony.getGridHeight() - 1;
                break;
            }
        }

        moveAnt(newPosX, newPosY);
//
    }
}
