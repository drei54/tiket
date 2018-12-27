package com.tiket.test.common.response;

import org.springframework.data.domain.Sort;

public class PaginationResponse {
	private boolean last;
	private int totalPages;
	private long totalElements;
	private Sort sort;
	private boolean first;
	private int numberOfElements;
	private int size;
	private int number;
	public boolean isLast() {
		return last;
	}
	public void setLast(boolean last) {
		this.last = last;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public long getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}
	public Sort getSort() {
		return sort;
	}
	public void setSort(Sort sort) {
		this.sort = sort;
	}
	public boolean isFirst() {
		return first;
	}
	public void setFirst(boolean first) {
		this.first = first;
	}
	public int getNumberOfElements() {
		return numberOfElements;
	}
	public void setNumberOfElements(int numberOfElements) {
		this.numberOfElements = numberOfElements;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
}
