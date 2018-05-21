package modelo;

import entities.Grupo;
import util.Conexion;


public class GrupoDao 
	extends Conexion<Grupo> 
	implements GenericDao<Grupo>{
	
	public GrupoDao() {
		super(Grupo.class);
	}
}
