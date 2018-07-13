package common.dominios;



public class FreeUsuario extends Usuario {

	private String fName;
	private String lName;
	private String email;
	
	public FreeUsuario(String username, String password, String fName,
                       String lName, String email) {
		super(username, password,false);
		this.fName = fName;
		this.lName = lName;
		this.email = email;
	}

	public String getfName() {
		return fName;
	}

	public String getlName() {
		return lName;
	}

	public String getEmail() {
		return email;
	}
	
	public String usuario(){
		return super.usuario();
	}
	public String password(){
		return super.password();
	}
	public void usuario(String usuario){
		super.usuario(usuario);
	}
	public void password(String password){
		super.password(password);
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
