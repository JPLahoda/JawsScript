/* Jason Lahoda
 * Section 4
 * The purpose of this program is to convert the Jaws script into a "Southie" accent. */

//import java.util.*;
//import java.util.Scanner;
//import java.util.regex.*;
import java.io.*;
//import java.io.PrintStream;
public class Jaws_Script {

	public static void main(String[] args) throws IOException, FileNotFoundException {

		FileReader fr = new FileReader("JawsScriptText.txt");
        BufferedReader br = new BufferedReader(fr);
        String buffer;
        String fullscript="";
        while ((buffer = br.readLine()) != null) {
        	buffer = addRandWicked(buffer);
        	buffer = vowelChange(buffer);
        	buffer.replaceAll(" ar ", " a ");
        	buffer = buffer.replaceAll(" ah ", " a ");
            System.out.println(buffer);
            fullscript += buffer;
            //in case fullscript is to be sent into a new file
        }
        br.close();
        fr.close();
	    }
	
	public static String vowelChange(String buffer) {
        StringBuilder toReturn = new StringBuilder();
        boolean afterVowel = false;
			for(char c : buffer.toCharArray()) {
		//	if (buffer.contains("a")) {
					//if (buffer.charAt(i-1) == ' ' && buffer.charAt(i+1) == ' '){
						//continue;
					//}
					//else if (buffer[i+1] == ' ' || buffer.charAt(i+1) == ',' || buffer.charAt(i+1) == '.') {
					//	buffer[i] + 'r';
				//	}
			//}
		//}
            char out = c;
            switch(c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            	
                afterVowel = true;
                break;
            case 'r':
                if(afterVowel) out = 'h';
            default:
                afterVowel = false;
            }
            toReturn.append(out);
			}
        return toReturn.toString();

	}
	public static String addRandWicked(String buffer)  {  
		String[] words = buffer.split(" ");
		for (int i = 0; i < words.length; i++) {
			if (words[i].contains("very")) {
				words[i] = "wicked";
			}
		if (words[i].endsWith("a") && (words[i] != "a")){
		String s = words[i];
		words[i] = s +"r";
		}
		}
		//*for (int i = 0; i < buffer.length(); i++) {
			//if (i == 'a') {
					//if (buffer.charAt(i-1) == ' ' && buffer.charAt(i+1) == ' '){
						//continue;
					//}
					//else if (buffer[i+1] == ' ' || buffer.charAt(i+1) == ',' || buffer.charAt(i+1) == '.') {
					//	buffer[i] + 'r';
				//	}
			//}
		//}
	
	    String output = ""; 
	    for (int j =0; j< words.length; j++) {
	    	output += words[j];
	    	output += " ";
	    }
		return output;  
		}
	
	
}



	
	
