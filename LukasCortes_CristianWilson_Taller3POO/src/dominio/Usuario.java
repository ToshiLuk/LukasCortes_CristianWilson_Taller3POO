package dominio;

public abstract class Usuario {
	
	protected String usuario;
    protected String contraseña;
    protected String rol;

    public Usuario(String usuario, String contraseña, String rol) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.rol = rol;
    }

    public String getUsername() { 
    		return usuario; 
    	}
    public String getPassword() { 
    		return contraseña; 
    	}
    public String getRol() { 
    		return rol; 
    	}
    
}
