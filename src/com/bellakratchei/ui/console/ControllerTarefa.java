package com.bellakratchei.ui.console;

import java.util.List;
import java.util.Scanner;
import com.bellakratchei.models.Tarefa;
import com.bellakratchei.repositorio.RepositorioTarefaDB;

public class ControllerTarefa {
	
//	private RepositorioUsuario repositorioUsuario = new RepositorioUsuario();
	private RepositorioTarefaDB repositorioTarefa = new RepositorioTarefaDB();
	
	private Scanner scan = new Scanner(System.in);
	
	public void listaTodos(){
		List<Tarefa> lista = this.repositorioTarefa.all();
		
		if(lista.isEmpty()) {
			System.out.println("Nenhuma tarefa encontrada");
		}
		
		lista.forEach(t -> {
			System.out.println("ID:" + t.getId());
			System.out.println("Status:" + t.getStatus());
			System.out.println("ID do Usu�rio:" + t.getId_usuario());
			System.out.println("T�tulo:" + t.getTitulo());
			System.out.println("Descri��o:" + t.getDescricao());
			System.out.println("_________________________");
		});
	}
	
	public void listaUm(){
		System.out.println("Digite o id da tarefa a ser consultada: ");
		int id = scan.nextInt();
		scan.nextLine();
		Tarefa task = repositorioTarefa.one(id);
		if(!task.equals(null)) {
			System.out.println("\n____________Infoma��es Cadastradas____________");
			System.out.println("\nID:" + task.getId());
			System.out.println("\nStatus:" + task.getStatus());
			System.out.println("\nID do usu�rio:" + task.getId_usuario());
			System.out.println("\nT�tulo:" + task.getTitulo());
			System.out.println("\nDescri��o:" + task.getDescricao());
		}
	}
	
	public void adicionar(){
		Integer id;
		Character status;
		int id_user;
		String titulo;
		String descricao;
		
		System.out.println("Digite o id:");
		id = scan.nextInt();
		scan.nextLine();
		System.out.println("Digite o status:");
		status = scan.next().charAt(0);
		System.out.println("Digite o ID do usu�rio:");
		id_user = scan.nextInt();
		System.out.println("Digite o t�tulo:");
		titulo = scan.nextLine();
		System.out.println("Digite a descri��o:");
		descricao = scan.nextLine();
		scan.close();
		Tarefa t = new Tarefa(id, status, id_user, titulo, descricao);
		
		repositorioTarefa.insert(t);
		System.out.println("Tarefa cadastrada com sucesso!");
		
		listaTodos();
	
	}
	
	public void alterar(){
		System.out.println("Digite o id da tarefa a ser alterada: ");
		int id = scan.nextInt();
		scan.nextLine();
		
		Tarefa taskOld = repositorioTarefa.one(id);
		
		if(!taskOld.equals(null)) {
			System.out.println("\n____________Infoma��es Cadastradas____________");
			System.out.println("\nStatus:" + taskOld.getStatus());
			System.out.println("\nID do usu�rio:" + taskOld.getId_usuario());
			System.out.println("\nT�tulo:" + taskOld.getTitulo());
			System.out.println("\nDescri��o:" + taskOld.getDescricao());
			
			System.out.println("Digite o novo status da tarefa:");
			Character task = scan.next().charAt(0);
			System.out.println("Digite o novo ID do usu�rio da tarefa:");
			int id_user = scan.nextInt();
			System.out.println("Digite o novo t�tulo da tarefa:");
			String title = scan.nextLine();
			System.out.println("Digite a nova descri��o da tarefa:");
			String desc = scan.nextLine();
			Tarefa taskNew = new Tarefa(taskOld.getId(), task, id_user, title, desc);
			
			repositorioTarefa.update(taskNew);
			System.out.println("Tarefa alterada com sucesso!");
		} else {
			System.out.println("Tarefa n�o existente!");
		}

	}
	
 	public void remover(){
		System.out.println("Digite o id da tarefa a ser removida: ");
		int id = scan.nextInt();
		scan.nextLine();
		
		repositorioTarefa.delete(id);
		System.out.println("Tarefa removida com sucesso!");
	}
}
