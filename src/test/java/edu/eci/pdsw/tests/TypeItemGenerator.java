package edu.eci.pdsw.tests;

import org.quicktheories.core.Gen;
import static org.quicktheories.QuickTheory.qt;
import org.quicktheories.generators.Generate;
import static org.quicktheories.generators.SourceDSL.*;

import java.util.ArrayList;

import edu.eci.pdsw.samples.entities.*;


public class TypeItemGenerator {
	
	public static Gen<TipoItem> TiposItems() {
		return Genid().zip(Gendescripcion(),(id,descripcion)->new TipoItem(id,descripcion));
	}

	private static Gen<Integer> Genid() {
		return integers().between(0, 10000);
	}
	
	private static Gen<String> Gendescripcion(){
		return strings().basicLatinAlphabet().ofLengthBetween(20,30);
	}

}