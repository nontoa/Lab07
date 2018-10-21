package edu.eci.pdsw.view;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.entities.ItemRentado;
import edu.eci.pdsw.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.pdsw.samples.services.ServiciosAlquiler;

@SuppressWarnings("deprecation")
@ManagedBean(name = "alquilerItemsBean")
@RequestScoped

public class AlquilerItemsBean extends BasePageBean {

	@ManagedProperty(value = "#{param.document}")
	private Long document;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Inject
	private ServiciosAlquiler serviciosalquiler;
	
	private String nombre,telefono,direccion,email;
	private long documento,costo;
	private int iditem;
	private int numdias;
	
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
	
	public List<ItemRentado> getAlquilados() throws Exception{
		try {
			setDocumento(document);
			return serviciosalquiler.consultarCliente(document).getRentados();
		}catch(ExcepcionServiciosAlquiler ex) {
			throw ex;	
		} 
	}
	
	
	public long multa(int id) throws Exception{
		try {
			return serviciosalquiler.consultarMultaAlquiler(id,java.sql.Date.valueOf(LocalDate.now()));
		}catch(ExcepcionServiciosAlquiler ex) {
			throw ex;
		}
	}
	
	public void costoAlquiler(int iditem, int numdias) throws Exception {
		try {
			setCosto(serviciosalquiler.consultarCostoAlquiler(iditem, numdias)); 
		} catch (ExcepcionServiciosAlquiler e) {
			setCosto(0);
		}
	}
	
	public void rentarItem(int iditem,int numdias)throws Exception {
		try {
			System.out.println(documento);
			serviciosalquiler.registrarAlquilerCliente(java.sql.Date.valueOf(LocalDate.now()), documento,serviciosalquiler.consultarItem(iditem), numdias);
			//return "registrocliente";
		} catch (ExcepcionServiciosAlquiler e) {
			throw e;
		}
	}
	
	public Date fechaActual() {
		return java.sql.Date.valueOf(LocalDate.now());
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


	public int getIditem() {
		return iditem;
	}


	public void setIditem(int iditem) {
		this.iditem = iditem;
	}


	public int getNumdias() {
		return numdias;
	}

	public void setNumdias(int numerodedias) {
		this.numdias = numerodedias;
	}
	
	public Long getDocument() {
		return document;
	}
	
	public void setDocument(Long d) {
		document = d;
	}


	public long getCosto() {
		return costo;
	}


	public void setCosto(long costo) {
		this.costo = costo;
	}	
}
