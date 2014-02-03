package ex4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Manip {

	/*
	 * Plusieurs méthodes s'offrent à nous :
	 * 		- Lecture caractère par caractère et saut de ligne à la lecture d'un "\n" ou d'un retour chariot
	 * 		- Lecture d'un Buffer une ligne sur deux
	 * 		- ...  
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cpt = 0;
		try {
			Scanner sc = new Scanner(new FileReader(args[0]));
			while(sc.hasNextLine())
			{
				cpt++;
				if(cpt%2 == 0)
					System.out.println(sc.nextLine());
				else
					sc.nextLine();
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
