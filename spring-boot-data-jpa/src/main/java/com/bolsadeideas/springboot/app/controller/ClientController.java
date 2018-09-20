package com.bolsadeideas.springboot.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bolsadeideas.springboot.app.service.ClientService;

/**
 * Controller for clients
 * 
 * @author eggiraldo
 *
 */
@Controller
public class ClientController {

	@Autowired
	private ClientService clientService;

	@GetMapping(value = "/getAll")
	public String getAll(Model model) {

		clientService.retrieveAll(model);

		return "getAll";
	}

}
