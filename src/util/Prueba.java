package util;

import entities.Deporte;
import modelo.DeporteDao;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeporteDao dd = new DeporteDao();
		Deporte d = new Deporte("Futbol");
		dd.insert(d);

	}

}
