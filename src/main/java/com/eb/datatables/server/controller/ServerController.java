package com.eb.datatables.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServerController {
	@GetMapping("/server")
	public String client() {
		return "server";
	}
}
