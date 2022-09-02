package com.uce.edu.demo.hilos.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainStreamDeber {

	private static final Logger LOG = LoggerFactory.getLogger(MainStreamDeber.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LOG.info("Stream Supplier");
		Stream<String> listaAnime = Stream.generate(()-> "Death Note").limit(10);
		
		LOG.info("Stream Consumer");
		listaAnime.forEach(cadena -> LOG.info("Anime: " + cadena));
		
		LOG.info("Stream Predicate");
		List<String> listaPred = Arrays.asList("One Piece","Dragon Ball", "Death Note");
		Stream<String> listImpr = listaPred.stream().filter(cadena -> cadena.contains("o"));
		listImpr.forEach(cade -> LOG.info("Cadena Filtrada: " +cade));
		
		LOG.info("Stream Function");
		listaPred.stream().map(cadena -> cadena.toLowerCase()).forEach(cadena -> LOG.info("Function map: "+ cadena));
	}

}
