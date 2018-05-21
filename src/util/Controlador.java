package util;

import entities.Delegacion;
import entities.Deporte;
import entities.Escenario;
import entities.Funcionario;
import entities.Grupo;
import modelo.DelegacionDao;
import modelo.DeporteDao;
import modelo.EscenarioDao;
import modelo.FuncionarioDao;
import modelo.GenericDao;
import modelo.GrupoDao;




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
	
    public void registrarDelegacion(String nombre){
		
	    Delegacion d = new Delegacion(nombre);
	    GenericDao<Delegacion> usDao = new DelegacionDao();
	    usDao.insert(d);

	}
	
	public void eliminarDelegacion(int id) {
		
		GenericDao<Delegacion> usDao= new DelegacionDao();
		Delegacion u = usDao.find(id);
		System.out.println(u);
		usDao.delete(u);
		
	}
	
	public void ActualizarDelegacion(int id,String nombre) {
		Delegacion u = new Delegacion(id,nombre);
		GenericDao<Delegacion> usDao= new DelegacionDao();
		usDao.update(u);
		
	}
	
	public void registrarFuncionario(String apellido, int delegado, String nombre,String telefono,int iddelegado){
		
		Funcionario f = new Funcionario(apellido,delegado,nombre,telefono);
		GenericDao<Delegacion> dDao = new DelegacionDao();
		Delegacion d = dDao.find(iddelegado);
		f.setDelegacion(d);
		GenericDao<Funcionario> fDao = new FuncionarioDao();
		fDao.insert(f);
	    
	}
	
	public void registrarGrupo(String letra, int deporte, int delegacion){
		
		Grupo g = new Grupo(letra);
		GenericDao<Delegacion> dDao = new DelegacionDao();
		Delegacion d = dDao.find(delegacion);
		GenericDao<Deporte> deDao = new DeporteDao();
		Deporte de = deDao.find(deporte);
		g.setDeporte(de);
		g.setDelegacion(d);
		GenericDao<Grupo> gDao = new GrupoDao();
		gDao.insert(g);
	}
}
