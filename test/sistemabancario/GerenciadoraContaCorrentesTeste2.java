package sistemabancario;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GerenciadoraContaCorrentesTeste2 {
	private GerenciadoraContas gerContas;
    
	@Test
    public void testeTransfereValor1(){
	  	//**********Montar o cenario**********
	  	int idConta01 = 1;
	  	int idConta02 = 2;
	  	 
	  	 
	  	ContaCorrente conta01 = new ContaCorrente(idConta01, 200, true);
	  	ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);
	  	
	  	List<ContaCorrente> contaDoBanco = new ArrayList<>();
	  	contaDoBanco.add(conta01);
		contaDoBanco.add(conta02);
		gerContas = new GerenciadoraContas(contaDoBanco);
	  	
	  	//*********Execução do negocio selecionado para o Teste********
	  	boolean sucesso = gerContas.transfereValor(idConta01, 100, idConta02);
	  	
	  	//*******Verificação e Analise*******
	  	assertTrue(sucesso);
	  	assertThat(conta01.getSaldo(), is(100.0));  
	  	assertThat(conta02.getSaldo(), is(100.0));
	
    }
	
	@Test
    public void testeTransfereValor2(){
		//Teste quando o saldo é insuficiente, entrando no cheque especial
	  	//**********Montar o cenario**********
	  	int idConta01 = 1;
	  	int idConta02 = 2;
	  	 
	  	 
	  	ContaCorrente conta01 = new ContaCorrente(idConta01, 100, true);
	  	ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);
	  	
	  	List<ContaCorrente> contaDoBanco = new ArrayList<>();
	  	contaDoBanco.add(conta01);
		contaDoBanco.add(conta02);
		gerContas = new GerenciadoraContas(contaDoBanco);
	  	
	  	//*********Execução do negocio selecionado para o Teste********
	  	boolean sucesso = gerContas.transfereValor(idConta01, 200, idConta02);
	  	
	  	//*******Verificação e Analise*******
	  	assertTrue(sucesso);
	  	assertThat(conta01.getSaldo(), is(-100.0));  
	  	assertThat(conta02.getSaldo(), is(200.0));
	
    }
	
	@Test
    public void testeTransfereValor3(){
	  	//**********Montar o cenario**********
	  	int idConta01 = 1;
	  	int idConta02 = 2;
	  	 
	  	 
	  	ContaCorrente conta01 = new ContaCorrente(idConta01, -100, true);
	  	ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);
	  	
	  	List<ContaCorrente> contaDoBanco = new ArrayList<>();
	  	contaDoBanco.add(conta01);
		contaDoBanco.add(conta02);
		gerContas = new GerenciadoraContas(contaDoBanco);
	  	
	  	//*********Execução do negocio selecionado para o Teste********
	  	boolean sucesso = gerContas.transfereValor(idConta01, 200, idConta02);
	  	
	  	//*******Verificação e Analise*******
	  	assertTrue(sucesso);
	  	assertThat(conta01.getSaldo(), is(-300.0));  
	  	assertThat(conta02.getSaldo(), is(200.0));
	
    }
	
	@Test
    public void testeTransfereValor4(){
	  	//**********Montar o cenario**********
	  	int idConta01 = 1;
	  	int idConta02 = 2;
	  	 
	  	 
	  	ContaCorrente conta01 = new ContaCorrente(idConta01, -100, true);
	  	ContaCorrente conta02 = new ContaCorrente(idConta02, -100, true);
	  	
	  	List<ContaCorrente> contaDoBanco = new ArrayList<>();
	  	contaDoBanco.add(conta01);
		contaDoBanco.add(conta02);
		gerContas = new GerenciadoraContas(contaDoBanco);
	  	
	  	//*********Execução do negocio selecionado para o Teste********
	  	boolean sucesso = gerContas.transfereValor(idConta01, 200, idConta02);
	  	
	  	//*******Verificação e Analise*******
	  	assertTrue(sucesso);
	  	assertThat(conta01.getSaldo(), is(-300.0));  
	  	assertThat(conta02.getSaldo(), is(100.0));
	
    }
}