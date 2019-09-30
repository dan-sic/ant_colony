package com.daniel;

public class EmptyField extends ColonyObject {

    @Override
    public String displayValue() {
        return ".";
    }

    public ColonyObjectType getType() {
        return ColonyObjectType.FIELD;
    }
}
