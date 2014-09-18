package ${package};

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("resources")
public interface ResourceService extends RemoteService {

	byte[] fetch(String uri);
	void store(String uri, byte[] bytes);
	void delete(String uri);
	boolean exists(String uri);

}
