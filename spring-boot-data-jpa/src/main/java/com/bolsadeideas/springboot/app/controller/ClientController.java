package com.bolsadeideas.springboot.app.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.bolsadeideas.springboot.app.models.entity.Client;
import com.bolsadeideas.springboot.app.service.ClientService;

/**
 * Controller for clients
 * 
 * @author eggiraldo
 *
 */
@Controller
@SessionAttributes("client") /* For saving client in session */
public class ClientController {

	@Autowired
	private ClientService clientService;

	@GetMapping(value = "/getAll")
	public String getAll(Model model) {

		clientService.retrieveAll(model);

		return "getAll";
	}

	@GetMapping(value = "/form")
	public String create(Map<String, Object> model) {

		clientService.createModel(model);

		return "form";
	}

	@PostMapping(value = "/form")
	public String save(@Valid Client client, BindingResult result, Model model, SessionStatus status) {

		if (result.hasErrors()) {
			model.addAttribute("title", "Client Form");
			return "form";
		}

		clientService.save(client);
		status.setComplete(); /* For delete client in session */
		return "redirect:getAll";
	}

	@GetMapping(value = "/form/{id}")
	public String edit(@PathVariable(value = "id") Long id, Map<String, Object> model) {
		if (id > 0) {
			return clientService.findById(id, model);
		} else {
			return "redirect:/getAll";
		}
	}

}
