package com.bellakratchei.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bellakratchei.models.Usuario;

import bellakratchei.com.github.fabrica.FabricaJDBC;

public class RepositorioUsuarioDB implements RepositorioInterface<Integer, Usuario>{

	public List<Usuario> all() {
		List<Usuario> lista = new ArrayList<Usuario>();
		
		try (Connection conn = FabricaJDBC.criaConn()) {
			String sql = "SELECT * FROM usuario";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				Usuario u = new Usuario(rs.getInt("id"),rs.getString("nome"),rs.getString("email"),rs.getString("cargo"));
				lista.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}

	public Usuario one(Integer id) {
		try(Connection conn = FabricaJDBC.criaConn()){
			String sql = "SELECT * FROM usuario where id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Usuario u = new Usuario(rs.getInt("id"),rs.getString("nome"),rs.getString("email"),rs.getString("cargo"));
				return u;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void insert(Usuario entidade) {
		try(Connection conn = FabricaJDBC.criaConn()){
			String sql = "INSERT INTO usuario (nome,email,cargo) VALUES (?,?,?);";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,entidade.getNome());
			ps.setString(2,entidade.getEmail());
			ps.setString(3,entidade.getCargo());
			ps.execute();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Usuario entidade) {
		try(Connection conn = FabricaJDBC.criaConn()){
			String sql = "UPDATE usuario SET nome = ?, email = ?, cargo = ? WHERE id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,entidade.getNome());
			ps.setString(2,entidade.getEmail());
			ps.setString(3,entidade.getCargo());
			ps.setInt(4,entidade.getId());
			ps.execute();	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(Integer id) {
		try(Connection conn = FabricaJDBC.criaConn()){
			String sql = "DELETE FROM usuario WHERE id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
