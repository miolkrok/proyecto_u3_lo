package com.uce.edu.demo;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.ITransferenciaRepository;
import com.uce.edu.demo.repository.modelo.Detalle;
import com.uce.edu.demo.repository.modelo.Factura;
import com.uce.edu.demo.repository.modelo.Habitacion;
import com.uce.edu.demo.repository.modelo.Hotel;
import com.uce.edu.demo.service.IFacturaService;
import com.uce.edu.demo.service.IHotelService;
import com.uce.edu.demo.service.ITransferenciaService;

@SpringBootApplication
public class ProyectoU3LoApplication implements CommandLineRunner{

	@Autowired
	private IHotelService hotelService;
	
	@Autowired
	private IFacturaService facturaService;
	
	@Autowired
	private ITransferenciaService transferenciaService;
	
	private static final Logger LOG = LoggerFactory.getLogger(ProyectoU3LoApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3LoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
//		//INNER
//		LOG.info("INNER JOIN ");
//		List<Hotel> listHotel = this.hotelService.buscarHotelInnerJoin("Familiar");
//		for(Hotel h : listHotel) {
//			LOG.info("Hotel " +h.getNombre() + h.getDireccion());
//		}
//		//INNER todos
//		LOG.info("INNER JOIN ");
//		List<Hotel> listHotelJoin = this.hotelService.buscarHotelInnerJoinS();
//		for(Hotel h : listHotelJoin) {
//			LOG.info("Hotel " +h.getNombre() + h.getDireccion());
//		}
//		
//		//LEFT
//		LOG.info("LEFT JOIN ");
//		List<Hotel> listHotelLeft = this.hotelService.buscarHotelOuterJoinLeft("Familiar");
//		for(Hotel h : listHotelLeft) {
//			LOG.info("Hotel " +h.getNombre() + h.getDireccion());
//		}
//		//LEFT todos
//		LOG.info("LEFT JOIN ");
//		List<Hotel> listHotelLeftB = this.hotelService.buscarHotelOuterJoinLeftS();
//		for(Hotel h : listHotelLeftB) {
//			LOG.info("Hotel " +h.getNombre() + h.getDireccion());
//		}
//		
//		//RIGHT
//		LOG.info("RIGHT JOIN ");
//		List<Hotel> listHotelRight = this.hotelService.buscarHotelOuterJoinRight("Familiar");
//		for(Hotel h : listHotelRight) {
//			LOG.info("Hotel " +h.getNombre() + h.getDireccion());
//		}
		
		//WHERE
//		LOG.info("RELACIONAMIENTO WHERE ");
//		List<Hotel> listHotelWhere = this.hotelService.buscarHotelJoinWhere("Familiar");
//		for(Hotel h : listHotelWhere) {
//			LOG.info("Hotel: " +h.getNombre()+ " "+ h.getDireccion());
//		}
		
		//INNER
//		LOG.info("INNER JOIN EAGER/LAZY ");
//		List<Hotel> listHotel = this.hotelService.buscarHotelInnerJoin("Familiar");
//		for(Hotel h : listHotel) {
//			LOG.info("Hotel 2: " +h.getNombre() +" "+ h.getDireccion());
//			for(Habitacion ha:h.getHabitacion()) {
//				LOG.info("Hotel2 habitacion: " + ha);
//			}
//			
//		}
		//FETCH
//		LOG.info("JOIN FETCH ");
//		List<Hotel> listHotelFetch = this.hotelService.buscarHotelJoinFetch("Familiar");
//		for(Hotel h : listHotelFetch) {
//			LOG.info("Hotel: " +h.getNombre()+ " "+ h.getDireccion());
//			for(Habitacion ha:h.getHabitacion()) {
//				LOG.info("Hotel2 habitacion: " + ha);
//			}
//		}
		//INNER JOIN
//		LOG.info("INNER JOIN ");
//		List<Factura> listaFacturaJoin = this.facturaService.buscarFacturaInnerJoin(new BigDecimal(20));
//		for(Factura f :listaFacturaJoin) {
//			LOG.info("Factura: " +f.getNumero()+ " " + f.getFecha());
//		}
//		//LEFT JOIN
//		LOG.info("LEFT JOIN ");
//		List<Factura> listaFacturaLeft = this.facturaService.buscarFacturaOuterJoinLeft(new BigDecimal(20));
//		for(Factura f :listaFacturaLeft) {
//			LOG.info("Factura: " +f.getNumero()+ " " + f.getFecha());
//		}
//		//RIGHT JOIN
//		LOG.info("RIGHT JOIN ");
//		List<Factura> listaFacturaRight = this.facturaService.buscarFacturaOuterJoinRight(new BigDecimal(20));
//		for(Factura f :listaFacturaRight) {
//			LOG.info("Factura: " +f.getNumero()+ " " + f.getFecha());
//		}
		
//		//WHERE
//		LOG.info("RELACIONAMIENTO WHERE ");
//		List<Factura> listFacturaWhere = this.facturaService.buscarFacturaJoinWhere(new BigDecimal(20));
//		for(Factura f : listFacturaWhere) {
//			LOG.info("Factura: " +f.getNumero()+ " " + f.getFecha());
//		}
//		
//		//FETCH JOIN
//		LOG.info("JOIN FETCH");
//		List<Factura> listFacturaFetch = this.facturaService.buscarFacturaJoinFetch(new BigDecimal(20));
//		for(Factura f : listFacturaFetch) {
//			LOG.info("Factura: " +f.getNumero()+ " " + f.getFecha());
//			for(Detalle df:f.getDetalleFact()) {
//				LOG.info("Factura detalle: " +df);
//			}
//		}
		
//		this.transferenciaService.realizarTransferencia("58463", "96512", new BigDecimal(5));
		this.transferenciaService.realizarTransferenciaFachada("96512", "58463", new BigDecimal(50));
	}

}
