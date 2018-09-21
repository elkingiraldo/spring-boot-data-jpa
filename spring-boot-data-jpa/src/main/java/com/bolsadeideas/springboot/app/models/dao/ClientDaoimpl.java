package com.bolsadeideas.springboot.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.app.models.entity.Client;

/**
 * Implementation of {@link IClientDao}
 * 
 * @author eggiraldo
 *
 */
@Repository
public class ClientDaoimpl implements IClientDao {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Client> findAll() {
		return em.createQuery("from Client").getResultList();
	}

	@Override
	@Transactional
	public void save(Client client) {
		if (client.getId() != null && client.getId() > 0) {
			em.merge(client);
		} else {
			em.persist(client);
		}
	}

	@Override
	public Client findOne(Long id) {
		return em.find(Client.class, id);
	}

}
