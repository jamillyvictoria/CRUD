package com.jamilly.contatos;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static ArrayList<Contatos> arrayListContatos = new ArrayList<Contatos>();
	static Scanner inputUsuario = new Scanner(System.in);
	public static void main(String[] args) {
		telaInicial(0);
    }
	public static void telaInicial(int error_code) {
		clearConsole();
		//SE O CÓDIGO DE ERROR FOR DIFERENTE DE 0(SUCESSO), ENTÃO MOSTRE A TELA DE TENTE NOVAMENTE
		if (error_code != 0) {
			telaTenteNovamente();
		}
		System.out.println("Selecione a opção:");
		System.out.println("1 - Create:");
		System.out.println("2 - Read:");
		System.out.println("3 - Update:");
		System.out.println("4 - Delete:");
		
		String respostaUsuario = inputUsuario.nextLine();
		
		switch (respostaUsuario) {
		case "1":
			telaCreate();
			break;
		case "2":
			telaRead();
			break;
		case "3":
			telaUpdate();
			break;
		case "4":
			telaDelete();
			break;
		default:
			telaInicial(1);
			break;
		
		}
	}
	
	public static void telaDelete() {
		clearConsole();
		
		System.out.println("Digite o indice que voce quer deletar");
		String indiceContato = inputUsuario.nextLine();
		arrayListContatos.remove((int)Integer.valueOf(indiceContato));
		
		telaDigiteQualquerTecla();
	}
	public static void telaUpdate() {
		clearConsole();
		
		System.out.println("Digite o indice que voce quer atualizar");
		String indiceContato = inputUsuario.nextLine();
		
		System.out.println("Digite o novo nome: ");
		String inputNome = inputUsuario.nextLine();
		
		System.out.println("Digite o novo email: ");
		String inputEmail = inputUsuario.nextLine();
		
		System.out.println("Digite o novo telefone: ");
		String inputTelefone = inputUsuario.nextLine();
		
		arrayListContatos.get(Integer.valueOf(indiceContato)).setNome(inputNome);
		arrayListContatos.get(Integer.valueOf(indiceContato)).setEmail(inputEmail);
		arrayListContatos.get(Integer.valueOf(indiceContato)).setTelefone(inputTelefone);

		telaDigiteQualquerTecla();

	}
	
	public static void telaRead() {
		clearConsole();
		
		for(int i = 0 ; i < arrayListContatos.size(); i++) {
			System.out.println("INDICE: " + i);
			System.out.println(arrayListContatos.get(i).getNome());
			System.out.println(arrayListContatos.get(i).getEmail());
			System.out.println(arrayListContatos.get(i).getTelefone());
			System.out.println();
		}
		
		telaDigiteQualquerTecla();
	}
	
	public static void telaCreate() {
		clearConsole();
		System.out.println("BEM VINDO A TELA DE CRIAR CONTATOS");
		System.out.println("Insira as informações abaixo: ");
		
		System.out.println("Digite o nome: ");
		String inputNome = inputUsuario.nextLine();
		
		System.out.println("Digite o email: ");
		String inputEmail = inputUsuario.nextLine();
		
		System.out.println("Digite o telefone: ");
		String inputTelefone = inputUsuario.nextLine();
		
		
		Contatos contatos = new Contatos();
		contatos.setNome(inputNome);
		contatos.setEmail(inputEmail);
		contatos.setTelefone(inputTelefone);
		
		arrayListContatos.add(contatos);
		
		System.out.println("CONTATO ADICIONADO");

		telaDigiteQualquerTecla();
	}
	public static void telaTenteNovamente() {
		System.out.println("Tente novamente!");
	}
	public static void telaDigiteQualquerTecla() {
		System.out.println("Digite qualquer tecla pra sair da tela: ");
		inputUsuario.nextLine();
		telaInicial(0);
	}
	public final static void clearConsole()
	{   
		for (int i = 0; i < 50; ++i)  
	       System.out.println();  
	}
}
