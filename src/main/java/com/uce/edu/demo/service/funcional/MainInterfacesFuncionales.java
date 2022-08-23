package com.uce.edu.demo.service.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainInterfacesFuncionales {
	
	private static final Logger LOG = LoggerFactory.getLogger(MainInterfacesFuncionales.class);
	
	public static void main(String[] args) {
		
		
		//SUPPLIER
		//CLASES
		IPersonaSupplier<String> supplier = new PersonaSupplierImpl();
		LOG.info("Supplier Clase: " +supplier.getNombre());
		
		IPersonaSupplier<String> supplierTE = new PersonaSupplierTEImpl();
		LOG.info("Supplier Clase TE: " +supplierTE.getNombre());
		//LAMBDAS
		IPersonaSupplier<String> supplierLambda = () -> "Luis2"; 
		LOG.info("Supplier Lambda: " +supplierLambda.getNombre());
		
		IPersonaSupplier<String> supplierLambdaTE = () -> "Daniel TE2"; 
		LOG.info("Supplier Lambda TE: " +supplierLambdaTE.getNombre());
		//CONSUMER
		//CLASES
		IPersonaConsumer<String> consumer = new PersonaConsumerImpl();
		consumer.accept("Prueba Consumer");
		
		//LAMBDAS
		IPersonaConsumer<String> consumerLambda = cadena -> System.out.println(cadena);
		consumerLambda.accept("Prueba Consumer Lambda");
		
		//PREDICATE
		//CLASES
		//LAMBDAS
		
		//FUNCTION
		//CLASES
		//LAMBDAS
		
		//UNARY OPERATOR (FUNCTION)
		//CLASES
		//LAMBDAS
		
	}

}
