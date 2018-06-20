package com.freemarkertemplate.poc.main;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import com.freemarkertemplate.poc.config.FreeMarkerConfig;
import com.freemarkertemplate.poc.model.Product;
import com.freemarkertemplate.poc.model.TempPojo;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

public class Main {

	public static void main(String[] args) {
		
		/* Create a data-model - WITH MAP */
//		Map<String, Object> root = new HashMap<>();
//		root.put("user", "Big Joe");
//		
//		Product latest = new Product("products/greenmouse.html", "green mouse");
//		
//		root.put("latestProduct", latest);
		
		/* Create a data-model - WITH POJO */
		TempPojo root = new TempPojo("Big Joe", new Product("products/greenmouse.html", "green mouse"));
		
		Configuration cfg = FreeMarkerConfig.setupFreeMarker();
		
		Template temp = null;
		try {
			temp = cfg.getTemplate("temp.ftlh");
		} catch (TemplateNotFoundException e) {
			e.printStackTrace();
		} catch (MalformedTemplateNameException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Writer out = new OutputStreamWriter(System.out);
		try {
			temp.process(root, out);
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.exit(0);
	}

}
