package edu.eci.pdsw.sampleprj.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import com.google.inject.Inject;

import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.pdsw.samples.entities.Item;
import edu.eci.pdsw.samples.entities.TipoItem;

public interface TipoItemDAO {
	
	
	public void save(String it) throws PersistenceException;

	public TipoItem load(int id) throws PersistenceException;
	
	public List<TipoItem> consultarTipoItems() throws PersistenceException;

}
