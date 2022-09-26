package sistemabancario;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GerenciadoraContaCorrentesTeste {
    @Test
	public void testePesquisaContaCorrente() {
		/*criando ContaCorrentes para instaciar no caso de Teste*/
		
		ContaCorrente ContaCorrente01 = new ContaCorrente(1, 5000, true);
		ContaCorrente ContaCorrente02 = new ContaCorrente(2, 1000, false);
		
		List <ContaCorrente> ContaCorrentes = new ArrayList();
		ContaCorrentes.add(ContaCorrente01);
		ContaCorrentes.add(ContaCorrente02);
		
		GerenciadoraContas gerContaCorrentes = new GerenciadoraContas(ContaCorrentes);
	
		ContaCorrente contaCorrente = gerContaCorrentes.pesquisaConta(1);
		ContaCorrente contaCorrente2 = gerContaCorrentes.pesquisaConta(4);

		assertThat(contaCorrente, instanceOf(ContaCorrente.class));
		assertNull(contaCorrente2);
	}
	
	@Test
	public void testeAdicionarContaCorrente() {
		ContaCorrente contaCorrente01 = new ContaCorrente(1, 5000, true);
		List <ContaCorrente> contaCorrentes = new ArrayList();
		GerenciadoraContas gerContaCorrentes = new GerenciadoraContas(contaCorrentes);
		gerContaCorrentes.adicionaConta(contaCorrente01);
		
		assertThat(contaCorrente01.getId(), is(1));
		assertThat(contaCorrente01.getSaldo(), is(5000.0));
		
	}

	@Test
	public void testeRemoveContaCorrente(){
		ContaCorrente contaCorrente01 = new ContaCorrente(1, 5000, true);
		List <ContaCorrente> contaCorrentes = new ArrayList();
		GerenciadoraContas gerContaCorrentes = new GerenciadoraContas(contaCorrentes);
		gerContaCorrentes.adicionaConta(contaCorrente01);
		assertThat(gerContaCorrentes.removeConta(contaCorrente01.getId()), is(true));
	}

	@Test
	public void testeContaCorrenteAtivo(){
		ContaCorrente contaCorrente01 = new ContaCorrente(1, 5000, true);
		List <ContaCorrente> contaCorrentes = new ArrayList();
		GerenciadoraContas gerContaCorrentes = new GerenciadoraContas(contaCorrentes);
		gerContaCorrentes.adicionaConta(contaCorrente01);

		boolean ativo = gerContaCorrentes.contaAtiva(contaCorrente01.getId());
		assertThat(ativo, is(true));
	}

	@Test
	public void testeTransfereValor(){
		ContaCorrente contaCorrente01 = new ContaCorrente(1, 5000, true);
		ContaCorrente contaCorrente02 = new ContaCorrente(2, 5000, true);
		List <ContaCorrente> contasCorrentes = new ArrayList();
		contasCorrentes.add(contaCorrente01);
		contasCorrentes.add(contaCorrente02);
		GerenciadoraContas gerContaCorrentes = new GerenciadoraContas(contasCorrentes);
		boolean transferenciaEfetuada = gerContaCorrentes.transfereValor(1, 100, 2);

		assertThat(transferenciaEfetuada, is(true));
		assertThat(contaCorrente01.getSaldo(), is(4900.0));
		assertThat(contaCorrente02.getSaldo(), is(5100.0));
	}
}
