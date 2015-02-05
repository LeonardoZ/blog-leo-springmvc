package com.leonardoz.blog.dao;

public class Paginacao {
	
	public int paginar(int razao,int valorInicial,int elementoDesejado){
		int acumulador = valorInicial;
		for (int i = 1; i < elementoDesejado; i++) {
			acumulador += razao;
		}
		return acumulador;
	}
	
}
