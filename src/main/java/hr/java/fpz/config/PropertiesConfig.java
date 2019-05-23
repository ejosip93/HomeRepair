package hr.java.fpz.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


@PropertySource("classpath:app.properties")
@Component
@Scope("singleton")
public class PropertiesConfig {
	@Autowired
	Environment env;
	
	public String getProperty(String path){
		return env.getProperty(path);
	}
}
  