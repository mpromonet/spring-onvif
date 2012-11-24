import org.springframework.context.support.ClassPathXmlApplicationContext;
def ctx = new ClassPathXmlApplicationContext("classpath:groovy/groovy-context.xml");
def ptzCfg = ctx.getBean('ptzCfg');

response = new org.onvif.ver20.ptz.wsdl.GetConfigurationsResponse();
response.getPTZConfiguration().add(ptzCfg);
response;
