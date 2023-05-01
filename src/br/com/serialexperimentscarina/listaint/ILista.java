package br.com.serialexperimentscarina.listaint;

public interface ILista {
	
	public boolean isEmpty();
	public int size();
	public void addFirst(int dado);
	public void addLast(int dado) throws Exception;
	public void add(int dado, int pos) throws Exception;
	public void removeFirst() throws Exception;
	public void removeLast() throws Exception;
	public void remove(int pos) throws Exception;
	public int get(int pos) throws Exception;

}
