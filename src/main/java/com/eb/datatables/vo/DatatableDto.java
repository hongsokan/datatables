package com.eb.datatables.vo;

import java.util.List;

import lombok.Data;

@Data
public class DatatableDto<T> {
	private int draw;
	private long recordsTotal;
	private long recordsFiltered;
	private List<T> data;
}