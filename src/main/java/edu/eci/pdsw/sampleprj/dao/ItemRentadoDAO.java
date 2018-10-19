package edu.eci.pdsw.sampleprj.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.pdsw.samples.entities.Item;
import edu.eci.pdsw.samples.entities.ItemRentado;

public interface ItemRentadoDAO {
	   public void save(int id,Item item,Date inicio, Date fin,long idcliente) throws PersistenceException;

	   public ItemRentado load(int id) throws PersistenceException;
	   
	   public List<ItemRentado> consultarItemsRentados() throws PersistenceException;
}