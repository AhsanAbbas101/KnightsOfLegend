# KnightsOfLegend

KnightsOfLegend is Java Implementation of [Round Table Games: Knights of Legend](https://www.cs.colostate.edu/~cs163/.Fall21/practicals/p5/knightfight-revamp/)

## Build and Execute
To compile the files, execute the folllowing command in base directory:
```
javac src/*.java
```
To run the program, execute:
```
java -cp src Main
```

## Features
### File Handling

Program data is be stored in CSV files, read at the launch of the program. The program also saves the current progress of the knights. There are both default files, and the ability to pass in files via the command line.

### Knights
Knights gain experience defeating monsters, and there can only be four active knights on a quest at a time.

### Fortunes / Bonus Cards
Before knights start a quest, a random fortune is assigned to them. This fortune provides bonuses or even minuses if the fortune is bad.

### MOBS / Monsters
Knights will have random encounters with 1-4 monsters (depending on the number of active knights).

### Team Management
When not on a quest, players can view information on each knight, and manage their active knight pool. Knights never “die”, they are just defeated and return to the normal pool.

### Text-based game
The entire game is text based to the System console (System.out / System.in), however, it is done in a way that can easily be replaced.
