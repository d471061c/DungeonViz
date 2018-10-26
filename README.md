# DungeonViz
[![Build Status](https://travis-ci.org/d471061c/DungeonViz.svg?branch=master)](https://travis-ci.org/d471061c/DungeonViz)
[![Javadocs](https://img.shields.io/badge/javadoc-DungeonViz-brightgreen.svg?label=javadoc)](https://d471061c.github.io/DungeonViz/jdoc)


## What is DungeonViz?

DungeonViz is an application which produces a random dungeon using Prim's algorithm.

## How to use

DungeonViz is written in java. To run this software you can use the following command:
```
$ java -jar DungeonViz-1.0-SNAPSHOT.jar
DungeonViz, beta version
   -r, --rooms       amount of rooms, default = 5
   -w, --width       width of rooms, default = 20
   -h, --height      height of rooms, default = 20
   -sx, --spreadX    spread in x direction of rooms, default = 50
   -sy, --spreadY    spread in y direction of rooms, default = 50
   -fs, --fixedSize  whether or not the size of the rooms are fixed, default = true
```

Example usage:
```
$ java -jar DungeonViz-1.0-SNAPSHOT.jar -r 9 -sx 100 -sy 100
            ##########
            #........#
            #........#
            #........#
    #########........#
    #................#
    #.#######........#
    #.#     #........#
    #.#     #........#
    #.#     ##########
    #.#
    #.#
    #.#
    #.#
    #.#
    #.#
    #.#
    #.#
    #.#
    #.#
    #.#
    #.#
    #.#
#####.####
#........#                     ##########
#........#                     #........#
#........#       ##########    #........#
#........#########........#    #........#
#.........................#    #........#####################
#........#########........#    #............................#
#........#       #........######........###################.#
#........#       #......................#                 #.#
##########       #........######........#                 #.#
                 #........#    #####.####                 #.#
                 #........#        #.#                    #.#
                 ##########        #.#    ##########      #.#
                                   #.#    #........#      #.#
                                   #.#    #........#      #.#
                                   #.#    #........#      #.#
                                   #.######........#      #.#
                                   #...............#      #.#
                                   ########........#      #.#
                                          #........#      #.#
                                          #........#      #.#
                                          ##########      #.#
                                                          #.#
                                                          #.#
                                                          #.#
                                                          #.#
                                                          #.#
                                                          #.#
                                                          #.#
                                                          #.#      ##########
                                                          #.#      #........#
                                                          #.#      #........#
                                                          #.#      #........#
                                                          #.########........#
                                                          #.................#
                                                          #.########........#
                                                          #.#      #........#
                                                          #.#      #........#
                                                          #.#      ##########
                                                      #####.####
                                                      #........#
                                                      #........#
                                                      #........#
                                       ################........#
                                       #.......................#
                                       #.##############........#
                                       #.#            #........#
                                       #.#            #........#
                                       #.#            #####.####
                                       #.#                #.#
                                       #.#                #.#
                                       #.#                #.#
                                       #.#                #.#
                                   #####.####             #.#
                                   #........#            ##.#######
                                   #........#            #........#
                                   #........#            #........#
                                   #........#            #........#
                                   #........#            #........#
                                   #........#            #........#
                                   #........#            #........#
                                   #........#            #........#
                                   ##########            #........#
                                                         ##########
```