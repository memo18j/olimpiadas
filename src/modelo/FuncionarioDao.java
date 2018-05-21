package modelo;

import entities.Funcionario;
import util.Conexion;

public class FuncionarioDao 
extends Conexion<Funcionario> 
implements GenericDao<Funcionario>{
	
public FuncionarioDao() {
	super(Funcionario.class);
}

}
