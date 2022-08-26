package com.uce.edu.demo.repository.deber;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.deber.Factura;
import com.uce.edu.demo.repository.modelo.deber.FacturaElectronica;

@Repository
@Transactional
public class FacturaRepositoryImpl implements IFacturaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Factura> buscarFacturaInnerJoin(BigDecimal subtotal) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(
				"SELECT f FROM Factura2 f JOIN f.detalleFact df WHERE df.subtotal >= :datoSubtotal", Factura.class);
		myQuery.setParameter("datoSubtotal", subtotal);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaOuterJoinLeft(BigDecimal subtotal) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(
				"SELECT f FROM Factura2 f LEFT JOIN f.detalleFact df WHERE df.subtotal >= :datoSubtotal",
				Factura.class);
		myQuery.setParameter("datoSubtotal", subtotal);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaOuterJoinRight(BigDecimal subtotal) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(
				"SELECT f FROM Factura2 f RIGHT JOIN f.detalleFact df WHERE df.subtotal >= :datoSubtotal",
				Factura.class);
		myQuery.setParameter("datoSubtotal", subtotal);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaJoinWhere(BigDecimal subtotal) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(
				"SELECT f FROM Factura2 f, Detalle2 df WHERE f = df.factura AND df.subtotal >= :datoSubtotal",
				Factura.class);
		myQuery.setParameter("datoSubtotal", subtotal);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaJoinFetch(BigDecimal subtotal) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(
				"SELECT f FROM Factura2 f JOIN FETCH f.detalleFact df WHERE df.subtotal >= :datoSubtotal",
				Factura.class);
		myQuery.setParameter("datoSubtotal", subtotal);
		return myQuery.getResultList();
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.persist(factura);
	}

	@Override
	public Factura buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Factura.class, id);
	}

	@Override
	public void actualizar(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.merge(factura);
	}

	@Override
	public List<FacturaElectronica> buscarPorNumeroFacturaElectronicaTO(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<FacturaElectronica> myTypedQuery = this.entityManager.createQuery(
				"SELECT f from Factura f WHERE f.numero = :datoNumero",
				FacturaElectronica.class);
		myTypedQuery.setParameter("datoNumero", numero);

		return myTypedQuery.getResultList();
	}

}
