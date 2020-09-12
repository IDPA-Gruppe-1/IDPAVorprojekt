package i3a.schbennoa.idpa_vorprojekt;


import java.util.Scanner;

/**
 *
 * @version 12.09.2020
 */
public class Calculations {
	private double anschaffungswert=0;
	private double dauerInJahren=0;
	private double abschProzent=0;
	private double restwert=0;
	
	//Variable ob Direkt(0) oder Indirekt(1)
	private int dirIn=0;


	//Variable ob Linear(0) oder Degressiv(1)
	private int liDeg=0;



	//Singleton Pattern Instanz
	private static Calculations instance=null;

	
	private Konto[] konten=new Konto[3];


	private Calculations(){
		//Konto[0]=anlagevermoegen
		//Konto[1]=WB Anlagevermoegen
		//Konto[2]=abschreibungen
		for(int i=0;i<3;i++){
			konten[i]=new Konto();
		}
	
	}

	

	//Methode für Singleton
	public static Calculations getInstance(){
		if(instance==null){
			instance=new Calculations();
		}

		return instance;
	}
	
	/**
	* Berechnet den Abschreibungsbetrag jedes Jahres und bucht die daraus folgenden Beträge auf die Konten
	* 
	* 
 	* @param anschaffungswert Wert des Objektes, beim Kauf 
	* @param dauerInJahren  Über wie lange das Objekt absgeschrieben werden soll
	* @param dirIn  0 für direkte Abschreibung, 1 für indirekte Abschreibungen 
	* @param liDeg 0 für lineare Abschreibung, 1 für degressive Abschreibung
	* @param restWertProzent entweder wieviel Prozent jedes Jahr abgeschrieben werden sollen oder wie gross der Restwert des Objekts am Ende sein soll
	* 
	*/
	public void calculate(double anschaffungswert, int dauerInJahren, int dirIn,int liDeg,double restWertProzent){
		for (Konto konten1 : konten) {
			konten1.setkontoStand(0);
		}
		this.anschaffungswert=anschaffungswert;
		this.dauerInJahren=dauerInJahren;
		this.dirIn=dirIn;
		this.liDeg=liDeg;
		

		//Befüllen von Anlagevermoegen Konto mit anschaffungswert
		konten[0].add(anschaffungswert,1);
		
		if(liDeg==0){
		//Lineare Abschreibung
			restwert=restWertProzent;
			double abschreibungsBetrag=((anschaffungswert-restwert)/dauerInJahren);	
			for(int i=0;i<dauerInJahren;i++){
			konten[2].setkontoStand(0);
			konten[2].add(abschreibungsBetrag,1);	
			konten[1-dirIn].add(0,0);
			konten[dirIn].add(abschreibungsBetrag, dirIn);
			}	

		
		}else{
		//Degressive Abschreibung	
			abschProzent=restWertProzent;
			double abschreibungsBetrag=0;
			for(int i=0;i<dauerInJahren;i++){
			abschreibungsBetrag=(konten[0].getkontoStand()-konten[1].getkontoStand())*(abschProzent/100);
			konten[2].setkontoStand(0);
			konten[2].add(abschreibungsBetrag,1);	
			konten[1-dirIn].add(0,0);
			konten[dirIn].add(abschreibungsBetrag,dirIn);
			}
		}
		
	}


	public Konto[] getKonten() {
		return konten;
	}


	
	
	
}
