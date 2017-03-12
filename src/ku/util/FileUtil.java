package ku.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;

/**
 * This class for copy the InputStream to the OutputStream.
 * 
 * @author Wongsathorn Panichkurkul
 *
 */
public class FileUtil {

	/**
	 * Copy the InputStream to the OutputStream one byte at a time. Close the
	 * InputStream and OutputStream when finished.
	 * 
	 * @param in
	 *            is the Object of InputStream.
	 * @param out
	 *            is the Object of OutputStream.
	 * @throws RuntimeException
	 *             if it cannot copy the InputStream to the OutputStream.
	 */
	public static void copy(InputStream in, OutputStream out) {

		try {
			int index;
			while ((index = in.read()) != -1) {
				out.write(index);
			}
		} catch (IOException e) {
			throw new RuntimeException();
		} finally {
			try {
				in.close();
				out.close();
			} catch (IOException e) {
				throw new RuntimeException();
			}
		}
	}

	/**
	 * Copy the InputStream to the OutputStream using a byte array of size
	 * blocksize. Close the InputStream and OutputStream when finished.
	 * 
	 * @param in
	 *            is the Object of InputStream.
	 * @param out
	 *            is the Object of OutputStream.
	 * @param blocksize
	 *            the the byte array of size.
	 * @throws RuntimeException
	 *             if it cannot copy the InputStream to the OutputStream.
	 */
	public static void copy(InputStream in, OutputStream out, int blocksize) {

		try {
			byte[] buffer = new byte[blocksize];
			int index;
			while ((index = in.read(buffer)) != -1) {
				out.write(index);
			}
		} catch (IOException e) {
			throw new RuntimeException();
		} finally {
			try {
				in.close();
				out.close();
			} catch (IOException e) {
				throw new RuntimeException();
			}
		}

	}

	/**
	 * Copy the InputStream to the OutputStream using a BufferedReader to read
	 * the InputStream and PrintWriter to write the OutputStream. Read and write
	 * one line at a time.
	 * 
	 * @param in
	 *            is the Object of InputStream.
	 * @param out
	 *            is the Object of OutputStream.
	 * @throws RuntimeException
	 *             if it cannot copy the InputStream to the OutputStream.
	 */
	public static void bcopy(InputStream in, OutputStream out) {

		BufferedReader bufferedReader = null;
		PrintWriter print = null;
		try {
			Reader reader = new InputStreamReader(in);
			bufferedReader = new BufferedReader(reader);
			print = new PrintWriter(out);
			String index;
			while ((index = bufferedReader.readLine()) != null) {
				print.write(index);
				print.write("\r\n");
			}
		} catch (IOException e) {
			throw new RuntimeException();
		} finally {
			try {
				bufferedReader.close();
				print.close();
			} catch (IOException e) {
				throw new RuntimeException();
			}

		}
	}

	/**
	 * Read and write using BufferReader and BufferWriter with an array of char.
	 * 
	 * @param in
	 *            is the Object of InputStream.
	 * @param out
	 *            is the Object of OutputStream.
	 * @param blocksize
	 *            the char array of size.
	 * @throws RuntimeException
	 *             if it cannot copy the InputStream to the OutputStream.
	 */
	public static void charcopy(InputStream in, OutputStream out, int blocksize) {

		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		try {
			Reader reader = new InputStreamReader(in);
			Writer writer = new OutputStreamWriter(out);
			bufferedReader = new BufferedReader(reader);
			bufferedWriter = new BufferedWriter(writer);
			char[] charecter = new char[blocksize];
			int index;
			while ((index = bufferedReader.read(charecter)) != -1) {
				bufferedWriter.write(charecter, 0, index);
			}

		} catch (IOException e) {
			throw new RuntimeException();
		} finally {
			try {
				bufferedReader.close();
				bufferedWriter.close();
			} catch (IOException e) {
				throw new RuntimeException();
			}
		}
	}
}
