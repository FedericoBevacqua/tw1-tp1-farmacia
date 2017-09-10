package ar.edu.unlam.tallerweb1.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Comuna {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	
	@OneToMany (mappedBy = "comuna", cascade = CascadeType.ALL)
	private List<Barrio> barrios = new ArrayList<Barrio> ();
	
   public Barrio addBarrio(Barrio barrios) {
		
		return barrios;
	}
	

}
