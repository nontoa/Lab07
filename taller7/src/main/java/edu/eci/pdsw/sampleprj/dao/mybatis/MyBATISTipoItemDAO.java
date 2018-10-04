package edu.eci.pdsw.sampleprj.dao.mybatis;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import com.google.inject.Inject;

import edu.eci.pdsw.sampleprj.dao.TipoItemDAO;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.TipoItemMapper;
import edu.eci.pdsw.samples.entities.Item;
import edu.eci.pdsw.samples.entities.TipoItem;

public class MyBATISTipoItemDAO implements TipoItemDAO {

	@Inject
	private TipoItemMapper tipoitemMapper; 
	
	@Override
	public void save(String it) throws PersistenceException {
		try{
			tipoitemMapper.addTipoItem(it);
		  }
		  catch(org.apache.ibatis.exceptions.PersistenceException e){ 
		      throw new PersistenceException("Error al registrar el Tipo item "+it.toString(),e);
		  }    
		
	}

	@Override
	public TipoItem load(int id) throws PersistenceException {
		try{
		      return tipoitemMapper.getTipoItem(id);
		  }
		  catch(org.apache.ibatis.exceptions.PersistenceException e){
		      throw new PersistenceException("Error al consultar el Tipo item "+id,e);
		  }
	}

	@Override
	public List<TipoItem> consultarTipoItems() throws PersistenceException {
		try{
		      return tipoitemMapper.getTiposItems();
		  }
		  catch(org.apache.ibatis.exceptions.PersistenceException e){
		      throw new PersistenceException("Error al consultar los tipos items "+e);
		  }
	}

}
