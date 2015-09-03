package com.netshoes.poc.featuretoggle.feature;

import com.netshoes.poc.featuretoggle.core.toggle.Feature;

public enum MyFeatures implements Feature {

	ENABLE_HAPPY_MESSAGE("feature-enable-happy-message", false);
	
	private String key;
	private boolean defaultValue;

	private MyFeatures(final String key, final boolean defaultValue) {
		this.key = key;
		this.defaultValue = defaultValue;
	}
	
	@Override
	public String getKey() {
		return this.key;
	}

	@Override
	public boolean getDefaultValue() {
		return this.defaultValue;
	}

}
