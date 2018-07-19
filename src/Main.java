/*
 * This class starts the program. It displays the active drones and their current speed.
 * Also, it highlights drones which have not been moving for more than 10 seconds.
 *
 */

import java.util.Scanner;

 
@SuppressWarnings("WeakerAccess")
public class Main {

    public static void main(String[] args){

        Drone firstDrone = new Drone();
        Drone secondDrone = new Drone();
        Drone thirdDrone = new Drone();

        int secondsCounter = 0;
        Boolean run = true;


        Scanner in = new Scanner(System.in);
        System.out.println("Type 'stop' to cease execution.");


        while(run) {

            /*
             * Given that cellular modem connections are expensive, we can assume that having the drones report back
             * just every one second would use as little data as possible while keeping the user reasonably informed.
             */
            try {
                Thread.sleep(1000);
                secondsCounter++;

            } catch (InterruptedException e) {
                e.printStackTrace();

            }

            System.out.print("\r");

            firstDrone.sendDetails(secondsCounter);
            secondDrone.sendDetails(secondsCounter);
            thirdDrone.sendDetails(secondsCounter);

            if(in.next().equals("stop")){
                run = false;

            }

        }

    }
}
