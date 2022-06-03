package com.eb.datatables.server.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eb.datatables.server.service.ServerService;
import com.eb.datatables.vo.CompleteInfo;

@RestController
public class ServerRestController {

	private ServerService serverService;

	public ServerRestController(ServerService serverService) {
		this.serverService = serverService;
	}

	@GetMapping("/server/count")
	public int count() {
		return serverService.count();
	}

	@GetMapping("/server/list")
	public List<CompleteInfo> list(int start, int length) {
		return serverService.findAll(start, length);
	}
}
