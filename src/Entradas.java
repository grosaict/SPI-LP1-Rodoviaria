
import java.util.InputMismatchException;

import java.util.Scanner;

public class Entradas {

	public char leiaBus(){
		char tipoBus;
		Scanner leia = new Scanner(System.in);
		System.out.println("Escolha o tipo de ônibus para inciar o sistema:");
		System.out.println("(C)onvencional  |  (E)xecutivo  |  (S)air");
		try {
			tipoBus = leia.next().charAt(0);
			if (!Character.isLetter(tipoBus)){
				throw new InputMismatchException("NÃO ALFABÉTICO");
			}else{
				tipoBus = Character.toUpperCase(tipoBus);
				if (tipoBus != 'C' && tipoBus != 'E' && tipoBus != 'S'){
					throw new InputMismatchException("OPÇÃO INEXISTENTE");
				}
			}
		}catch(InputMismatchException e){
        	System.err.println("Entrada inválida!! >>"+e.getMessage()+"<< Informe novamente");
        	tipoBus = leiaBus();
		}
		return tipoBus;
	}
	
	public char leiaMenu(){
		char opcaoMenu;
		Scanner leia = new Scanner(System.in);
		System.out.println("Escolha uma das opções abaixo:");
		System.out.println("(V)enda Passagem  |  (C)ancelamento  |  (E)ncerrar Vendas");
		try {
			opcaoMenu = leia.next().charAt(0);
			if (!Character.isLetter(opcaoMenu)){
				throw new InputMismatchException("NÃO ALFABÉTICO");
			}else{
				opcaoMenu = Character.toUpperCase(opcaoMenu);
				if (opcaoMenu != 'V' && opcaoMenu != 'C' && opcaoMenu != 'E'){
					throw new InputMismatchException("OPÇÃO INEXISTENTE");
				}
			}
		}catch(InputMismatchException e){
        	System.err.println("Entrada inválida!! >>"+e.getMessage()+"<< Informe novamente");
        	opcaoMenu = leiaMenu();
		}
		return opcaoMenu;
	}
	
	public char leiaConfirmacao(String msg){
		char opcaoSN;
		Scanner leia = new Scanner(System.in);
		System.out.println(msg);
		System.out.println("         (S)im  |  (N)ão");
		try {
			opcaoSN = leia.next().charAt(0);
			if (!Character.isLetter(opcaoSN)){
				throw new InputMismatchException("NÃO ALFABÉTICO");
			}else{
				opcaoSN = Character.toUpperCase(opcaoSN);
				if (opcaoSN != 'S' && opcaoSN != 'N'){
					throw new InputMismatchException("OPÇÃO INEXISTENTE");
				}
			}
		}catch(InputMismatchException e){
        	System.err.println("Entrada inválida!! >>"+e.getMessage()+"<< Informe novamente");
        	opcaoSN = leiaConfirmacao(msg);
		}
		return opcaoSN;
	}
	
	public byte leiaAssento(byte aTot){
		byte assento;
		Scanner leia = new Scanner(System.in);
		System.out.println("Informe o número do assento desejado ou 0 para abadonar:");
		try {
			assento = leia.nextByte();
			if (assento > aTot || assento < 0){
				throw new InputMismatchException("ASSENTO INEXISTENTE");
			}
		}catch(InputMismatchException e){
        	System.err.println("Entrada inválida!! >>ASSENTO INEXISTENTE<< Informe novamente");
        	assento = leiaAssento(aTot);
		}
		return assento;
	}
	
	public String leiaNome(){
		String nome;
		Scanner leia = new Scanner(System.in);
		System.out.println("Informe o nome do passageiro (sem acentuação e/ou pontuação) (* para desistir):");
		try {
			nome = leia.nextLine();
			if (nome.charAt(0) != '*'){
				if (nome.charAt(0) == ' '){
					throw new Exception("INICIADO POR ESPAÇO");
				}else{
					for (int i=0; i<nome.length();i++){
						if (!(Character.isLetter(nome.charAt(i)) || (nome.charAt(i) == ' '))){
							throw new Exception("NÃO ALFABÉTICO");
						}
					}
				}
			}
		}catch(Exception e){
        	System.err.println("Entrada inválida!! >>"+e.getMessage()+"<< Informe novamente");
        	nome = leiaNome();
		}
		nome = nome.toUpperCase();
		return nome;
	}
	
	public String leiaDocumento(){
		String documento;
		Scanner leia = new Scanner(System.in);
		System.out.println("Informe o documento de identificação do passageiro (sem pontuação) (* para desistir):");
		try {
			documento = leia.nextLine();
			if (documento.charAt(0) != '*'){
				for (int i=0; i<documento.length();i++){
					if (!(Character.isLetter(documento.charAt(i)) || Character.isDigit(documento.charAt(i)))){
						throw new InputMismatchException("ACEITA SOMENTE NÚMEROS E LETRAS");
					}
				}
			}
		}catch(InputMismatchException e){
        	System.err.println("Entrada inválida!! >>>ACEITA SOMENTE NÚMEROS E LETRAS<<< Informe novamente");
        	documento = leiaDocumento();
		}
		documento = documento.toUpperCase();
		return documento;
	}
}
