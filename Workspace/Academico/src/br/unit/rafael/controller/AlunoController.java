package br.unit.rafael.controller;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unit.rafael.academico.Aluno;
import br.unit.rafael.academico.Classe;

@WebServlet("/AlunoController")
public class AlunoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AlunoController() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//request.getRequestDispatcher("Aluno.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
       
		
	}

}
