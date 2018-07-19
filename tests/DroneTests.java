/*
 * The purpose of this class is to test the Drone class.
 *
 */

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Scanner;

public class DroneTests {

    @Test
    public void droneSetSpeed() {
        Drone someDrone = new Drone();
        someDrone.setSpeed(1);

        assertEquals(1, someDrone.getSpeed());
    }

    @Test
    public void droneSetCoordinates() {
        Drone someDrone = new Drone();
        someDrone.setCoordinates(50, 50);

        assertEquals("50,50", someDrone.getCoordinates());
    }

    @Test
    public void droneUpdateSpeed() {
        Drone someDrone = new Drone();
        someDrone.updateSpeed();

        assertTrue(0 <= someDrone.getSpeed() && someDrone.getSpeed() <= 100);
    }

    @Test
    public void droneUpdateCoordinates() {
        Drone someDrone = new Drone();
        someDrone.updateCoordinates();

        String currentCoordinates = someDrone.getCoordinates();
        Scanner line = new Scanner(currentCoordinates).useDelimiter(",");
        int xCoordinate = line.nextInt();
        int yCoordinate = line.nextInt();

        assertTrue(0 <= xCoordinate && xCoordinate <= 50);
        assertTrue(0 <= yCoordinate && yCoordinate <= 50);
    }

}