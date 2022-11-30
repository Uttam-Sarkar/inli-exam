//File Name StudentList.java
import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
public static void main(String[] args) {
//		Check arguments
		if(args[0].equals(Constant.ShowAll)) {
			System.out.println(Constant.LoadingMessage);		
			try {
			String[] studentName = getString().split(Constant.StrudentEntryDelimiter);			
			for(String student : studentName) {
			    System.out.println(student); 
			}
			} catch (Exception e){

			} 
			System.out.println(Constant.DataLoadedMessage);
		}
		else if(args[0].equals(Constant.ShowRandom)) 
		{
			System.out.println(Constant.LoadingMessage);			
			try {
			String[] studentName = getString().split(", ");	
			Random x = new Random();
				int y = Math.abs(x.nextInt()%studentName.length);
					System.out.println(studentName[y]);
			} catch (Exception e){

			} 
			System.out.println(Constant.DataLoadedMessage);			
		}
		else if(args[0].contains(Constant.AddEntry)){
			System.out.println(Constant.LoadingMessage);			
			try {
			BufferedWriter bufferedWriter = new BufferedWriter(
					new FileWriter(Constant.StudentList, true));
			String newData = args[0].substring(1);
	        Date date = new Date();
	        String dateFormatText = Constant.DateFormate;
	        DateFormat dateFormat = new SimpleDateFormat(dateFormatText);
	        String dateUpdate= dateFormat.format(date);
			bufferedWriter.write(" ,"+newData+Constant.LastUpdateMessage+dateUpdate);
			bufferedWriter.close();
			} catch (Exception e){

			}							
			System.out.println(Constant.DataLoadedMessage);	
		}
		else if(args[0].contains(Constant.FindEntry)) 
		{
			System.out.println(Constant.LoadingMessage);			
			try {
			String[] studentNames = getString().split(", ");	
			boolean done = false;
			String studentName = args[0].substring(1);
			for(int idx = 0; idx<studentNames.length && !done; idx++){
				if(studentNames[idx].equals(studentName)) {
					System.out.println(Constant.DataFoundMessage);
						done=true;
				}
			}
			} catch (Exception e){

			} 
			System.out.println(Constant.DataLoadedMessage);				
		}
		else if(args[0].contains(Constant.ShowCount)) 
		{
			System.out.println(Constant.LoadingMessage);			
			try {
			char[] studentNamestoCharArray = getString().toCharArray();			
			boolean in_word = false;
			int count=0;
			for(char studentNameChar:studentNamestoCharArray) {
				if(studentNameChar ==' ') 
				{
					if (!in_word) {	count++; in_word =true;	}
					else{
					    in_word=false;
					}			
				}
			}
			System.out.println(count +Constant.WordsFoundMessage);
			} catch (Exception e){

			} 
			System.out.println(Constant.DataLoadedMessage);				
		}
		else{
			System.out.println(Constant.WrongInputMessage);
		}	
	}

	private static String getString() throws IOException{
		BufferedReader bufferedReader = new BufferedReader(
			new InputStreamReader(
				new FileInputStream(Constant.StudentList))); 
		return bufferedReader.readLine();
	}
}

