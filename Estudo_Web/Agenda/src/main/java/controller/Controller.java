package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = {
	"/Controller",
	"/main",
	"/insert"})
public class Controller extends HttpServlet{

	private static final long serialVersionUID = 1L;

	DAO dao = new DAO();
	JavaBeans contatos = new JavaBeans();

	public Controller(){
		super();
	}


	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{

		String action = request.getServletPath();

		if(action.equals("/main")){
			contatos(request, response);
		}else if(action.equals("/insert")){
			novoContatos(request, response);
		}else{
			response.sendRedirect("index.html");
		}

	}

	// Listar contatos

	protected void contatos(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{

		List<JavaBeans> lista = dao.listarContatos();

		// encaminhar a lista ao documento
		request.setAttribute("contatos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
		rd.forward(request, response);

	}


	// Novo contato

	protected void novoContatos(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{

		contatos.setNome(request.getParameter("nome"));
		contatos.setFone(request.getParameter("fone"));
		contatos.setEmail(request.getParameter("email"));
		// inserir contatos
		dao.inserirContatos(contatos);
		// redirecionar 
		response.sendRedirect("main");

	}

}
