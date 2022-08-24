package com.uce.edu.demo.service.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainInterfacesFuncionales {

	private static final Logger LOG = LoggerFactory.getLogger(MainInterfacesFuncionales.class);

	public static void main(String[] args) {

		ConsumoMetodosHighOrder metodosHighOrder = new ConsumoMetodosHighOrder();

		// SUPPLIER
		// CLASES
		IPersonaSupplier<String> supplier = new PersonaSupplierImpl();
		LOG.info("Supplier Clase: " + supplier.getNombre());

		IPersonaSupplier<String> supplierTE = new PersonaSupplierTEImpl();
		LOG.info("Supplier Clase TE: " + supplierTE.getNombre());
		// LAMBDAS
		IPersonaSupplier<String> supplierLambda = () -> "Luis2";
		LOG.info("Supplier Lambda: " + supplierLambda.getNombre());

		IPersonaSupplier<String> supplierLambdaTE = () -> "Daniel TE2";
		LOG.info("Supplier Lambda TE: " + supplierLambdaTE.getNombre());

		//Metodos high order

		String valorHO = metodosHighOrder.consumirSupplier(() -> "Hola mundo");
		LOG.info("HO Supplier: " + valorHO);

		String valorHO1 = metodosHighOrder.consumirSupplier(() -> {

			String valorConsultado = "1474521051";

			return valorConsultado;
		});

		LOG.info("HO Supplier: " + valorHO1);
		// CONSUMER
		// CLASES
		IPersonaConsumer<String> consumer = new PersonaConsumerImpl();
		consumer.accept("Prueba Consumer");

		// LAMBDAS
		IPersonaConsumer<String> consumerLambda = cadena -> System.out.println(cadena);
		consumerLambda.accept("Prueba Consumer Lambda");

		//Metodos high order
		metodosHighOrder.consumirConsumer(valor -> System.out.println(valor), 2);
		// PREDICATE
		// CLASES

		// LAMBDAS
		IPersonaPredicate<String> predicateLambda = cadena -> cadena.contains("Z");
		LOG.info("Predicate Lambdas: " + predicateLambda.evaluar("EdiZon"));

		//Metodos high order
		boolean respuesta =  metodosHighOrder.consumirPredicate(cadena -> cadena.contains("Z"), "EdiZon");
		LOG.info("HO Predicate: " +respuesta);
		// FUNCTION
		// CLASES
		// LAMBDAS
		IPersonaFunction<Integer, String> functionLambda = cadena -> {
			Integer valor = Integer.parseInt(cadena);
			Integer valorFinal = valor - 2;
			return valorFinal;
		};
		LOG.info("Function Lambdas: " + functionLambda.aplicar("7"));

		//Metodos high order
		String valorFinalHO = metodosHighOrder.consumirFunction(valor -> {
			String retorno = valor.toString() + " A";
			return retorno;
		}, 1);
		
		LOG.info("HO Function: " + valorFinalHO);
		// UNARY OPERATOR (FUNCTION)
		// CLASES
		// LAMBDAS
		IPersonaUnaryOperator<String> unaryLambda = cadena -> {
			String valorFinal = cadena.concat("sufijo");
			return valorFinal;
		};
		LOG.info("UnaryOperator Lambdas: " + unaryLambda.apply("Daniel "));

	}

}
