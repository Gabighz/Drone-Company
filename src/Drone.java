/**
 * This class constructs a Drone object.
 * It has get and set methods for its unique identifier, speed, and geo-location coordinates.
 * It has no set method for its unique identifier as it shouldn't be changed.
 *
 * @author Gabriel Ghiuzan
 */

import java.util.Random;

public class Drone {

    // Stores the last assigned unique identifier
    private static int idCounter;

    // The unique identifier of the drone
    private final int uniqueId;

    // The speed of the drone
    private int speed;

    // The geo-location coordinates of the drone
    private int coordinates;

    /**
     * Constructs a Drone
     */
    public Drone() {
        this.uniqueId = idCounter;
        this.speed = initializeSpeed();
        this.coordinates = initializeCoordinates();
        idCounter++;
    }

   /**
    * @param speed Resets the speed of the drone.
    */
    public void setSpeed(int speed) {
        this.speed = speed;

    }

   /**
    * @param coordinates Resets the geo-location coordinates of the drone.
    */
    public void setCoordinates(int coordinates){
        this.coordinates = coordinates;

    }

   /**
    * @return uniqueId Returns the unique identifier of the drone.
    */
    public int getUniqueId() {
        return uniqueId;

    }

   /**
    * @return speed Returns the speed of the drone.
    */
    public int getSpeed(){
        return speed;

    }

   /**
    * @return coordinates Return the geo-location coordinates of the drone.
    */
    public int getCoordinates(){
        return coordinates;

    }

    /**
     * @return Returns the initial speed of the drone.
     * We can assume that the maximum speed of a drone is 100 units of some arbitrary measurement.
     */
    public int initializeSpeed() {
        return new Random().nextInt(100);

    }


}
