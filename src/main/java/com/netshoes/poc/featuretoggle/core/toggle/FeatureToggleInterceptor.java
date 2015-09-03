package com.netshoes.poc.featuretoggle.core.toggle;

import java.util.Enumeration;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.servlet.http.HttpServletRequest;

@EnableFeatureToggle
@Interceptor
@Dependent
public class FeatureToggleInterceptor {

	@Inject
	private FeatureToggleData featureToggleData;
	
	@Inject
	private HttpServletRequest request;

	@AroundInvoke
	protected Object invoke(InvocationContext context) throws Exception {
		Enumeration<String> headerNames = null;
		try {
			headerNames = request.getHeaderNames();
			String key;
			boolean value;
			while (headerNames.hasMoreElements()) {
				key = (String) headerNames.nextElement();
				
				if (key.startsWith("feature-")) {
					value = Boolean.valueOf(request.getHeader(key));
					featureToggleData.add(key, value);
				}
			}	
		} catch(Exception e) {
			throw new InvalidaFeatureToggleException("Invalid feature toggle format! It expected : param=true or param=false.", e);
		}
		return context.proceed();
	}
}
