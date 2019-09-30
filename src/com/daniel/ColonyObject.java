package com.daniel;

abstract class ColonyObject {

    public enum ColonyObjectType {
        FIELD,
        ANT
    }

    protected int posX;
    protected int posY;

    abstract String displayValue();
    abstract ColonyObjectType getType();
}
