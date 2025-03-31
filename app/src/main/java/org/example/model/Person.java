package org.example.model;

public class Person {
    private int currentFloor;
    private int destinationFloor;
    private boolean inElevator;

    public Person(int currentFloor, int destinationFloor) {
        this.currentFloor = currentFloor;
        this.destinationFloor = destinationFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }

    public boolean isInElevator() {
        return inElevator;
    }

    public void setInElevator(boolean inElevator) {
        this.inElevator = inElevator;
    }
}
