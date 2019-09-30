# Ant colony

## About the project

This is an execrise project I've made during Codecool course. Its aim was to practice using OOP concepts in Java.

## Rules

The colony of ants in the project operates according to the following rules:

* In an Ant colony there are four different castes: Workers, Soldiers, Drones, and there is one Queen.
* Ants live on a grid. Ants have an actual ( x , y ) position. They change their positions in each timestep, according to a caste-specific rule:
* The Queen sits in the origo and does not move.
* All the Ants are aware of their distance from the Queen which is the number of steps needed to get to her.
* The Workers normally make one step randomly in one of the four directions.
* The Soldiers normally just “patrol” close to their starting points; this means that in a 4-cycle they step one towards North, then East, South, and West, and then they start the cycle again.
* The Drones always try to make one step towards the Queen. When they get 3 steps close, they have a chance that the Queen is in the mood of mating. In this happy case they, stay there for 5 timesteps, and after that they are kicked off to a random corner of the colony. If they do not have luck, they and are kicked to a random corner of the colony instantly.
* The Queen’s mating mood is following this rule: after a successful mating she sets a countdown timer to get in the mood again. 
