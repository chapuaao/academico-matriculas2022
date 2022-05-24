package dominio;

import java.util.ArrayList;
import java.util.List;

public class Turma {
	
	public int anoLectivo, anoAcademico;
	public String curso, periodo;
	
	//atributo lista de matriculas de diferentes alunos
	public List<Matricula> matriculas;
	
	public Turma(int anoLectivo, int anoAcademico, 
			String curso, String periodo) {

		this.anoLectivo = anoLectivo;
		this.anoAcademico = anoAcademico;
		this.curso = curso;
		this.periodo = periodo;
		this.matriculas = new ArrayList<Matricula>();
	}
	
	
	///
	
	
}
