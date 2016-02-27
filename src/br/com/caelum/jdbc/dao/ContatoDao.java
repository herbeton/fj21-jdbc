package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.sql.Date;
import java.sql.ResultSet;

import com.mysql.jdbc.PreparedStatement;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Contato;

public class ContatoDao {
	// a conexão com o banco de dados
	private Connection connection;
	
	public ContatoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Contato contato) {
	     String sql = "insert into contatos " +
	             "(nome,email,endereco,dataNascimento)" +
	             " values (?,?,?,?)";
	 
	     try {
	         // prepared statement para inserção
	         PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
	 
	         // seta os valores
	         stmt.setString(1,contato.getNome());
	         stmt.setString(2,contato.getEmail());
	         stmt.setString(3,contato.getEndereco());
	         stmt.setDate(4, (java.sql.Date) new Date(
	                 contato.getDataNascimento().getTimeInMillis()));
	 
	         // executa
	         stmt.execute();
	         stmt.close();
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }
	
	public List<Contato> getLista() {
	     try {
	         List<Contato> contatos = new ArrayList<Contato>();
	         PreparedStatement stmt = (PreparedStatement) this.connection.
	                 prepareStatement("select * from contatos");
	         ResultSet rs = stmt.executeQuery();
	 
	         while (rs.next()) {
	             // criando o objeto Contato
	             Contato contato = new Contato();
	             contato.setId(rs.getLong("id"));
	             contato.setNome(rs.getString("nome"));
	             contato.setEmail(rs.getString("email"));
	             contato.setEndereco(rs.getString("endereco"));
	 
	             // montando a data através do Calendar
	             Calendar data = Calendar.getInstance();
	             data.setTime(rs.getDate("dataNascimento"));
	             contato.setDataNascimento(data);
	 
	             // adicionando o objeto à lista
	             contatos.add(contato);
	         }
	         rs.close();
	         stmt.close();
	         return contatos;
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }
}
