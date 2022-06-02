package com.eb.datatables.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eb.datatables.service.ServerService;
import com.eb.datatables.vo.CompleteInfo;
import com.eb.datatables.vo.DatatableDto;
import com.eb.datatables.vo.DatatableParam;

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
	public DatatableDto<CompleteInfo> list(DatatableParam param) {
		return serverService.findAll(param);
	}
}
