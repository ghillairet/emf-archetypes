/**
 */
package ${package}.${ModelNameLower};

import com.google.gwt.user.client.rpc.IsSerializable;

import org.eclipse.emf.common.util.Reflect;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see ${package}.${ModelNameLower}.${ModelNameUpper}Factory
 * @generated
 */
public class ${ModelNameUpper}Package extends EPackageImpl {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNAME = "${ModelName}";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNS_URI = "http://${package}/${ModelName}";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNS_PREFIX = "${ModelName}";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final ${ModelNameUpper}Package eINSTANCE = ${package}.${ModelNameLower}.${ModelNameUpper}Package.init();

	/**
	 * The meta object id for the '{@link ${package}.${ModelNameLower}.Entity <em>Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ${package}.${ModelNameLower}.Entity
	 * @see ${package}.${ModelNameLower}.${ModelNameUpper}Package#getEntity()
	 * @generated
	 */
	public static final int ENTITY = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ENTITY__NAME = 0;

	/**
	 * The number of structural features of the '<em>Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ENTITY_FEATURE_COUNT = 1;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see ${package}.${ModelNameLower}.${ModelNameUpper}Package#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ${ModelNameUpper}Package() {
		super(eNS_URI, ${ModelNameUpper}Factory.INSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ${ModelNameUpper}Package#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ${ModelNameUpper}Package init() {
		if (isInited) return (${ModelNameUpper}Package)EPackage.Registry.INSTANCE.getEPackage(${ModelNameUpper}Package.eNS_URI);

		initializeRegistryHelpers();

		// Obtain or create and register package
		${ModelNameUpper}Package the${ModelNameUpper}Package = (${ModelNameUpper}Package)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ${ModelNameUpper}Package ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ${ModelNameUpper}Package());

		isInited = true;

		// Create package meta-data objects
		the${ModelNameUpper}Package.createPackageContents();

		// Initialize created meta-data
		the${ModelNameUpper}Package.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		the${ModelNameUpper}Package.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(${ModelNameUpper}Package.eNS_URI, the${ModelNameUpper}Package);
		return the${ModelNameUpper}Package;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void initializeRegistryHelpers() {
		Reflect.register
			(Entity.class, 
			 new Reflect.Helper() {
				 public boolean isInstance(Object instance) {
					 return instance instanceof Entity;
				 }

				 public Object newArrayInstance(int size) {
					 return new Entity[size];
				 }
			 });
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static class WhiteList implements IsSerializable, EBasicWhiteList {
		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		protected Entity entity;

	}


	/**
	 * Returns the meta object for class '{@link ${package}.${ModelNameLower}.Entity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity</em>'.
	 * @see ${package}.${ModelNameLower}.Entity
	 * @generated
	 */
	public EClass getEntity() {
		return entityEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link ${package}.${ModelNameLower}.Entity#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see ${package}.${ModelNameLower}.Entity#getName()
	 * @see #getEntity()
	 * @generated
	 */
	public EAttribute getEntity_Name() {
		return (EAttribute)entityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	public ${ModelNameUpper}Factory get${ModelNameUpper}Factory() {
		return (${ModelNameUpper}Factory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		entityEClass = createEClass(ENTITY);
		createEAttribute(entityEClass, ENTITY__NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(entityEClass, Entity.class, "Entity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEntity_Name(), ecorePackage.getEString(), "name", "", 0, 1, Entity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public interface Literals {
		/**
		 * The meta object literal for the '{@link ${package}.${ModelNameLower}.Entity <em>Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ${package}.${ModelNameLower}.Entity
		 * @see ${package}.${ModelNameLower}.${ModelNameUpper}Package#getEntity()
		 * @generated
		 */
		public static final EClass ENTITY = eINSTANCE.getEntity();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute ENTITY__NAME = eINSTANCE.getEntity_Name();

	}

} //${ModelNameUpper}Package
