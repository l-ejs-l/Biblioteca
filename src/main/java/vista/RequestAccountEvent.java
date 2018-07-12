package vista;


import common.dominios.Usuario;

import java.util.EventObject;

public class RequestAccountEvent extends EventObject{
	private Usuario cuenta;
	
	public RequestAccountEvent(Object source){
		super(source);
	}
	
	public RequestAccountEvent(Object source, Usuario cuenta){
		super(source);
		this.cuenta = cuenta;
	}	
	
	public Usuario getCuenta(){
		return cuenta;
	}
	
	public String toString(){
		return cuenta.toString();
	}
}
