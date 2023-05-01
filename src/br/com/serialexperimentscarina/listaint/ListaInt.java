package br.com.serialexperimentscarina.listaint;

public class ListaInt implements ILista{
	
	No primeiro;
	
	public ListaInt() {
		primeiro = null;
	}

	@Override
	public boolean isEmpty() {
		return (primeiro == null);
	}

	@Override
	public int size() {
		int cont = 0;
		No auxiliar = primeiro;
		
		while (auxiliar != null) {
			auxiliar = auxiliar.proximo;
			cont++;;
		}
		return cont;
	}

	@Override
	public void addFirst(int dado) {
		No elemento = new No();
		elemento.dado = dado;
		elemento.proximo = primeiro;
		primeiro = elemento;
	}

	@Override
	public void addLast(int dado) throws Exception {
		No elemento = new No();
		elemento.dado = dado;
		elemento.proximo = null;
		if (isEmpty()) {
			primeiro = elemento;
		} else {
			No ultimo = getNo(size() - 1);
			ultimo.proximo = elemento;
		}
	}

	@Override
	public void add(int dado, int pos) throws Exception {
		if (isEmpty() && pos != 0) {
			throw new Exception("Lista vazia!");
		}
		if (pos < 0 || pos > size()) {
			throw new Exception("Posição inválida!");
		}
		if (pos == 0) {
			addFirst(dado);
		} else if (pos == size()) {
			addLast(dado);
		} else {
			No elemento = new No();
			No anterior = getNo(pos - 1);
			
			elemento.dado = dado;
			elemento.proximo = anterior.proximo;
			anterior.proximo = elemento;
		}
	}

	@Override
	public void removeFirst() throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista vazia!");
		}
		primeiro = primeiro.proximo;
	}

	@Override
	public void removeLast() throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista vazia!");
		}
		if (size() == 1) {
			removeFirst();
		} else {
			No anterior = getNo(size() - 2);
			anterior.proximo = null;
		}
	}

	@Override
	public void remove(int pos) throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista vazia!");
		}
		if (pos < 0 || pos >= size()) {
			throw new Exception("Posição inválida!");
		}
		if (pos == 0) {
			removeFirst();
		} else if (pos == size() - 1) {
			removeLast();
		} else {
			No atual = getNo(pos);
			No anterior = getNo(pos - 1);
			
			anterior.proximo = atual.proximo;
		}
	}

	@Override
	public int get(int pos) throws Exception {
		return getNo(pos).dado;
	}
	
	private No getNo(int pos) throws Exception{
		if (isEmpty()) {
			throw new Exception("Lista vazia!");
		}
		if (pos < 0 || pos >= size()) {
			throw new Exception("Posição inválida!");
		}
		No auxiliar = primeiro;
		int cont = 0;
		
		while (cont < pos) {
			auxiliar = auxiliar.proximo;
			cont++;;
		}
		return auxiliar;
	}

}
