package com.fabrick.test.rest.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Error {
	private String code;
	private String description;
	private String params;
}
