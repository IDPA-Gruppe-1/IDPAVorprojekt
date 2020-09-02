package i3a.schbennoa.idpa_vorprojekt;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1810g
 */





public class Konto {

	double kontoStand = 0;
	ArrayList<Double>betraegeList=new ArrayList();
	

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
