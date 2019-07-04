package dominio;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dados.DTO.SolicitacaoMuseuDTO;
import dados.MdD.SolicitacaoMuseuFinder;

import java.util.ArrayList;
import java.util.InputMismatchException;

import dominio.exception.*;


public class MuseuMD
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
	
	
}
