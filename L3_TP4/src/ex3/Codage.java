package ex3;
import java.util.Scanner;

public class Codage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] in = null;
		char[] out = null;
		String str = "";
		if((args.length == 2) && (args[0].length() == args[1].length()))
		{
			in = args[0].toCharArray();
			out = args[1].toCharArray();

			Scanner sc = new Scanner(System.in);

			str += sc.nextLine();
			char[] ch = str.toCharArray();

			sc.close(); 

			for(int i = 0; i < ch.length; i++)
			{
				boolean ok = false;
				for(int j = 0; j < in.length;j++)
				{
					if(ch[i] == in[j])
					{
						System.out.print((char) out[j]);
						ok = true;
					}	
				}
				if(!ok)
				{
					System.out.print((char)ch[i]);
				}
			}
		}
		else
			System.out.println("Vous n'avez pas entré un nombre valide d'arguments");

	}

}
