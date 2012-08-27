package org.no_ip.fornever.winapiterminal;

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

	Pointer GetStdHandle(int nStdHandle);

	boolean WriteConsoleW(
			Pointer hConsoleOutput,
			WString lpBuffer,
			int nNumberOfCharsToWrite,
			Buffer lpNumberOfCharsWritten,
			Pointer lpReserved);
}
