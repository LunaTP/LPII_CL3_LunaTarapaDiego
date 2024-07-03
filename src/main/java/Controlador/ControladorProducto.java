package Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ClassProductoImp;
import model.TblProductocl3;
import model.TblUsuariocl3;

/**
 * Servlet implementation class ControladorProducto
 */
public class ControladorProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ClassProductoImp crud = new ClassProductoImp();
		
		List<TblProductocl3> listadoproducto = crud.ListadoProducto();
		request.setAttribute("listadoproductos", listadoproducto);
		
		request.getRequestDispatcher("/FormRegistrarProducto.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		double precio = Double.parseDouble(request.getParameter("precio"));
		double precioVen = Double.parseDouble(request.getParameter("precioVenta"));
		String estado = request.getParameter("estado");
		String descrip = request.getParameter("descrip");
		
		
		TblProductocl3 producto = new TblProductocl3();
		ClassProductoImp crud = new ClassProductoImp();
		
		producto.setNombrecl3(nombre);
		producto.setPreciocompcl3(precio);
		producto.setPrecioventacl3(precioVen);
		producto.setEstadocl3(estado);
		producto.setDescripcl3(descrip);
		
		crud.RegistrarProducto(producto);
		
		request.setAttribute("mensaje", "Dato Registrado en la BD");
		
		List<TblProductocl3> listadoproducto = crud.ListadoProducto();
		request.setAttribute("listadoproductos", listadoproducto);
		
		doGet(request, response);
	}

}
