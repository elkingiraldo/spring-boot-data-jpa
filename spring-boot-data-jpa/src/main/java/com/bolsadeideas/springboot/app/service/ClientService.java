package com.bolsadeideas.springboot.app.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.bolsadeideas.springboot.app.models.dao.IClientRepository;
import com.bolsadeideas.springboot.app.models.entity.Client;

/**
 * All services for clients
 * 
 * @author eggiraldo
 *
 */
@Service
public class ClientService implements IClientService {

//	@Autowired
//	private IClientDao clientDao;

	@Autowired
	private IClientRepository clientRepository;

	@Override
	public void createModel(Map<String, Object> model) {
		Client client = new Client();
		model.put("client", client);
		model.put("title", "Client Form");
	}

	@Override
	public void save(Client client) {
		clientRepository.save(client);
	}

	@Override
	public void delete(Long id) {
		clientRepository.delete(id);
	}

	@Override
	public void findAll(Model model) {
		model.addAttribute("title", "Clients lists");
		model.addAttribute("clients", (List<Client>) clientRepository.findAll());
	}

	@Override
	public String findOne(Long id, Map<String, Object> model) {

		Client client = clientRepository.findOne(id);

		model.put("client", client);
		model.put("title", "Edit client");

		return "form";
	}

}
