package org.example.view;

import javax.swing.*;
import java.awt.*;

public class ElevatorView extends JComponent {

    private final int x = 300;
    private final int width = 50;
    private final int height = 100;
    private int elevatorY;
    private int personY;
    private int personXAdjust;
    private boolean inElevator;

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawRect(this.x, this.elevatorY, this.width, this.height); // Elevator
        drawFloors(g2);
        drawPerson(g2);
    }

    public void render(int elevatorFloor, int personFloor, boolean inElevator) {
        elevatorY = 350 - (elevatorFloor * 100);
        personY = 400 - (personFloor * 100);
        personXAdjust = inElevator ? 118 : 0;
        repaint();
    }

    private void drawFloors(Graphics2D g2) {
        g2.drawLine(50, 50, 600, 50);
        g2.drawLine(50, 150, 600, 150);
        g2.drawLine(50, 250, 600, 250);
        g2.drawLine(50, 350, 600, 350);
        g2.drawLine(50, 450, 600, 450);
    }

    private void drawPerson(Graphics2D g2) {
        // Head
        g2.drawOval(200 + personXAdjust, this.personY, 15, 15);

        // Torso
        g2.drawLine(208 + personXAdjust,
                this.personY + 15,
                208 + personXAdjust,
                this.personY + 30);

        // Arms
        g2.drawLine(208 + personXAdjust,
                this.personY + 25,
                220 + personXAdjust,
                this.personY + 20);
        g2.drawLine(208 + personXAdjust,
                this.personY + 25,
                196 + personXAdjust,
                this.personY + 20);

        // Legs
        g2.drawLine(208 + personXAdjust,
                this.personY + 30,
                210 + personXAdjust,
                this.personY + 50);
        g2.drawLine(208 + personXAdjust,
                this.personY + 30,
                206 + personXAdjust,
                this.personY + 50);
    }
}
