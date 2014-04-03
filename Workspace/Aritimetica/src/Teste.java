import static org.junit.Assert.*;

import org.junit.Test;

public class Teste {

	@Test
	public void TesteFatorial() throws OperacoesException {
		Operacoes op = new Operacoes(4);

		System.out.println(op.Fatorial(4));
		assertEquals(24, op.Fatorial(4), 0);
	}

	@Test
	public void TesteArranjoSimples() throws OperacoesException {
		Operacoes op = new Operacoes(7, 4);

		//System.out.println(op.ArranjoSimples());
		assertEquals(840, op.ArranjoSimples(), 0);
	}

	@Test
	public void TesteCombinacaoSimples() throws OperacoesException {
		Operacoes op = new Operacoes(7, 4);

		System.out.println(op.CombinacaoSimples());
		assertEquals(35, op.CombinacaoSimples(), 0);
	}

}
