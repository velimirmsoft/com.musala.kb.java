
NearestAeroplane task ...

We want to find the closest airborne aeroplane to any given position in North America or Europe. 
To assist in this we can use an API which will give us the data on all currently airborne commercial aeroplanes in these regions.

OpenSky's Network API can return to us all the data we need in a JSON format.

https://opensky-network.org/api/states/all
From this we can find the positions of all the planes and compare them to our given position.

Use the basic Euclidean distance in your calculation.