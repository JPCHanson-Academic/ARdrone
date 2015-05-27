#ARdrone
This project was part of a Brunel University Code-a-thon, to control a Parrot AR Drone 2.0 and have it fly 
autonomously to and from coordinates given in a text file scanning QR codes at each of the coordinate locations. These QR codes contain 
words which when taken together make a "secret message", the drone to make the message wins.

The project was split into the following general sub problems:

* sensors  
* control  
* GUI  
* QR Capture  
* Travelling Salesman  
* Video  

This project has been written in Java as that was one of brunel's requirements, even though the native SDK is written in C++.

The /ARdrone/src/ folder contains 3 sub folders Drone/, ReferencedLibraries/ and workspace/ All of the work done for this project is 
contained within the Drone/ directory. ReferencedLibraries/ is more or less what the name suggests, and workspace/ is a poor attempt by 
Brunel lecturers to create a java "API", however each is currently a functional program with a main I assume for testing purposes. At some 
point I need to clean this up.

## TODO
* clean up "API" and integrate it into the framework properly
