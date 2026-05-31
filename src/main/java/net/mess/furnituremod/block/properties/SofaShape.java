package net.mess.furnituremod.block.properties;

import net.minecraft.util.StringRepresentable;

public enum SofaShape implements StringRepresentable {
    SINGLE("single"),
    LEFT("left"),
    MIDDLE("middle"),
    RIGHT("right"),
    CORNERLEFT("cornerleft"),
    CORNERRIGHT("cornerright");

    private final String name;

    SofaShape(String type) {
        this.name = type;
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;     }
}