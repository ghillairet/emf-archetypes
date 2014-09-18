package ${package};

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.Callback;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.URIHandlerImpl;

import com.google.gwt.user.client.rpc.AsyncCallback;

public class ServiceCallback extends URIHandlerImpl {

	private final ResourceServiceAsync service;

	public ServiceCallback(ResourceServiceAsync service) {
		this.service = service;
	}

	@Override
	public void createInputStream(final URI uri, Map<?, ?> options, final Callback<Map<?, ?>> callback) {
		service.fetch(uri.toString(), new AsyncCallback<byte[]>() {
			@Override
			public void onFailure(Throwable caught) {
				callback.onFailure(caught);
			}
			@Override
			public void onSuccess(byte[] result) {
				if (result == null) {
					callback.onFailure(new Exception("Cannot load resource " + uri));
				} else {
					final Map<String, Object> resultMap = new HashMap<>();
					final Map<String, Object> response = new HashMap<>();

					resultMap.put(URIConverter.OPTION_RESPONSE, response);
					response.put(URIConverter.RESPONSE_RESULT, new ByteArrayInputStream(result));

					callback.onSuccess(resultMap);
				}
			}
		});
	}

	@Override
	public void store(URI uri, byte[] bytes, final Map<?, ?> options, final Callback<Map<?, ?>> callback) {
		service.store(uri.toString(), bytes, new AsyncCallback<Void>() {
			@Override
			public void onFailure(Throwable caught) {
				callback.onFailure(caught);
			}
			@Override
			public void onSuccess(Void result) {
				callback.onSuccess(options);
			}
		});
	}

	@Override
	public void exists(URI uri, Map<?, ?> options, final Callback<Boolean> callback) {
		service.exists(uri.toString(), new AsyncCallback<Boolean>() {
			@Override
			public void onSuccess(Boolean result) {
				callback.onSuccess(result);
			}
			@Override
			public void onFailure(Throwable caught) {
				callback.onFailure(caught);
			}
		});
	}

	@Override
	public void delete(URI uri, final Map<?, ?> options, final Callback<Map<?, ?>> callback) {
		service.delete(uri.toString(), new AsyncCallback<Void>() {
			@Override
			public void onFailure(Throwable caught) {
				callback.onFailure(caught);
			}
			@Override
			public void onSuccess(Void result) {
				callback.onSuccess(options);
			}
		});
	}

}
