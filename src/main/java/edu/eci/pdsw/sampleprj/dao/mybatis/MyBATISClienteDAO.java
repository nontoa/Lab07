package edu.eci.pdsw.sampleprj.dao.mybatis;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import com.google.inject.Inject;

import edu.eci.pdsw.sampleprj.dao.ClienteDAO;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.ItemMapper;
import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.entities.Item;

public class MyBATISClienteDAO implements ClienteDAO {

	@Inject
	private ClienteMapper ClienteMapper; 
	
	
	@Override
	public void save(Cliente it) throws PersistenceException {
		try{
		      ClienteMapper.insertarCliente(it);
		  }
		  catch(org.apache.ibatis.exceptions.PersistenceException e){ 
		      throw new PersistenceException("Error al registrar el cliente "+it.toString(),e);
		  }       	
	}

	@Override
	public Cliente load(long id) throws PersistenceException {
		try{
		      return ClienteMapper.consultarCliente(id);
		  }
		  catch(org.apache.ibatis.exceptions.PersistenceException e){
		      throw new PersistenceException("Error al consultar el cliente "+id,e);
		  }
	}
	
	@Override
	public List<Cliente> consultarClientes(){
		try{
		      return ClienteMapper.consultarClientes();
		  }
		  catch(org.apache.ibatis.exceptions.PersistenceException e){
		      throw new PersistenceException("Error al consultar los clientes "+e);
		  }
		
		
	}

}
