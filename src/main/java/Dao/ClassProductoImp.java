package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.IProducto;
import model.TblProductocl3;

public class ClassProductoImp implements IProducto{

	@Override
	public void RegistrarProducto(TblProductocl3 producto) {
		EntityManagerFactory fabr = Persistence.createEntityManagerFactory("LPII_CL3_LunaTarapaDiego");
		//Permite gestionar entidades
		EntityManager em = fabr.createEntityManager();
		//Iniciar Tran
		em.getTransaction().begin();
	
		em.persist(producto);
		
		System.out.println("Producto registrado satisfactoriamente");
		
		em.getTransaction().commit();
		
		em.close();
	}

	@Override
	public void ActualizarProducto(TblProductocl3 producto) {
		EntityManagerFactory fabr = Persistence.createEntityManagerFactory("LPII_CL3_LunaTarapaDiego");

		EntityManager em = fabr.createEntityManager();

		em.getTransaction().begin();
	
		em.merge(producto);
		
		em.getTransaction().commit();
		
		em.close();
	}

	@Override
	public void EliminarProducto(TblProductocl3 producto) {
		EntityManagerFactory fabr = Persistence.createEntityManagerFactory("LPII_CL3_LunaTarapaDiego");

		EntityManager em = fabr.createEntityManager();

		em.getTransaction().begin();
		
		TblProductocl3 elim = em.merge(producto);
		
		em.remove(elim);
		
		System.out.println("Producto eliminado de la base de datos");
	
		em.getTransaction().commit();
		
		em.close();
	}

	@Override
	public TblProductocl3 BuscarProducto(TblProductocl3 producto) {
		EntityManagerFactory fabr = Persistence.createEntityManagerFactory("LPII_CL3_LunaTarapaDiego");

		EntityManager em = fabr.createEntityManager();

		em.getTransaction().begin();
		
		TblProductocl3 buscado = em.find(TblProductocl3.class, producto.getIdproductoscl3());
		
		em.getTransaction().commit();
		
		em.close();
		
		return buscado;
	}

	@Override
	public List<TblProductocl3> ListadoProducto() {
		EntityManagerFactory fabr = Persistence.createEntityManagerFactory("LPII_CL3_LunaTarapaDiego");

		EntityManager em = fabr.createEntityManager();

		em.getTransaction().begin();
		
		List<TblProductocl3> lista = em.createQuery("select c from TblProductocl3 c",TblProductocl3.class).getResultList();
		
		em.getTransaction().commit();
		
		em.close();
		return lista;
	}

}
