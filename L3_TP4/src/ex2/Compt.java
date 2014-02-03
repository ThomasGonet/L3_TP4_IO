package ex2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;

public class Compt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cpt = 0;
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(args[0]));
			StreamTokenizer st = new StreamTokenizer(br);
			if(args[1] != null)
			{
				try {
					while(st.nextToken() != StreamTokenizer.TT_EOF)
					{
						if(st.ttype == StreamTokenizer.TT_WORD)
						{
							if(st.sval.equals(args[1]))
							{
								cpt++;
							}
						}
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(cpt <= 1)
					System.out.println("Il y a " + cpt +" occurence" + " du mot "+ args[1] + " dans le fichier " + args[0]);
				else
					System.out.println("Il y a " + cpt +" occurence(s)" + " du mot "+ args[1] + " dans le fichier " + args[0]);
			}
			else
			{
				System.out.println("Vous n'avez pas entré un mot valide");
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Erreur, le fichier n'existe pas ou n'est pas lisible");
		}
	}

}
