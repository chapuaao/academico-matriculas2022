package dominio;

import java.time.LocalDateTime;

public class Matricula {
	
	public boolean certificado, pagou;
	public float mediaCertificado;
	public String estado;
	public LocalDateTime data;
	
	//atributo do tipo Turma
	public Turma turma;
	public Aluno aluno;
	
	public Matricula(boolean certificado, boolean pagou, 
			float mediaCertificado, String estado, 
			LocalDateTime data, Turma turma, Aluno aluno) {
		
		this.certificado = certificado;
		this.pagou = pagou;
		this.mediaCertificado = mediaCertificado;
		this.estado = estado;
		this.data = data;
		this.turma = turma;
		this.aluno = aluno;
	}
	
	
}
