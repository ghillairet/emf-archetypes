package ${package}.providers;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipselabs.emfjson.EMFJs;
import org.eclipselabs.emfjson.map.streaming.JacksonStreamMapper;

@Provider
@Produces("application/json")
public class JsonResourceBodyWriter implements MessageBodyWriter<Resource> {

	@Override
	public boolean isWriteable(Class<?> type, Type genericType, 
			Annotation[] annotations, MediaType mediaType) {
		return type == Resource.class || Resource.class.isAssignableFrom(type);
	}

	@Override
	public long getSize(Resource t, Class<?> type, Type genericType, 
			Annotation[] annotations, MediaType mediaType) {
		return 0;
	}

	@Override
	public void writeTo(Resource resource, Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders,
			OutputStream entityStream) throws IOException,
			WebApplicationException {
		
		JacksonStreamMapper mapper = new JacksonStreamMapper();
		Map<String, Object> options = new HashMap<>();
		options.put(EMFJs.OPTION_INDENT_OUTPUT, true);
		options.put(EMFJs.OPTION_SERIALIZE_REF_TYPE, false);

		mapper.write(resource, entityStream, options);
	}

}
