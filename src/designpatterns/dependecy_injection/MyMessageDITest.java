package designpatterns.dependecy_injection;

import designpatterns.dependecy_injection.consumer.Consumer;
import designpatterns.dependecy_injection.service_injector.EmailServiceInjector;
import designpatterns.dependecy_injection.service_injector.MessageServiceInjector;
import designpatterns.dependecy_injection.service_injector.SMSServiceInjector;

public class MyMessageDITest {

    public static void main(String[] args) {
        String msg = "Hi Pankaj";
        String email = "pankaj@abc.com";
        String phone = "4088888888";
        MessageServiceInjector injector = null;
        Consumer app = null;

        //Send email
        injector = new EmailServiceInjector();
        app = injector.getConsumer();
        app.processMessages(msg, email);

        //Send SMS
        injector = new SMSServiceInjector();
        app = injector.getConsumer();
        app.processMessages(msg, phone);
    }
}
