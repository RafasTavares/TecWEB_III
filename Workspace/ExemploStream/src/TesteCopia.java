import java.io.IOException;


public class TesteCopia {

	public static void main(String[] args) throws IOException {
		Copia copia = new Copia("arq1.txt" , "arq2.txt");
		copia.setProgresso(new ProgressoTexto());
		copia.Copiar();
	}

}
