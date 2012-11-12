# MancalaConcurrent

This is a Java implementation of a sequence I developed while working on a Magic: The Gathering simulator.  I was trying to express all possible combinations of cards in an M:TG deck.

The name comes from the board game Mancala, where beads are moved between different slots on a board.  The metaphor is applicable, because the algorithm involves moving a constant number of 'beads', which represents the number of cards in a deck, between 'slots', which represent the available cards.

![image of a mancala board](http://i.imgur.com/hOHGh.png)

This particular project implements the mancala sequence with the producer-consumer pattern.  In theory, one producer could generate M:TG deck combinations for several concurrent deck simulators.