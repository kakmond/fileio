package ku.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;

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
	static void copy(InputStream in, OutputStream out) throws IOException {

		try {
			int index;
			while ((index = in.read()) != -1) {
				out.write(index);
			}
		} catch (IOException e) {
			throw new RuntimeException();
		} finally {
			in.close();
			out.close();
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
	static void copy(InputStream in, OutputStream out, int blocksize) throws IOException {

		try {
			byte[] buffer = new byte[blocksize];
			int index;
			while ((index = in.read(buffer)) != -1) {
				out.write(index);
			}
		} catch (IOException e) {
			throw new RuntimeException();
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
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
	static void bcopy(InputStream in, OutputStream out) throws IOException {

		BufferedReader bufferedReader = null;
		Reader reader = null;
		PrintWriter print = null;
		try {
			reader = new InputStreamReader(in);
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
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}
}
