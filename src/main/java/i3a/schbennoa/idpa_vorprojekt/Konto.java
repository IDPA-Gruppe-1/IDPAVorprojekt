package i3a.schbennoa.idpa_vorprojekt;

import java.util.ArrayList;


/**
 * Diese Klasse simuliert ein Konto einer Bilanz
 *
 * @version 12.09.2020
 */





public class Konto {

	private double kontoStand = 0;
	private final ArrayList<Double>betraegeList=new ArrayList();
	
	
	/**
	 * Addiert oder Subtrahiert einen Betrag auf das Konto
	 * 
	 * @param betrag betrag der auf das Konto gebucht wird
	 * @param konto  0: von Konto subtrahieren, 1 auf Konto addieren
	 */
	public void add(double betrag, int konto) {
		if (konto == 0) {
			kontoStand -= betrag;
			
			
		}
		else {
			kontoStand += betrag;
		}

		
	betraegeList.add(kontoStand);
		
	}

	public double getkontoStand(){
		return kontoStand;
	}


	public void setkontoStand(double betrag){
		kontoStand=betrag;
		
	}

	public ArrayList<Double>getBetraegeList(){
		return betraegeList;
	}


}
