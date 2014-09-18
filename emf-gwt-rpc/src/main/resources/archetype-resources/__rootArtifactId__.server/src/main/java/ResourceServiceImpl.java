package ${package};

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import ${package}.${ModelNameLower}.${ModelNameUpper}Factory;
import ${package}.${ModelNameLower}.${ModelNameUpper}Package;
import ${package}.${ModelNameLower}.Entity;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class ResourceServiceImpl extends RemoteServiceServlet implements ResourceService {

	private static final long serialVersionUID = 1L;

	private ResourceSet resourceSet;

	private ResourceSet getResourceSet() {
		if (resourceSet == null) {
			resourceSet = new ResourceSetImpl();
			resourceSet.getPackageRegistry().put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
			resourceSet.getPackageRegistry().put(${ModelNameUpper}Package.eNS_URI, ${ModelNameUpper}Package.eINSTANCE);
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new ResourceFactoryImpl() {
				@Override
				public Resource createResource(URI uri) {
					return new BinaryResourceImpl(uri);
				}
			});
		}
		return resourceSet;
	}

	@Override
	public byte[] fetch(String uri) {
		Resource resource = getResourceSet().createResource(URI.createURI(uri));
		Entity entity = ${ModelNameUpper}Factory.INSTANCE.createEntity();
		entity.setName("My Entity");

		resource.getContents().add(entity);
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try {
			resource.save(outputStream, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return outputStream.toByteArray();
	}

	@Override
	public void store(String uri, byte[] bytes) {
		Resource resource = getResourceSet().createResource(URI.createURI(uri));
		try {
			resource.load(new ByteArrayInputStream(bytes), null);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		if (resource.isLoaded()) {
			System.out.println("storing resource " + uri);
			// do something here to store the resource
		}
	}

	@Override
	public void delete(String uri) {
		// do something here 
	}

	@Override
	public boolean exists(String uri) {
		return true;
	}

}
