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
