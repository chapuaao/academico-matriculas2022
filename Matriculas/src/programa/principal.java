package programa;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dominio.Aluno;
import dominio.Matricula;
import dominio.Turma;

public class principal {

	//Variavel global - repositorio de turmas
	public static List<Turma> todasTurmas = new ArrayList<Turma>();
	public static List<Aluno> todosAlunos = new ArrayList<Aluno>();
	public static List<Matricula> todasMatriculas = new ArrayList<Matricula>();

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

		if(todasTurmas.size() > 0) {
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
		} else {
			System.out.println("Nao existem turmas");
		}

	}



	/**
	 * Recebe dados digitados pelo utilizador sobre um novo aluno
	 * e regista no sistema. Alem disso permite seleccionar uma 
	 * turma onde o aluno vai pertencer;
	 */
	public static void matricularPrimeiraVez() {
		System.out.println("3. MATRICULAR PRIMEIRA VEZ");

		if(todasTurmas.size() > 0) {
			verTodasTurmas();	//exibe a lista das turmas que existem

			System.out.print("Escolha uma turma pelo numero de ordem: ");
			int nOrdem = entrada.nextInt();		//ler a escolha do usuario

			//pegamos a turma para matricular da lista todasTurmas
			//atraves do metodo .get(posicao) da lista.
			Turma turma = todasTurmas.get(nOrdem);

			if(turma == null) {
				System.out.println("A turma não foi encontrada. "
						+ "A a matriucula nao pode ser realizada");
			} else if(turma.atingiuOLimite()){
				System.out.println("A turma esta cheia.");
			}
			else {
				System.out.print("Digite o nome do aluno: ");
				String nome = entrada.next();

				//criar novo numero de processo
				long novoNumProcesso = todosAlunos.size() + 1;

				Aluno aluno = new Aluno(nome, novoNumProcesso);
				todosAlunos.add(aluno); 	//adicionamos o objecto aluno na lista

				//realizar a matricula
				//ler os dados da matricula
				System.out.print("O estudente forneceu certificado? ");
				boolean certificado = (entrada.next().equals("s"));
				System.out.print("O estudante pagou pelo serviço? ");
				boolean pagou = (entrada.next().equals("s"));
				System.out.print("Media do certificado anterior: ");
				float media = entrada.nextFloat();
				//manipular o estado
				String estado = "Normal";
				if(!pagou) {	//se aluno nao pagou
					estado = "Pagamento pendente";
				}
				//pegar a data no formato 2007-12-03T10:15:30
				LocalDateTime data = LocalDateTime.now();

				//instanciar a nova matricula
				Matricula novaMatricula = new Matricula(certificado, pagou, 
						media, estado, data, turma, aluno);
				//adicionar a matricula na lista de matriculas da turma
				turma.matriculas.add(novaMatricula);

				//adicionar a matricula na lista de todas as matriculas
				todasMatriculas.add(novaMatricula);
				System.out.println("Matricula realizada com sucesso!");
			}
		} 		
	}


}
