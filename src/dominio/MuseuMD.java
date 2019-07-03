package dominio;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.InputMismatchException;

import dominio.exception.*;


@WebServlet("/criarMuseu")
public class MuseuMD extends HttpServlet
{
	private String nomeMuseu;
	private String cidade;
	private String estado;
	private UsuarioMD gestor;
	
	public MuseuMD()
	{
		super();
	}
	
	public MuseuMD(String nomeMuseu, String cidade, String estado, UsuarioMD gestor)
	{
		this.nomeMuseu = nomeMuseu;
		this.cidade = cidade;
		this.estado = estado;
		this.gestor = gestor;
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.getSession().invalidate();
		request.getRequestDispatcher("CriarSolicitacao.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String cmd = (String)request.getParameter("cmd");
		
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		
		if(cmd == null) 
		{
			doGet(request,response);
		} 
		else
		{
			
		}
	}

}
