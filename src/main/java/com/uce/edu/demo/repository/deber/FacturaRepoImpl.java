package com.uce.edu.demo.repository.deber;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.deber.Factura;
import com.uce.edu.demo.repository.modelo.deber.FacturaElectronicaTO;

@Repository
@Transactional
public class FacturaRepoImpl implements IFacturaRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
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
	public List<FacturaElectronicaTO> buscarPorNumeroFacturaElectronicaTO(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<FacturaElectronicaTO> myTypedQuery = this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.demo.repository.modelo.deber.FacturaElectronicaTO(f.id, f.numero, f.fecha, f.monto, d.numeroItems) FROM Factura f, DetalleFactura d WHERE f=d.factura AND f.numero = :datoNumero",
				FacturaElectronicaTO.class);
		myTypedQuery.setParameter("datoNumero", numero);

		return myTypedQuery.getResultList();
	}

}
