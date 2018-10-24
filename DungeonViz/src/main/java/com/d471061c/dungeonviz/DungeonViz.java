package com.d471061c.dungeonviz;

import com.d471061c.dungeonviz.domain.Dungeon;
import com.d471061c.dungeonviz.exception.InvalidArgumentException;
import com.d471061c.dungeonviz.logic.DungeonGenerator;
import com.d471061c.dungeonviz.logic.RoomFactory;
import com.d471061c.dungeonviz.utils.CommandLineParser;

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
            System.out.println(ex.getMessage());
            return;
        }

        RoomFactory roomFactory = new RoomFactory();

        // Will be refactored in future
        roomFactory.setMaximumHeight(parser.getHeight());
        roomFactory.setMaximumWidth(parser.getWidth());
        roomFactory.setFixedSize(parser.isFixedSize());
        int rooms = parser.getRooms();

        DungeonGenerator generator = new DungeonGenerator(roomFactory);
        Dungeon dungeon = generator.generateDungeon(rooms);

        System.out.println(dungeon);

    }

    public static void main(String[] args) {
        parseCommandLine(args);
    }

}
