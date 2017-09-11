package ar.edu.unlam.tallerweb1.modelo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import ar.edu.unlam.tallerweb1.SpringTest;

public class Test1Farmacia extends SpringTest{

	@Test
	@Transactional
	@Rollback(true)
	
	public void testBusqueTodasFarmaciasDeTurnoDiaMarte(){
		
		//Declaramos
		Farmacia farmacia1,farmacia2, farmacia3;
		Session session;
		
		//Inicializamos
		farmacia1=new Farmacia();
		farmacia2=new Farmacia();
		farmacia3=new Farmacia();
		session=getSession();
		
		//Settear
		farmacia1.setDiaDeTurno("lunes");
		farmacia2.setDiaDeTurno("martes");
		farmacia3.setDiaDeTurno("martes");
		
		//guardar
		session.save(farmacia1);
		session.save(farmacia2);
		session.save(farmacia3);
		
		List<Farmacia>resultado;
		resultado=session.createCriteria(Farmacia.class)
				.add(Restrictions.eq("diaDeTurno", "martes"))
				.list();
		
		assertThat(resultado).hasSize(2);
		
		
		
		
		
	}
}
