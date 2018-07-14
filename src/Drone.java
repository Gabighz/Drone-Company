/**
 * This class constructs a Drone object.
 * It has get and set methods for its unique identifier, speed, and geo-location coordinates.
 * It has no set method for its unique identifier as it shouldn't be changed.
 *
 * @author Gabriel Ghiuzan
 */
public class Drone {

    // The unique identifier of the drone
    private final int uniqueId;

    // The speed of the drone
    private int speed;

    // The geo-location coordinates of the drone
    private int coordinates;

    /**
     * Constructs a Drone
     * @param uniqueId The unique identifier of the drone.
     * @param speed The speed of the drone.
     * @param coordinates The geo-location coordinates of the drone.
     */
    public Drone(int uniqueId, int speed, int coordinates){
        this.uniqueId = uniqueId;
        this.speed = speed;
        this.coordinates = coordinates;
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

}
