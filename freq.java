import java.io.*;
import java.util.Arrays;
import java.util.*;
import java.util.List;
import java.util.ArrayList;
public class freq
{
	public static List<String> wordArrayList = new ArrayList<String>();	//arraylist to store email
	public static int emailSize=0;	//total number of words in email
	public static String [] spamWords=
					{"income","disclaimer","free","finance","prizes","marketing","security"
					,"cash","employment","offer","card","credit","Claims","you","registered"
					,"with","Some","Kind","of","Partner","for","just","$","Act","now!","Don’t"
					,"hesitate!","Click","below","auto","email","removal","Congratulations"
					,"investment","Avoid","bankruptcy","Consolidate","debt","and","credit"
					,"leads","other","Easy","terms","Hidden","assets","Cash","bonus"}; //48 common email spam words

	private int readFile(String filename) throws Exception
	{
		File file = new File(filename);
 		BufferedReader br = new BufferedReader(new FileReader(file));	
		String st=null; 

  		while ((st = br.readLine())!=null)
		{
			for(String word : st.split("\\s+")) 	//splitting the line read in to seperate words
			{
    				wordArrayList.add(word);	//adding the each of  seperate words to an arraylist
			}
			
		}
		return wordArrayList.size();
	}

	public static void main(String [] args)
	{
		freq obj= new freq();
		String filename="email.txt";			//reading the email tex file
		try
		{
			emailSize=obj.readFile(filename);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		Set<String> unique = new HashSet<String>(wordArrayList);	//loading  unique words to hashset
		for(int i=0;i<spamWords.length;i++)
		{
			System.out.println("\n");
			if(unique.contains(spamWords[i]))
			{
				int int1=Collections.frequency(wordArrayList,spamWords[i]); 
				double prop=((double)int1/(double)emailSize)*100;//calculating the proportion of the word		
				System.out.format("%-32s%10s",spamWords[i],""+prop);
				
			}
			else
			{
				System.out.format("%-32s%10s",spamWords[i],""+0);
				
			}
			
		}
		System.out.println("\n");
	}

}
