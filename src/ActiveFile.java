import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ActiveFile {

	private Scanner readIn;
	private String noPunctuation; //File with punctuation removed
	private File file; //File name being read
	private int numLines; //number of lines in file
	private int blankLines; //number of blank lines in file
	private int numWords; //total number of words in file
	private int numSpaces;
	private int totalChars;
	private double avgWordLength; //average word length
	private double avgCharLines; //average characters per line
	private ArrayList<String> mostCommonWords; //list of the most commonly occurring words in the file
	private ArrayList<String> fileLines;
	private ArrayList<Object> wordCount; //index = word, index + 1 = number of times word occurs
	private static ArrayList<String> bannedWords = new ArrayList<String>(Arrays.asList("the", "he", "she", "it", "they",
							"them", "a", "an", "and", "in", "has", "for", "to", "too", "on", "that", "of", "when", "by",
							"will", "is", "as", "but", "i", "or", "not", "be", "can", "was", "from", "were"));
	private String completeFile;

	public ActiveFile(File selected) {
		noPunctuation = "";
		file = selected;
		numLines = 0;
		blankLines = 0;
		numWords = 0;
		avgWordLength = 0;
		avgCharLines = 0;
		mostCommonWords = new ArrayList<String>();
		fileLines = new ArrayList<String>();
		wordCount = new ArrayList<Object>();
		completeFile = "";
		numSpaces = 0;
		totalChars = 0;
	}

	public void openFile() {
		try {
			
			readIn = new Scanner(new FileReader(file.getAbsolutePath()));
			while(readIn.hasNextLine())
				fileLines.add(readIn.nextLine());
			readIn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private int calculateLines() {
		return fileLines.size();
	}
	
	private void populateCompleteFile() {
		
		for (String s : fileLines) {
			totalChars += s.length();
			completeFile += s;
			completeFile += "\n";
		}
		
	}
	
	
	
	
	/**
	 * Analyzes calling ActiveFile text to populate required statistics (given in README)
	 * @author Mason Salisbury
	 */
	public void analyze() {
		
		//Finding the number of lines in the file
		numLines = this.calculateLines();
		
		//Finding the average characters per line
		this.populateCompleteFile();
		avgCharLines = (double)totalChars / numLines;
		
		//Finding the most commonly occurring words and number of blank lines
		int highOccur = 0;
		int mostUncommon = 0;
		for (String line : fileLines){
			
			if (line.equals("")) {
				
				blankLines++;
				continue;
				
			}
			
			String word[] = line.split("\\.| ");
			
			for (int index = 0; index < word.length; index++) {
				
				if (!word[index].matches("[a-zA-Z0-9]+"))
					continue;
				
				word[index] = word[index].toLowerCase();
				
				//If word is already in the list it increases the number of times it has occurred
				if (wordCount.contains(word[index])) {
					
					int replaceIndex = wordCount.indexOf(word[index]) + 1;
					int value = (Integer)wordCount.get(replaceIndex) + 1;
					wordCount.set(replaceIndex, value);
					if (value > highOccur)
						highOccur = value;
					
					if (!bannedWords.contains(word[index])) {
						
						if (value > mostUncommon)
							mostUncommon = value;
						
					}
					
				}
				
				else {
					
					wordCount.add(word[index]);
					wordCount.add(1);
					if (1 > highOccur)
						highOccur = 1;
					
					if (!bannedWords.contains(word[index])) {
						
						if (1 > mostUncommon)
							mostUncommon = 1;
						
					}
					
				}
				
			}
			
		}
		
		int totWordLength = 0;
		
		//Finds total number of words, builds list of most common words, and the total number of characters in words
		for (int index = 1; index < wordCount.size(); index += 2) {
				
			int numOccur = (Integer)wordCount.get(index);
			String curWord = (String)wordCount.get(index - 1);
			
			//Finds the total number of words
			numWords += numOccur;
			
			//If word is one of the most occurring it adds it to mostCommonWords
			if (numOccur == highOccur)
				mostCommonWords.add(curWord + " (" + numOccur + ")");
			
			if (highOccur != mostUncommon && numOccur == mostUncommon) {
				
				if (!bannedWords.contains(curWord))
					mostCommonWords.add(curWord + " (" + numOccur + ")");
				
			}
			
			totWordLength += curWord.length() * numOccur;
			
		}
		
		//Finding average word length
		avgWordLength = (double) totWordLength / numWords;
		
		// Count spaces
		for (int i = 0; i < completeFile.length(); i++) {
			char current = completeFile.charAt(i);
			if (current == ' ') numSpaces++;
		}
		
	}
	
	
	/**
	 * Generates a copy of ActiveFile text with punctuation removed.
	 * @author Mason Salisbury
	 */
	public void removePunctuation() {
		
		String noPunct[] = completeFile.split("\\p{Punct}");
		for (String s : noPunct)
			noPunctuation += s;
		
	}
	
	/*
	 * Getters
	 */
	
	public int getNumLines() {
		return this.numLines;
	}
	
	public int getBlankLines() {
		return this.blankLines;
	}
	
	public int getNumWords() {
		return numWords;
	}
	
	public int getNumSpaces() {
		return numSpaces;
	}
	
	public double getWordLength() {
		return avgWordLength;
	}
	
	public double getCharLines() {
		return avgCharLines;
	}
	
	public File getFile() {
		return file;
	}
	
	public ArrayList<String> getCommonWords() {
		return mostCommonWords;
	}
	
	public String getCompleteFile() {
		return completeFile;
	}
	
	public String getNoPunctuation() {
		return noPunctuation;
	}
}
