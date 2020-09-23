package com.bellakratchei.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.bellakratchei.models.Tarefa;
import bellakratchei.com.github.fabrica.FabricaJDBC;

public class RepositorioTarefaDB implements RepositorioInterface<Integer, Tarefa>{

	public List<Tarefa> all() {
		List<Tarefa> lista = new ArrayList<Tarefa>();
		
		try (Connection conn = FabricaJDBC.criaConn()) {
			String sql = "SELECT * FROM tarefa";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				Tarefa t = new Tarefa(rs.getInt("id"),rs.getString("status").charAt(0),rs.getInt("id_usuario"), rs.getString("titulo"),rs.getString("descricao"));
				lista.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}

	public Tarefa one(Integer id) {

		try(Connection conn = FabricaJDBC.criaConn()){
			String sql = "SELECT * FROM tarefa where id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Tarefa t = new Tarefa(rs.getInt("id"),rs.getString("status").charAt(0),rs.getInt("id_usuario"), rs.getString("titulo"),rs.getString("descricao"));
				return t;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void insert(Tarefa entidade) {

		try(Connection conn = FabricaJDBC.criaConn()){
			String sql = "INSERT INTO tarefa (status,id_usuario,titulo,descricao) VALUES (?,?,?,?);";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,String.valueOf(entidade.getStatus()));
			ps.setInt(2, entidade.getId_usuario());
			ps.setString(3,entidade.getTitulo());
			ps.setString(4,entidade.getDescricao());
			ps.execute();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void update(Tarefa entidade) {
		try(Connection conn = FabricaJDBC.criaConn()){
			String sql = "UPDATE tarefa SET status = ?, id_usuario = ?, titulo = ?, descricao = ? WHERE id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,String.valueOf(entidade.getStatus()));
			ps.setInt(2,entidade.getId_usuario());
			ps.setString(3,entidade.getTitulo());
			ps.setString(4,entidade.getDescricao());
			ps.setInt(5,entidade.getId());
			ps.execute();	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(Integer id) {
		try(Connection conn = FabricaJDBC.criaConn()){
			String sql = "DELETE FROM tarefa WHERE id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
