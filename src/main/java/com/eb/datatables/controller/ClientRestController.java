package com.eb.datatables.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eb.datatables.service.ClientService;
import com.eb.datatables.vo.CompleteInfo;

@RestController
public class ClientRestController {

	private ClientService clientService;

	public ClientRestController(ClientService clientService) {
		this.clientService = clientService;
	}

	@GetMapping("/client/count")
	public int count() {
		return clientService.count();
	}

	@GetMapping("/client/list")
	public List<CompleteInfo> list() {
		return clientService.findAll();
	}
}
