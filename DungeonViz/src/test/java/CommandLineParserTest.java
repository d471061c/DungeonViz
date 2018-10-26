/*
 * The MIT License
 *
 * Copyright 2018 d471061c.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

import com.d471061c.dungeonviz.exception.InvalidArgumentException;
import com.d471061c.dungeonviz.utils.CommandLineParser;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 *
 * @author d471061c
 */
public class CommandLineParserTest {
    
    @Rule
    public final ExpectedException exception = ExpectedException.none();
    
    private CommandLineParser parser;
    
    @Before
    public void setup() {
        this.parser = new CommandLineParser();
    }
    
    @Test
    public void parseRoomsWithoutShortcutTest() throws InvalidArgumentException {
        String[] input = {"--rooms", "7"};
        
        parser.parse(input);
        assertEquals(7, parser.getRooms());
    }
    
    @Test
    public void parseRoomsTest() throws InvalidArgumentException {
        String[] input = {"-r", "3"};
        
        parser.parse(input);
        assertEquals(3, parser.getRooms());
    }
    
    @Test
    public void failsWithNegativeAmountOfRoomsTest() throws InvalidArgumentException{
        String[] input = {"-r", "-3"};

        exception.expect(InvalidArgumentException.class);
        parser.parse(input);
        
    }
    
    @Test
    public void failsWithBadRoomsInputTest() throws InvalidArgumentException {
        String[] input = {"-r", "error"};
        
        exception.expect(InvalidArgumentException.class);
        parser.parse(input);
    }
    
    @Test
    public void parseWidthOfRoomsWithoutShortcutTest() throws InvalidArgumentException {
        String[] input = {"--width", "20"};
        
        parser.parse(input);
        assertEquals(20, parser.getWidth()); 
    }
    
    @Test
    public void parseWidthOfRoomsTest() throws InvalidArgumentException {
        String[] input = {"-w", "20"};
        
        parser.parse(input);
        assertEquals(20, parser.getWidth());
    }
    
    @Test
    public void parseWithNegativeWidthTest() throws InvalidArgumentException {
        String[] input = {"-w", "-3"};
        
        exception.expect(InvalidArgumentException.class);
        parser.parse(input);
    }
    
    @Test
    public void parseWithBadWidthTest() throws InvalidArgumentException {
        String input[] = {"-w", "error"};
        
        exception.expect(InvalidArgumentException.class);
        parser.parse(input);
    }
    
    
    @Test
    public void parseHeightOfRoomsWithoutShortcutTest() throws InvalidArgumentException {
        String[] input = {"--height", "20"};
        
        parser.parse(input);
        assertEquals(20, parser.getHeight()); 
    }
    
    @Test
    public void parseHeightOfRoomsTest() throws InvalidArgumentException {
        String[] input = {"-h", "20"};
        
        parser.parse(input);
        assertEquals(20, parser.getHeight());
    }
    
    @Test
    public void parseWithNegativeHeightTest() throws InvalidArgumentException {
        String[] input = {"-h", "-3"};
        
        exception.expect(InvalidArgumentException.class);
        parser.parse(input);
    }
    
    @Test
    public void parseWithBadHeightTest() throws InvalidArgumentException {
        String input[] = {"-h", "error"};
        
        exception.expect(InvalidArgumentException.class);
        parser.parse(input);
    }
    
    
    @Test
    public void parseSpreadXWithoutShortcutTest() throws InvalidArgumentException {
        String[] input = {"--spreadX", "20"};
        
        parser.parse(input);
        assertEquals(20, parser.getSpreadX()); 
    }
    
    @Test
    public void parseSpreadXTest() throws InvalidArgumentException {
        String[] input = {"-sx", "20"};
        
        parser.parse(input);
        assertEquals(20, parser.getSpreadX());
    }
    
    @Test
    public void parseWithNegativeSpreadXTest() throws InvalidArgumentException {
        String[] input = {"-sx", "-3"};
        
        exception.expect(InvalidArgumentException.class);
        parser.parse(input);
    }
    
    @Test
    public void parseWithBadSpreadXTest() throws InvalidArgumentException {
        String input[] = {"-sx", "error"};
        
        exception.expect(InvalidArgumentException.class);
        parser.parse(input);
    }
    
    
    @Test
    public void parseSpreadYWithoutShortcutTest() throws InvalidArgumentException {
        String[] input = {"--spreadY", "20"};
        
        parser.parse(input);
        assertEquals(20, parser.getSpreadY()); 
    }
    
    @Test
    public void parseSpreadYTest() throws InvalidArgumentException {
        String[] input = {"-sy", "20"};
        
        parser.parse(input);
        assertEquals(20, parser.getSpreadY());
    }
    
    @Test
    public void parseWithNegativeSpreadYTest() throws InvalidArgumentException {
        String[] input = {"-sy", "-3"};
        
        exception.expect(InvalidArgumentException.class);
        parser.parse(input);
    }
    
    @Test
    public void parseWithBadSpreadYTest() throws InvalidArgumentException {
        String input[] = {"-w", "error"};
        
        exception.expect(InvalidArgumentException.class);
        parser.parse(input);
    }
    
    @Test
    public void parseFixedSizeTest() throws InvalidArgumentException {
        String input[] = {"-fs", "false"};
        
        parser.parse(input);
        assertFalse(parser.isFixedSize());
    }
    
    @Test
    public void parseFixedSizeWithoutShortcutTest() throws InvalidArgumentException {
        String input[] = {"--fixedSize", "false"};
        
        parser.parse(input);
        assertFalse(parser.isFixedSize());
    }

}
