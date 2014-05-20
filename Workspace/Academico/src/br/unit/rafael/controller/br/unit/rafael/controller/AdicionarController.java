package br.unit.rafael.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xerces.internal.impl.dv.xs.DateDV;

import br.unit.rafael.academico.Aluno;
import br.unit.rafael.academico.Classe;
import br.unit.rafael.academico.EstadoCivil;
import br.unit.rafael.academico.Matricula;
import br.unit.rafael.academico.Nota;
import br.unit.rafael.academico.Sexo;

/**
 * Servlet implementation class AdicionarController
 */
@WebServlet("/AdicionarController")
public class AdicionarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdicionarController() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			String nome = request.getParameter("nome");
			int matricula = Integer.parseInt(request.getParameter("matricula"));
			char sexo = request.getParameter("sexo").charAt(0);
			String estadoCivil = request.getParameter("estadoCivil");
			String dtNascimento = request.getParameter("dtNascimento");
			double nota = Double.parseDouble(request.getParameter("nota"));
			// Nome
			Aluno aluno = new Aluno();
			aluno.setNome(nome);
			// Data
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date date = (Date) formatter.parse(dtNascimento);
			aluno.setDtNascimento(date);
			// Estado Civil
			EstadoCivil estadoC = new EstadoCivil(estadoCivil);
			aluno.setEstadoCivil(estadoC);
			// Sexo
			Sexo sex = new Sexo(sexo);
			aluno.setSexo(sex);
			// Nota
			Nota vlr = new Nota(nota);
			aluno.setNota(vlr);
			// Matricula
			Matricula mat = new Matricula(matricula);
			aluno.setMatricula(mat);

			Classe classAluno = new Classe();
			classAluno.AdicionarAlunos(aluno);
			request.setAttribute("alunos", classAluno.ListarAlunos());
			request.getRequestDispatcher("Aluno.jsp")
					.forward(request, response);

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}
