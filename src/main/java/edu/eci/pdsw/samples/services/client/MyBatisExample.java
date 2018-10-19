/*
 * Copyright (C) 2015 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.pdsw.samples.services.client;



import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.ItemMapper;
import edu.eci.pdsw.samples.entities.Item;
import edu.eci.pdsw.samples.entities.TipoItem;
import edu.eci.pdsw.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.pdsw.samples.services.impl.ServiciosAlquilerImpl;

/**
 *
 * @author hcadavid
 */
public class MyBatisExample {

    /**
     * Método que construye una fábrica de sesiones de MyBatis a partir del
     * archivo de configuración ubicado en src/main/resources
     *
     * @return instancia de SQLSessionFactory
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        SqlSessionFactory sqlSessionFactory = null;
        if (sqlSessionFactory == null) {
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream("mybatis-config.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        return sqlSessionFactory;
    }

    /**
     * Programa principal de ejempo de uso de MyBATIS
     * @param args
     * @throws SQLException 
     * @throws ParseException 
     */
    public static void main(String args[]) throws SQLException, ParseException {
        SqlSessionFactory sessionfact = getSqlSessionFactory();
        SqlSession sqlss = sessionfact.openSession();
        ClienteMapper cm=sqlss.getMapper(ClienteMapper.class);     
        ServiciosAlquilerImpl servicios = new ServiciosAlquilerImpl();
        try {
			servicios.consultarCliente(666);
		} 
        catch (ExcepcionServiciosAlquiler e) {
			e.printStackTrace();
		}
        
        //System.out.println(cm.consultarClientes());
        
        //2 Verifique el funcionamiento haciendo una consulta a través del 
        //'mapper' desde MyBatisExample..
        /*System.out.println(cm.consultarCliente(666));
        
        //3.Configure en el XML correspondiente, la operación agregarItemRentadoACliente. 
        //Verifique el funcionamiento haciendo una consulta a través del 'mapper' 
        //desde MyBatisExample.
        SimpleDateFormat fecha1= new SimpleDateFormat("dd-M-yyyy");
        String fInicio="30-10-2018";
        String fFin = "05-11-2018";
        Date inicio = fecha1.parse(fInicio);
        Date fin = fecha1.parse(fFin);
        
        //cm.agregarItemRentadoACliente(24530883, 213, inicio, fin);
        //System.out.println(cm.consultarCliente(24530883));
        
        //4.Configure en el XML correspondiente (en este caso ItemMapper.xml) 
        //la operación 'insertarItem(Item it).
        String flanzamiento = "09-02-1997";
        Date lanzamiento = fecha1.parse(flanzamiento);
        ItemMapper im=sqlss.getMapper(ItemMapper.class);
        Item item = new Item(new TipoItem(3, "musica"), 1250, "espinoza", "estabien", lanzamiento, 500, "DVD", "popular");
        //im.insertarItem(item);
        
        //5.Configure en el XML correspondiente (de nuevo en ItemMapper.xml) 
        //las operaciones 'consultarItem(int it) y 'consultarItems()' de ItemMapper. 
        
        System.out.println(im.consultarItems());
        System.out.println(im.consultarItem(1));
        */
        sqlss.commit();
        
        
        sqlss.close();

        
        
    }


}
