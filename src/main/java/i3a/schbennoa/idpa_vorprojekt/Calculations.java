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
	
	public void calculate(double anschaffungswert, int dauerInJahren, int dirIn,int liDeg,double restWertProzent){
		for(int i=0;i<konten.length;i++){
			konten[i].setkontoStand(0);
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
