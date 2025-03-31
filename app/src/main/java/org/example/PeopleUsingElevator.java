package org.example;

import org.example.model.Person;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class PeopleUsingElevator implements Runnable {

    private final BlockingQueue<Person> messages;

    public PeopleUsingElevator(BlockingQueue messages) {
        this.messages = messages;
    }

    private Person generatePerson() {
        Random rand = new Random();
        int destinationFloor = rand.nextInt(4);
        int currentFloor = rand.nextInt(4);

        while (currentFloor == destinationFloor) {
            currentFloor = rand.nextInt(4);
        }

        return new Person(currentFloor, destinationFloor);
    }

    public void run() {
        while (true) {
            try {
                // Simulate people coming and going
                if (messages.isEmpty()) {
                    Person person = generatePerson();
                    messages.put(person);
                }

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
