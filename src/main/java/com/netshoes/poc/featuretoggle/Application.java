package com.netshoes.poc.featuretoggle;

import javax.servlet.ServletException;

import com.netshoes.poc.featuretoggle.core.undertow.EmbeddedServer;
import com.netshoes.poc.featuretoggle.core.undertow.ResourceFactory;

public class Application {

	public static void main(String[] args) throws ServletException {
		new EmbeddedServer("0.0.0.0", 8080)
			.contextPath("/my-app")
			.deploymentName("my-app")
			.appPath("/api")
			.resourcesClass(ResourceFactory.class)
			.start();
	}
	
}
