package com.daniel;

public class Soldier extends Ant {

    private SequenceMove movementDir = SequenceMove.RIGHT;

    private enum SequenceMove {
        RIGHT,
        DOWN,
        LEFT,
        UP
    }

    Soldier(int x, int y) {
        super();
        this.posX = x;
        this.posY = y;
    }

    @Override
    void makeTurnAction() {
        moveInSequence();
    }

    private void moveInSequence() {

        boolean antMoved;
        switch (movementDir) {
            case RIGHT: {
                antMoved = moveAnt(this.posX + 1, this.posY);
                if (antMoved) this.movementDir = SequenceMove.DOWN;
                break;
            }
            case DOWN: {
                antMoved = moveAnt(this.posX, this.posY + 1);
                if (antMoved) this.movementDir = SequenceMove.LEFT;
                break;
            }
            case LEFT: {
                antMoved = moveAnt(this.posX - 1, this.posY);
                if (antMoved) this.movementDir = SequenceMove.UP;
                break;
            }
            case UP: {
                antMoved = moveAnt(this.posX,this.posY - 1);
                if (antMoved) this.movementDir = SequenceMove.RIGHT;
                break;
            }
        }
    }

    @Override
    public String displayValue() {
        return "s";
    }
}
