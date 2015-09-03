package com.netshoes.poc.featuretoggle.core.toggle;

public class InvalidaFeatureToggleException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public InvalidaFeatureToggleException(String message, Throwable cause) {
		super(message, cause);
	}
}
