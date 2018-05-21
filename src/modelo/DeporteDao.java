package modelo;

import entities.Deporte;
import util.Conexion;

public class DeporteDao 
extends Conexion<Deporte> 
implements GenericDao<Deporte>{
	
public DeporteDao() {
	super(Deporte.class);
}

}
