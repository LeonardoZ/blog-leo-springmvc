package com.leonardoz.blog;

import java.io.File;

import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

public class Main {
	public static void main(String[] args) throws Exception {
		String webappDirLocation = "src/main/webapp";
		Tomcat tomcat = new Tomcat();
		String webPort = System.getenv("PORT");
		if (webPort == null || webPort.isEmpty()) {
			webPort = "8080";
		}

		tomcat.setPort(Integer.valueOf(webPort));

		StandardContext ctx = (StandardContext) tomcat.addWebapp("/blogleo", new File(webappDirLocation).getAbsolutePath());
		System.out.println("configuring app with basedir: " + new File(webappDirLocation).getAbsolutePath());
		
		ctx.setReloadable(true);
		// Declare an alternative location for your "WEB-INF/classes" dir
		// Servlet 3.0 annotation will work
		File additionWebInfClasses = new File("target/classes");
		WebResourceRoot resources = new StandardRoot(ctx);
		resources.addPreResources(
				new DirResourceSet(resources, "/WEB-INF/classes", additionWebInfClasses.getAbsolutePath(), "/"));
		ctx.setResources(resources);
		
		ctx.addWelcomeFile("index.html");
		tomcat.start();

		tomcat.getServer().await();
	}
}
