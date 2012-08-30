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

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.WString;
import java.nio.Buffer;

/**
 * Kernel32.dll interface.
 *
 * @author ForNeVeR
 */
public interface Kernel32 extends Library {

    Kernel32 INSTANCE = (Kernel32) Native.loadLibrary("Kernel32", Kernel32.class);
    static final int STD_INPUT_HANDLE = -10;
    static final int STD_OUTPUT_HANDLE = -11;
    static final int STD_ERROR_HANDLE = -12;
    static final short FOREGROUND_BLUE = 0x01;
    static final short FOREGROUND_GREEN = 0x02;
    static final short FOREGROUND_RED = 0x04;
    static final short FOREGROUND_INTENSITY = 0x08;
    static final short BACKGROUND_BLUE = 0x10;
    static final short BACKGROUND_GREEN = 0x20;
    static final short BACKGROUND_RED = 0x40;
    static final short BACKGROUND_INTENSITY = 0x80;

    Pointer GetStdHandle(int nStdHandle);

    boolean GetConsoleScreenBufferInfo(
            Pointer hConsoleOutput,
            ConsoleScreenBufferInfo lpConsoleScreenBufferInfo);

    boolean SetConsoleCursorPosition(Pointer hConsoleOutput, Coord.ByValue dwCursorPosition);

    boolean SetConsoleTextAttribute(Pointer hConsoleOutput, short wAttributes);

    boolean WriteConsoleW(
            Pointer hConsoleOutput,
            WString lpBuffer,
            int nNumberOfCharsToWrite,
            Buffer lpNumberOfCharsWritten,
            Pointer lpReserved);

    boolean FillConsoleOutputCharacterW(
            Pointer hConsoleOutput,
            char cCharacter,
            int nLength,
            Coord.ByValue dwWriteCoord,
            Buffer lpNumberOfCharsWritten);
}
