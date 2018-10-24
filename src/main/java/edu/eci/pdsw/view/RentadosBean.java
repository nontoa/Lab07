package edu.eci.pdsw.view;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.entities.ItemRentado;
import edu.eci.pdsw.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.pdsw.samples.services.ServiciosAlquiler;


@SuppressWarnings("deprecation")
@ManagedBean(name = "rentadosBean")
@RequestScoped


public class RentadosBean extends BasePageBean{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManagedProperty(value = "#{param.document}")
	private long document;
	/**
	 * 
	 */
	private int iditem;
	private int numdias;
	private long costo;
	private Cliente cliente;
	@Inject
	private ServiciosAlquiler serviciosalquiler;
	
	
	public List<ItemRentado> getAlquilados() throws Exception{
		try {
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
	
	public void rentarItem(int iditem,int numdias,long document)throws Exception {
		try {
			serviciosalquiler.registrarAlquilerCliente(java.sql.Date.valueOf(LocalDate.now()), document,serviciosalquiler.consultarItem(iditem), numdias);
		} catch (ExcepcionServiciosAlquiler e) {
			throw e;
		}
	}
	
	public Date fechaActual() {
		return java.sql.Date.valueOf(LocalDate.now());
	}


	public long getCosto() {
		return costo;
	}


	public void setCosto(long costo) {
		this.costo = costo;
	}


	public int getNumdias() {
		return numdias;
	}


	public void setNumdias(int numdias) {
		this.numdias = numdias;
	}


	public int getIditem() {
		return iditem;
	}


	public void setIditem(int iditem) {
		this.iditem = iditem;
	}
	
	public long getDocument() {
		return document;
	}
	
	public void setDocument(long d) {
		document = d;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		System.out.println("entra");
		this.cliente = cliente;
	}
}