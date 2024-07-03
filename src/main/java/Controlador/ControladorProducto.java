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
		TblProductocl3 producto = new TblProductocl3();
		ClassProductoImp crud = new ClassProductoImp();
		
		List<TblProductocl3> listadoproducto = crud.ListadoProducto();
		request.setAttribute("listadoproductos", listadoproducto);
		
		//request.getRequestDispatcher("/FormRegistrarProducto.jsp").forward(request, response);
		String accion = request.getParameter("accion");
		if(accion != null){
			switch(accion){
				case "Modificar":
					int codigo = Integer.parseInt(request.getParameter("cod"));
			
					producto.setIdproductoscl3(codigo);
					TblProductocl3 buscarcod = crud.BuscarProducto(producto);
					
					request.setAttribute("codigo", buscarcod.getIdproductoscl3());
					request.setAttribute("nombre", buscarcod.getNombrecl3());
					request.setAttribute("precio", buscarcod.getPreciocompcl3());
					request.setAttribute("precioVenta", buscarcod.getPrecioventacl3());
					request.setAttribute("estado", buscarcod.getEstadocl3());
					request.setAttribute("descrip", buscarcod.getDescripcl3());
					
					request.getRequestDispatcher("/FormActualizarProducto.jsp").forward(request, response);
					break;
				case "Eliminar":
					int codigoEliminar = Integer.parseInt(request.getParameter("cod"));
					
					producto.setIdproductoscl3(codigoEliminar);
					
					crud.EliminarProducto(producto);
					List<TblProductocl3> listado = crud.ListadoProducto();
					request.setAttribute("listadoproductos", listado);
					
					request.getRequestDispatcher("/FormRegistrarProducto.jsp").forward(request, response);
					break;
				case "Listar":
					List<TblProductocl3> listadopro = crud.ListadoProducto();
					request.setAttribute("listadoproductos", listadopro);
					
					request.getRequestDispatcher("/FormRegistrarProducto.jsp").forward(request, response);
					break;
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		String nombre = request.getParameter("nombre");
		double precio = Double.parseDouble(request.getParameter("precio"));
		double precioVen = Double.parseDouble(request.getParameter("precioVenta"));
		String estado = request.getParameter("estado");
		String descrip = request.getParameter("descrip");
		
		List<TblProductocl3> listadoproducto = null;
		
		TblProductocl3 producto = new TblProductocl3();
		ClassProductoImp crud = new ClassProductoImp();
		
		producto.setNombrecl3(nombre);
		producto.setPreciocompcl3(precio);
		producto.setPrecioventacl3(precioVen);
		producto.setEstadocl3(estado);
		producto.setDescripcl3(descrip);
		if(codigo != null){
			int cod = Integer.parseInt(codigo);
			producto.setIdproductoscl3(cod);
			crud.ActualizarProducto(producto);
			listadoproducto = crud.ListadoProducto();
		}else{
			crud.RegistrarProducto(producto);
			request.setAttribute("mensaje", "Dato Registrado en la BD");
			listadoproducto = crud.ListadoProducto();
		}
		
	
	
		request.setAttribute("listadoproductos", listadoproducto);
		
		request.getRequestDispatcher("/FormRegistrarProducto.jsp").forward(request, response);
	}

}
