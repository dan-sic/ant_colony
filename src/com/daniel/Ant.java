package com.daniel;

public abstract class Ant extends ColonyObject {

//    Colony colony;

    int queenPosX = Colony.getGridWidth() / 2;
    int queenPosY = Colony.getGridHeight() / 2;
    int distanceFromQueen;
    private ColonyObject[][] colony = Colony.getColonyGrid();

    abstract void makeTurnAction();

    void trackDistanceFromQueen() {
//        int queenPosX = Colony.getQueenPosX();
//        int queenPosY = Colony.getQueenPosY();

        int distanceX = queenPosX > posX ? queenPosX - posX : posX - queenPosX;
        int distanceY = queenPosY > posY ? queenPosY - posY : posY - queenPosY;
        distanceFromQueen = distanceX + distanceY;
    }

    protected ColonyObjectType getType() {
        return ColonyObjectType.ANT;
    }

    private boolean isValidMove(int newX, int newY) {
        if (newX < 0 || newX >= Colony.getGridWidth()) return false;
        if (newY < 0 || newY >= Colony.getGridHeight()) return false;
        if (Colony.getColonyGrid()[newY][newX].getType().equals(ColonyObjectType.ANT)) return false;

//        if (Colony.hasAntOnPosition(newX, newY)) return false;

        return true;
    }

    private void updateAntPosition(int newX, int newY) {
        this.posX = newX;
        this.posY = newY;
    }

    boolean moveAnt(int nextX, int nextY) {
        if (isValidMove(nextX, nextY)) {
            ColonyObject replacedObject = colony[nextY][nextX];
            colony[nextY][nextX] = this;
            colony[this.posY][this.posX] = replacedObject;

            updateAntPosition(nextX, nextY);

            return true;
        }
        return false;
    }
}
