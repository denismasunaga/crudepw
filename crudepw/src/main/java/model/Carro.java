package model;

public class Carro {
	private String modelo, cor, fabricante;
	private int codigo, ano;
	
	public Carro(int codigo, String modelo, String cor, String fabricante, int ano) {
		this.codigo = codigo;
		this.modelo = modelo;
		this.cor = cor;
		this.fabricante = fabricante;
		this.ano = ano;
	}
	
	public Carro() {
		
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
}
