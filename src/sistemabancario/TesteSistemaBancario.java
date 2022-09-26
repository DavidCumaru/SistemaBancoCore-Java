package sistemabancario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TesteSistemaBancario {

	static GerenciadoraClientes gerClientes;
	static GerenciadoraContas gerContas;

	public static void main(String[] args) {
		inicializaSistemaBancario();//Inicializar dados de contas e clientes

		Scanner sc = new Scanner(System.in);
		boolean continua = true;

		while(continua) {
			printMenu();

			int opcao = sc.nextInt();

			switch (opcao) {
			case 1:
				System.out.println("Digite o ID do cliente: ");
				int idCliente = sc.nextInt();
				Cliente cliente = gerClientes.pesquisaCliente(idCliente);

				if(cliente != null) {
					System.out.println(cliente.toString());
				}else {
					System.out.println("Cliente não encontrado!");
				}
				break;

			case 2:
				System.out.println("Digite o ID da Conta: ");
				int idContas = sc.nextInt();
				ContaCorrente conta = gerContas.pesquisaConta(idContas);

				if(conta != null) {
					System.out.println(conta.toString());
				}else {
					System.out.println("Conta não encontrado!");
				}
				break;

			case 3:
				System.out.println("Digite o ID do cliente: ");
				int idCliente2 = sc.nextInt();
				Cliente cliente2 = gerClientes.pesquisaCliente(idCliente2);

				if(cliente2 != null) {
					cliente2.setAtivo(true);
					System.out.println("Cliente ativado com sucesso!");
				}else {
					System.out.println("Cliente não encontraro!");
				}
				break;

			case 4:
				System.out.println("Digite o ID do cliente: ");
				int idCliente3 = sc.nextInt();
				Cliente cliente3 = gerClientes.pesquisaCliente(idCliente3);

				if(cliente3 != null) {
					cliente3.setAtivo(false);
					System.out.println("Cliente desativado com sucesso!");
				}else {
					System.out.println("Cliente não encontraro!");
				}	
				break;

			case 5:
				continua = false;
				System.out.println("*************** Bye Bye **************");
				break;

			default:
				System.out.println();
				break;
				
			}
			
		}sc.close();

	}

	private static void printMenu() {
		System.out.println("Qual operaçào você deseja executar?\n ");
		System.out.println("1) Consultar por um cliente ");
		System.out.println("2) Consultar por uma conta corrente ");
		System.out.println("3) Ativar um cliente ");
		System.out.println("4) Desativar um cliente ");
		System.out.println("5) Sair");
		System.out.println();

	}

	private static void inicializaSistemaBancario() {
		// Criar lista vazia de contas e clientes:
		List<ContaCorrente> contasDoBanco = new ArrayList<>();
		List<Cliente> clientesDoBanco = new ArrayList<>();

		// Criar e inserir duas contas no banco
		ContaCorrente conta01 = new ContaCorrente(1, 0, true);
		ContaCorrente conta02 = new ContaCorrente(2, 0, true);
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);

		// Criar e inserir dois clientes no banco

		Cliente cliente01 = new Cliente(1, "David", 23, "david@gmail.com", conta01.getId(), true);
		Cliente cliente02 = new Cliente(1, "Gabriel", 22, "gabriel@gmail.com", conta02.getId(), true);
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);

		gerClientes = new GerenciadoraClientes(clientesDoBanco);
		gerContas = new GerenciadoraContas(contasDoBanco);

	}

}
