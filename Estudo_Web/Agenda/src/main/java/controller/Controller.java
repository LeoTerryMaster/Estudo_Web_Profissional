package controller;

import java.io.IOException;
import java.util.ArrayList;

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
	"/insert",
	"/select",
	"/update",
	"/delete"})
public class Controller extends HttpServlet{

	private static final long serialVersionUID = 1L;

	DAO dao = new DAO();
	JavaBeans contatos = new JavaBeans();

	public Controller(){
		super();
	}


	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{

		String action = request.getServletPath();
		System.out.println(action);
		if(action.equals("/main")){
			contatos(request, response);
		}else if(action.equals("/insert")){
			novoContatos(request, response);
		}else if(action.equals("/select")){
			listarContatos(request, response);
		}else if(action.equals("/update")){
			editarContatos(request, response);
		}else if(action.equals("/delete")){
			deletarContatos(request, response);
		}else{
			response.sendRedirect("index.html");
		}

	}

	// Listar contatos

	protected void contatos(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{

		ArrayList<JavaBeans> lista = dao.listarContatos();

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


	// Editar contatos
	protected void listarContatos(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{

		// receber id do contatos
		String idcon = request.getParameter("idcon");
		contatos.setIdcon(idcon);

		// executar método selecionr contatos
		dao.selecionarContatos(contatos);

		// setar os atribustos do formularios
		request.setAttribute("idcon", contatos.getIdcon());
		request.setAttribute("nome", contatos.getNome());
		request.setAttribute("fone", contatos.getFone());
		request.setAttribute("email", contatos.getEmail());

		// Encamnhar ao documento ecitar 
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);


	}


	protected void editarContatos(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		// setar as variáveis JavaBeans

		contatos.setIdcon(request.getParameter("idcon"));
		contatos.setNome(request.getParameter("nome"));
		contatos.setFone(request.getParameter("fone"));
		contatos.setEmail(request.getParameter("email"));

		// executar alteração do contato
		dao.alterarContatos(contatos);

		// redirecionar para o documento agenda.jsp
		response.sendRedirect("main");

	}


	protected void deletarContatos(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{

		//recebimento do id do contato a ser excluido
		String idcon = request.getParameter("idcon");

		// setart a variável idcon
		contatos.setIdcon(idcon);

		//deletar na tabela
		dao.deletarContatos(contatos);

		// redirecionar para o documento agenda.jsp
		response.sendRedirect("main");
	}

}
