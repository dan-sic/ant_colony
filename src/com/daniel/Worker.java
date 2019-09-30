package com.daniel;

import java.util.concurrent.ThreadLocalRandom;

public class Worker extends Ant {

    Worker(int x, int y) {
        super();
        this.posX = x;
        this.posY = y;
    }

    @Override
    void makeTurnAction() {
        moveRandomly();
    }

    @Override
    public String displayValue() {
        return "w";
    }

    private void moveRandomly() {
        int nextX = getRandomNumber(this.posX);
        int nextY = getRandomNumber(this.posY);

        moveAnt(nextX, nextY);
    }

    private int getRandomNumber(int bound) {
        return ThreadLocalRandom.current().nextInt(bound - 1, bound + 2);
    }
}
