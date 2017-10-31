import java.io.File;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RecordFile implements Serializable{

	private static final long serialVersionUID = -565555512807439922L;
	
	
	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	public LocalDate date;

	public final File file; //File name being read
	public final int numLines; //number of lines in file
	public final int blankLines; //number of blank lines in file
	public final int numWords; //total number of words in file
	public final int numSpaces;
	public final double avgWordLength; //average word length
	public final double avgCharLines; //average characters per line
	
	/**
	 * Class constructor using the parameters of a given ActiveFile
	 * @param in
	 */
	public RecordFile(ActiveFile in) {
		this.file = (in.getFile());
		this.numLines = in.getNumLines();
		this.blankLines = in.getBlankLines();
		this.numWords = in.getNumWords();
		this.numSpaces = in.getNumSpaces();
		this.avgWordLength = in.getWordLength();
		this.avgCharLines = in.getCharLines();
		
		date = LocalDate.now();
	}
	
	/**
	 * Generates a string that represents the RecordFile.
	 * Used to list the history in a log view.
	 * @returns	a string that represents a RecordFile
	 */
	@Override
	public String toString() {
		return file.getName() + "\t" + dtf.format(date);
	}
	
}
