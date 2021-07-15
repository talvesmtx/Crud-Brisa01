import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.api.mysqla.result.Resultset;

public class Alunos {
	
	private int id;
	private String nome;
	private int idade;
	private int ra;
	
	public Alunos()
	{
		nome = "Thiago";
		idade = 38;
		ra = 123456;
	}
	public Alunos(int id)
	{
		this.id = id;
	}

	public Alunos(String nome, int id, int r)
	{
		this.nome = nome;
		idade = id;
		ra = r;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public int getId()
	{
		return id;
	}
	public void setNome(String n) {
		nome = n;
	}
	
	public String getNome()
	{
		return nome;
	}
	
	public void setIdade(int id)
	{
		idade = id;
	}
	
	public int getIdade()
	{
		return idade;
	}
	
	public void setRA(int r)
	{
		ra = r;
	}
	public int getRA()
	{
		return ra;
	}
	public void imprirDados() {
		System.out.println("ID: "+id+"\nNome: "+nome+"\nIdade: "+idade+"\nRA: "+ra);
	}
	
	public void inserir(Connection conn)
	{
		String sqlInsert = "insert into alunos (nome,idade,ra)"
				+ "values(?, ?, ?)";
		try (PreparedStatement stm = conn.prepareStatement(sqlInsert)){
			stm.setString(1, getNome());
			stm.setInt(2, getIdade());
			stm.setInt(3, getRA());
			stm.execute();
		}catch (Exception e) {
			e.printStackTrace();
			try
			{
				conn.rollback();
			}catch (Exception e1) {
				System.out.print(e1.getStackTrace());
			}
		}
	}
	public void excluir(Connection conn)
	{
		String sqlDelete = "delete from alunos where id = ?";
		try (PreparedStatement stm = conn.prepareStatement(sqlDelete)){
			stm.setInt(1, getId());
			stm.execute();
		}catch (Exception e) {
			e.printStackTrace();
			try
			{
				conn.rollback();
			}catch (Exception e1) {
				System.out.print(e1.getStackTrace());
			}
		}
	}
	public void atualizar(Connection conn)
	{
		String sqlUpdate = "update alunos set nome = ? where id = ?";
		try (PreparedStatement stm = conn.prepareStatement(sqlUpdate)){
			stm.setString(1, getNome());
			stm.setInt(2, getId());
			stm.execute();
		}catch (Exception e) {
			e.printStackTrace();
			try
			{
				conn.rollback();
			}catch (Exception e1) {
				System.out.print(e1.getStackTrace());
			}
		}
	}
	public void carregar(Connection conn)
	{
		String sqlSelect = "select * from alunos where id = ?";
		try (PreparedStatement stm = conn.prepareStatement(sqlSelect)){
			stm.setInt(1, getId());
			try(ResultSet rs = stm.executeQuery(); ){
				if(rs.next()) {
					this.setNome(rs.getString(2));
					this.setIdade(rs.getInt(3));
					this.setRA(rs.getInt(4));
				}	
			}
		}catch (Exception e) {
			e.printStackTrace();
			try
			{
				conn.rollback();
			}catch (Exception e1) {
				System.out.print(e1.getStackTrace());
			}
		}
	}


}
