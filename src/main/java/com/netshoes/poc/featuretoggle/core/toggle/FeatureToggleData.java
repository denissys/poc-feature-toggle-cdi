package com.netshoes.poc.featuretoggle.core.toggle;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.enterprise.context.RequestScoped;

@RequestScoped
class FeatureToggleData {

	private Map<String, Boolean> features = new HashMap<String, Boolean>();
	
	void add(final String key, final boolean value) {
		features.put(key, value);
	}

	boolean get(final Feature feature) {
		final Optional<Boolean> value = Optional.ofNullable(features.get(feature.getKey()));
		return value.isPresent() ? value.get() : feature.getDefaultValue();
	}

}
