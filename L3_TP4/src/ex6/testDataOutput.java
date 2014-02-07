package ex6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.GregorianCalendar;


public class testDataOutput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GregorianCalendar date = new GregorianCalendar(1980, 9, 15);
		Personne p1 = new Personne("T", "P", date, new Adresse(3, "ldt", "20600", "bastia"));
		File f = new File("output.txt");
		p1.saveBinaire(f);
		System.out.println(p1);
		
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("pers.ser"));
			oos.writeObject(p1);
			oos.flush();
			oos.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Personne p3 = null;
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("pers.ser"));
			p3 = (Personne) in.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Personne p2 = Personne.lireBinaire(f);
		
		
		System.out.println(p2);
		
		System.out.println(p3);
	}

}
