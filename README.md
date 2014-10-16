emf-archetypes
====================

This project contains Maven archetypes for modular EMF (EMF-GWT) projects.

How to use
----------

### Generate a project

    mvn archetype:generate \
       -DarchetypeGroupId=org.eclipselabs \
       -DarchetypeArtifactId=<artifactId> \
       -DarchetypeVersion=0.2.1

where the available `<artifactIds>` are:

* `emf-gwt-jersey`
* `emf-gwt-rpc`

### Use SuperDevMode

Change directory to your generated project and issue the following commands:

1. `mvn clean install -Dgwt.draftCompile`
2. In one terminal window: `cd *client && mvn gwt:run-codeserver -Ddev`
3. In another terminal window: `mvn tomcat7:run -Ddev`

The same is available with `tomcat6` instead of `tomcat7`.

Or if you'd rather use Jetty than Tomcat, use `cd *server && mvn jetty:start -Ddev` instead of `mvn tomcat7:run`.

Note that you only need to `install` once so that `gwt:run-codeserver` and `jetty:start`
can find the other modules. This is currently needed because neither `gwt:run`
nor `jetty:start` support running in reactor builds, contrary to `tomcat7:run`.

The `-Dgwt.draftCompile` in the first step is not required, it's only to speed up the
GWT compilation by disabling optimizations.
