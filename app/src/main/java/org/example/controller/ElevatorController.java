package org.example.controller;

import org.example.model.Person;
import org.example.model.Elevator;
import org.example.view.ElevatorView;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class ElevatorController implements Runnable {
    private final Elevator elevator;
    private Person person;
    private final ElevatorView view;
    private final BlockingQueue<Person> people;

    public ElevatorController(Elevator elevator, ElevatorView view, BlockingQueue<Person> people) {
        this.elevator = elevator;
        this.view = view;
        this.people = people;

        Random rand = new Random();
        elevator.setFloor(rand.nextInt(4));
    }

    public void render() {
        view.render(elevator.getFloor(), person.getCurrentFloor(), person.isInElevator());
    }

    private void meetPerson() {
        if (elevator.getFloor() < person.getCurrentFloor()) {
            while (elevator.getFloor() < person.getCurrentFloor()) {
                try {
                    Thread.sleep(1000);
                    elevator.setFloor(elevator.getFloor() + 1);
                    render();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } else {
            while (elevator.getFloor() > person.getCurrentFloor()) {
                try {
                    Thread.sleep(1000);
                    elevator.setFloor(elevator.getFloor() - 1);
                    render();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private void movePerson() {
        if (elevator.getFloor() < person.getDestinationFloor()) {
            while (elevator.getFloor() < person.getDestinationFloor()) {
                try {
                    Thread.sleep(1000);
                    elevator.setFloor(elevator.getFloor() + 1);
                    person.setCurrentFloor(person.getCurrentFloor() + 1);
                    render();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } else {
            while (elevator.getFloor() > person.getDestinationFloor()) {
                try {
                    Thread.sleep(1000);
                    elevator.setFloor(elevator.getFloor() - 1);
                    person.setCurrentFloor(person.getCurrentFloor() - 1);
                    render();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private void personInElevator(boolean in) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        person.setInElevator(in);
        render();
    }

    private void transportPerson() {
        meetPerson();
        personInElevator(true);
        movePerson();
        personInElevator(false);
    }

    public void run() {
        while (true) {
            try {
                this.person = people.take();
                render();
                transportPerson();
                people.remove();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
