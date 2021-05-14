package br.edu.univas.vo;

public class Imprime {
	
	public void começo(List list) 
	{
		System.out.println("Suas Peças.");
		System.out.println(list.getAsString());
	}
	
	public void derrota()
	{
		System.out.println("Voce Perdeu.");
	}
	
	public void vitoria()
	{
		System.out.println("Voce Ganhou.");
	}
	
	public void vezPlayer() 
	{
		System.out.println("\n\nSua vez !\nDigite 00 para Comprar.");
	}

	public void pecasjogas(List pecasjogadas) 
	{
		System.out.println("Pecas Jogadas\n\n"+pecasjogadas.getAsString());
	}
	
	public void comprar(List list) 
	{
		System.out.println("\nDigite 9 para comprar e passar a vez, ou 99 para comprar e jogar\n"+list.getAsString());
	}
}
