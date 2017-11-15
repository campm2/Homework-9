/* ========================================================================== */
/* PROGRAM: File Analysis
    AUTHOR: Megan Camp
    COURSE NUMBER: CIS 210
    COURSE SECTION NUMBER: 02
    INSTRUCTOR NAME: Dr.Tian
    PROJECT NUMBER: 9
    DUE DATE: 11/16/2017
SUMMARY
You are required to write a program to read the content of an input file named input.txt and 
then write the following statistics into an output file named output.txt:  
-The content of the input file 
-The number of lines  
-The number of words o Note: the character ’  is one word.  For example, the phrase “that’s” contains two words. 
-The number of sentences o Every sentence ends with either a period or semicolon.  
-The number of punctuation characters o Punctuation is anything that neither an alphabet nor a digit 
-The number of alphabet characters
-The number of digit characters 
-The number of whitespace characters 
-The number of words that start with uppercase letter 
-The frequency of words (case insensitive). Please display and write the frequency of words as a list.  
- Frequency of a word shows the number of occurrences of a word in the input file. 
For example, this sentence “The sun is so nice in the morning” has the following frequency of words (case insensitive):
 the:   2 sun:  1 is:     1 so:    1 in:     1 morning: 1       


INPUT
This program requires that you read in data from an input file input.txt. You must ask the user to enter this file name. 
If the file doesn’t exist, then display a warning message and quit the program.


OUTPUT
Your program should display the following on the console and write it to an output file named output.txt: 
(Please ask the user to enter an output file name) 
-The content of the file. 
-The number of words. 
-The number of sentences. 
-The number of alphabet characters.
-The number of punctuation characters. 
-The number of digit characters. 
-The number of whitespaces. 
-The number of words that start with uppercase letter. 
-The frequency of words. 
 

ASSUMPTIONS

/* MAIN FUNCTION */
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;
public class hw9_file_analysis{
	public static void main(String[] args) throws IOException {
		
		int digits=0;
		int letters=0;
		int whiteSpace=0;
		int upperCase=0;
		int sentences=0;
		int lineCount=0;
		int punctuation=0;
		int wordCount=0;
		Scanner keyboard= new Scanner(System.in);
		// to get the name of the file
		System.out.print("Enter the name of the input file: ");
		String inputFileName=keyboard.nextLine();
		File file=new File(inputFileName);
		
		//to check if file exists
		if (file.exists()) {
			PrintWriter output=new PrintWriter("output.txt");
			ArrayList<String> word=new ArrayList<String>();
			word=ToArrayList(inputFileName);
			
			String input=ReadInputData(inputFileName);
			String [] inputArray=ReadToArray(inputFileName);
			//the amount of digits in the file
			digits=CountDigit(input);
			// the amount of letters of the alphabet in the file
			letters=CountAlphabet(input);
			// the amount of whitespaces in the the file
			whiteSpace=Whitespace(input);
			// the amount of uppercase words in the file
			upperCase=CountWordStartingWithUppercase(input);
			// the amount of sentences in the file
			sentences=CountSentences(input);
			//the amount of punctuation in the file
			punctuation=CountPunctuation(input);
			//the amount of lines in the file
			lineCount=CountLines(inputFileName);
			//the amount of words in the file
			wordCount=CountWords(inputArray);
			// output to the screen and the output file
			System.out.println(input);
			output.println(input);
			System.out.println("---------------------------------------------------------------------");
			output.println("---------------------------------------------------------------------");
			System.out.println("The total number of lines in the files: "+ lineCount );
			output.println("The total number of lines in the files: "+ lineCount );
			System.out.println("The total number of words in the files: "+ wordCount);
			output.println("The total number of words in the files: "+ wordCount);
			System.out.println("The total number of sentences in the files: "+ sentences);
			output.println("The total number of sentences in the files: "+ sentences);
			System.out.println("The total number of punctuation in the files: "+ punctuation);
			output.println("The total number of punctuation in the files: "+ punctuation);
			System.out.println("The total number of alphabet in the files: "+ letters);
			output.println("The total number of alphabet in the files: "+ letters);
			System.out.println("The total number of digits in the files: "+ digits);
			output.println("The total number of digits in the files: "+ digits);
			System.out.println("The total number of whitespaces in the files: "+ whiteSpace);
			output.println("The total number of whitespaces in the files: "+ whiteSpace);
			System.out.println("The total number of uppercase in the files: "+ upperCase);
			output.println("The total number of uppercase in the files: "+ upperCase);
			System.out.println("---------------------------------------------------------------------");
			output.println("---------------------------------------------------------------------");
			CountWordFrequency(word);
		}
		// will execute if the file does not exist
		else {
			System.out.println("Error: File does not exist");
		}//end of outside else
		keyboard.close();
	}
	/**
	 * @param filename
	 * @return fileInput
	 * @throws IOException
	 */
	public static String ReadInputData(String filename) throws IOException{
		
		String fileInput="";
		File file=new File(filename);
		Scanner inputFile=new Scanner(file);
		
			while(inputFile.hasNext()) {
				if((inputFile!=null)) {
					fileInput+=inputFile.nextLine();
					
				}//end of if
			
		}//end of while loop
		inputFile.close();
		return fileInput;
		
	}//end of Read inputData method
	/**
	 * @param filename
	 * @return word
	 * @throws IOException
	 */
	public static String [] ReadToArray(String filename) throws IOException{
		
		
		File file=new File(filename);
		Scanner inputFile=new Scanner(file);
		int fileCount=CountLines(filename);
		String [] word= new String [fileCount];
			for(int i=0;i<fileCount;i++) {
				if((inputFile!=null)) {
					word[i]=inputFile.nextLine();
					
				}//end of if
			
		}//end of while loop
		inputFile.close();
		return word;
	}//end bracket of to array


	/**
	 * @param word
	 * @return counter
	 */
	public static int CountDigit(String word) {
		int counter=0;
		for(int i=0;i< word.length();i++) {
			if(Character.isDigit(word.charAt(i))) {
			counter++;
			
			}//end bracket of if
		
		}//end bracket of for loop
		return counter;
	}//end bracket for count digit function
	/**
	 * @param word
	 * @return counter
	 */
	public static int CountAlphabet(String word) {
		int counter=0;
		for(int i=0;i<word.length() ;i++) {
			if(Character.isLetter(word.charAt(i))) {
				counter++;
			}//end bracket of if statement 
			
		}//end bracket of for loop
		return counter;
	}//end bracket count Alphabet
	/**
	 * @param word
	 * @return counter
	 */
	public static int Whitespace(String word) {
		int counter=0;
		for(int i=0; i<word.length();i++) {
			if(Character.isSpaceChar(word.charAt(i))) {
				counter++;
			}//end bracket of if 
		}//end bracket of for loop
		return counter;
	
	}//end bracket Whitespace
	/**
	 * @param word
	 * @return counter
	 */
	public static int CountWordStartingWithUppercase(String word) {
		int counter=0;
		for(int i=0;i<word.length();i++) {
			if(Character.isUpperCase(word.charAt(i))) {
				counter++;
			}//end bracket of if 
		}//end bracket of for loop
		return counter;
	}//end bracket CountWordStartingWithUppercase
	/**
	 * @param word
	 * @return counter
	 */
	public static int CountSentences(String word) {
		int counter=0;
		for(int i=0;i<word.length();i++) {
			if(word.charAt(i)=='.' || word.charAt(i)==';') {
				counter++;
			
			}//end bracket of if 
		}//end bracket of for loop
		return counter;
	}//end bracket of countSentences
	/**
	 * @param word
	 * @return counter
	 */
	public static int CountPunctuation(String word) {
		int counter=0;
		for (int i=0;i<word.length();i++) {
			if(!(Character.isSpaceChar(word.charAt(i)))&& !(Character.isLetter(word.charAt(i))) && !(Character.isDigit(word.charAt(i))) ){
				counter++;
			}//end bracket of if
		}//end bracket of for loop
		return counter;
	}//end bracket CountPunctuation
	/**
	 * @param filename
	 * @return counter
	 * @throws IOException
	 */
	public static int CountLines(String filename) throws IOException{
		int counter=0;
	
		File file=new File(filename);
		Scanner inputFile=new Scanner(file);
	
		while(inputFile.hasNext()) {
			if(inputFile!=null) {
			
				inputFile.nextLine();
				counter++;
			
			}//end bracket of if
		}//end of while loop
		inputFile.close();
		return counter;
	
	
	}//end bracket of CountLines
	
	/**
	 * @param word
	 * @return counter
	 */
	public static int CountWords(String [] word) {
		int counter=0;
		for(int i=0;i<word.length;i++) {
			String [] wordArray = word [i].split("[ ']+");
			counter+=wordArray.length;
		}
		return counter;
		
	}//end bracket of count words
	public static ArrayList<String> ToArrayList (String filename) throws IOException{
		ArrayList<String> wordArrayList=new ArrayList<String>();
		String fileInput="";
		String array[] = null;
		File file=new File(filename);
		Scanner inputFile=new Scanner(file);
		
			while(inputFile.hasNext()) {
				if((inputFile!=null)) {
					fileInput=inputFile.nextLine();
					fileInput=fileInput.toLowerCase();
					
					array=fileInput.split("[\\s/.,;\n]+");
					
					for(int i=0;i<array.length;i++) {
						
						//fileInput.split("[ .,;]+");
						wordArrayList.add(array[i]);
					}
					
				}//end of if
				
			
			}//end of while loop
			
			inputFile.close();
			return wordArrayList;
			
}
	public static void CountWordFrequency(ArrayList<String> word) {
		
		
		for(int i=0; i<word.size();i++) {
			int counter=1;
			for(int j=i+1;j<word.size();j++) {
				if(word.contains(word.get(j))) {
					if(word.get(i).equals(word.get(j))&& i!=j) {
						counter++;
						word.remove(j);
					}
				}
				
				
			}
			System.out.println(word.get(i) +":"+ counter);
		}
	}

}//end bracket of class
	
