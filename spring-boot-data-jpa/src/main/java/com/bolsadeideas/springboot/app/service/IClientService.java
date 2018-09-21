package com.bolsadeideas.springboot.app.service;

import java.util.Map;

import org.springframework.ui.Model;

import com.bolsadeideas.springboot.app.models.entity.Client;

public interface IClientService {

	public void createModel(Map<String, Object> model);

	public void findAll(Model model);

	public void save(Client client);

	public String findOne(Long id, Map<String, Object> model);

	public void delete(Long id);

}
