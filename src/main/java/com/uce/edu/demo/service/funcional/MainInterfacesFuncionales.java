package com.uce.edu.demo.service.funcional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainInterfacesFuncionales {

	private static final Logger LOG = LoggerFactory.getLogger(MainInterfacesFuncionales.class);

	public static boolean prueba(Integer numero) {
		return numero >= 3;
	}

	public static void imprimir(String cadena) {

		LOG.info("Impresion " + cadena);
	}
	
	public static void guardar(String elementoAInsertar) {

//		LOG.info("Impresion " + elementoAInsertar);
	}

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

		// Metodos high order

		String valorHO = metodosHighOrder.consumirSupplier(() -> "Hola mundo");
		LOG.info("HO Supplier: " + valorHO);

		String valorHO1 = metodosHighOrder.consumirSupplier(() -> {

			String valorConsultado = "1474521051";

			return valorConsultado;
		});

		LOG.info("HO Supplier: " + valorHO1);

		// JAVA
		LOG.info("JAVA Supplier");
		Stream<String> test = Stream.generate(() -> "Luis 3").limit(7);
		test.forEach(cadena -> System.out.println(cadena));

		// CONSUMER
		// CLASES
		IPersonaConsumer<String> consumer = new PersonaConsumerImpl();
		consumer.accept("Prueba Consumer");

		// LAMBDAS
		IPersonaConsumer<String> consumerLambda = cadena -> System.out.println(cadena);
		consumerLambda.accept("Prueba Consumer Lambda");

		// Metodos high order
		metodosHighOrder.consumirConsumer(valor -> System.out.println(valor), 2);

		// JAVA
		LOG.info("JAVA Consumer");
		List<Integer> listaNumeros = Arrays.asList(1, 2, 3, 4, 5);
		listaNumeros.forEach(numero -> System.out.println(numero));

		// PREDICATE
		// CLASES

		// LAMBDAS
		IPersonaPredicate<String> predicateLambda = cadena -> cadena.contains("Z");
		LOG.info("Predicate Lambdas: " + predicateLambda.evaluar("EdiZon"));

		// Metodos high order
		boolean respuesta = metodosHighOrder.consumirPredicate(cadena -> cadena.contains("Z"), "EdiZon");
		LOG.info("HO Predicate: " + respuesta);

		// JAVA
		LOG.info("JAVA Predicate");
		Stream<Integer> nuevaLista = listaNumeros.stream().filter(numero -> prueba(numero));
		nuevaLista.forEach(numero -> System.out.println(numero));

		// FUNCTION
		// LAMBDAS
		IPersonaFunction<Integer, String> functionLambda = cadena -> {
			Integer valor = Integer.parseInt(cadena);
			Integer valorFinal = valor - 2;
			return valorFinal;
		};
		LOG.info("Function Lambdas: " + functionLambda.aplicar("7"));

		// Metodos high order
		String valorFinalHO = metodosHighOrder.consumirFunction(valor -> {
			String retorno = valor.toString() + " A";
			return retorno;
		}, 1);

		LOG.info("JAVA Function");
		// Conversiones/cast Empleado -> EmpleadoDTO (Ligero)
		Stream<String> listaCambiada = listaNumeros.stream().map(numeroLista -> {
			Integer valor = numeroLista + 1;
			String cadena = "num: " + valor.toString();
			return cadena;
		});
		//Declarativa: ideas/inten
		listaCambiada.forEach(valor -> imprimir(valor));
		
		List<String> lista1 = new ArrayList<>();
		Map<String, String> mpa1 = new HashMap<String, String>();
		
		
		//Imperativa
//		for(String valor: abc) {
//			imprimi(abc);
//		}

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
