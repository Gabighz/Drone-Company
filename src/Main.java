/**
 * This class starts the program. It creates a window and displays the active drones and their current speed.
 * Also, it highlights drones which have not been moving for more than 10 seconds.
 *
 * @author Gabriel Ghiuzan
 */

 
@SuppressWarnings("WeakerAccess")
public class Main {

    public static void main(String[] args){

        Drone firstDrone = new Drone();
        Drone secondDrone = new Drone();
        Drone thirdDrone = new Drone();

        while(true) {

            /*
             * Given that cellular modem connections are expensive, we can assume that having the drones report back
             * just every one second would use as little data as possible while keeping the user reasonably informed.
             */
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();

            }

            System.out.print("\r");

            firstDrone.sendDetails();
            secondDrone.sendDetails();
            thirdDrone.sendDetails();

        }

    }
}
