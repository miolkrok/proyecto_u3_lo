package com.uce.edu.demo.repository;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Factura;

@Repository
@Transactional
public class FacturaRepositoryImpl implements IFacturaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Factura> buscarFacturaInnerJoin(BigDecimal subtotal) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura2 f JOIN f.detalleFact df WHERE df.subtotal >= :datoSubtotal",Factura.class);
		myQuery.setParameter("datoSubtotal", subtotal);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaOuterJoinLeft(BigDecimal subtotal) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura2 f LEFT JOIN f.detalleFact df WHERE df.subtotal >= :datoSubtotal",Factura.class);
		myQuery.setParameter("datoSubtotal", subtotal);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaOuterJoinRight(BigDecimal subtotal) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura2 f RIGHT JOIN f.detalleFact df WHERE df.subtotal >= :datoSubtotal",Factura.class);
		myQuery.setParameter("datoSubtotal", subtotal);
		return myQuery.getResultList();
	}

}
