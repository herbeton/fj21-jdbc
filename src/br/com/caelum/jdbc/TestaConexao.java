package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import com.mysql.jdbc.PreparedStatement;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaConexao {
	public static void main(String[] args) throws SQLException {
		//Testando a conexão
		/* Connection connection = new ConnectionFactory().getConnection();
		System.out.println("Conexão aberta!");
		connection.close();*/
		
		
		// Dando um insert no banco de dados
		/*Contato contato = new Contato();
		contato.setNome("Caelum4");
		contato.setEmail("contato@caelum.com.br4");
		contato.setEndereco("R. Vergueiro 3185 cj574");
		contato.setDataNascimento(Calendar.getInstance());
		 
		// grave nessa conexão!!!
		ContatoDao dao = new ContatoDao();
		 
		// método elegante
		dao.adiciona(contato);
		 
		System.out.println("Gravado!");*/
		
		
		//Testando o select no banco de dados
		/*// pega a conexão e o Statement
		Connection con = new ConnectionFactory().getConnection();
		PreparedStatement stmt = (PreparedStatement) con.prepareStatement("select * from contatos");

		// executa um select
		ResultSet rs = stmt.executeQuery();

		// itera no ResultSet
		while (rs.next()) {
		  String nome = rs.getString("nome");
		  String email = rs.getString("email");

		  System.out.println(nome + " :: " + email);
		}

		stmt.close();
		con.close();*/
		
		
		
	}

}
