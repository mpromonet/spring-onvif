import org.springframework.context.support.ClassPathXmlApplicationContext;
def ctx = new ClassPathXmlApplicationContext("classpath:groovy/groovy-context.xml");
def profile = ctx.getBean('profile');

response = new org.onvif.ver10.media.wsdl.GetProfilesResponse();
response.getProfiles().add(profile);
response;
