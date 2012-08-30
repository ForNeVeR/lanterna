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

package com.googlecode.lanterna.terminal.text;

import com.googlecode.lanterna.terminal.Terminal.Color;

/**
 * Helper methods for the Color values.
 *
 * @author ForNeVeR
 */
public class ColorHelper {

    public static int getRed(Color color) {
        switch (color) {
            case BLUE:
            case CYAN:
            case GREEN:
            case WHITE:
            case YELLOW:
                return 0;
            case BLACK:
            case MAGENTA:
            case RED:
                return 255;
        }

        return 0;
    }

    public static int getGreen(Color color) {
        switch (color) {
            case BLUE:
            case MAGENTA:
            case RED:
            case WHITE:
                return 0;
            case BLACK:
            case CYAN:
            case GREEN:
            case YELLOW:
                return 255;
        }

        return 0;
    }

    public static int getBlue(Color color) {
        switch (color) {
            case GREEN:
            case RED:
            case WHITE:
            case YELLOW:
                return 0;
            case BLACK:
            case BLUE:
            case CYAN:
            case MAGENTA:
                return 255;
        }

        return 0;
    }
}
