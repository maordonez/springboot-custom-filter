package co.maordonez.filter.dto;

import java.util.List;

import lombok.Data;

@Data
public class PageDto<T> {

	
	private Long totalRows;
	private int totalPages;
	private int pageCurrent;
	private int pageSize;
	private List<T> rows;
	
}
