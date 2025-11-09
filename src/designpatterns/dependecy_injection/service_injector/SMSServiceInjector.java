package designpatterns.dependecy_injection.service_injector;

import designpatterns.dependecy_injection.consumer.Consumer;
import designpatterns.dependecy_injection.consumer.MyDIApplication;
import designpatterns.dependecy_injection.service.SMSServiceImpl;

public class SMSServiceInjector implements MessageServiceInjector {

    @Override
    public Consumer getConsumer() {
        return new MyDIApplication(new SMSServiceImpl());
    }

}