package com.pokemon.character;

public class Charact {
    private String name;
    private int PosX = 1;
    private int PosY = 1;
    private int MovementSpeed = 1;

    public Charact(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosX() {
        return PosX;
    }

    public void setPosX(int posX) {
        PosX += posX;
    }

    public int getPosY() {
        return PosY;
    }

    public void setPosY(int posY) {
        PosY += posY;
    }

    public int getMovementSpeed() {
        return MovementSpeed;
    }

    public void setMovementSpeed(int movementSpeed) {
        MovementSpeed = movementSpeed;
    }
}
