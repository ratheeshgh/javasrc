import java.io.*;

/**
 * Read a file containing an offset, and a String at that offset.
 * @author Ian F. Darwin, ian@darwinsys.com
 * @version $Id$
 */
public class RandomRead {
	final static String FILENAME = "random.dat";
	protected String fileName;
	protected RandomAccessFile seeker;

	public static void main(String argv[]) throws IOException {
		//+
		RandomRead r = new RandomRead(FILENAME);

		System.out.println("Offset is " + r.readOffset());
		System.out.println("Message is \"" + r.readMessage() + "\".");
		//-
	}

	/** Constructor: save filename, construct RandomAccessFile */
	public RandomRead(String fname) throws IOException {
		fileName = fname;
		seeker = new RandomAccessFile(fname, "r");
	}

	/** Read the Offset field, defined to be at location 0 in the file. */
	public int readOffset() throws IOException {
		seeker.seek(0);
		return seeker.readInt();
	}

	public String readMessage() throws IOException {
		seeker.seek(readOffset());
		return seeker.readLine();
	}
}
