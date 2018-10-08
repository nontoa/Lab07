package edu.eci.pdsw.samples.services.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.pdsw.sampleprj.dao.ClienteDAO;
import edu.eci.pdsw.sampleprj.dao.ItemDAO;
import edu.eci.pdsw.sampleprj.dao.TipoItemDAO;

import org.apache.ibatis.exceptions.PersistenceException;
import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.entities.Item;
import edu.eci.pdsw.samples.entities.ItemRentado;
import edu.eci.pdsw.samples.entities.TipoItem;
import edu.eci.pdsw.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.pdsw.samples.services.ServiciosAlquiler;
import java.sql.Date;
import java.util.List;

@Singleton
public class ServiciosAlquilerImpl implements ServiciosAlquiler {

	
	
   @Inject
   private ItemDAO itemDAO;

   @Inject
   private ClienteDAO clienteDAO;
   
   @Inject
   private TipoItemDAO tipoItemDAO;

   
   @Override
   public int valorMultaRetrasoxDia(int itemId) {
	   try {
		   Item it=consultarItem(itemId);
		   return (int) it.getTarifaxDia();
	   }
	   catch(ExcepcionServiciosAlquiler ex) {
		   return 0;
	   }
   }

   @Override
   public Cliente consultarCliente(long docu) throws ExcepcionServiciosAlquiler {
	   try {
		   return clienteDAO.load((int)(docu));
	   }
	   catch(PersistenceException ex) {
           throw new ExcepcionServiciosAlquiler("Error al consultar el cliente "+docu,ex);

	   }
   }

   @Override
   public List<ItemRentado> consultarItemsCliente(long idcliente) throws ExcepcionServiciosAlquiler {
	   try {
		   Cliente cli = clienteDAO.load((int) idcliente);
		   return cli.getRentados();
	   }
	   catch(PersistenceException ex) {
           throw new ExcepcionServiciosAlquiler("Error al consultar los items rentados del cliente "+idcliente,ex);

	   }
   }

   @Override
   public List<Cliente> consultarClientes() throws ExcepcionServiciosAlquiler {
	   try {
		   return clienteDAO.consultarClientes();
	   }
	   catch(PersistenceException ex) {
           throw new ExcepcionServiciosAlquiler("Error al consultar los clientes "+ex);

	   }
   }

   @Override
   public Item consultarItem(int id) throws ExcepcionServiciosAlquiler {
       try {
           return itemDAO.load(id);
       } catch (PersistenceException ex) {
           throw new ExcepcionServiciosAlquiler("Error al consultar el item "+id,ex);
       }
   }

   @Override
   public List<Item> consultarItemsDisponibles()  {
	   	return itemDAO.consultarItems();
   }

   @Override
   public long consultarMultaAlquiler(int iditem, Date fechaDevolucion) throws ExcepcionServiciosAlquiler {
	   //FALTA IMPLEMENTAR
       throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public TipoItem consultarTipoItem(int id) throws ExcepcionServiciosAlquiler {
	   try {
		   return tipoItemDAO.load(id);
	   }
	   catch(PersistenceException ex) {
           throw new ExcepcionServiciosAlquiler("Error al consultar el tipo item "+id,ex);
	   }
   }

   @Override
   public List<TipoItem> consultarTiposItem() throws ExcepcionServiciosAlquiler {
	   try {
		   return tipoItemDAO.consultarTipoItems();
	   }
	   catch(PersistenceException ex) {
           throw new ExcepcionServiciosAlquiler("Error al consultar los tipos item "+ex);
	   }
   }

   @Override
   public void registrarAlquilerCliente(Date date, long docu, Item item, int numdias) throws ExcepcionServiciosAlquiler {
	   //FALTA IMPLEMENTAR
       throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public void registrarCliente(Cliente c) throws ExcepcionServiciosAlquiler {
	   try {
		   clienteDAO.save(c);
	   }
	   catch(PersistenceException ex) {
           throw new ExcepcionServiciosAlquiler("Error al insertar cliente"+ex);
	   }
   }

   @Override
   public long consultarCostoAlquiler(int iditem, int numdias) throws ExcepcionServiciosAlquiler {
	   try {
		   return valorMultaRetrasoxDia(iditem)*numdias;
	   }
	   catch(PersistenceException ex) {
           throw new ExcepcionServiciosAlquiler("Error al calcular costo de alquiler del item "+iditem+ex);

	   }
   }

   @Override
   public void actualizarTarifaItem(int id, long tarifa) throws ExcepcionServiciosAlquiler {
	   try{
		   Item it=consultarItem(id);
		   it.setTarifaxDia(tarifa);
	   }
	   catch(PersistenceException ex) {
           throw new ExcepcionServiciosAlquiler("Error al actualizar la tarifa del item"+id+ex);
	   }
	   
   }
   @Override
   public void registrarItem(Item i) throws ExcepcionServiciosAlquiler {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public void vetarCliente(long docu, boolean estado) throws ExcepcionServiciosAlquiler {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }
}
