package programa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dominio.Turma;

public class principal {
	
	//Variavel global - repositorio de turmas
	public static List<Turma> todasTurmas = new ArrayList<Turma>();
	static Scanner entrada = new Scanner(System.in);
	
	/**
	 * metodo main
	 */
	public static void main(String[] args) {
		//CADASTRAR TURMAS
		//MATRICULAR PRIMEIRA VEZ
		//CONFIRMAR MATRICULA
		int menu;
	
		do {
			System.out.print("Menu\n1. Ver turmas"
					+ "\n2. Cadastrar turma\n3. Matricula prim. vez\n"
					+ "4. Confirmar matricula\n0. Sair\nEscolha: ");
			menu = entrada.nextInt();
			
			switch(menu) {
			case 1:
				//chamada do metodo que exibe as todas as turmas
				verTodasTurmas();
				break;
			case 2:
				//chamada do metodo que cria nova turma
				criarNovaTurma();
				break;
			case 3:
				//chamada das accoes para matricula pela primeira vez
				matricularPrimeiraVez();
				break;
			case 4:
				break;
			case 0:
				break;
			default:
				break;
			}
			
		} while(menu != 0);
	}
	
	
	
	/**
	 * Método responsável por criar nova turma com a informacao
	 * digitada pelo utilizador
	 */
	public static void criarNovaTurma() {
		System.out.println("2. CADASTRAR TURMA");
		System.out.println("Digite os dados da nova turma");
		
		System.out.print("Digite o ano Lectivo: ");
		int anoLectivo = entrada.nextInt(); 
		System.out.print("Digite o ano academico: ");
		int anoAcademico = entrada.nextInt(); 
		System.out.print("Digite o curso: ");
		String curso = entrada.next(); 
		System.out.print("Digite o periodo: ");
		String periodo = entrada.next(); 
		
		// instanciamos nova turma atraves do seu
		// metodo construtor
		Turma t = new Turma(anoLectivo, 
				anoAcademico, curso, periodo);
		
		todasTurmas.add(t);
		System.out.println("A turma foi criada");
	}
	
	
	
	/**
	 * Metodo que exibe todas as turmas guardadas na
	 * variavel global do tipo List<Turma> todasTurmas
	 */
	public static void verTodasTurmas() {
		System.out.println("1. VER TURMAS");
		
		System.out.println("ORDEM --- " +
				"ANO ACAD. --- " +
				"ANO LECT. --- " +
				"CURSO --- PERIODO");
		
		for (int i = 0; i < todasTurmas.size(); i++) {
			//aceder e exibir os dados
			Turma t = todasTurmas.get(i);
			
			System.out.println(	i + " --- " +
					t.anoAcademico + "º ano --- " +
					t.anoLectivo + " --- " +
					t.curso + " --- " +
					t.periodo + " --- " +
					t.matriculas.size() + " Alunos"
					);
		}		
	}
	
	
	
	/**
	 * Recebe dados digitados pelo utilizador sobre um novo aluno
	 * e regista no sistema. Alem disso permite seleccionar uma 
	 * turma onde o aluno vai pertencer;
	 */
	public static void matricularPrimeiraVez() {
		System.out.println("3. MATRICULAR PRIMEIRA VEZ");
		
		verTodasTurmas();
		System.out.println("Escolha uma turma pelo numero de ordem: ");
		int nOrdem = entrada.nextInt();		//ler a escolha do usuario
		
		//pegamos a turma para matricular
		Turma t = todasTurmas.get(nOrdem);
		
		System.out.print("Digite o nome do aluno: ");
		String nome = entrada.next();
		
		
		
	}
	
	
}
