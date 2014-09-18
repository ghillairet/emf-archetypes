package ${package};

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ResourceServiceAsync {

	void fetch(String uri, AsyncCallback<byte[]> callback);
	void store(String uri, byte[] bytes, AsyncCallback<Void> callback);
	void delete(String uri, AsyncCallback<Void> callback);
	void exists(String uri, AsyncCallback<Boolean> callback);

}
