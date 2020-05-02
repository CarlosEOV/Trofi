package controlador;

import java.util.ArrayList;
import java.util.List;

import modelo.Alimento;

public class Carrito {
	
	private List<Alimento> alimentos; 
	private double total;
	
	public Carrito() {
		this.alimentos = new ArrayList<Alimento>();
		this.total = 0.0;
	}
	
	public void agregarAlimento(Alimento alimento) {
		alimentos.add(alimento);
		this.total += alimento.getCosto();
	}
	
	public void quitarAlimento(Alimento alimento) {
		for(Alimento actual: alimentos) {
			if(actual.getIdAlimento() == alimento.getIdAlimento()) {
				alimentos.remove(actual);
				this.total -= actual.getCosto();
				break;
			}
		}
	}
	
	public double calculaTotal() {
		double total = 0.0;
		for(Alimento actual: alimentos) {
			total += actual.getCosto();
		}
		return total;
	}
	
	public void mostrarCarrito() {
		for(Alimento actual: alimentos) {
			System.out.println(actual.getNombre());
		}
	}
	
	public List<Alimento> getAlimentos(){
		return this.alimentos;
	}
	
	public double getTotal() {
		return this.total;
	}
	
	public void resetCarrito() {
		this.alimentos = new ArrayList<Alimento>();
		this.total = 0.0;
	}
	
	public boolean estaVacio() {
		return this.alimentos.isEmpty();
	}
}
