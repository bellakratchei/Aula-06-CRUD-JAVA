package com.bellakratchei.ui.console;

import java.util.List;
import java.util.Scanner;

import com.bellakratchei.models.Usuario;
import com.bellakratchei.repositorio.RepositorioUsuarioDB;

public class ControllerUsuario {
	
//	private RepositorioUsuario repositorioUsuario = new RepositorioUsuario();
	private RepositorioUsuarioDB repositorioUsuario = new RepositorioUsuarioDB();
	
	private Scanner scan = new Scanner(System.in);
	
	public void listaTodos(){
		List<Usuario> lista = this.repositorioUsuario.all();
		
		if(lista.isEmpty()) {
			System.out.println("Nenhum usuário encontrado");
		}
		
		lista.forEach(u -> {
			System.out.println("ID:" + u.getId());
			System.out.println("Nome:" + u.getNome());
			System.out.println("Email:" + u.getEmail());
			System.out.println("Cargo:" + u.getCargo());
			System.out.println("_________________________");
		});
	}
	
	public void listaUm(){
		System.out.println("Digite o id do usuário a ser consultado: ");
		int id = scan.nextInt();
		scan.nextLine();
		Usuario user = repositorioUsuario.one(id);
		if(!user.equals(null)) {
			System.out.println("\nID Cadastrado:" + user.getNome());
			System.out.println("\nNome Cadastrado:" + user.getNome());
			System.out.println("\nEmail Cadastrado:" + user.getEmail());
			System.out.println("\nCargo Cadastrado:" + user.getCargo());
		}
	}
	
	public void adicionar(){
		Integer id;
		String nome;
		String email;
		String cargo;
		
		System.out.println("Digite o id:");
		id = scan.nextInt();
		scan.nextLine();
		System.out.println("Digite o nome:");
		nome = scan.nextLine();
		System.out.println("Digite o email:");
		email = scan.nextLine();
		System.out.println("Digite o cargo:");
		cargo = scan.nextLine();
		scan.close();
		Usuario u = new Usuario(id, nome, email, cargo);
		
		repositorioUsuario.insert(u);
		System.out.println("Usuário cadastrado com sucesso!");
		
		listaTodos();
	
	}
//	
	public void alterar(){
		System.out.println("Digite o id do usuário a ser alterado: ");
		int id = scan.nextInt();
		scan.nextLine();
		
		Usuario userOld = repositorioUsuario.one(id);
		
		if(!userOld.equals(null)) {
			System.out.println("\nNome Cadastrado:" + userOld.getNome());
			System.out.println("\nEmail Cadastrado:" + userOld.getEmail());
			System.out.println("\nCargo Cadastrado:" + userOld.getCargo());
			
			System.out.println("Digite o novo nome do usuário:");
			String nome = scan.nextLine();
			System.out.println("Digite o novo email  do usuário:");
			String email = scan.nextLine();
			System.out.println("Digite o novo cargo do usuário:");
			String cargo = scan.nextLine();
			Usuario userNew = new Usuario(userOld.getId(), nome, email, cargo);
			
			repositorioUsuario.update(userNew);
			System.out.println("Usuário alterado com sucesso!");
		} else {
			System.out.println("Usuário não existente!");
		}

	}
	
 	public void remover(){
		System.out.println("Digite o id do usuário a ser removido: ");
		int id = scan.nextInt();
		scan.nextLine();
		
		repositorioUsuario.delete(id);
		System.out.println("Usuário removido com sucesso!");
	}
}
