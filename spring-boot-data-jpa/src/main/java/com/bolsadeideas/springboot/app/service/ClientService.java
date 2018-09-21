package com.bolsadeideas.springboot.app.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.bolsadeideas.springboot.app.models.dao.IClientDao;
import com.bolsadeideas.springboot.app.models.entity.Client;

/**
 * All services for clients
 * 
 * @author eggiraldo
 *
 */
@Service
public class ClientService implements IClientService {

	@Autowired
	private IClientDao clientDao;

	@Override
	public void createModel(Map<String, Object> model) {
		Client client = new Client();
		model.put("client", client);
		model.put("title", "Client Form");
	}

	@Override
	public void save(Client client) {
		clientDao.save(client);
	}

	@Override
	public void delete(Long id) {
		clientDao.delete(id);
	}

	@Override
	public void findAll(Model model) {
		model.addAttribute("title", "Clients lists");
		model.addAttribute("clients", clientDao.findAll());
	}

	@Override
	public String findOne(Long id, Map<String, Object> model) {

		Client client = clientDao.findOne(id);

		model.put("client", client);
		model.put("title", "Edit client");

		return "form";
	}

}
