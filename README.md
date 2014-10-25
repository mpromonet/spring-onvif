[![Build status](https://travis-ci.org/mpromonet/spring-onvif.svg)](https://travis-ci.org/mpromonet/spring-onvif)

Spring-ONVIF
========
The aim is to try to implement ONVIF services in a flexible way and to learn a bit more about what could do Apache Camel.  
This should probably never run inside a camera, but it could be use to test ONVIF client.  

The application is based on Spring Framework and use :
- Apache CXF to manage WS endpoints
- Apache Camel to route the SOAP request
- Groovy to process SOAP request and produce SOAP response

The application instantiate an ONVIF Device Service and publish it using the WS-Discovery of Apache CXF.  
Apache Camel is used to dispatch each ONVIF method to a groovy script located in groovy/<serviceName>/<methodName>.groovy.  
Then adding support for a new method just need to add a new script. Modifying behaviour of a method could be done modifying the script without restart the application.   

Container is a war, but it should be possible to use a jar assembly or an osgi bundle.

Build
--------
- `mvn package` build the web application.
- `mvn` build and run the web application in embedded tomcat.

Copyright
------------
Domain public.

Links
------------
- Packaged Application (http://repository-mpr.forge.cloudbees.com/snapshot/spring/onvif/1.0-SNAPSHOT/)
- Running Application (http://spring-onvif.mpr.cloudbees.net)
- Maven Site (http://mpromonet.github.com/spring-onvif)
- Jenkins CI (https://mpr.ci.cloudbees.com/job/spring-onvif)
