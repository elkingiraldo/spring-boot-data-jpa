package com.bolsadeideas.springboot.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.bolsadeideas.springboot.app.models.dao.IClientDao;

/**
 * All services for clients
 * 
 * @author eggiraldo
 *
 */
@Service
public class ClientService {

	@Autowired
	private IClientDao clientDao;

	public void retrieveAll(Model model) {

		model.addAttribute("title", "Clients lists");
		model.addAttribute("clients", clientDao.findAll());

	}

}
