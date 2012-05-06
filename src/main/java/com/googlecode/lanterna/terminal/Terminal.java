/*
 * This file is part of lanterna (http://code.google.com/p/lanterna/).
 * 
 * lanterna is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * Copyright (C) 2010-2012 mabe02
 */

package com.googlecode.lanterna.terminal;

import com.googlecode.lanterna.LanternaException;
import com.googlecode.lanterna.input.InputProvider;
import com.googlecode.lanterna.input.KeyMappingProfile;

/**
 * This is the main terminal interface, at the lowest level supported by Lanterna.
 * You can implement your own implementation of this if you want to target an
 * exotic text terminal specification or another graphical environment (like SWT).
 * @author mabe02
 */
public interface Terminal extends InputProvider
{
    /**
     * Calling this method will, where supported, give your terminal a private
     * area to use, separate from what was there before. Some terminal emulators
     * will preserve the terminal history and restore it when you exit private 
     * mode. 
     * @throws LanternaException 
     */
    public void enterPrivateMode() throws LanternaException;
    
    /**
     * If you have previously entered private mode, this method will exit this
     * and, depending on implementation, maybe restore what the terminal looked
     * like before private mode was entered.
     * @throws LanternaException 
     */    
    public void exitPrivateMode() throws LanternaException;
    
    /**
     * Removes all the characters, colors and graphics from the screep and leaves
     * you with a big empty space. Text cursor position is undefined after this 
     * call (depends on platform and terminal) so you should always call 
     * {@code moveCursor} next.
     * @throws LanternaException 
     */    
    public void clearScreen() throws LanternaException;
    
    /**
     * Moves the text cursor to a new location
     * @param x The 0-indexed column to place the cursor at
     * @param y The 0-indexed row to place the cursor at
     * @throws LanternaException 
     */    
    public void moveCursor(int x, int y) throws LanternaException;
    
    /**
     * Prints one character to the terminal at the current cursor location. Please
     * note that the cursor will then move one column to the right but if reached
     * the end of the line may move to the beginning of the next line.
     * @param c
     * @throws LanternaException 
     */
    public void putCharacter(char c) throws LanternaException;
    
    /**
     * Activates an {@code SGR} code for all the following characters put to the 
     * terminal.
     * @param options List of SGR codes
     * @throws LanternaException 
     * @see Terminal.SGR
     */
    public void applySGR(SGR... options) throws LanternaException;
    
    /**
     * Changes the foreground color for all the following characters put to the 
     * terminal. The foreground color is what color to draw the text in.
     * @param color Color to use for foreground
     * @throws LanternaException 
     */    
    public void applyForegroundColor(Color color) throws LanternaException;
    
    /**
     * Changes the background color for all the following characters put to the 
     * terminal. The background color is the color surrounding the text being 
     * printed.
     * @param color Color to use for the background
     * @throws LanternaException 
     */    
    public void applyBackgroundColor(Color color) throws LanternaException;
    
    /**
     * Enables or disables keyboard echo, meaning the immediate output of the
     * characters you type on your keyboard. If your users are going to interact
     * with this application through the keyboard, you probably want to disable
     * echo mode.
     * @param echoOn true if keyboard input will immediately echo, false if it's hidden
     * @throws LanternaException 
     */    
    public void setEcho(boolean echoOn) throws LanternaException;
    
    /**
     * Enabling cbreak mode will allow you to read user input immediately as the
     * user enters the characters, as opposed to reading the data in lines as
     * the user presses enter. If you want your program to respond to user input
     * by the keyboard, you probably want to enable cbreak mode. 
     * @see <a href="http://en.wikipedia.org/wiki/POSIX_terminal_interface">POSIX terminal interface</a>
     * @param cbreakOn
     * @throws LanternaException 
     */
    public void setCBreak(boolean cbreakOn) throws LanternaException;
    
    /**
     * Adds a {@code ResizeListener} to be called when the terminal has changed
     * size. 
     * @see ResizeListener
     * @param listener Listener object to be called when the terminal has been changed
     */
    public void addResizeListener(ResizeListener listener);
    
    /**
     * Removes a {@code ResizeListener} from the list of listeners to be notified
     * when the terminal has changed size
     * @see ResizeListener
     * @param listener Listener object to remove
     */
    public void removeResizeListener(ResizeListener listener);
    
    /**
     * Will ask the terminal of its current size dimensions, represented by a 
     * {@code TerminalSize} object. Please note that the default way of figuring 
     * this information out is asynchorous and so you will be given the last
     * known dimensions. With proper resize listeners set up, this will only be
     * a problem for figuring out the initial size of the terminal.
     * @return a {@code TerminalSize} object representing the size of the terminal
     * @throws LanternaException 
     * @see TerminalSize
     */
    public TerminalSize queryTerminalSize() throws LanternaException;
    
    /**
     * Calls {@code flush()} on the underlying {@code OutputStream} object, or
     * whatever other implementation this terminal is built around. 
     * @throws LanternaException 
     */
    public void flush() throws LanternaException;

    /**
     * SGR - Select Graphic Rendition, changes the state of the terminal as to
     * what kind of text to print after this command. When applying an ENTER SGR 
     * code, it normally applies until you send the corresponding EXIT code. 
     * RESET_ALL will clear any code currently enabled.
     */
    public enum SGR
    {
        /**
         * Removes any code SGR code currently enabled
         */
        RESET_ALL,
        ENTER_BOLD,
        ENTER_REVERSE,
        ENTER_UNDERLINE,
        /**
         * This code may not be supported by all terminals/terminal emulators
         */
        ENTER_BLINK,
        EXIT_BOLD,
        EXIT_REVERSE,
        EXIT_UNDERLINE,
        EXIT_BLINK
    }

    public enum Color
    {
        BLACK(0),
        RED(1),
        GREEN(2),
        YELLOW(3),
        BLUE(4),
        MAGENTA(5),
        CYAN(6),
        WHITE(7),
        DEFAULT(9);

        private int index;

        private Color(int index) {
            this.index = index;
        }

        public int getIndex() {
            return index;
        }
    }

    public enum Style
    {
        Bold, 
        Underline, 
        Reverse, 
        Blinking
    }

    /**
     * Listener interface that can be used to be alerted on terminal resizing
     */
    public interface ResizeListener
    {
        public void onResized(TerminalSize newSize);
    }
}
