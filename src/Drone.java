/**
 * This class constructs a Drone object.
 * It has get and set methods for its unique identifier, speed, and geo-location coordinates.
 * It has no set method for its unique identifier as it shouldn't be changed.
 *
 * @author Gabriel Ghiuzan
 */

import java.util.Random;
import java.util.Scanner;



@SuppressWarnings("WeakerAccess")
public class Drone {

    // Stores the last assigned unique identifier
    private static int idCounter;

    // The unique identifier of the drone
    private final int uniqueId;

    // The speed of the drone
    private int speed;

    // The geo-location coordinates of the drone
    private String coordinates;

    // The last geo-location coordinates of the drone
    private String lastCoordinates;

    // Random object to be used in computing speed and coordinates
    private final Random rand = new Random();

    // ANSI escape sequences used for colouring drones which do not move
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";

    // Whether the drone is moving or not
    private Boolean moving = true;

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
    * Resets the geo-location coordinates of the drone.
    * @param xCoordinate The new x-coordinate of the drone.
    * @param yCoordinate The new y-coordinate of the drone.
    */
    public void setCoordinates(int xCoordinate, int yCoordinate){
        this.coordinates = xCoordinate + "," + yCoordinate;

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
    public String getCoordinates(){
        return coordinates;

    }

    /**
     * @return Returns the initial speed of the drone.
     * We can assume that the maximum speed of a drone is 100 units of some arbitrary measurement.
     */
    public int initializeSpeed() {
        return rand.nextInt(100) + 1;

    }

    /**
     * @return Returns the initial geo-location of the drone.
     * We can assume that the boundaries of the space in which the drone can travel are (0, 0) and (50, 50).
     */
    public String initializeCoordinates() {
        return (rand.nextInt(50) + 1) + "," + (rand.nextInt(50) + 1);

    }

    /**
     * Updates the speed of the drone.
     * There is a 33% chance of the speed being increased by a unit if and only if it is smaller than 100,
     * the same probability of it being decreased by a unit if and only if it is bigger than 0,
     * and the rest of the time the speed stays the same.
     */
    public void updateSpeed() {
        int probability = rand.nextInt(3) + 1;

        if (probability == 1 && this.speed < 100) {
            this.setSpeed(getSpeed() + 1);

        } else if (probability == 2 && this.speed > 0) {
            this.setSpeed(getSpeed() - 1);

        }

    }

    /**
     * Updates the coordinates of the drone.
     * There is a 50% chance of the x-coordinate or the y-coordinate to be either increased or decreased
     * by a unit of some arbitrary measurement, 25% chance of both of them being either increased or decreased,
     * if and only if they are bigger than 0 and smaller than 50, and the rest of the time they stay the same.
     */
    public void updateCoordinates() {
        String currentCoordinates = this.getCoordinates();
        Scanner line = new Scanner(currentCoordinates).useDelimiter(",");
        int xCoordinate = line.nextInt();
        int yCoordinate = line.nextInt();

        int probability = rand.nextInt(4) + 1;

        if (probability == 1) {
            if (rand.nextBoolean() && xCoordinate < 50) {
                xCoordinate++;

            } else {
                if (xCoordinate > 0){
                    xCoordinate--;

                }

            }

        } else if (probability == 2) {
            if (rand.nextBoolean() && yCoordinate < 50) {
                yCoordinate++;

            } else {
                if (yCoordinate > 0){
                    yCoordinate--;

                }

            }

        } else if (probability == 3) {
            if (rand.nextBoolean() && xCoordinate < 50 && yCoordinate < 50) {
                xCoordinate++;
                yCoordinate++;

            } else {
                if (xCoordinate > 0 && yCoordinate > 0){
                    xCoordinate--;
                    yCoordinate--;

                }

            }

        }

        this.coordinates = xCoordinate + "," + yCoordinate;

    }

    /**
     * Prints the drone's unique ID and current speed.
     * The print statement is highlighted if the drone has not been moving for more than 10 seconds.
     * @param secondsCounter Seconds that have passed since the program started.
     */
    public void sendDetails(int secondsCounter) {

        this.updateSpeed();
        this.updateCoordinates();


        if (secondsCounter % 10 == 0){
            if (coordinates.equals(lastCoordinates)) {
                this.moving = false;
            } else {
                this.moving = true;

            }
            this.lastCoordinates = coordinates;

        }

        if (this.moving) {
            System.out.printf("  Drone ID: %d Speed: %d  |", this.getUniqueId(), this.getSpeed());

        } else {
            System.out.printf(ANSI_RED + "  Drone ID: %d Speed: %d  |" + ANSI_RESET, this.getUniqueId(), this.getSpeed());

        }

    }

}
