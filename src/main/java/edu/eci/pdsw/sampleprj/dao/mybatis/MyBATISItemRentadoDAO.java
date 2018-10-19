package edu.eci.pdsw.sampleprj.dao.mybatis;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import com.google.inject.Inject;

import edu.eci.pdsw.sampleprj.dao.ItemRentadoDAO;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.ItemRentadoMapper;
import edu.eci.pdsw.samples.entities.Item;
import edu.eci.pdsw.samples.entities.ItemRentado;

public class MyBATISItemRentadoDAO implements ItemRentadoDAO{

	@Inject
	private ItemRentadoMapper itemRentadoMapper;    

	@Override
	public void save(int id, Item item, Date inicio, Date fin,long idcliente) throws PersistenceException {
		 try{
		      itemRentadoMapper.insertarItemRentado(id,item,inicio,fin,idcliente);
		  }
		  catch(org.apache.ibatis.exceptions.PersistenceException e){ 
		      throw new PersistenceException("Error al registrar el itemrentado "+id,e);
		  }  
		
	}
		
	  @Override
	  public ItemRentado load(int id) throws PersistenceException {
	  try{
	      return itemRentadoMapper.consultarItemRentado(id);
	  }
	  catch(org.apache.ibatis.exceptions.PersistenceException e){
	      throw new PersistenceException("Error al consultar el itemrentado "+id,e);
	  }


	  }

		@Override
		public List<ItemRentado> consultarItemsRentados() throws PersistenceException {
			try{
			      return itemRentadoMapper.consultarItemsRentados();
			  }
			  catch(org.apache.ibatis.exceptions.PersistenceException e){
			      throw new PersistenceException("Error al consultar los itemsrentados "+e);
			  }
		}

		
	  }