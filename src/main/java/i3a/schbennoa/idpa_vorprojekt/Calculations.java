package i3a.schbennoa.idpa_vorprojekt;


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1810g
 */
public class Calculations {
	double anschaffungswert=0;
	double dauerInJahren=0;
	double abschProzent=0;
	double restwert=0;
	
	//Variable ob Direkt oder Indirekt
	int dirIn=0;


	//Variable ob Linear oder Degressiv
	int liDeg=0;



	//Singleton Pattern Instanz
	static Calculations instance=null;

	
	Scanner in=new Scanner(System.in);
	Konto[] konten=new Konto[3];


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
	
	public void startProgram(){
		System.out.println("Geben sie bitte den Anschaffungswert ein");
		anschaffungswert=Double.parseDouble(in.nextLine());

		System.out.println("Geben sie bitte die Dauer in Jahren ein");
		dauerInJahren=Double.parseDouble(in.nextLine());
		
		System.out.println("Wollen sie direkt(0) oder indirekt(1) verbuchen?");
		dirIn=Integer.parseInt(in.nextLine());
		
		System.out.println("Wollen sie linear(0) oder degressiv(1) verbuchen?");
		liDeg=Integer.parseInt(in.nextLine());
		

		//Befüllen von Anlagevermoegen Konto mit anschaffungswert
		konten[0].add(anschaffungswert,1);
		
		if(liDeg==0){
		//Lineare Abschreibung
			System.out.println("Geben sie den Restwert ein");		
			restwert=Double.parseDouble(in.nextLine());
			double abschreibungsBetrag=((anschaffungswert-restwert)/dauerInJahren);	
			for(int i=0;i<dauerInJahren;i++){
			konten[2].setkontoStand(0);
			konten[2].add(abschreibungsBetrag,1);	
			konten[1-dirIn].add(0,0);
			konten[dirIn].add(abschreibungsBetrag, dirIn);
			}	

		
		}else{
		//Degressive Abschreibung	
			System.out.println("Geben sie die Abschreibung pro Jahr in prozent an");
			abschProzent=Double.parseDouble(in.nextLine());
			double abschreibungsBetrag=0;
			for(int i=0;i<dauerInJahren;i++){
			//abschreibungsBetrag=konten[0].getkontoStand()*(abschProzent/100);
			abschreibungsBetrag=(konten[0].getkontoStand()-konten[1].getkontoStand())*(abschProzent/100);
			konten[2].setkontoStand(0);
			konten[2].add(abschreibungsBetrag,1);	
			konten[1-dirIn].add(0,0);
			konten[dirIn].add(abschreibungsBetrag,dirIn);
			}
		}
		
		
		printOut();
		


		
	}


	private void printOut(){
		System.out.println("Länge WB: "+konten[1].getBetraegeList().size());
		for(int i=0;i<dauerInJahren;i++){
			System.out.println("\n");
			System.out.println("Abschreibungen: "+konten[2].getBetraegeList().get(i));
			if(konten[0].getBetraegeList().size()==1){
				//Arbeiten mit WB
				System.out.println("WB Anlagevermoegen: "+konten[1].getBetraegeList().get(i));
				System.out.println("Anlagevermoegen: "+konten[0].getkontoStand());
			}else{
				//Arbeiten mit Anlagevermoegen
				System.out.println("Anlagevermoegen: "+konten[0].getBetraegeList().get(i));
			}
		}
		System.out.println("\n Anlagevermögen am Ende: "+konten[0].getkontoStand());
		
	}

	public Konto[] getKonten() {
		return konten;
	}


	
	
	
}
