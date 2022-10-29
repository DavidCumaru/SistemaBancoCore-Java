package sistemabancario;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({GerenciadoraClienteTeste.class, GerenciadoraClienteTeste2.class, GerenciadoraClienteTeste3.class,
	GerenciadoraContaCorrentesTeste.class, GerenciadoraContaCorrentesTeste2.class})
public class AllTests {
	
}
