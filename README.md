# Drone Company

This Java application simulates a company's central server which has drones flying in a country.

## Dashboard

The interface of this application displays the active drones by their unique identifiers and their current speed. 

Drones which have not moved for more than 10 seconds are highlighted. To this purpose, a drone's last location from 10 seconds ago is checked with its current location. If they are the same, its colour is changed to red.

Given that cellular modem connections are expensive, we can assume that having the drones report back just every one second would use as little data as possible while keeping the user reasonably informed.

## Drone

A drone is constructed with a unique identifier, random speed and random geo-location coordinates.
<ul>
  <li><b>Unique identification</b> works with an identifier counter which is incremented after each time a drone is assigned to its current value.</li>
  <li>The <b>initial speed</b> is a random value between 0 and 100. We can assume that the maximum speed of a drone is 100 units of some arbitrary measurement.</li>
  <li>The <b>initial geo-location coordinates</b> are randomly choosen between 0, 0 and 50, 50. We can assume that these are the boundaries of the space in which the drone can travel.</li>
</ul>

The current speed and the current geo-location coordinates of the drone are updated every one second. Moreover, a check occurs if it moving.
<ul>
  <li><b>Updating the speed of the drone:</b> There is a 33% chance of the speed being increased by a unit if and only if it is smaller than 100, the same probability of it being decreased by a unit if and only if it is bigger than 0, and the rest of the time the speed stays the same.</li>
  <li><b>Updating the geo-location coordinates of the drone:</b> There is a 50% chance of the x-coordinate or the y-coordinate to be either increased or decreased by a unit of some arbitrary measurement, 25% chance of both of them being either increased or decreased, if and only if they are bigger than 0 and smaller than 50, and the rest of the time they stay the same.</li>
  <li><b>Checking if the drone is moving:</b> There are two variables, one which holds the drone's last coordinates and one which holds the drone's current coordinates. There is a counter which starts counting seconds from the start of the program. When the value of this counter is a multiple of 10, it is checked if the last coordinates of the drone are equal to its current coordinates. If so, the drone is defined as unmoving. Afterwards, regardless of whether it is moving or not, the last coordinates are updated with the current coordinates.
</ul>
