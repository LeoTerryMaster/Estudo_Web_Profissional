package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO{

	/**
	 * Módulo de conexão
	 */

	private String driver = "org.mariadb.jdbc.Driver";
	private String url = "jdbc:mariadb://127.0.0.1:3306/dbagenda?userTimesone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "123456";

	private Connection conectar(){

		Connection con = null;

		try{
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;

		}catch(Exception e){

			e.printStackTrace();
			return null;
		}

	}

	//		public void testeConexao() {
	//			try {
	//				Connection con = conectar();
	//				System.out.println(con);
	//				con.close();
	//			} catch (Exception e) {
	//				e.printStackTrace();
	//			}
	//	
	//		}


	/**
	 * CRUD CREATE
	 */

	public void inserirContatos(JavaBeans contatos){

		String create = "insert into contatos (nome, fone, email) values (?,?,?)";
		try(Connection connection = conectar(); PreparedStatement pst = connection.prepareStatement(create)){
			pst.setString(1, contatos.getNome());
			pst.setString(2, contatos.getFone());
			pst.setString(3, contatos.getEmail());
			// Executar Update a query 
			pst.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	/**
	 * CRUD READ
	 */
	public ArrayList<JavaBeans> listarContatos(){
		// criar objeto
		ArrayList<JavaBeans> contatos = new ArrayList<>();
		String read = "select * from contatos order by idcon";
		try(Connection connection = conectar(); PreparedStatement pst = connection.prepareStatement(read)){
			// listar todos do bando de dados 
			try(ResultSet rs = pst.executeQuery()){
				//em quanto tiver usuários execute
				while(rs.next()){
					String idcon = rs.getNString(1);
					String nome = rs.getNString(2);
					String fone = rs.getNString(3);
					String email = rs.getNString(4);
					// populando a lista
					contatos.add(new JavaBeans(idcon, nome, fone, email));
				}
			}
			return contatos;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}


	// CRUD UPDATE
	// selecionar contatos
	public void selecionarContatos(JavaBeans contato){
		String read = "select * from contatos where idcon =?";
		try(Connection connection = conectar(); PreparedStatement pst = connection.prepareStatement(read)){
			pst.setString(1, contato.getIdcon());
			try(ResultSet rs = pst.executeQuery()){
				while(rs.next()){
					//setar variáveis javaBeans alterar
					contato.setIdcon(rs.getString(1));
					contato.setNome(rs.getString(2));
					contato.setFone(rs.getString(3));
					contato.setEmail(rs.getString(4));
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}


	// editar contatos
	public void alterarContatos(JavaBeans contatos){
		String create = "update contatos set nome=?,fone=?,email=? where idcon=?";
		try(Connection connection = conectar(); PreparedStatement pst = connection.prepareStatement(create)){
			pst.setString(1, contatos.getNome());
			pst.setString(2, contatos.getFone());
			pst.setString(3, contatos.getEmail());
			pst.setString(4, contatos.getIdcon());
			pst.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	
	/*
	 * CRUD DELETE
	 * */
	//deleter 
	public void deletarContatos(JavaBeans contatos){
		String create = "delete from contatos where idcon = ?";
		try(Connection connection = conectar(); PreparedStatement pst = connection.prepareStatement(create)){
			pst.setString(1, contatos.getIdcon());
			pst.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	
	
	
	

}
