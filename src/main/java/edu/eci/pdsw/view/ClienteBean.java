package edu.eci.pdsw.view;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.entities.ItemRentado;
import edu.eci.pdsw.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.pdsw.samples.services.ServiciosAlquiler;

@SuppressWarnings("deprecation")
@ManagedBean(name = "clienteBean")
@SessionScoped


public class ClienteBean extends BasePageBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Inject
	private ServiciosAlquiler serviciosalquiler;
	
	private String nombre,telefono,direccion,email;
	private long documento;
	public void agregarCliente(String nombre, long documento, String telefono, String direccion, String email) throws Exception {
		try {
			serviciosalquiler.registrarCliente(new Cliente(nombre,documento,telefono,direccion,email));
		}catch(ExcepcionServiciosAlquiler ex) {
			throw ex;
		}
	}
	
	
	public List<Cliente> getClientes() throws Exception{
		try {
			return serviciosalquiler.consultarClientes();
		}catch(ExcepcionServiciosAlquiler ex) {
			throw ex;	
		}
		
	}
	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public long getDocumento() {
		return documento;
	}


	public void setDocumento(long documento) {
	
		this.documento = documento;
	}

	
}
