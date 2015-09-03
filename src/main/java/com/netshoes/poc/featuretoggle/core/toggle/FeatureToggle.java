package com.netshoes.poc.featuretoggle.core.toggle;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class FeatureToggle {

	@Inject
	private FeatureToggleData featureToggleData;
	
	public boolean isActive(final Feature feature) {
		return featureToggleData.get(feature);
	}
	
}
