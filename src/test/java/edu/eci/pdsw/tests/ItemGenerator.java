package edu.eci.pdsw.tests;

import org.quicktheories.core.Gen;
import static org.quicktheories.QuickTheory.qt;
import org.quicktheories.generators.Generate;
import org.quicktheories.generators.LocalDatesDSL;

import static org.quicktheories.generators.SourceDSL.*;
import static org.quicktheories.generators.LocalDatesDSL.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import edu.eci.pdsw.samples.entities.*;
import edu.eci.pdsw.tests.*;

public class ItemGenerator {

	public static Gen<Item> Items() {
		return TypeItemGenerator.TiposItems().zip(Genid(),Gennombre()
	,Gendescripcion(),Gentarifa(),(tipo,id,nombre,descripcion,tarifaxDia)-> new Item(tipo,id,nombre,descripcion,tarifaxDia));
				  
	}
      
	private static Gen<Integer> Genid() {
		return integers().between(0, 10000);
	}
	
	private static Gen<String> Gennombre(){
		return strings().basicLatinAlphabet().ofLengthBetween(10, 20);
	}
	
	private static Gen<String> Gendescripcion(){
		return strings().basicLatinAlphabet().ofLengthBetween(20, 30);
	}
	
	private static Gen<Date> Genfecha(){
		return dates().withMilliseconds(243659872);
	}
	
	
	private static Gen<Long> Gentarifa(){
		return longs().between(0, 1000000);
	}
	
	private static Gen<String> GenformatoRenta(){
		return strings().basicLatinAlphabet().ofLengthBetween(5,10);
	}

	private static Gen<String> Gengenero(){
		return strings().basicLatinAlphabet().ofLengthBetween(10,15);
	}
}