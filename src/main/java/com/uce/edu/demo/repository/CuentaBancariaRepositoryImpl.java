package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.demo.repository.modelo.CuentaBancaria;

@Repository
@Transactional
public class CuentaBancariaRepositoryImpl implements ICuentaBancariaRepository {

	private static Logger LOG = Logger.getLogger(CuentaBancariaRepositoryImpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void actualizar(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		this.entityManager.merge(cuentaBancaria);
		throw new RuntimeException();
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public CuentaBancaria buscarPorNumero(String numeroCta) {
		// TODO Auto-generated method stub
		LOG.info("Transaccion activa: " + TransactionSynchronizationManager.isActualTransactionActive());
		TypedQuery<CuentaBancaria> myQuery = this.entityManager
				.createQuery("SELECT c FROM CuentaBancaria c WHERE c.numero = :numeroCta", CuentaBancaria.class);
		myQuery.setParameter("numeroCta", numeroCta);

		return myQuery.getSingleResult();
	}

}
