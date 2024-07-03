package Test;

import Dao.ClassUsuarioImp;
import model.TblUsuariocl3;

public class Prueba {
	public static void main(String[] args) {
		ClassUsuarioImp crud = new ClassUsuarioImp();
		TblUsuariocl3 nuevo = new TblUsuariocl3();
		
		nuevo.setUsuariocl3("Luna");
		nuevo.setPasswordcl3("luna");
	
		crud.RegistrarUsuario(nuevo);
	}
}
