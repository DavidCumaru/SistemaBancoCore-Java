package sistemabancario;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GerenciadoraClienteTeste3 {
	
	private GerenciadoraClientes gerClientes;
	private int idCliente01 = 1;
	private int idCliente02 = 2;
	
	@Before
	public void setUp() {
		//******Montagem do cenario global******
		Cliente cliente01 = new Cliente(idCliente01, "Clayton", 47, "clayton@gmail.com", 1 ,true);
		Cliente cliente02 = new Cliente(idCliente02, "Maria", 10, "maria@gmail.com", 1 ,true);
		
		List <Cliente> clientes = new ArrayList();
		clientes.add(cliente01);
		clientes.add(cliente02);
		
		gerClientes = new GerenciadoraClientes(clientes);
				
	}
	
	
//	@Test
//	public void testePesquisaCliente() {
//		/************Montagem do cenario***************/	
//		int idCliente01 = 1;
//	 	int idCliente02 = 2;
//		//Definição e inicialização
//		/*criando clientes para instaciar no caso de Teste*/
//		
//		Cliente cliente01 = new Cliente(idCliente01, "Clayton", 47, "clayton@gmail.com", 1 ,true);
//		Cliente cliente02 = new Cliente(idCliente02, "Maria", 10, "maria@gmail.com", 1 ,true);
//		
//		List <Cliente> clientes = new ArrayList();
//		clientes.add(cliente01);
//		clientes.add(cliente02);
//		
//		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientes);
//	
//		Cliente cliente = gerClientes.pesquisaCliente(1);
//		
//		assertThat(cliente.getId(), is(1));
//		assertThat(cliente.getEmail(), is("clayton@gmail.com"));
//		
//		Cliente cliente2 = gerClientes.pesquisaCliente(2);
//		assertThat(cliente2.getId(), is(2));
//		assertThat(cliente2.getEmail(), is("maria@gmail.com"));	
//	}
	
	@Test
	public void testePesquisaClienteInexistente() {
		//*******Execucao*******
		Cliente cliente = gerClientes.pesquisaCliente(10);
		//*******Verificacao*****
		assertNull(cliente);
	}
	
	@Test
	public void testeAdicionarCliente() {
		Cliente cliente01 = new Cliente(1, "Clayton", 47, "clayton@gmail.com", 1 ,true);
		List <Cliente> clientes = new ArrayList();
		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientes);
		gerClientes.adicionaCliente(cliente01);
		boolean clienteAtivo = gerClientes.clienteAtivo(cliente01.getId());
		assertThat(clienteAtivo, is(true));
		
	}
	
	//Remover do Clayton
	@Test
	public void testeRemoveCliente(){
		/* 
	 	//************Montagem do cenario***************	
	 	int idCliente01 = 1;
	 	int idCliente02 = 2;
	 	***montagem do cenário do teste***
		Cliente cliente01 = new Cliente(idCliente01, "Clayton", 47, "clayton@gmail.com", 1 ,true);
	 	Cliente cliente02 = new Cliente(idCliente02, "Maria", 10, "maria@gmail.com", 1 ,true);
	  
	 	List <Cliente> clientes = new ArrayList();
	  
	 	clientes.add(cliente01);
	 	clientes.add(cliente01);
	  
	 	GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientes);
	 */
	  	//***Fase de execução do teste***
	  	boolean clienteRemovido = gerClientes.removeCliente(idCliente02);
	  
	  	//***Análise do resultado***
	  	//assertFalse para testar o remover inexistente
	  	assertThat(clienteRemovido, is(true));
	  	assertThat(gerClientes.getClientesDoBanco().size(), is(1));
	  	assertNull(gerClientes.pesquisaCliente(idCliente02));
	  	
	}  
	
	@Test
	public void testeRemoveClienteInexistente(){
	  	//***Fase de execução do teste***
	  	boolean clienteRemovido = gerClientes.removeCliente(10);
	  
	  	//***Análise do resultado***
	  	//assertFalse para testar o remover inexistente
	  	assertThat(clienteRemovido, is(false));
	  	assertFalse(clienteRemovido);
	  	assertThat(gerClientes.getClientesDoBanco().size(), is(2));	  	
	}  


//	@Test
//	public void testeRemoveCliente(){
//		Cliente cliente01 = new Cliente(1, "Clayton", 47, "clayton@gmail.com", 1 ,true);
//		Cliente cliente02 = new Cliente(2, "Maria", 10, "maria@gmail.com", 1 ,true);
//		List <Cliente> clientes = new ArrayList();
//		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientes);
//		gerClientes.adicionaCliente(cliente01);
//		assertThat(gerClientes.removeCliente(cliente01.getId()), is(true));	
//	}

	@Test
	public void testeClienteAtivo(){
		Cliente cliente01 = new Cliente(1, "Clayton", 47, "clayton@gmail.com", 1 ,true);
		List <Cliente> clientes = new ArrayList();
		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientes);
		gerClientes.adicionaCliente(cliente01);
		int cliente01Id = cliente01.getId();
		assertThat(gerClientes.clienteAtivo(cliente01Id), is(true));
	}

	@Test
	public void testeLimpaBanco(){
		Cliente cliente01 = new Cliente(1, "Clayton", 47, "clayton@gmail.com", 1 ,true);
		List <Cliente> clientes = new ArrayList();
		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientes);
		gerClientes.adicionaCliente(cliente01);
		gerClientes.limpa();
		assertThat(gerClientes.getClientesDoBanco(), is(java.util.Collections.emptyList()));
	}
	
	//Validação quando o cliente esta no intervalo de idade permitido
	@Test
	public void testeClienteIdadePermitida1() throws IdadeNaoPermitidaException {
	//cernario customizado para esse teste
		Cliente cliente = new Cliente(3, "Yuri", 26, "yuri@yuri.com", 1, true);
	//Execução
		boolean idadeValida = gerClientes.validaIdade(cliente.getIdade());
	//Verificação
		assertTrue(idadeValida);
	}
	
	//Validação quando o cliente esta no intervalo de idade permitido da borda inferior
	@Test
	public void testeClienteIdadePermitida2() throws IdadeNaoPermitidaException {
	//cernario customizado para esse teste
		Cliente cliente = new Cliente(4, "David", 18, "david@david.com", 1, true);
	//Execução
		boolean idadeValida = gerClientes.validaIdade(cliente.getIdade());
	//Verificação
		assertTrue(idadeValida);
	}
	
	//Validação quando o cliente esta no intervalo de idade permitido da borda superior
	@Test
	public void testeClienteIdadePermitida3() throws IdadeNaoPermitidaException {
	//cernario customizado para esse teste
		Cliente cliente = new Cliente(5, "Carlos", 65, "carlos@carlos.com", 1, true);
	//Execução
		boolean idadeValida = gerClientes.validaIdade(cliente.getIdade());
	//Verificação
		assertTrue(idadeValida);
	}
	
	//Validação quando o cliente esta no intervalo de idade permitido da borda inferior
		@Test
		public void testeClienteIdadePermitida4() throws IdadeNaoPermitidaException {
		//cernario customizado para esse teste
			Cliente cliente = new Cliente(6, "Felipe", 17, "felipe@felipe.com", 1, true);
		//Execução
			try {
				gerClientes.validaIdade(cliente.getIdade());
				fail();
			} catch (Exception e) {
				assertThat(e.getMessage(), is(IdadeNaoPermitidaException.MSG_IDADE_INVALIDA));
			}
		}
		
	//Validação quando o cliente esta no intervalo de idade permitido da borda superior
		@Test
		public void testeClienteIdadePermitida5() throws IdadeNaoPermitidaException {
		//cernario customizado para esse teste
			Cliente cliente = new Cliente(7, "Breno", 66, "breno@breno.com", 1, true);
		//Execução
			try {
				gerClientes.validaIdade(cliente.getIdade());
				fail();
			} catch (Exception e) {
				assertThat(e.getMessage(), is(IdadeNaoPermitidaException.MSG_IDADE_INVALIDA));
			}
		}
	
	@After
	public void tearDown() {
		//********Desmontagem do cenário global*********
		gerClientes.limpa();
	}
}