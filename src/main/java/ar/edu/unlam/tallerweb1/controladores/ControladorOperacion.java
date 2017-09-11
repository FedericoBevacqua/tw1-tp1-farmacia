package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorOperacion {
	
	//punto 5 vista
	@RequestMapping("/operacion/{operacionDeseada}/{primerOperando}/{segundoOperando}")
	public ModelAndView realizarOperacion(@PathVariable("operacionDeseada") String operacionDeseada, 
									@PathVariable("primerOperando") Integer primerOperando, 
									@PathVariable("segundoOperando") Integer segundoOperando) {
		
		ModelMap modelo = new ModelMap();
		modelo.put("operacionDeseada", operacionDeseada);
		modelo.put("primerOperando", primerOperando);
		modelo.put("segundoOperando", segundoOperando);
		
		//Verifico si la operación es sumar
		if(operacionDeseada.equalsIgnoreCase("sumar")) {
			Integer resultado = primerOperando + segundoOperando;
			modelo.put("resultado", resultado);
			return new ModelAndView("resultado-operacion", modelo);
		}
		
		//Si la operación indicada no existe, muestro pantalla de error
		return new ModelAndView("operacion-invalida", modelo);
}
	
	
/*	@RequestMapping("/operacion/suma/{primerOperando}/{segundoOperando}")
	public ModelAndView realizarSuma(@PathVariable("primerOperando") Integer primerOperando, 
									@PathVariable("segundoOperando") Integer segundoOperando) {
		
	Integer resultado = primerOperando + segundoOperando;
	ModelMap modelo = new ModelMap();
	modelo.put("primerOperando", primerOperando);
	modelo.put("segundoOperando", segundoOperando);
	modelo.put("resultado", resultado);
	
	return new ModelAndView("sumar", modelo);
}*/

}
