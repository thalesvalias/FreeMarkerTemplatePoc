package com.freemarkertemplate.poc.config;

import java.io.File;
import java.io.IOException;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;

/**
 * 
 * Configuration Instance of TemplateMarker.
 * It should be called only once at the beginning of the application (Singleton) life-cycle.
 * 
 * @author thalesvalias - 20/06/2018
 *
 */
public class FreeMarkerConfig {
	
	public static Configuration setupFreeMarker() {
		
		// Create your Configuration instance, and specify if up to what FreeMarker
		// version (here 2.3.27) do you want to apply the fixes that are not 100%
		// backward-compatible. See the Configuration JavaDoc for details.
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
	
		try {
			// Specify the source where the template files come from.
			ClassLoader classLoader = FreeMarkerConfig.class.getClassLoader();	
			cfg.setDirectoryForTemplateLoading(new File(classLoader.getResource("templates").getFile()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		cfg.setDefaultEncoding("UTF-8");
		
		// Sets how errors will appear.
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		
		// Don't log exceptions inside FreeMarker that it will thrown at you anyway.
		cfg.setLogTemplateExceptions(false);
		
		// Wrap unchecked exceptions thrown during template processing into TemplateException-s.
		cfg.setWrapUncheckedExceptions(true);
		
		return cfg;
	}
}
