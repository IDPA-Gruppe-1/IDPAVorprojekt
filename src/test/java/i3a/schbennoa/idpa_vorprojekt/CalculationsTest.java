/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i3a.schbennoa.idpa_vorprojekt;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 1810g
 */
public class CalculationsTest {
	
	public CalculationsTest() {
	}

	/*
	 * Testet ob es nach 10 Jahren, den gesamten Anschaffungswert im WB Konto hat 
	 * Mit Indirekt, Linear
	 */
	@org.junit.Test
	public void testIndirectLinearWB() {
		double anschaffungswert = 10000.0;
		int dauerInJahren = 10;
		int dirIn = 1;
		int liDeg = 0;
		double restWertProzent = 0.0;
		Calculations instance = Calculations.getInstance();
		instance.calculate(anschaffungswert, dauerInJahren, dirIn, liDeg, restWertProzent);
		assertEquals(10000.0,instance.getKonten()[1].getkontoStand(),0.0);
	}


	/*
	*Testet ob das Konto Anlagevermögen nach 10 Jahren immernoch voll ist
	*Mit Indirekt, Linear
	*/
	@org.junit.Test
	public void testIndirectLinearAv(){
		double anschaffungswert = 10000.0;
		int dauerInJahren = 10;
		int dirIn = 1;
		int liDeg = 0;
		double restWertProzent = 0.0;
		Calculations instance = Calculations.getInstance();
		instance.calculate(anschaffungswert, dauerInJahren, dirIn, liDeg, restWertProzent);
		assertEquals(10000.0,instance.getKonten()[0].getkontoStand(),0.0);	
	}


	/*
	*Testet ob das Konto Anlagevermögen nach 10 Jahren leer ist
	*Mit direkt, linear
	*/
	@org.junit.Test
	public void testDirectLinearAv(){
		double anschaffungswert = 10000.0;
		int dauerInJahren = 10;
		int dirIn = 0;
		int liDeg = 0;
		double restWertProzent = 0.0;
		Calculations instance = Calculations.getInstance();
		instance.calculate(anschaffungswert, dauerInJahren, dirIn, liDeg, restWertProzent);
		assertEquals(0.0,instance.getKonten()[0].getkontoStand(),0.0);	
	}
	

	/*
	*Testet ob das Konto Abschreibungen nach dem 1. Jahr den korrekten Betrag hat
	*Mit direkt, degressiv
	*/
	@org.junit.Test
	public void testDirectDeggresiveAb(){
		double anschaffungswert = 10000.0;
		int dauerInJahren = 10;
		int dirIn = 0;
		int liDeg = 1;
		double restWertProzent = 10.0;
		Calculations instance = Calculations.getInstance();
		instance.calculate(anschaffungswert, dauerInJahren, dirIn, liDeg, restWertProzent);
		assertEquals(1000.0,instance.getKonten()[2].getBetraegeList().get(0),0.0);	
	}


	/*
	*Testet ob das Konto Abschreibungen nach dem 1. Jahr den korrekten Abschreibungsbetrag hat
	*Mit direkt, linear
	*/
	@org.junit.Test
	public void testDirectLinearAb(){
		double anschaffungswert = 10000.0;
		int dauerInJahren = 10;
		int dirIn = 0;
		int liDeg = 0;
		double restWertProzent = 0.0;
		Calculations instance = Calculations.getInstance();
		instance.calculate(anschaffungswert, dauerInJahren, dirIn, liDeg, restWertProzent);
		assertEquals(1000.0,instance.getKonten()[2].getBetraegeList().get(0),0.0);	
	}

}
