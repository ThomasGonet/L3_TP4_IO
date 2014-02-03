package ex1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MonCat {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		try {
			String line = null;
			br = new BufferedReader(new FileReader(args[0]));
			while((line = br.readLine()) != null)
			{
				System.out.println(line);
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Erreur, le fichier n'existe pas ou n'est pas lisible");
		}
		
	}

}
