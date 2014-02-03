package ex5;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Format {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nbLignes= 0;
		int nbColonnes = 0;
		String str = "";

		try {

			Scanner sc = new Scanner(new FileReader(args[0]));
			if(sc.hasNextLine())
				nbColonnes = sc.nextInt();

			if(sc.hasNextLine())
				nbLignes = sc.nextInt();


			int[][] matrice = new int[nbLignes][nbColonnes];


			System.out.println(nbLignes + " " + nbColonnes);


			System.out.println("Lecture du fichier " + args[0] + "\n");
			for(int i = 0; i < nbLignes; i++)
			{
				if(sc.hasNext())
				{
					str = sc.next();
					System.out.println(str);
					StringTokenizer st = new StringTokenizer(str, ";");
					for(int j = 0; st.hasMoreTokens(); j++)
					{
						matrice[i][j] = Integer.parseInt(st.nextToken());
					}
				}
			}

			System.out.println("\nRésultat après formatage :");

			for(int i = 0; i < nbLignes; i++)
			{
				for(int j = 0; j < nbColonnes; j++)
					System.out.print(matrice[i][j] + "\t");
				System.out.println();
			}

			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Nom du fichier invalide ou fichier invalide");;
		}
	}

}
