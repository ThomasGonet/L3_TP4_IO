package ex1;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MonCatScan {

	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner (new FileReader(args[0]));
			while(sc.hasNext())
			{
				System.out.println(sc.nextLine());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Erreur, le fichier n'existe pas ou n'est pas lisible");
		}
		
	}


}
