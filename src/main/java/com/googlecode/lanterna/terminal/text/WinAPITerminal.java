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
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

/**
 * Terminal for pure Windows environment.
 *
 * @author ForNeVeR
 */
public class WinAPITerminal extends StreamBasedTerminal {

    public WinAPITerminal(
            InputStream inputStream,
            OutputStream outputStream,
            Charset terminalCharset) {
        super(inputStream, outputStream, terminalCharset);
    }

    @Override
    public void enterPrivateMode() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void exitPrivateMode() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void clearScreen() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void moveCursor(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet.");
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

    @Override
    public TerminalSize queryTerminalSize() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public TerminalSize getTerminalSize() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
