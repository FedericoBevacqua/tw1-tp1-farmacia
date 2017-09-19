package ar.edu.unlam.tallerweb1.modelo;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;

public class Test2Farmacia extends SpringTest{


	@Test
	@Transactional
	@Rollback(true)
	
	public void testBusqueTodasFarmaciasDeUnaCalle(){
		
		//Declarar
		Farmacia farmacia1,farmacia2,farmacia3;
		Direccion direccion1,direccion2,direccion3;
		Session session;
		
		//Inicializar
		farmacia1=new Farmacia();
		farmacia2=new Farmacia();
		farmacia3=new Farmacia();
		session=getSession();
		direccion1= new Direccion();
		direccion2= new Direccion();
		direccion3= new Direccion();
		
		//Settear
		direccion1.setCalle("Arieta");
		direccion2.setCalle("Urdaneta");
		direccion3.setCalle("25 de mayo");
		farmacia1.setDireccion(direccion1);
		farmacia2.setDireccion(direccion2);
		farmacia3.setDireccion(direccion3);
		
		//Guardar
		session.save(direccion1);
		session.save(direccion2);
		session.save(direccion3);
		session.save(farmacia1);
		session.save(farmacia2);
		session.save(farmacia3);
		
		//Restringir
		List<Farmacia>resultado;
		resultado=session.createCriteria(Farmacia.class)
				.createAlias("direccion", "dire")
				.add(Restrictions.eq("dire.calle", "Arieta"))
				.list();
		
		assertThat(resultado).hasSize(1);
		
		
		for (Farmacia lista: resultado) {
			
			assertEquals("Arieta",lista.getDireccion().getCalle());
			
		}
	
	}
}
