package util;

import entities.Deporte;
import entities.Escenario;
import modelo.DeporteDao;
import modelo.EscenarioDao;
import modelo.GenericDao;



public class Controlador {

	public void registrarDeporte(String nombre){
		
	    Deporte d = new Deporte(nombre);
	    GenericDao<Deporte> usDao = new DeporteDao();
	    usDao.insert(d);

	}
	
	public void eliminarDeporte(int id) {
		
		GenericDao<Deporte> usDao= new DeporteDao();
		Deporte u = usDao.find(id);
		System.out.println(u);
		usDao.delete(u);
		
	}
	
	public void ActualizarDeporte(int id,String nombre) {
		Deporte u = new Deporte(id,nombre);
		GenericDao<Deporte> usDao= new DeporteDao();
		usDao.update(u);
		
	}
	
	
	public void registrarEscenario(String nombre){
		
		Escenario d = new Escenario(nombre);
	    GenericDao<Escenario> usDao = new EscenarioDao();
	    usDao.insert(d);

	}
	
	public void eliminarEscenario(int id) {
		
		GenericDao<Escenario> usDao= new EscenarioDao();
		Escenario u = usDao.find(id);
		System.out.println(u);
		usDao.delete(u);
		
	}
	
	public void ActualizarEscenario(int id,String nombre) {
		Escenario u = new Escenario(id,nombre);
		GenericDao<Escenario> usDao= new EscenarioDao();
		usDao.update(u);
		
	}
}
