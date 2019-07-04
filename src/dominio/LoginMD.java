package dominio;

public class LoginMD
{
	private static String nomeUser;
	private static String cpfUser;
	private static String senhaUser;
	
	private static LoginMD user = new LoginMD();
	
	public static void saveLogin(String _nomeUser, String _cpfUser, String _senhaUser)
	{

		nomeUser = _nomeUser;
		cpfUser = _cpfUser;
		senhaUser = _senhaUser;
	}

	public static String getNomeUser() {
		return nomeUser;
	}

	public static String getCpfUser() {
		return cpfUser;
	}


	public static String getSenhaUser() {
		return senhaUser;
	}	
}
