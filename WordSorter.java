import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
public class WordSorter 
{
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in); 
		try
		{
			in = new Scanner(new File("article.txt"));	
		}//end try
		catch(Exception e)
		{
			System.out.println("Cannot find file... Exiting Program");
			return;
		}//end catch
		String word = "";


		ArrayList [] alphabet = new ArrayList [26];
		for(int i = 0; i<26; i++){
			alphabet[i] = new ArrayList <String> ();
		}//end for loop
		int q = 0;

		while(in.hasNext())
		{
			word = in.next();
			word = word.replace(",", "");
			word = word.replace("(tm)", "");
			word = word.replace(")", "");
			word = word.replace("(", "");
			word = word.replace(".", "");
			word = word.replace("'s", "");
			word = word.replace(":", "");
			word = word.replace("!", "");
			word = word.replace("?", "");
			word = word.replace("'", "");
			word = word.toLowerCase();

			//System.out.println(word);

			int dex = word.charAt(0)-97;
			boolean dupe = false;

			for(int i = 0; i<alphabet.length; i++){
				for(int j = 0; j<alphabet[i].size(); j++){
					if (word.equals(alphabet[i].get(j))){
						dupe = true;
					}//end if
				}//end inner for
			}//end outer for

			if (dupe == false){
				alphabet[dex].add(word);
				q++;
			}//end if
		}//end while loop
		
		Scanner input = new Scanner(System.in);
		int answer = 0;
		while (answer != 6){
			System.out.println("1 = Print out all words starting with a specific letter");
			System.out.println("2 = Print out all words");
			System.out.println("3 = Print out the total number of unique words");
			System.out.println("4 = Search and determine if a word is in the article");
			System.out.println("5 = Remove a word from the data structure");
			System.out.println("6 = Exit");
			System.out.println("What option would you like?");

			answer = input.nextInt();
			input.nextLine();

			if (answer == 1){
				int index = 0;
				System.out.println("What letter would you like to see?");
				String letter = input.nextLine();
				index = letter.charAt(0)-97;
				for (int i = 0; i<alphabet[index].size(); i++){
					System.out.println(alphabet[index].get(i));
				}//end for loop
				if (alphabet[index].size() == 0){
					System.out.println("No words start with this letter");
				}//end if
			}//end answer 1 if

			else if (answer == 2){
				for(int i = 0; i<alphabet.length; i++){
					for(int j = 0; j<alphabet[i].size(); j++){
						System.out.println(alphabet[i].get(j));
					}//end inner for
				}//end outer for
				if (q==0){
					System.out.println("Empty List");
				}//end if
			}//end answer 2 if

			else if (answer == 3){
				System.out.println("There are " + q + " unique words in the article");
			}//end answer 3 if

			else if (answer == 4){
				System.out.println("What word would you like to search for?");
				String inWord = input.nextLine();
				int index = 0;
				index = inWord.charAt(0)-97;
				boolean found = false;
				for (int i = 0; i<alphabet[index].size(); i++){
					if (alphabet[index].get(i).equals(inWord)){
						found = true;
					}//end if
				}//end for loop
				if(found == false){
					System.out.println("Word NOT found in the article.");
				}//end if
				else {
					System.out.println("Word found in the article");
				}// end else
			}//end answer 4 if

			else if (answer == 5){
				System.out.println("What word would you like to remove?");
				String inWord = input.nextLine();
				int index = 0;
				index = inWord.charAt(0)-97;
				boolean found = false;
				for (int i = 0; i<alphabet[index].size(); i++){
					if (alphabet[index].get(i).equals(inWord)){
						found = true;
						alphabet[index].remove(i);
						q--;
					}//end if
				}//end for loop
				if(found == false){
					System.out.println("Word NOT found in the article.");
				}//end if
				else {
					System.out.println("Word successfully removed from the list");
				}//end else
			}//end answer 5 if

			System.out.println();
		}//end while

	}//end main
}//end class