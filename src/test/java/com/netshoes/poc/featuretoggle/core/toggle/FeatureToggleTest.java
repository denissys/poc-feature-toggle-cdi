package com.netshoes.poc.featuretoggle.core.toggle;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FeatureToggleTest {

	@Spy
	private FeatureToggleData featureToggleData = new FeatureToggleData();
	
	@InjectMocks
	private FeatureToggle featureToggle = new FeatureToggle();
	
	@Before
	public void setup() {
		featureToggleData.add("feature-enable-log", true);
		featureToggleData.add("feature-enable-discount", false);
	}
	
	@Test
	public void isActive_validFeature_returnValueTrue() {
		assertTrue(featureToggle.isActive(getFeature("feature-enable-log")));
	}
	
	@Test
	public void isActive_invalidFeature_returnDefaultValue() {
		assertFalse(featureToggle.isActive(getFeature("feature-enable-xpto")));
	}
	
	@Test
	public void isActive_featureWithNullValue_returnDefaultValue() {
		assertFalse(featureToggle.isActive(getFeature(null)));
	}
	
	@Test
	public void add_replaceValue_shouldReplaceValue() {
		featureToggleData.add("feature-enable-discount", true);
		assertTrue(featureToggle.isActive(getFeature("feature-enable-discount")));
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
