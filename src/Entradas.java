
import java.util.InputMismatchException;

import java.util.Scanner;

public class Entradas {

	public char leiaBus(){
		char tipoBus;
		Scanner leia = new Scanner(System.in);
		System.out.println("Escolha o tipo de �nibus para inciar o sistema:");
		System.out.println("(C)onvencional  |  (E)xecutivo  |  (S)air");
		try {
			tipoBus = leia.next().charAt(0);
			if (!Character.isLetter(tipoBus)){
				throw new InputMismatchException("N�O ALFAB�TICO");
			}else{
				tipoBus = Character.toUpperCase(tipoBus);
				if (tipoBus != 'C' && tipoBus != 'E' && tipoBus != 'S'){
					throw new InputMismatchException("OP��O INEXISTENTE");
				}
			}
		}catch(InputMismatchException e){
        	System.err.println("Entrada inv�lida!! >>"+e.getMessage()+"<< Informe novamente");
        	tipoBus = leiaBus();
		}
		return tipoBus;
	}
	
	public char leiaMenu(){
		char opcaoMenu;
		Scanner leia = new Scanner(System.in);
		System.out.println("Escolha uma das op��es abaixo:");
		System.out.println("(V)enda Passagem  |  (C)ancelamento  |  (E)ncerrar Vendas");
		try {
			opcaoMenu = leia.next().charAt(0);
			if (!Character.isLetter(opcaoMenu)){
				throw new InputMismatchException("N�O ALFAB�TICO");
			}else{
				opcaoMenu = Character.toUpperCase(opcaoMenu);
				if (opcaoMenu != 'V' && opcaoMenu != 'C' && opcaoMenu != 'E'){
					throw new InputMismatchException("OP��O INEXISTENTE");
				}
			}
		}catch(InputMismatchException e){
        	System.err.println("Entrada inv�lida!! >>"+e.getMessage()+"<< Informe novamente");
        	opcaoMenu = leiaMenu();
		}
		return opcaoMenu;
	}
	
	public char leiaConfirmacao(String msg){
		char opcaoSN;
		Scanner leia = new Scanner(System.in);
		System.out.println(msg);
		System.out.println("         (S)im  |  (N)�o");
		try {
			opcaoSN = leia.next().charAt(0);
			if (!Character.isLetter(opcaoSN)){
				throw new InputMismatchException("N�O ALFAB�TICO");
			}else{
				opcaoSN = Character.toUpperCase(opcaoSN);
				if (opcaoSN != 'S' && opcaoSN != 'N'){
					throw new InputMismatchException("OP��O INEXISTENTE");
				}
			}
		}catch(InputMismatchException e){
        	System.err.println("Entrada inv�lida!! >>"+e.getMessage()+"<< Informe novamente");
        	opcaoSN = leiaConfirmacao(msg);
		}
		return opcaoSN;
	}
	
	public byte leiaAssento(byte aTot){
		byte assento;
		Scanner leia = new Scanner(System.in);
		System.out.println("Informe o n�mero do assento desejado ou 0 para abadonar:");
		try {
			assento = leia.nextByte();
			if (assento > aTot || assento < 0){
				throw new InputMismatchException("ASSENTO INEXISTENTE");
			}
		}catch(InputMismatchException e){
        	System.err.println("Entrada inv�lida!! >>ASSENTO INEXISTENTE<< Informe novamente");
        	assento = leiaAssento(aTot);
		}
		return assento;
	}
	
	public String leiaNome(){
		String nome;
		Scanner leia = new Scanner(System.in);
		System.out.println("Informe o nome do passageiro (sem acentua��o e/ou pontua��o) (* para desistir):");
		try {
			nome = leia.nextLine();
			if (nome.charAt(0) != '*'){
				if (nome.charAt(0) == ' '){
					throw new Exception("INICIADO POR ESPA�O");
				}else{
					for (int i=0; i<nome.length();i++){
						if (!(Character.isLetter(nome.charAt(i)) || (nome.charAt(i) == ' '))){
							throw new Exception("N�O ALFAB�TICO");
						}
					}
				}
			}
		}catch(Exception e){
        	System.err.println("Entrada inv�lida!! >>"+e.getMessage()+"<< Informe novamente");
        	nome = leiaNome();
		}
		nome = nome.toUpperCase();
		return nome;
	}
	
	public String leiaDocumento(){
		String documento;
		Scanner leia = new Scanner(System.in);
		System.out.println("Informe o documento de identifica��o do passageiro (sem pontua��o) (* para desistir):");
		try {
			documento = leia.nextLine();
			if (documento.charAt(0) != '*'){
				for (int i=0; i<documento.length();i++){
					if (!(Character.isLetter(documento.charAt(i)) || Character.isDigit(documento.charAt(i)))){
						throw new InputMismatchException("ACEITA SOMENTE N�MEROS E LETRAS");
					}
				}
			}
		}catch(InputMismatchException e){
        	System.err.println("Entrada inv�lida!! >>>ACEITA SOMENTE N�MEROS E LETRAS<<< Informe novamente");
        	documento = leiaDocumento();
		}
		documento = documento.toUpperCase();
		return documento;
	}
}
