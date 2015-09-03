package com.netshoes.poc.featuretoggle.commons;

import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.netshoes.poc.featuretoggle.core.undertow.EmbeddedServer;
import com.netshoes.poc.featuretoggle.core.undertow.ResourceFactory;

public abstract class AbstractEmbeddedServer {

	private static UndertowJaxrsServer server = null;

	@BeforeClass
	public static void beforeClass() throws Exception {
		createEmbeddedUndertow();
	}

	private static void createEmbeddedUndertow() {
		try {
			server = new EmbeddedServer("0.0.0.0", 8080)
				.contextPath("/my-app")
				.deploymentName("my-app")
				.appPath("/api")
				.resourcesClass(ResourceFactory.class)
				.start();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@AfterClass
	public static void afterClass() {
		if (server != null) {
			server.stop();
		}
	}
	
}