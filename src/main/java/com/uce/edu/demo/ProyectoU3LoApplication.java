package com.uce.edu.demo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Hotel;
import com.uce.edu.demo.service.IHotelService;

@SpringBootApplication
public class ProyectoU3LoApplication implements CommandLineRunner{

	@Autowired
	private IHotelService hotelService;
	
	
	private static final Logger LOG = LoggerFactory.getLogger(ProyectoU3LoApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3LoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//INNER
		LOG.info("INNER JOIN ");
		List<Hotel> listHotel = this.hotelService.buscarHotelInnerJoin("Familiar");
		for(Hotel h : listHotel) {
			LOG.info("Hotel " +h.getNombre() + h.getDireccion());
		}
		//INNER todos
		LOG.info("INNER JOIN ");
		List<Hotel> listHotelJoin = this.hotelService.buscarHotelInnerJoinS();
		for(Hotel h : listHotelJoin) {
			LOG.info("Hotel " +h.getNombre() + h.getDireccion());
		}
		
		//LEFT
		LOG.info("LEFT JOIN ");
		List<Hotel> listHotelLeft = this.hotelService.buscarHotelOuterJoinLeft("Familiar");
		for(Hotel h : listHotelLeft) {
			LOG.info("Hotel " +h.getNombre() + h.getDireccion());
		}
		//LEFT todos
		LOG.info("LEFT JOIN ");
		List<Hotel> listHotelLeftB = this.hotelService.buscarHotelOuterJoinLeftS();
		for(Hotel h : listHotelLeftB) {
			LOG.info("Hotel " +h.getNombre() + h.getDireccion());
		}
		
		//RIGHT
		LOG.info("RIGHT JOIN ");
		List<Hotel> listHotelRight = this.hotelService.buscarHotelOuterJoinRight("Familiar");
		for(Hotel h : listHotelRight) {
			LOG.info("Hotel " +h.getNombre() + h.getDireccion());
		}
	}

}
