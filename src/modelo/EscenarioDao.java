package modelo;

import entities.Escenario;
import util.Conexion;

public class EscenarioDao 
extends Conexion<Escenario> 
implements GenericDao<Escenario>{
	
public EscenarioDao() {
	super(Escenario.class);
}

}
