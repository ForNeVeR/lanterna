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
 * Copyright (C) 2012 von Never
 */

package com.googlecode.lanterna.terminal.text.winapi;

/**
 * Helper methods for WinAPI console text attributes.
 *
 * @author ForNeVeR
 */
public abstract class ConsoleTextAttributeHelper {

    /**
     * Clears the bits responding for foreground color parameters.
     *
     * @param attributes the attributes.
     * @return resulting attributes.
     */
    public static short clearForegroundColor(short attributes) {
        return (short) (attributes
                & ~Kernel32.FOREGROUND_RED
                & ~Kernel32.FOREGROUND_GREEN
                & ~Kernel32.FOREGROUND_BLUE);
    }

    /**
     * Sets the bits for the foreground color.
     *
     * @param attributes the attributes.
     * @return resulting attributes.
     */
    public static short setForegroundColor(short attributes, int red, int green, int blue) {
        if (red > 0) {
            attributes |= Kernel32.FOREGROUND_RED;
        }
        if (green > 0) {
            attributes |= Kernel32.FOREGROUND_GREEN;
        }
        if (blue > 0) {
            attributes |= Kernel32.FOREGROUND_BLUE;
        }

        return attributes;
    }

    /**
     * Clears the bits responding for background color parameters.
     *
     * @param attributes the attributes.
     * @return resulting attributes.
     */
    public static short clearBackgroundColor(short attributes) {
        return (short) (attributes
                & ~Kernel32.BACKGROUND_RED
                & ~Kernel32.BACKGROUND_GREEN
                & ~Kernel32.BACKGROUND_BLUE);
    }

    /**
     * Sets the bits for the background color.
     *
     * @param attributes the attributes.
     * @return resulting attributes.
     */
    public static short setBackgroundColor(short attributes, int red, int green, int blue) {
        if (red > 0) {
            attributes |= Kernel32.BACKGROUND_RED;
        }
        if (green > 0) {
            attributes |= Kernel32.BACKGROUND_GREEN;
        }
        if (blue > 0) {
            attributes |= Kernel32.BACKGROUND_BLUE;
        }

        return attributes;
    }
}
