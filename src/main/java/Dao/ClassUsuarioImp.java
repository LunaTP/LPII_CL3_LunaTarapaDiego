package Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Interfaces.IUsuario;
import model.TblUsuariocl3;

public class ClassUsuarioImp implements IUsuario{

	@Override
	public TblUsuariocl3 autenticarUsuario(String nombreUsuario, String contrasena) {
		EntityManagerFactory fabr = Persistence.createEntityManagerFactory("LPII_CL3_LunaTarapaDiego");

		EntityManager em = fabr.createEntityManager();
		
		em.getTransaction().begin();
	
		TblUsuariocl3 usuario = null;
        try {
            TypedQuery<TblUsuariocl3> query = em.createQuery("SELECT u FROM TblUsuariocl3 u WHERE u.usuariocl3 = :nombreUsuario AND u.passwordcl3 = :contrasena", TblUsuariocl3.class);
            query.setParameter("nombreUsuario", nombreUsuario);
            query.setParameter("contrasena", contrasena);
            usuario = query.getSingleResult();
            
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            
        } finally {
            em.close();
        }
        
		
		
		return usuario;
	}

	@Override
	public void RegistrarUsuario(TblUsuariocl3 usuario) {
		EntityManagerFactory fabr = Persistence.createEntityManagerFactory("LPII_CL3_LunaTarapaDiego");
		//Permite gestionar entidades
		EntityManager em = fabr.createEntityManager();
		//Iniciar Tran
		em.getTransaction().begin();

		em.persist(usuario);
		
		System.out.println("Cliente registrado satisfactoriamente");
		
		em.getTransaction().commit();
		
		em.close();
		
	}

}
