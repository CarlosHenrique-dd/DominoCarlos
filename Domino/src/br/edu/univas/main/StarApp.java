package br.edu.univas.main;

import java.util.Scanner;

import br.edu.univas.vo.Imprime;
import br.edu.univas.vo.List;
import br.edu.univas.vo.Pecas;

public class StarApp {
	
	static Scanner sc = new Scanner(System.in);
	static Imprime imp = new Imprime();
	
	public static void main(String[] args) {
		
		List pecas = new List();
		List pecasPlayer = new List();
		List pecasBot = new List();
		List pecasNaMesa = new List();
		boolean GameOver = false;
		
		pecas.criaPecas();
		pecas.setPecas(pecasPlayer, pecas);
		pecas.setPecas(pecasBot, pecas);
		imp.começo(pecasPlayer);
		
		do 
		{
			GameOver = jogaBot(pecasBot, pecasNaMesa, pecas);
			if(GameOver == false)
			{
				GameOver = jogaPlayer(pecasPlayer, pecasNaMesa, pecas);
				{
					if(GameOver == true) 
					{
						imp.vitoria();
					}
				}
			}
				else
				{
					imp.vitoria();
				}
		}while(GameOver == false);
		
		System.out.println("Fim de Jogo.");
		
	
	
}


	
	private static boolean jogaBot(List list, List pecasNaMesa, List pecas)
	{
		String valida = "Sem Peças";
		boolean fimDeJogo = false;
		boolean aux = false;
		Pecas peca;
		int numero = 0; 
		
		while(true) {
			int isValid = list.tamanhoLista(list);
			if(numero <= isValid) 
			{
				peca = list.getElementAt(numero);
				aux = pecasNaMesa.posiciona(pecasNaMesa, peca);
				if(aux == true)
				{
					peca = list.remove(peca.toString());
					System.out.println("Sua vez.\n");
					break;
				}
				else
				{
					numero++;
				}
			}
			else 
			{
				System.out.println("Bot Passou.\n");
				pecaRandom(list, pecas);
				break;
			}
		}
		imp.pecasjogas(pecasNaMesa);
		if(valida.equals(list.getAsString())) 
		{
			fimDeJogo = true;
		}
		return fimDeJogo;
	}
	
	public static boolean jogaPlayer (List list, List pecaNaMes, List pecas) 
	{
		String Vez = "sem peças.";
		boolean fimDeJogo = false;
		Pecas peca;
		int n;
		
		imp.vezPlayer();
		while(true) 
		{
			System.out.println("Suas peças:\n"+list.getAsString());
			n = leInt();
			
			if(n == 00)
			{
				imp.comprar(pecas);
				n = leInt();
				if(n == 9)
				{
					compraPeca(list, pecas);
					System.out.println("Vez Passada.");
					break;
				}
				else if(n == 99	) 
				{
					compraPeca(list,pecas);
					continue;
				}
				else 
				{
					System.out.println("Comando invalido.");
				}
			}
			n--;
			int isValid = list.tamanhoLista(list);
			if(n <= isValid && n >= 0)
			{
				peca = list.getElementAt(n);
				boolean aux = pecaNaMes.posiciona(pecaNaMes, peca);
				if(aux == true)
				{
					peca = list.remove(peca.toString());
					
						if(Vez.equals(list.getAsString())) 
						{
							fimDeJogo = true;
						}
						break;
					}
					else
					{
						System.out.println("escolha outra peça.");
						continue;
					}
				}
				System.out.println("numero invalido.");
				
			}
		imp.pecasjogas(pecaNaMes);
		return fimDeJogo;
	}
	
	public static int leInt()
	{
		int Number = sc.nextInt();
		sc.nextLine();
		return Number;
	}

			public static void pecaRandom(List list, List pecas)
			{
				int n = pecas.tamanhoLista(pecas);
				Pecas peca;
				
				n = 1 + (int)(Math.random()*n);
				peca =	pecas.getElementAt(n);
				peca = pecas.remove(peca.toString());
				list.insert(peca);
			}
			
			
			public static void compraPeca(List list, List pecas)
			{
				Pecas peca;
				System.out.println("Escolha uma peça");
				int n = leInt();
				n--;
				peca = pecas.getElementAt(n);
				peca = pecas.remove(peca.toString());
				list.insert(peca);
			}
	}
	
	
	
	
	
	

