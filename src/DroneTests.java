/*
 * The purpose of this class is to test the Drone class.
 *
 */

import static org.junit.Assert.*;
import org.junit.Test;

public class DroneTests {

    @Test
    public void drone1() {
        Drone firstDrone = new Drone();
        firstDrone.setSpeed(1);

        assertEquals(1, firstDrone.getSpeed());
    }

    @Test
    public void drone2() {
        Drone secondDrone = new Drone();
        secondDrone.setCoordinates(50, 50);

        assertEquals("50,50", secondDrone.getCoordinates());
    }

}