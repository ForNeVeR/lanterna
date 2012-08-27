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

import com.sun.jna.Structure;

/**
 * Windows COORD structure.
 *
 * @author ForNeVeR
 */
public class Coord extends Structure {

    public short x;
    public short y;

    public Coord(short x, short y) {
        this.x = x;
        this.y = y;
    }
}
