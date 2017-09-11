package ar.edu.unlam.tallerweb1.modelo;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import ar.edu.unlam.tallerweb1.SpringTest;

public class Test3Farmacia extends SpringTest{

	@Test
	@Transactional
	@Rollback(true)
	
	public void testBusqueTodasFarmaciasDeUnBarrio(){
		//Declarar
		Farmacia farmacia1,farmacia2,farmacia3;
		Direccion direccion1,direccion2,direccion3;
		Barrio barrio1,barrio2, barrio3;
		Session session;
				
		//Inicializar
		farmacia1=new Farmacia();
		farmacia2=new Farmacia();
		farmacia3=new Farmacia();
		session=getSession();
		direccion1= new Direccion();
		direccion2= new Direccion();
		direccion3= new Direccion();
		barrio1=new Barrio();
		barrio2=new Barrio();
		barrio3=new Barrio();
				
		//settear
		barrio1.setNombre("Los Aromos");
		barrio2.setNombre("Barrio Nuevo");
		barrio3.setNombre("El portal");
		direccion1.setBarrio(barrio1);
		direccion2.setBarrio(barrio2);	
		direccion3.setBarrio(barrio3);	
		farmacia1.setDireccion(direccion1);
		farmacia2.setDireccion(direccion2);
		farmacia3.setDireccion(direccion3);
				
		//Gaurdar
		session.save(barrio1);
		session.save(barrio2);
		session.save(barrio3);
		session.save(direccion1);
		session.save(direccion2);
		session.save(direccion3);
		session.save(farmacia1);
		session.save(farmacia2);
		session.save(farmacia3);
				
		//restringir
		List<Farmacia>resultado;
		resultado=session.createCriteria(Farmacia.class)
					.createAlias("direccion", "dire")
					.createAlias("dire.barrio", "b")
					.add(Restrictions.eq("b.nombre", "Los Aromos"))
						.list();
				
				assertThat(resultado).hasSize(1);
			
			}
	}

