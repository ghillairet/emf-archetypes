package ${package}.providers;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipselabs.emfjson.EMFJs;
import org.eclipselabs.emfjson.map.streaming.JacksonStreamMapper;
import ${package}.store.ModelStore;

@Provider
@Consumes("application/json")
public class JsonResourceBodyReader implements MessageBodyReader<Resource> {

	@Override
	public boolean isReadable(Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType) {
		return type == Resource.class || Resource.class.isAssignableFrom(type);
	}

	@Override
	public Resource readFrom(Class<Resource> type, Type genericType,
			Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
			throws IOException, WebApplicationException {

		JacksonStreamMapper mapper = new JacksonStreamMapper();
		Map<String, Object> options = new HashMap<>();
		options.put(EMFJs.OPTION_INDENT_OUTPUT, true);
		options.put(EMFJs.OPTION_SERIALIZE_REF_TYPE, false);

		Resource resource = ModelStore.resource("tmp");
		try {
			mapper.parse(resource, entityStream, options);
		} catch (IOException e) {
			return null;
		}

		return resource;
	}

}
