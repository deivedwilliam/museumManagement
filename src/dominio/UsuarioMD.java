package dominio;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.InputMismatchException;

import dominio.exception.*;
import dados.DTO.*;
import dados.ENUM.Tipo_Usuario;
import dados.MdD.SolicitacaoMuseuFinder;
import dados.MdD.SolicitacaoMuseuMdD;
import dados.MdD.UsuarioFinder;
import dados.MdD.UsuarioMdD;
import dados.exception.*;


@WebServlet("/efetuarLogin")
public class UsuarioMD extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private String nome;
	private String cpf;
	private String senha;
	private Tipo_Usuario tipoUsuario;
	public static UsuarioMD userLogado;
	
	//private static FachadaDados camadaDados = FachadaDados.getMock();
	
	
	
	public UsuarioMD()
	{
		super();
	}
	
	public UsuarioMD(String nome, String cpf, String senha, Tipo_Usuario tipoUsuario)
	{
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.tipoUsuario = tipoUsuario;
	}
	
	
	
	public String getNome() {
		return this.nome;
	}

	public String getCpf() {
		return this.cpf;
	}
	
	public String getSenha() {
		return this.senha;
	}
	private void criarSolicitacaoMuseu(String nomeMuseu, String nomeGestor, String cpfGestor, String senhaGestor, String estado, String cidade, String data)
	{
		try
		{
			SolicitacaoMuseuMdD novaSolicitacao = new SolicitacaoMuseuMdD();
			
			novaSolicitacao.set(new SolicitacaoMuseuDTO(nomeMuseu,data, cidade, estado, cpfGestor, senhaGestor));
			novaSolicitacao.insert();
			
		}
		catch(SQLException e)
		{
			throw new RuntimeException("falha ao criar solicitação do museu");
		}
		
	}

	private UsuarioMD buscarUsuario(String cpf) throws UsuarioNaoExiste
	{
		
		try
		{
			UsuarioFinder userFind = new UsuarioFinder();
			
			Usuario u = userFind.search(cpf);
			
			if(u == null)
			{
				throw new UsuarioNaoExiste();
			}
			
			return new UsuarioMD(u.getNome(),u.getCPF(), u.getSenha(), u.getTipo());
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	private boolean inserirUsuario(String nome, String cpf, String senha) throws UsuarioJaExiste
	{
		try
		{
			UsuarioMdD user = new UsuarioMdD();
			UsuarioFinder userFind = new UsuarioFinder();
			
			if(userFind.search(cpf) != null)
			{
				throw new UsuarioJaExiste();
			}
			
			user.set(new VisitanteDTO(nome,cpf,senha,Tipo_Usuario.VISITANTE));
			user.insert();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	
	private void verificarCPF(String CPF) throws CPFinvalidoException
	{
		// considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (CPF.equals("00000000000") ||
            CPF.equals("11111111111") ||
            CPF.equals("22222222222") || CPF.equals("33333333333") ||
            CPF.equals("44444444444") || CPF.equals("55555555555") ||
            CPF.equals("66666666666") || CPF.equals("77777777777") ||
            CPF.equals("88888888888") || CPF.equals("99999999999") ||
            (CPF.length() != 11))
            throw new CPFinvalidoException(); 
          
        char dig10, dig11;
        int sm, i, r, num, peso;
          
        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try 
        {
        // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for(i=0; i < 9; i++) 
            {              
		        // converte o i-esimo caractere do CPF em um numero:
		        // por exemplo, transforma o caractere '0' no inteiro 0         
		        // (48 eh a posicao de '0' na tabela ASCII)         
            	num = (int)(CPF.charAt(i) - 48); 
            	sm = sm + (num * peso);
            	peso = peso - 1;
            }
          
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
            {
                dig10 = '0';
            }
            else
        	{
        		dig10 = (char)(r + 48); // converte no respectivo caractere numerico
        	}
          
            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for(i=0; i<10; i++)
            {
	            num = (int)(CPF.charAt(i) - 48);
	            sm = sm + (num * peso);
	            peso = peso - 1;
            }
          
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
            {
                 dig11 = '0';
            }
            else 
        	{
        		dig11 = (char)(r + 48);
        	}
          
            // Verifica se os digitos calculados conferem com os digitos informados.
            if((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)));
                 
            else throw new CPFinvalidoException();
        } 
        catch(InputMismatchException erro) 
        {
        	throw new CPFinvalidoException();
        }
	}
	
	private void verificarSenha(String senha) throws SenhaRN1Exception 
	{
		if(senha.length()<6)
			throw new SenhaRN1Exception();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.getSession().invalidate();
		request.getRequestDispatcher("Login.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String cmd = (String)request.getParameter("cmd");
		PrintWriter out = response.getWriter();
		String cpf;
		String senha;
		String nome;
		String nomeMuseu;
		String cidade;
		String estado;
		String nomeGestor;
		String senhaGestor;
		String cpfGestor;
		String data;
		
		request.setCharacterEncoding("UTF-8");
		
		
		if(cmd == null) 
		{
			doGet(request,response);
		} 
		else
		{
			
			
			
			if(!response.isCommitted())
			{
				try
				{
					switch (cmd) 
					{
						
						case "Entrar":
							
							cpf = (String)request.getParameter("cpfUsuario");
							senha = (String)request.getParameter("pswUsuario");
							
							if(cpf.isEmpty() || senha.isEmpty())
							{
								request.getRequestDispatcher("UsuarioNaoInformaDados.jsp").forward(request, response);
							}
							
							
							this.verificarCPF(cpf);
							
							try
							{
								
								userLogado = this.buscarUsuario(cpf);
								if(userLogado == null)
								{
									throw new UsuarioNaoExiste();
								}
								if(userLogado.tipoUsuario == Tipo_Usuario.ADMINISTRADOR)
								{
									request.setAttribute("Usuario", userLogado);
									request.getSession().setAttribute("nome", userLogado.getNome());
									request.getRequestDispatcher("AreaAdm.jsp").forward(request, response);

								}
								else if(userLogado.tipoUsuario == Tipo_Usuario.VISITANTE)
								{
									
									request.setAttribute("Usuario", userLogado);
									request.getSession().setAttribute("nome", userLogado.getNome());
									request.getRequestDispatcher("AreaUsuario.jsp").forward(request, response);

								}
								else
								{
									
								}
							}
							catch(UsuarioNaoExiste e)
							{
								request.getRequestDispatcher("UsuarioNaoExiste.jsp").forward(request, response);
							}
							
							break;
							
						case "Cadastrar Usuario":
							
							cpf = (String)request.getParameter("cpfUsuario");
							senha = (String)request.getParameter("pswUsuario");
							nome = request.getParameter("nomeUsuario");
							
							this.verificarCPF(cpf);
							this.verificarSenha(senha);
							
							try
							{
								
								if(this.inserirUsuario(nome, cpf, senha))
								{
									request.getRequestDispatcher("CadastradoSucesso.jsp").forward(request, response);
								}
								else
								{
									request.getRequestDispatcher("FalhaInserirUsuario.jsp").forward(request, response);
								}
							}
							catch(UsuarioJaExiste e)
							{
								request.getRequestDispatcher("UsuarioJaExtiste.jsp").forward(request, response);
							}
						break;
						
						case "Solicitar Criacao":
			
							
							nomeMuseu = request.getParameter("nomeMuseu");
							cidade = request.getParameter("cidadeMuseu");
							estado = request.getParameter("estadoMuseu");
							senhaGestor = request.getParameter("pswGestor");
							cpfGestor = request.getParameter("cpfGestor");
							nomeGestor = request.getParameter("nomeGestor");
							data = request.getParameter("dataCriacao");
							
							this.criarSolicitacaoMuseu(nomeMuseu, nomeGestor, cpfGestor, senhaGestor, estado, cidade, data);
							request.setAttribute("Usuario", userLogado);
							request.getSession().setAttribute("nome", userLogado.getNome());
							request.getRequestDispatcher("AreaUsuario.jsp").forward(request, response);
							
						break;
						
						default:
							
							doGet(request,response);
							break;
					}
				}
				catch(CPFinvalidoException e)
				{
					request.getRequestDispatcher("CPFinvalido.jsp").forward(request, response);
				}
				catch(SenhaRN1Exception e)
				{
					request.getRequestDispatcher("SenhaForaDaRegra.jsp").forward(request, response);
				}
			}
		}
	}
}

