package com.alvarolongueira.managerservice.controller.response;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseBody<T> extends ResponseEntity<T> {

	private ResponseBody(T value) {
		super(value, new HttpHeaders(), HttpStatus.OK);
	}

	public static ResponseEntity<Void> of() {
		return new ResponseBody<Void>(null);
	}

	public static <T> ResponseEntity<T> of(T value) {
		return new ResponseBody<T>(value);
	}

}
