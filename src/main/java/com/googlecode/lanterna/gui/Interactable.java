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
 * Copyright (C) 2010-2012 Martin
 */

package com.googlecode.lanterna.gui;

import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.TerminalPosition;

/**
 * Any component which wants to recieve keyboard events must implement this
 * interface.
 * @author Martin
 */
public interface Interactable
{
    /**
     * This method is called when this component has focus and the user has
     * pressed a key on the keyboard
     * @param key Key pressed on the keyboard
     * @param result Change the value inside this object for the desired action
     * to be taken by the GUI system as a result of this interaction
     */
    public void keyboardInteraction(Key key, InteractableResult result);
    
    /**
     * Method called when this component gained keyboard focus
     * @param direction What direction did the focus come from
     */
    public void onEnterFocus(FocusChangeDirection direction);
    /**
     * Method called when this component leaves keyboard focus
     * @param direction What direction is focus going to
     */
    public void onLeaveFocus(FocusChangeDirection direction);
    
    /**
     * When the component has keyboard focus, this method is called by the GUI
     * system to figure out where should the cursor be positioned
     * @return position of the cursor, in component-local coordinates
     */
    public TerminalPosition getHotspot();

    /**
     * The available results from a keyboard interaction
     */
    public enum Result
    {
        /**
         * The event has been dealt with, don't do anything special
         */
        DO_NOTHING,
        /**
         * Move keyboard focus to the next component
         */
        NEXT_INTERACTABLE,
        /**
         * Move keyboard focus to the previous component
         */
        PREVIOUS_INTERACTABLE
    }

    /**
     * When focus has changed, which direction
     */
    public enum FocusChangeDirection
    {
        /**
         * The next interactable component
         */
        DOWN_OR_RIGHT,
        /**
         * The previous interactable component
         */
        UP_OR_LEFT
    }
}
