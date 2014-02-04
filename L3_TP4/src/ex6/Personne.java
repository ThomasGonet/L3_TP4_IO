package ex6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;



public class Personne implements Cloneable, Comparable<Personne>, Serializable{
	private static final Adresse ADRESSE_INCONNUE = null;
	private String nom;
	private String prenom;
	private GregorianCalendar dateNaissance;
	private Adresse adresse=ADRESSE_INCONNUE;
	private static int NB_PERSONNE = 0;

	/**
	 * Constructeur de Personne
	 * @param leNom le nom de la personne
	 * @param lePrenom le prenom de la personne
	 * @param laDate la date de naissance de la personne
	 * @param lAdresse l'adresse de la personne
	 */
	public Personne(String leNom,String lePrenom, GregorianCalendar laDate, Adresse lAdresse){
		nom = leNom.toUpperCase();
		prenom=lePrenom;
		dateNaissance=laDate;
		adresse=lAdresse;
		NB_PERSONNE++;
	}

	/** 
	 * Constructeur de Personne
	 * @param leNom le nom de la personne
	 * @param lePrenom le prenom de la personne
	 * @param j le jour de naissance
	 * @param m le mois de naissance
	 * @param a l'annee de naissance
	 * @param numero le numero de la rue
	 * @param rue la rue
	 * @param code_postal le code postal de l'adresse
	 * @param ville la ville ou la personne habite
	 */
	public Personne(String leNom,String lePrenom, int j, int m, int a, int numero, String rue, String code_postal, String ville){
		this(leNom, lePrenom, new GregorianCalendar(a,m,j), new Adresse(numero,rue,code_postal,ville));
	}

	/**
	 * Accesseur
	 * @return retourne le nom
	 */
	public String getNom(){
		return nom;
	}
	/**
	 * Accesseur
	 * @return retourne le prenom
	 */
	public String getPrenom(){
		return prenom;
	}
	/**
	 * Accesseur
	 * @return retourne la date de naissance	 
	 */
	public GregorianCalendar getDateNaissance() {
		return dateNaissance;
	}
	/**
	 * Accesseur
	 * @return retourne l'adresse	 
	 */
	public Adresse getAdresse() {
		return adresse;
	}
	/**
	 * Modificateur
	 * @param retourne l'adresse	 
	 */
	public void setAdresse(Adresse a) {
		adresse=a;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		String result="\nNom : "+nom+"\n"
				+"Prenom : "+prenom+"\n"+
				"Ne(e) le : "+dateNaissance.get(Calendar.DAY_OF_MONTH)+
				"-"+dateNaissance.get(Calendar.MONTH)+
				"-"+dateNaissance.get(Calendar.YEAR)+"\n"+
				"Adresse : "+
				adresse.toString();
		return result;
	}

	public boolean plusAgeeQue(Personne p)
	{
		return this.getDateNaissance().getTime().before(p.getDateNaissance().getTime());
	}

	public static boolean plusAgee(Personne p1, Personne p2)
	{
		return (p1.getDateNaissance().getTime().before(p2.getDateNaissance().getTime()));
	} 

	public boolean equals(Object o)
	{
		Personne p = (Personne) o;
		return (this.getNom() == p.getNom() && this.getPrenom()==p.getPrenom() && this.getDateNaissance().equals(p.getDateNaissance()));
	}

	public static int getNB_PERSONNE() {
		return NB_PERSONNE;
	}


	public int calculAge(/*GregorianCalendar dateNaissance*/)
	{
		Calendar curr = new GregorianCalendar();
		Calendar birth = new GregorianCalendar(dateNaissance.get(Calendar.YEAR), dateNaissance.get(Calendar.MONTH), dateNaissance.get(Calendar.DAY_OF_MONTH));
		int yeardiff = curr.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
		curr.add(Calendar.YEAR,-yeardiff);
		if(birth.after(curr))
		{
			yeardiff = yeardiff - 1;
		}
		//System.out.println("Age :" + yeardiff);
		return yeardiff;
	}

	public Object clone() throws CloneNotSupportedException
	{
		Personne p = null;
		try{
			p = (Personne)super.clone();
			p.adresse = (Adresse)adresse.clone();
			p.dateNaissance = (GregorianCalendar)this.dateNaissance.clone();

		}
		catch(CloneNotSupportedException e){}
		return p;
	}


	public int compareTo(Personne p)
		{
			//Personne p = (Personne) o;
			if (this.dateNaissance.before(p.getDateNaissance()))
				return 1;
			else if(this.dateNaissance.after(p.getDateNaissance()))
				return -1;
			else{
				int comparaisonNom = this.nom.compareTo(p.getNom());
				return (comparaisonNom != 0)? comparaisonNom : this.prenom.compareTo(p.getPrenom());
			}
		}
	
	public void saveBinaire(File f)
	{
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(f);
			DataOutputStream dos = new DataOutputStream(fos);
			
			dos.writeUTF(nom);
			dos.writeUTF(prenom);
			dos.writeLong(dateNaissance.getTimeInMillis());
			dos.writeInt(adresse.getNumero());
			dos.writeUTF(adresse.getRue());
			dos.writeUTF(adresse.getCode_postal());
			dos.writeUTF(adresse.getVille());
			
			dos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static Personne lireBinaire(File f)
	{
		Personne p = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(f);
			DataInputStream dis = new DataInputStream(fis);
			GregorianCalendar da = new GregorianCalendar();
			
			
			String nom = dis.readUTF();
			String prenom = dis.readUTF();
			long t= dis.readLong();
			da.setTimeInMillis(t);

			int num = dis.readInt();
			String rue = dis.readUTF();
			String cp = dis.readUTF();
			String ville = dis.readUTF();
			
			p = new Personne(prenom, nom, da, new Adresse(num, rue, cp, ville));
			
			fis.close();
			dis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return p;
	}

	

	/*public static Comparator<Personne> PersonneComparator = new Comparator<Personne>(){
		public int compare(Personne arg0, Personne arg1) {
			if (arg0.dateNaissance.before(arg1.getDateNaissance()))
				return 1;
			else if(arg0.dateNaissance.after(arg1.getDateNaissance()))
				return -1;
			else{
				int comparaisonNom = arg0.nom.compareTo(arg1.getNom());
				//System.out.println(comparaisonNom);
				if(comparaisonNom != 0)
				{
					return comparaisonNom;
				}
				else
				{
					return arg0.prenom.compareTo(arg1.getPrenom());
				}
			}

		}
	};*/
}
