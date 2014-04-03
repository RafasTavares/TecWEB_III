import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Copia {

	private ProgressoListener progresso;
	private String origem;
	private String destino;

	public Copia(String origem, String destino) {
		this.origem = origem;
		this.destino = destino;
	}

	public void Copiar() throws IOException {

		InputStream in = new FileInputStream(this.origem);
		OutputStream out = new FileOutputStream(this.destino);
		File t = new File(this.origem);
		long total = t.length();
		byte[] buffer = new byte[1024];
		// nem sempre o vetor vai ter o tamanho 1024 total
		int len = in.read(buffer);
		// o reade pega o tamanho do arquivo no array de buffer
		while (len > 0) {
			out.write(buffer, 0, len);
			// na escrita é necessário passar o buffer que é o vetor todo como
			// nem sempre vai ter 1024 o lengh e o tamanho ocupado do vetor
			len = in.read(buffer);
			// atribui o tamanho do buffer novamente pra testea
			progresso.AtualizarProgresso(len, total);
		}
		in.close();
		out.close();
	}

	public ProgressoListener getProgresso() {
		return progresso;
	}

	public void setProgresso(ProgressoListener progresso) {
		this.progresso = progresso;
	}
}
