package br.edu.univas.vo;

public class List {
	
	private Node head;
	private Node last;
	
	public void insert(Pecas peca) 
	{
		Node newNo = new Node();
		
		if(head == null)
		{
			head = newNo;
		}
		else
		{
			last.next = newNo;
			newNo.previous = last;
		}
		last = newNo;
		newNo.peca = peca;
	}
	
	public String getAsString() 
	{
		if(head == null) {
			return "Sem Peças.";
		}
		StringBuilder construtor = new StringBuilder();
		
		Node aux = head;
		while(aux != null)
		{
			construtor.append("(").append(aux.peca.getN1());
			construtor.append("|");
			construtor.append(aux.peca.getN2()).append(")");
			construtor.append(" ");
			aux = aux.next;
		}
		return construtor.toString();
	}
	
	private Node getNodeAt(int index) 
	{
		if(index < 0) 
		{
			return null;
		}
		int i = 0;
		Node aux = head;
		while(aux != null)
		{
			if(index == i) 
			{
				return aux;
			}
			i++;
			aux = aux.next;
		}
		return null;
	}
	
	public Pecas getElementAt(int index) 
	{
		Node no = getNodeAt(index);
			if(no != null)
			{
				return no.peca;
			}
			return null;
		}
	
	public Pecas remove (String nome) 
	{
		if(head == null) 
		{
			return null;
		}
		Node current = head;
		Node previous = head.previous;
		Node next = head.next;
		
		while(current != null)
		{
			if(current.peca.toString().equals(nome)) 
			{
				break;
			}
			previous = current;
			current = current.next;
			next = next.next;
		}
		if(current == null) 
		{
			return null;
		}
		Pecas removePeca = current.peca;
		if(this.head == this.last) 
		{
			this.head = null;
			this.last = null;
			return removePeca;
		}
		if(previous == null)
		{
			head = next;
			next.previous = null;
		}
		else 
		{
			if(current.next != null)
			{
				previous.next = next;
				next.previous = previous;
			}
			else
			{
				this.last = previous;
				previous.next = null;
			}
		}
		return removePeca;
	}
	
	public boolean posiciona(List list, Pecas peca) 
	{
		boolean aux0 = false;
		if(peca != null)
		{
			if(list.head == null)
			{
				list.insert(peca);
				aux0 = true;
			}
			else if(head.peca.getN1() == peca.getN1() || head.peca.getN1() == peca.getN2())
			{
				aux0 = true;
				if(head.peca.getN1() == peca.getN1())
				{
					int aux1 = peca.getN1();
					int aux2 = peca.getN2();
					peca.setN2(aux1);
					peca.setN1(aux2);
				}
				Node newNo = new Node();
				head.previous = newNo;
				newNo.peca = peca;
				newNo.next = head;
				head = newNo;
			}
			else if(last.peca.getN2() == peca.getN1() || last.peca.getN2() == peca.getN2())
			{
				aux0 = true;
				if(last.peca.getN2() == peca.getN2())
				{
					int aux1 = peca.getN1();
					int aux2 = peca.getN2();
					peca.setN2(aux1);
					peca.setN1(aux2);
				}
				Node newNo = new Node();
				last.next = newNo;
				newNo.peca = peca;
				newNo.previous = last;
				last = newNo;
			}
		}
		return aux0;
	}
	
	public void criaPecas() 
	{
		int cont = 0;
		for(int i = 0; i < 7; i++)
		{
			for(int x = 0; x+cont < 7; x++)
			{
				Pecas nPeca = new Pecas();
				nPeca.setN1(i);
				nPeca.setN2(x+cont);
				insert(nPeca);
			}
			cont++;
		}
	}
	
	public void setPecas(List list, List nList) 
	{
		Pecas peca;
		int aux = tamanhoLista(nList);
		for(int i = 0; i< 7; i++)
		{
			int random = 1 + (int)(Math.random()*aux);
			peca = getElementAt(random);
			peca = remove(peca.toString());
			list.insert(peca);
			aux-- ;
		}
	}
	
	public int	tamanhoLista(List list)
	{
		Node aux1 = list.head;
		Node aux2 = list.last;
		
		int aux = 0;
		if(aux1 == null) 
		{
			return aux = 100;
		}
		while(!aux1.peca.toString().equals(aux2.peca.toString()))
		{
			aux1 = aux1.next;
			aux++;
			if(aux1 == null) 
			{
				break;
			}
		}
		return aux;
	}
}