package dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa {
	
	public long numeroInscricao;

	// As matriculas do aluno em diferentes turmas
	// e anos lectivos
	public List<Matricula> matriculas;
	
	//metodo construtor
	public Aluno(String pNome, String pGenero, String pMorada, 
			String pBi, String pTelefone, String pEmail,
			LocalDate pDataNasc, long pNumeroInscricao) {
		
		super(pNome, pGenero, pMorada, pBi, pTelefone, 
				pEmail, pDataNasc);
		
		this.numeroInscricao = pNumeroInscricao;
		this.matriculas = new ArrayList<Matricula>();
	}
	
	
	
}
