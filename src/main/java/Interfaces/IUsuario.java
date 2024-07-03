package Interfaces;

import model.TblUsuariocl3;

public interface IUsuario {
	public TblUsuariocl3 autenticarUsuario(String nombreUsuario, String contrasena);
	public void RegistrarUsuario (TblUsuariocl3 usuario);

}
