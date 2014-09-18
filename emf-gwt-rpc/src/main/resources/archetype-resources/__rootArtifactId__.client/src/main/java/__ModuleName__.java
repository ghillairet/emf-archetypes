package ${package};

import java.io.IOException;

import org.eclipse.emf.common.util.Callback;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import ${package}.${ModelNameLower}.${ModelNameUpper}Package;
import ${package}.${ModelNameLower}.Entity;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;

public class ${ModuleName} implements EntryPoint {

	private final ResourceServiceAsync modelService = GWT.create(ResourceService.class);
	private final ServiceCallback modelCallback = new ServiceCallback(modelService);
	private Resource currentResource;

	public void onModuleLoad() {
		final View view = new View();
		RootPanel.get().add(view);

		view.handleClickSave(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (currentResource != null) {
					save(currentResource, new Callback<Resource>() {
						@Override public void onFailure(Throwable caught) {
							Window.alert("Fail to save resource");
						}
						@Override public void onSuccess(Resource result) {
							Window.alert("Successfully saved resource");
						}
					});
				}
			}
		});

		load(createResourceSet(), URI.createURI("http://resources/sample.xmi"), new Callback<Resource>() {
			@Override public void onSuccess(Resource result) {
				currentResource = result;

				if (!currentResource.getContents().isEmpty()) {
					Entity entity = (Entity) currentResource.getContents().get(0);
					view.setText(entity.getName());
				}
			}
			@Override public void onFailure(Throwable caught) {
				GWT.log("Fail to load resource " + caught.getMessage());
			}
		});
	}

	private ResourceSet createResourceSet() {
		ResourceSet resourceSet = new ResourceSetImpl();

		resourceSet.getPackageRegistry().put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(${ModelNameUpper}Package.eNS_URI, ${ModelNameUpper}Package.eINSTANCE);

		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*",new ResourceFactoryImpl() {
			@Override
			public Resource createResource(URI uri) {
				return new BinaryResourceImpl(uri);
			}
		});

		resourceSet.getURIConverter().getURIHandlers().add(modelCallback);
		resourceSet.getURIConverter().getURIMap().put(
				URI.createURI("http://resources/"), 
				URI.createURI(GWT.getHostPageBaseURL() + "resources/"));
		
		return resourceSet;
	}

	private void save(Resource resource, Callback<Resource> callback) {
		try {
			resource.save(null, callback);
		} catch (IOException e) {
			callback.onFailure(e);
		}
	}

	private void load(ResourceSet resourceSet, URI uri, Callback<Resource> callback) {
		try {
			resourceSet.createResource(uri).load(null, callback);
		} catch (IOException e) {
			callback.onFailure(e);
		}
	}

}

