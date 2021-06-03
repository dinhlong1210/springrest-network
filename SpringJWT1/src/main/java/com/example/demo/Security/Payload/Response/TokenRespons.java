package com.example.demo.Security.Payload.Response;

import javax.validation.constraints.NotBlank;

public class TokenRespons {
	@NotBlank
	private String token;

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}
	
	
}
