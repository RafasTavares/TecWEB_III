public class ProgressoTexto implements ProgressoListener {

	@Override
	public void AtualizarProgresso(long atual, long tamanho) {

		System.out.println((atual * 100)/ 100);
	}

}
