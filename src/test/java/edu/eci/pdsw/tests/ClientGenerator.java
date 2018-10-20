package edu.eci.pdsw.tests;
import org.quicktheories.core.Gen;
import static org.quicktheories.QuickTheory.qt;
import org.quicktheories.generators.Generate;
import static org.quicktheories.generators.SourceDSL.*;

import edu.eci.pdsw.samples.entities.*;


public class ClientGenerator {
	
	public static Gen<Cliente> Clientes() {
		return GenNombre().zip(Gendocumento(),Gentelefono(),Gendireccion(),Genemails(),(nombre,documento,telefono,direccion,email) -> new Cliente(nombre,documento,telefono,direccion,email));
	}

	private static Gen<Long> Gendocumento() {
		return longs().between(0, 1000000);
	}
	
	private static Gen<String> GenNombre(){
		return strings().basicLatinAlphabet().ofLengthBetween(10, 20);
	}
	
	private static Gen<String> Gentelefono(){
		return strings().numericBetween(1000000, 9999999);
	}
	
	private static Gen<String> Gendireccion(){
		return strings().basicMultilingualPlaneAlphabet().ofLengthBetween(10, 100);
	}
	
	private static Gen<String> Genemails(){
		return strings().basicMultilingualPlaneAlphabet().ofLengthBetween(10, 100).map(x -> {return x+"@pdsw.com";}); 
	}
}