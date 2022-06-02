package com.eb.datatables.vo;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class DatatableParam {
	private int draw;
	private int start;
	private int length;
	private long recordsTotal;
	private String type;
	private Map<String, Object> search;
	private List<Map<String, String>> order;
}
