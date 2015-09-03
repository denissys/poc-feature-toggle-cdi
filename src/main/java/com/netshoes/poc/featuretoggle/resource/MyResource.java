package com.netshoes.poc.featuretoggle.resource;

import static com.netshoes.poc.featuretoggle.feature.MyFeatures.ENABLE_HAPPY_MESSAGE;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.netshoes.poc.featuretoggle.core.toggle.EnableFeatureToggle;
import com.netshoes.poc.featuretoggle.core.toggle.FeatureToggle;
import com.netshoes.poc.featuretoggle.core.undertow.Resource;

@EnableFeatureToggle
@Path("/test")
public class MyResource implements Resource {

	@Inject
	private FeatureToggle featureToggle;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		String responseData = "Feature toggle turn off :(";
		
		if (featureToggle.isActive(ENABLE_HAPPY_MESSAGE)) {
			responseData = "Feature toggle turn on :)";
		}
		return responseData;
	}
	
}
