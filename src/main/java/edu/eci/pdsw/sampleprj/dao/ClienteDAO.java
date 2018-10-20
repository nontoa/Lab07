package edu.eci.pdsw.sampleprj.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.entities.Item;

public interface ClienteDAO {

	
	 public void save(Cliente it) throws PersistenceException;

	 public Cliente load(long id) throws PersistenceException;
	 
	 public List<Cliente> consultarClientes() throws PersistenceException;
	 
	 public void vetar(long docu, boolean estado) throws PersistenceException;
}
