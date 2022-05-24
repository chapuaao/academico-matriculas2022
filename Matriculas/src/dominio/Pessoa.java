package dominio;

import java.time.LocalDate;

public class Pessoa {
	//declaramos os atributos
	public String nome, genero,
			morada, bi, telefone, email;
	
	//declaramos o attributo data de nascimento
	public LocalDate dataNasc;
	
	public long id; 	//declaramos o atributo id
	
	//declaramos o METODO CONSTRUTOR
	// serve para inicializar (instanciar) os
	// objectos da classe
	public Pessoa (String pNome, String pGenero, 
			String pMorada, String pBi, 
			String pTelefone, String pEmail,
			LocalDate pDataNasc) {
		
		this.nome = pNome;
		this.genero = pGenero;
		this.morada = pMorada;
		this.bi = pBi;
		this.telefone = pTelefone;
		this.email = pEmail;
		this.dataNasc = pDataNasc;
		//this.id = 
	}
	
	//metodo que calcula a idade
	public int idade() {
		if(this.dataNasc == null)
			return -1;
		int anoActual = LocalDate.now().getYear();
		int anoNasc = this.dataNasc.getYear();
		return anoActual - anoNasc;
	}
	
	
	

}
