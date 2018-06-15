package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.CarroDAO;
import model.Carro;

@WebServlet(name = "CarrosController", urlPatterns = "/carro")
public class CarrosController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CarrosController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Carro carro = new Carro();
		CarroDAO cDao = new CarroDAO();

		carro.setCodigo(Integer.parseInt((request.getParameter("codigo"))));
		carro.setModelo(request.getParameter("modelo"));
		carro.setCor(request.getParameter("cor"));
		carro.setFabricante(request.getParameter("fabricante"));
		carro.setAno(Integer.parseInt((request.getParameter("ano"))));

		List<Carro> carros;
		try {
			cDao.add(carro);
			carros = cDao.getAll();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		request.setAttribute("carros", carros);

	    request.
	      getRequestDispatcher("/carros.jsp").
	      forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		CarroDAO cDao = new CarroDAO();
		List<Carro> carros;
		try {
			carros = cDao.getAll();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		request.setAttribute("carros", carros);
	    request.
	      getRequestDispatcher("/carros.jsp").
	      forward(request, response);
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		CarroDAO cDao = new CarroDAO();
		Carro carro = new Carro();
		
		carro.setCodigo(Integer.parseInt((request.getParameter("codigo"))));
		carro.setModelo(request.getParameter("modelo"));
		carro.setCor(request.getParameter("cor"));
		carro.setFabricante(request.getParameter("fabricante"));
		carro.setAno(Integer.parseInt((request.getParameter("ano"))));
		
		List<Carro> carros;
		try {
			cDao.update(carro);
			carros = cDao.getAll();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		request.setAttribute("carros", carros);
	    request.
	      getRequestDispatcher("/carros.jsp").
	      forward(request, response);
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Carro carro = new Carro();
		CarroDAO cDao = new CarroDAO();
		
		carro.setCodigo(Integer.parseInt((request.getParameter("codigo"))));
		carro.setModelo(request.getParameter("modelo"));
		carro.setCor(request.getParameter("cor"));
		carro.setFabricante(request.getParameter("fabricante"));
		carro.setAno(Integer.parseInt((request.getParameter("ano"))));
		
		List<Carro> carros;
		try {
			cDao.delete(carro);
			carros = cDao.getAll();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		request.setAttribute("carros", carros);
		
	    request.
	      getRequestDispatcher("/carros.jsp").
	      forward(request, response);
	}

}
