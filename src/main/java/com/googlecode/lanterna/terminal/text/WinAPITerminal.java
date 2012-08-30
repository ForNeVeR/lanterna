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

import com.googlecode.lanterna.terminal.TerminalSize;
import com.googlecode.lanterna.terminal.text.winapi.ConsoleScreenBufferInfo;
import com.googlecode.lanterna.terminal.text.winapi.Coord;
import com.googlecode.lanterna.terminal.text.winapi.Kernel32;
import com.sun.jna.Pointer;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/**
 * Terminal for pure Windows environment.
 *
 * @author ForNeVeR
 */
public class WinAPITerminal extends StreamBasedTerminal {

    private final Kernel32 kernel32;
    private Pointer outputHandle;

    public WinAPITerminal(
            InputStream inputStream,
            OutputStream outputStream,
            Charset terminalCharset) {
        super(inputStream, outputStream, terminalCharset);

        kernel32 = Kernel32.INSTANCE;
    }

    @Override
    public void enterPrivateMode() {
        // TODO: Clear screen at least?
    }

    @Override
    public void exitPrivateMode() {
        // TODO: Nothing here?
    }

    @Override
    public void clearScreen() {
        // TODO: Error handling.
        Pointer handle = getOutputHandle();

        TerminalSize terminalSize = getTerminalSize();
        int size = terminalSize.getColumns() * terminalSize.getRows();

        Coord.ByValue coord = new Coord.ByValue();
        coord.x = 0;
        coord.y = 0;

        kernel32.FillConsoleOutputCharacterW(handle, ' ', size, coord, ByteBuffer.allocate(4));
        // TODO: Clear colors?
        // TODO: Move cursor to (0, 0)?
    }

    @Override
    public void moveCursor(int x, int y) {
        Pointer handle = getOutputHandle();
        Coord.ByValue coord = new Coord.ByValue();
        coord.x = (short) x;
        coord.y = (short) y;

        kernel32.SetConsoleCursorPosition(handle, coord);
    }

    @Override
    public void applySGR(SGR... options) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void applyForegroundColor(Color color) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void applyForegroundColor(int r, int g, int b) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void applyBackgroundColor(Color color) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void applyBackgroundColor(int r, int g, int b) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Deprecated
    @Override
    public TerminalSize queryTerminalSize() {
        return getTerminalSize();
    }

    @Override
    public TerminalSize getTerminalSize() {
        // TODO: Error handling.
        Pointer handle = getOutputHandle();

        ConsoleScreenBufferInfo info = new ConsoleScreenBufferInfo();
        kernel32.GetConsoleScreenBufferInfo(handle, info);

        return new TerminalSize(info.dwSize.x, info.dwSize.y);
    }

    private Pointer getOutputHandle() {
        if (outputHandle == null) {
            outputHandle = kernel32.GetStdHandle(Kernel32.STD_OUTPUT_HANDLE);
        }

        return outputHandle;
    }
}
