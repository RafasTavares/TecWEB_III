import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import jdk.internal.jfr.events.FileWriteEvent;


public class ArquivoDeNumeros {

	public void GravarArquivos() throws IOException{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		 PrintWriter arq = new PrintWriter(new BufferedWriter(new  FileWriter("numeros.txt")));
		String texto = in.readLine();
		for (int i = 0; i < 10; i++) {
			double  n = Double.parseDouble(texto);
			arq.println(n);
			texto = in.readLine();
		}
		arq.close();
	}
	
	public void LerArquivo() throws IOException{		
	BufferedReader arq = new BufferedReader(new FileReader("numeros.txt"));
	
	 String linha = arq.readLine();
	 while (linha != null){
		 Double numero = Double.parseDouble(linha);
		 System.out.print(numero + ", ");
		 linha = arq.readLine();
	 }
	
	}
	public static void main(String[] args) throws IOException{
		ArquivoDeNumeros arquivos = new ArquivoDeNumeros();
		arquivos.GravarArquivos();
		arquivos.LerArquivo();
	}
	
}
