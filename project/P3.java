import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class P3 {

	public static void main(String[] args) throws IOException {
		/*
		 * File and buffer reader to read the data from Expressions.txt
		 * Separates each expressions using the ';' char
		 */
		FileReader fr = new FileReader("Expressions.txt");
		BufferedReader br = new BufferedReader(fr);
		String fileData="", l="";
		while((l=br.readLine())!=null) { 
		    fileData += l;
		}
		br.close();

		String[] expressions = fileData.split(";");
		// TODO Auto-generated method stub
		
		for (int q = 0; q < expressions.length; q++) {
			String poop = expressions[q];
			Build_tree.newTree(poop);

		}

	}

}
