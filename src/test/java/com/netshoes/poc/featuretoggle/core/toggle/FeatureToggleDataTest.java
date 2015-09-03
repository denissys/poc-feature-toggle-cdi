package com.netshoes.poc.featuretoggle.core.toggle;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class FeatureToggleDataTest {

	private static final String FEATURE_KEY = "feature-one";
	private FeatureToggleData featureToggleData = new FeatureToggleData();
	
	@Before
	public void setup() {
		featureToggleData.add(FEATURE_KEY, true);
	}
	
	@Test
	public void get_validFeature_returnValueTrue() {
		assertTrue(featureToggleData.get(getFeature(FEATURE_KEY)));
	}
	
	@Test
	public void get_invalidFeature_returnDefaultValue() {
		assertFalse(featureToggleData.get(getFeature("feature-invalid-xpto")));
	}

	private Feature getFeature(final String key) {
		return new Feature() {
			
			@Override
			public String getKey() {
				return key;
			}
			
			@Override
			public boolean getDefaultValue() {
				return false;
			}
		};
	}

}
