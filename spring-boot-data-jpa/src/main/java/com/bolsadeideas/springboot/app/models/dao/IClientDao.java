package com.bolsadeideas.springboot.app.models.dao;

import java.util.List;

import com.bolsadeideas.springboot.app.models.entity.Client;

/**
 * Interface for manage {@link Client}
 * 
 * @author eggiraldo
 *
 */
public interface IClientDao {

	public List<Client> findAll();
	
	public void save(Client client);
	
	public Client findOne(Long id);
	
}
