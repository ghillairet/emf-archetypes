package ${package};

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import ${package}.providers.JsonResourceBodyReader;
import ${package}.providers.JsonResourceBodyWriter;
import ${package}.resources.ModelResource;

@ApplicationPath("api")
public class ServerApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<>();
		classes.add(ModelResource.class);
		classes.add(JsonResourceBodyReader.class);
		classes.add(JsonResourceBodyWriter.class);
		return classes;
	}

}
