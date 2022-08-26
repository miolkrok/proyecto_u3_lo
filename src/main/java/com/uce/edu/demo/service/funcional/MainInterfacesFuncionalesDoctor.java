package com.uce.edu.demo.service.funcional;

import org.apache.log4j.Logger;

public class MainInterfacesFuncionalesDoctor {

	private static Logger LOG = Logger.getLogger(MainInterfacesFuncionalesDoctor.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DoctorMetodosHighOrder doctorMetodosHO = new DoctorMetodosHighOrder();

		// SUPPLIER
		// Clases

		IDoctorSupplier<String> supplierClase = new DoctorSupplierImpl();
		LOG.info("Supplier Doctor: " + supplierClase.getNombre());

		// Lambdas

		IDoctorSupplier<String> supplierLambdas = () -> "Luis Ortiz";
		LOG.info("Supplier Lambda Doctor: " + supplierLambdas.getNombre());

		// Metodos HO
		String valorHO = doctorMetodosHO.consumirSupplier(() -> "Probando Lambas Doctor");
		LOG.info("High Order Supplier Doctor" + valorHO);

		String valorHO1 = doctorMetodosHO.consumirSupplier(() -> {
			String valorConsultado = "8";
			String valorFinal = valorConsultado.concat("concatenando...");
			return valorFinal;
		});
		LOG.info("High Order Supplier Doctor" + valorHO1);

		// CONSUMER
		// Clases

		IDoctorConsumer<String> consumerClase = new DoctorConsumerImpl();
		consumerClase.accept("Consumer para Doctor");

		// Lambdas

		IDoctorConsumer<String> consumerLamba = cadena -> System.out.println(cadena);
		consumerLamba.accept("Consumer para Doctor con Lambdas");

		// Metodos HO
		doctorMetodosHO.consumirConsumer(valor -> System.out.println(valor), 19);

		// PREDICATE
		// Clases
		IDoctorPredicate<String> predicateClase = new DoctorPredicateImpl();
		boolean valorImprimir = predicateClase.evaluar("Alexander");
		LOG.info("predicate Clase Doctor: " + valorImprimir);
		
		// Lambdas

		IDoctorPredicate<String> predicateLamba = cadena -> cadena.contains("L");
		LOG.info("predicate Lamba Doctor: " + predicateLamba.evaluar("Doctor"));

		// Metodos HO
		boolean respuesta = doctorMetodosHO.consumirPredicate(cadena -> cadena.contains("a"), "Carla");
		LOG.info("High Order predicate Doctor" + respuesta);
		
		// FUNCTION
		// Clases
		
		IDoctorFunction<String, Integer> functionPredicate = new DoctorFunctionImpl<>();
		String funcionImprimir = functionPredicate.aplicar(23);
		LOG.info("Function clase Doctor: el numero es: " + funcionImprimir);

		// Lambdas

		IDoctorFunction<Integer, String> functionLambda = cadena -> {
			Integer valor = Integer.parseInt(cadena);
			Integer valorFinal = valor - 2;
			if (valorFinal < 14) {
				LOG.info("Function Doctor: Si cumple con la condicion");
				return valorFinal;
			} else {
				LOG.info("Function Doctor: No cumple con la condicion");
				return valorFinal + 40;
			}

		};

		LOG.info("Function Doctor Lamba : " + functionLambda.aplicar("5"));

		// Metodos HO
		
		String valorFinalHO = doctorMetodosHO.consumirFunction(valor -> {
			String retorno = valor.toString() + " Ingresando datos en Function";
			return retorno;
		}, 1);
		LOG.info("High Order Function Doctor " + valorFinalHO);

		// UNARY OPERATOR
		
		// Clases
		
		IDoctorFunctionUnaryOperator<String> functionUnaryOperator = new DoctorFunctionUnaryOperatorImpl();
		String ValorPrueba = functionUnaryOperator.aplicar("Doctor Unary Operator");
		LOG.info(ValorPrueba);

		// Lambdas

		IDoctorFunctionUnaryOperator<String> unaryLambda = cadena -> {
			String valorFinal = cadena.concat("Doctor UnaryOperator de los lambdas");
			return valorFinal;
		};
		LOG.info("Unary Lamba Doctor: " + unaryLambda.aplicar("Luis "));

		// Metodos HO
		String valorFinalHO1 = doctorMetodosHO.consumirFunction(valor -> {
			String retorno = valor.toString() + " Ingresando para Unary Operator Doctor";
			return retorno;
		}, 1);
		LOG.info("High Order function Doctor " + valorFinalHO1);
	}

}
