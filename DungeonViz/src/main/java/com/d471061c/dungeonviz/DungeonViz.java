package com.d471061c.dungeonviz;

import com.d471061c.dungeonviz.domain.Dungeon;
import com.d471061c.dungeonviz.domain.PrimObject;
import com.d471061c.dungeonviz.domain.datastructures.PrimObjectHeap;
import com.d471061c.dungeonviz.exception.InvalidArgumentException;
import com.d471061c.dungeonviz.logic.DungeonGenerator;
import com.d471061c.dungeonviz.logic.RoomFactory;
import com.d471061c.dungeonviz.utils.CommandLineParser;
import java.util.Arrays;

/**
 * @author d471061c
 */
public class DungeonViz {
    
    public static void parseCommandLine(String[] args) {
        
        CommandLineParser parser = new CommandLineParser();
        if (args.length == 0) {
            parser.displayInfo();
            return;
        }
        
        try {
            parser.parse(args);
            
            
        } catch (InvalidArgumentException ex) {
            System.out.println(ex);
        }
        
        RoomFactory roomFactory = new RoomFactory();
            
            // Will be refactored in future
            if (parser.getHeight() > 10) {
                roomFactory.setMaximumHeight(parser.getHeight());
            }
            
            if (parser.getWidth() > 10) {
                roomFactory.setMaximumWidth(parser.getWidth());
            }
            
            roomFactory.setFixedSize(parser.isFixedSize());
            int rooms = parser.getRooms() > 0 ? parser.getRooms() : 5;
            
            //System.out.format("Generated dungeon with %d rooms.\n", rooms);
            
            DungeonGenerator generator = new DungeonGenerator();
            Dungeon dungeon = generator.generateDungeon(rooms);
            
            
            System.out.println(dungeon);
        
    }

    public static void main(String[] args) {
        parseCommandLine(args);
    }

}
