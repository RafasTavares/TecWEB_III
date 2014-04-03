/*
 * A classe é responsavel por calcular os valores de Fatorial, Arranjo e Combinação
 */
public class Operacoes {

	/*
	 * Valor para o calculo
	 */
	private static int p = 0;
	private static int n = 0;

	/*
	 * Contrutor da Classe
	 */
	public Operacoes(int n, int p) {
		this.p = p;
		this.n = n;
	}

	/*
	 * Sobrecarga para fatorial
	 */
	public Operacoes(int p) {
		this.p = p;

	}

	/*
	 * Método GET do valor p
	 */
	public int getP() {
		return p;
	}

	/*
	 * Método SET de valor p
	 */
	public void setP(int p) {
		this.p = p;
	}

	/*
	 * Método GET do valor n
	 */
	public int getN() {
		return this.n;
	}

	/*
	 * Método SET de valor n
	 */
	public void setN(int n) {
		this.n = n;
	}

	/*
	 * O Método calcula o fatoria de um valor passado comparametro
	 */
	public static long Fatorial(int numero) throws OperacoesException {

		try {
			if (numero == 1)
				return 1;
			return numero * Fatorial(numero - 1);
		} catch (Exception ex) {
			ex.getMessage();
		}
		return 1;
	}

	public static long ArranjoSimples() throws OperacoesException {
		long result = (Fatorial(n)) / (Fatorial(n - p));
		return result;
	}

	public static long CombinacaoSimples() throws OperacoesException {
		long result = (Fatorial(n)) / (Fatorial(p) * (Fatorial(n - p)));
		return result;
	}

	@Override
	public String toString() {
		String resultado;
		this.getP();
		return "O Fatorial de " + p + " é ";
	}
}
