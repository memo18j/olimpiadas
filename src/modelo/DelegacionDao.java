package modelo;

import entities.Delegacion;
import util.Conexion;

public class DelegacionDao 
extends Conexion<Delegacion> 
implements GenericDao<Delegacion>{
	
public DelegacionDao() {
	super(Delegacion.class);
}

}
