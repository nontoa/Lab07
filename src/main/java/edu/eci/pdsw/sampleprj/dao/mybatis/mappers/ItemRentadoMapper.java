package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.pdsw.samples.entities.Item;
import edu.eci.pdsw.samples.entities.ItemRentado;

public interface ItemRentadoMapper {

    
    public List<ItemRentado> consultarItemsRentados();        
    
    public ItemRentado consultarItemRentado(@Param("id")int id);
    
    public void insertarItemRentado(@Param("id")int id,@Param("item")Item item,
    		@Param("inicio")Date inicio,@Param("fin")Date fin,@Param("idcliente")long idc);
}
